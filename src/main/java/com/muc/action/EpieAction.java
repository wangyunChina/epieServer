package com.muc.action;

import com.muc.bean.*;
import com.muc.bean.Collection;
import com.muc.service.*;
import com.muc.util.AesCbcUtil;
import com.muc.viewModel.CompanyViewModel;
import com.muc.viewModel.DiliverViewModel;
import com.muc.viewModel.PartimeJobViewModel;
import io.swagger.annotations.*;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.util.*;

/*
* @author Wangyun
* @Date 2020-5-14
* */
@RestController
@CrossOrigin
@RequestMapping("/epie")
public class EpieAction {
    @Resource
    UserService userService;
    @Resource
    EpieChatService epieChatService;
    @ApiOperation(value = "历史消息读取",notes = "读取用户之间的历史消息")
    /*获取历史消息
    * @param send 消息发送方
    * @param accept 消息接收方
    * */
    @GetMapping("/gethistorymessage")
    public Map<String,Object> getHistoryMessage(String send,String accept,HttpServletRequest request)
    {
        Map<String,Object> map  =new HashMap<String, Object>();
           try {
               map.put("messageArray",epieChatService.getHistoryMessage(send,accept));
           }
           catch (Exception e)
           {
               e.printStackTrace();
           }
           finally {
               return map;
           }

    }

    /*消息界面加载的时候调用的api
    * @param accept 消息接收方
    * @author WangYun
    * */
    @ApiOperation(value = "消息概览",notes = "获取这个用户的消息概览")
    @GetMapping("/getAllmessage")
    public Map<String,Object> getMessageAll(String accept,HttpServletRequest request)
    {
        Map<String,Object> map  =new HashMap<String, Object>();
        try {
           ArrayList<EpieChat> temp=epieChatService.getMessageAll(accept);
           System.out.println("人数："+temp.size());
            ArrayList<MessageView> messageViews=new ArrayList<>();
            for ( EpieChat i: temp
                 ) {
                MessageView view=new MessageView();
                String openid=i.getSendpeople();
                view.setSendPeople(userService.check(openid));
                System.out.println("发送人："+openid);
                ArrayList<EpieChat> list=epieChatService.getMessageAcceptOnePerson(accept,openid);
                System.out.println("发送条数："+list.size());
                view.setMessageArray(list);
                int count=0;
                for( EpieChat j: list
                 )
                {
                    if(j.getIsread()==false)
                    {
                        count++;
                    }
                }
                view.setUnread(count);
                messageViews.add(view);
            }
            map.put("messageArray",messageViews);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            return map;
        }

    }
    @ApiOperation(value = "登录方法",notes = "通过微信登录是第一次进入系统则将用户信息加入本地数据库")
    @GetMapping("/login_by_weixin")
    public Map loginByWeixin(String code, String encryptedData, String iv, HttpServletRequest request)
    {
        Map<String,Object> map  =new HashMap<String, Object>();

        String sendGet=userService.loginByWeixin(code,encryptedData,iv); //根据code去调用接口获取用户openid和session_key

        JSONObject json = JSONObject.fromObject(sendGet);
        System.out.println("返回过来的json数据:"+json.toString());
        String sessionkey=json.get("session_key").toString(); //会话秘钥
        String openid=json.get("openid").toString(); //用户唯一标识
        try{
            //拿到用户session_key和用户敏感数据进行解密，拿到用户信息。
            String decrypts= AesCbcUtil.decrypt(encryptedData,sessionkey,iv,"utf-8");//解密
            JSONObject jsons = JSONObject.fromObject(decrypts);
            System.out.println(jsons);
            String nickName=jsons.get("nickName").toString(); //用户昵称
            String avatarUrl=jsons.get("avatarUrl").toString(); //用户头像
            Byte sex=Byte.valueOf(jsons.get("gender").toString());
            EpieUser epieUser=new EpieUser();
            epieUser.setSex(sex);
            epieUser.setAvatarurl(avatarUrl);
            epieUser.setNickname(nickName);
            epieUser.setOpenid(openid);

            map.put("nickName",nickName);
            map.put("sessionKey",sessionkey);
            map.put("openId",openid);
            map.put("avatarUrl",avatarUrl);
            map.put("sex",sex);
            if(userService.check(openid)==null)
            {
                userService.reg(epieUser);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
    @ApiOperation(value = "上传文件",notes = "只能上传jpg,jpeg,gif,png,word,pdf,m4a,mp3,mp4格式的文件！")
    @PostMapping(value = "/uploadPhoto")
    @ResponseBody
    @CrossOrigin
    public Map<String, String> uploadPhoto(MultipartFile photo, HttpServletRequest request) {
        Map<String, String> ret = new HashMap<String, String>();
        if (photo == null) {
            ret.put("type", "error");
            ret.put("msg", "选择要上传的文件！");
            return ret;
        }
        if (photo.getSize() > 1024 * 1024 * 20) {
            ret.put("type", "error");
            ret.put("msg", "文件大小不能超过20M！");
            return ret;
        }
        //获取文件后缀
        String suffix = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".") + 1, photo.getOriginalFilename().length());
        if (!"jpg,jpeg,gif,png,word,pdf,m4a,mp3,mp4".toUpperCase().contains(suffix.toUpperCase())) {
            ret.put("type", "error");
            ret.put("msg", "请选择jpg,jpeg,gif,png,word,pdf,m4a,mp3,mp4格式的文件！");
            return ret;
        }
        //获取项目根目录加上图片目录 webapp/static/imgages/upload/
        String savePath = "C:/Users/王云/IdeaProjects/cloud/epie/src/main/resources/static/userfile/";
        System.out.println(savePath);
        File savePathFile = new File(savePath);
        if (!savePathFile.exists()) {
            //若不存在该目录，则创建目录
            savePathFile.mkdir();
        }
        String filename = new Date().getTime() + "." + suffix;
        try {
            //将文件保存指定目录
            photo.transferTo(new File(savePath + filename));
        } catch (Exception e) {
            ret.put("type", "error");
            ret.put("msg", "保存文件异常！");
            e.printStackTrace();
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "上传图片成功！");
        ret.put("filepath", "C:/Users/王云/IdeaProjects/cloud/epie/src/main/resources/static/userfile/");
        ret.put("filename", filename);
        return ret;
    }
    @ApiOperation(value = "消息已读更新",notes = "用户读取消息后更新消息已读")
    @PostMapping("/setMessageHasRead")
    public int setMessageHasRead(String send,String accept,HttpServletRequest request){
        return epieChatService.setMessageHasRead(send,accept);
    }
    @Resource
    TempMessageDiliveryService tempMessageDiliveryService;

    /*这个是工资到账的消息提醒，*/
    @ApiOperation(value = "工资到账消息推送",notes = "需要用户端订阅一次该消息，否则无法发送，还需要编写服务端获取并存储")
    @GetMapping("/wagesMessage")
    @ApiResponse(code = 400,message = "参数格式不正确",response = String.class)
    public String sendwagesMessage(String openid,Double money,HttpServletRequest request)
    {
        //String data= GetWageMessage.getData(money,,openid,,"pages/index/index","trial");
        Template template=new Template();
        template.setTemplate_id("YCqqfkTnsuKMznt670NXVOmD2i-8lcfuZvSD9plSFqE");
        template.setPage("pages/index/index");
        template.setTouser(openid);
        List<TemplateParam> paras=new ArrayList<TemplateParam>();
        paras.add(new TemplateParam("amount1",money.toString()));
        paras.add(new TemplateParam("thing3","工资已到账"));
        template.setTemplateParamList(paras);
        String requestUrl="https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=ACCESS_TOKEN";
        String Access_Token="33_JZIARzjWzNFTrDDcoCJhzhJJEuAVJzQd6gjeHiYap0xeKaaf_6kuc-YloV2nr95XVbuN8W65WEQBPkoja1JXLpvd4A5lcRI9Je3czLlYqR9KwRj450rwxx-VKL3yXVARJJnXOG6PIWgCzITyVGBbAJAKVQ";
        requestUrl=requestUrl.replace("ACCESS_TOKEN", Access_Token);
        System.out.println(template.toJSON().toString());

        return tempMessageDiliveryService.sendWageMessage(requestUrl,template.toJSON().toString());

    }
    @Resource
    PartimeJobService partimeJobService;
    @Resource
    CompanyService companyService;
    @Resource
    IndustryLevelOneService levelOneService;
    @Resource IndustryLevelTwoService levelTwoService;
    @Resource JobRequirementsService requirementsService;
    @Resource JobDescriptionService descriptionService;
    /*
    * @Desc 首页推荐兼职，本地有搜索记录时按名称收索，没有时则按用户地点推荐,用户搜索也可以使用
    * @Param reginal 地域名称
    * @Param name 兼职名称关键字
    * @Path /epei/index/job
    * */
    @ApiOperation(value = "首页兼职推荐",notes = "首页的兼职推荐，根据最近搜索记录、地域推荐，需要优化，用户搜索也可以使用")
    @GetMapping("/index/job")
    @ApiResponse(code = 400,message = "参数格式不正确",response = String.class)
    public Map<String,Object> getIndexJob(String reginal, String name,HttpServletRequest request){
        Map<String,Object> map  =new HashMap<String, Object>();
        List<ParttimeJob> joblist1=null;
        List<PartimeJobViewModel> viewIndexList=new ArrayList<>();
        try {
            System.out.println(name);
            if (name != null&&reginal!=null) {
                joblist1 = partimeJobService.selectByReginalAndName(reginal, name);
            } else if(reginal!=null){
                joblist1 = partimeJobService.selectByReginal(reginal);
            }
            else if(name!=null)
            {
                joblist1=partimeJobService.selectByName(name);
            }
            else{
                joblist1=partimeJobService.selectAll(20);
            }
            for (ParttimeJob i : joblist1
            ) {
                PartimeJobViewModel temp = new PartimeJobViewModel();
                temp.setJob(i);
                temp.setCompany(companyService.selectById(i.getCompanyid()));
                viewIndexList.add(temp);
            }
            /*如果数据少于10那么查询补充*/
            map.put("result","success");
            map.put("data",viewIndexList);
        }
        catch ( Exception e) {
            map.put("result", "fail");
            map.put("errorMessage", e.getMessage());
            e.printStackTrace();
        }

        return map;
    }
    /*
    * 兼职详情查询接口
    * @param jobId string
    * @path /epie/jobinfo
    * @return map
    * */
    @ApiOperation(value = "兼职详情",notes = "首页点击传入兼职id,返回兼职的详细信息")
    @GetMapping("/jobinfo")
    @ApiResponse(code = 400,message = "参数格式不正确",response = String.class)
    public Map getJobInfo(Integer job_id,HttpServletRequest request)
    {
        Map<String,Object> map  =new HashMap<String, Object>();
        try{
            if(job_id!=null) {
                ParttimeJob job = partimeJobService.selectById(job_id);
                PartimeJobViewModel viewIndex = new PartimeJobViewModel();
                if (job != null) {
                    viewIndex.setJob(job);
                    viewIndex.setCompany(companyService.selectById(job.getCompanyid()));
                    viewIndex.setIndustryLevelOne(levelOneService.selectById(job.getJobTypeLevel1()));
                    viewIndex.setIndustryLevelTwo(levelTwoService.selectById(job.getJobTypeLevel2()));
                    viewIndex.setJobDescription((ArrayList<JobDescription>) descriptionService.selectByJobId(job.getId()));
                    viewIndex.setJobRequirements((ArrayList<JobRequirements>) requirementsService.selectByJobId(job.getId()));
                    map.put("result", "success");
                    map.put("data", viewIndex);
                }
            }
            else{
                map.put("result", "fail");
                map.put("errorMessage", "param format error");
            }
        }
        catch (Exception e)
        {
            map.put("result", "fail");
            map.put("errorMessage", e.getMessage());
            e.printStackTrace();
        }
        return map;
    }
    /*
    * 首页公司推荐api
    * @param reginal 地名 String
    * @return map
    * */
    @ApiOperation(value = "公司推荐",notes = "根据地域位置推荐否则随机推荐10家公司")
    @GetMapping("/index/company")
    public Map getIndexCompany( String reginal, HttpServletRequest request)
    {
        Map<String,Object> map  =new HashMap<String, Object>();
        ArrayList<Company> companies=null;
        ArrayList<CompanyViewModel> data=new ArrayList<>();
        try {
            if (reginal != null) {
                companies = (ArrayList<Company>) companyService.selectByLocation(reginal);
                for (Company i : companies) {
                    CompanyViewModel temp = new CompanyViewModel();
                    ArrayList<PartimeJobViewModel> companyViewModels = new ArrayList<>();
                    temp.setCompany(i);
                    ArrayList<ParttimeJob> list = (ArrayList<ParttimeJob>) partimeJobService.selectByCompanyId(i.getId());

                    for (ParttimeJob j : list) {
                        PartimeJobViewModel viewIndex = new PartimeJobViewModel();
                        viewIndex.setJob(j);
                        viewIndex.setCompany(companyService.selectById(j.getCompanyid()));
                        viewIndex.setIndustryLevelOne(levelOneService.selectById(j.getJobTypeLevel1()));
                        viewIndex.setIndustryLevelTwo(levelTwoService.selectById(j.getJobTypeLevel2()));
                        viewIndex.setJobDescription((ArrayList<JobDescription>) descriptionService.selectByJobId(j.getId()));
                        viewIndex.setJobRequirements((ArrayList<JobRequirements>) requirementsService.selectByJobId(j.getId()));
                        companyViewModels.add(viewIndex);
                    }
                    temp.setCompanyParttimeJob(companyViewModels);
                    data.add(temp);
                }
                map.put("result", "success");
                map.put("data", data);
            } else {
                companies = (ArrayList<Company>) companyService.selectAll(10);
                for (Company i : companies) {
                    CompanyViewModel temp = new CompanyViewModel();
                    ArrayList<PartimeJobViewModel> companyViewModels = new ArrayList<>();
                    temp.setCompany(i);
                    ArrayList<ParttimeJob> list = (ArrayList<ParttimeJob>) partimeJobService.selectByCompanyId(i.getId());

                    for (ParttimeJob j : list) {
                        PartimeJobViewModel viewIndex = new PartimeJobViewModel();
                        viewIndex.setJob(j);
                        viewIndex.setCompany(companyService.selectById(j.getCompanyid()));
                        viewIndex.setIndustryLevelOne(levelOneService.selectById(j.getJobTypeLevel1()));
                        viewIndex.setIndustryLevelTwo(levelTwoService.selectById(j.getJobTypeLevel2()));
                        viewIndex.setJobDescription((ArrayList<JobDescription>) descriptionService.selectByJobId(j.getId()));
                        viewIndex.setJobRequirements((ArrayList<JobRequirements>) requirementsService.selectByJobId(j.getId()));
                        companyViewModels.add(viewIndex);
                    }
                    temp.setCompanyParttimeJob(companyViewModels);
                    data.add(temp);
                }
                map.put("result", "success");
                map.put("data", data);
            }
        }
        catch (Exception e)
        {
            map.put("result", "fail");
            map.put("errorMessage", e.getMessage());
            e.printStackTrace();
        }
        return  map;
    }

    @ApiOperation(value = "公司详情",notes = "查询公司的详细信息")
    @GetMapping("/companyinfo")
    public Map getCompanyInfo( int id, HttpServletRequest request)
    {
        Map<String,Object> map  =new HashMap<String, Object>();
            Company company=null;
        ArrayList<CompanyViewModel> data=new ArrayList<>();
        try {
            if (id != 0) {
                company =companyService.selectById(id);

                    CompanyViewModel temp = new CompanyViewModel();
                    ArrayList<PartimeJobViewModel> companyViewModels = new ArrayList<>();
                    temp.setCompany(company);
                    ArrayList<ParttimeJob> list = (ArrayList<ParttimeJob>) partimeJobService.selectByCompanyId(company.getId());

                    for (ParttimeJob j : list) {
                        PartimeJobViewModel viewIndex = new PartimeJobViewModel();
                        viewIndex.setJob(j);
                        viewIndex.setCompany(companyService.selectById(j.getCompanyid()));
                        viewIndex.setIndustryLevelOne(levelOneService.selectById(j.getJobTypeLevel1()));
                        viewIndex.setIndustryLevelTwo(levelTwoService.selectById(j.getJobTypeLevel2()));
                        viewIndex.setJobDescription((ArrayList<JobDescription>) descriptionService.selectByJobId(j.getId()));
                        viewIndex.setJobRequirements((ArrayList<JobRequirements>) requirementsService.selectByJobId(j.getId()));
                        companyViewModels.add(viewIndex);
                    }
                    temp.setCompanyParttimeJob(companyViewModels);
                    data.add(temp);

                map.put("result", "success");
                map.put("data", data);
            }
        }
        catch (Exception e)
        {
            map.put("result", "fail");
            map.put("errorMessage", e.getMessage());
            e.printStackTrace();
        }
        return  map;
    }
    /*
    * 简历获取api
    * @param openid String 用户的openid
    * */
    @Resource
    ResumeService resumeService;
    @ApiOperation(value="我的简历",notes = "用户查询自己的简历")
    @GetMapping("/myResume")
    public Map getMyResume(String openid,HttpServletRequest request)
    {
        HashMap<String,Object> map=new HashMap<>();
        try{

            ArrayList list=resumeService.selectByOpenid(openid);
            map.put("result", "success");
            map.put("data", list);
        }
        catch (Exception e)
        {
            map.put("result", "fail");
            map.put("errorMessage", e.getMessage());
            e.printStackTrace();
        }
        return map;
    }


    @ApiOperation(value="创建我的简历",notes = "创建简历")
    @PostMapping("/CreatemyResume")
    public Map CreateMyResume(Resume resume,HttpServletRequest request)
    {
        HashMap<String,Object> map=new HashMap<>();
        try{
            resumeService.insert(resume);
            map.put("result", "success");

        }
        catch (Exception e)
        {
            map.put("result", "fail");
            map.put("errorMessage", e.getMessage());
            e.printStackTrace();
        }
        return map;
    }
    /*
    * @author Wangyun
    * @param 用户的id，用于安全验证
    * @param 用户的简历的编号
    * */
    @ApiOperation(value="删除我的简历",notes = "删除简历，此方法不安全要改进")
    @PostMapping("/deletmyResume")
    public Map deleteMyResume(String openid,int resumeid,HttpServletRequest request)
    {
        HashMap<String,Object> map=new HashMap<>();
        try{
            for(Resume i:resumeService.selectByOpenid(openid))
            {
                if(i.getId()==resumeid)
                {
                    resumeService.delete(resumeid);
                    map.put("result", "success");
                }
            }

        }
        catch (Exception e)
        {
            map.put("result", "fail");
            map.put("errorMessage", e.getMessage());
            e.printStackTrace();
        }
        return map;
    }
    @Resource
    UserWorkService userWorkService;
    /*
    * @author Wangyun
    * @param openid 用户的唯一标识
    * @return map*/
    @GetMapping("/getMyworks")
    @ApiOperation(value = "获取我的作品",notes = "通过我的用户名查询我的作品")
    public Map getMyWorks(String openid,HttpServletRequest request){
        HashMap<String,Object> map=new HashMap<>();
        if(openid!=null)
        {
            try{

                ArrayList list=userWorkService.selectByOpenid(openid);
                map.put("result", "success");
                map.put("data", list);
            }
            catch (Exception e)
            {
                map.put("result", "fail");
                map.put("errorMessage", e.getMessage());
                e.printStackTrace();
            }
        }
        return map;
    }
    @ApiOperation(value = "上传作品",notes = "只有poster的值可以为空")
    @PostMapping("addWorks")
    public void addWork(UserWork userWork,HttpServletRequest request)
    {
        HashMap<String,Object> map=new HashMap<>();
        try{
            userWorkService.insert(userWork);
            map.put("result", "success");

        }
        catch (Exception e)
        {
            map.put("result", "fail");
            map.put("errorMessage", e.getMessage());
            e.printStackTrace();
        }

    }

    /*
     * @author Wangyun
     * @param 用户的id，用于安全验证
     * @param 用户的简历的编号
     * */
    @ApiOperation(value="删除我的作品",notes = "这里只能删除用户的作品")
    @PostMapping("/deletmyWork")
    public Map deleteMyWork(String openid,int workid,HttpServletRequest request)
    {
        HashMap<String,Object> map=new HashMap<>();
        try{
            for(UserWork i:userWorkService.selectByOpenid(openid))
            {
                if(i.getId()==workid)
                {
                    resumeService.delete(workid);
                    map.put("result", "success");
                }
            }

        }
        catch (Exception e)
        {
            map.put("result", "fail");
            map.put("errorMessage", e.getMessage());
            e.printStackTrace();
        }
        return map;
    }
    @Resource NoticeService noticeService;
    @ApiOperation(value = "读取我的通知",notes="这里只能读取未读的消息")
    @GetMapping("/mynotice")
    public Map mynotice(String openid)
    {
        HashMap<String,Object> map=new HashMap<>();
        ArrayList<Notice> list=null;
        try {
            if(openid!=null)
            {
                list=noticeService.searchMyNotic(openid);
                map.put("result","success");
                map.put("data",list);
            }
            else{
                map.put("result", "fail");
                map.put("errorMessage", "data format Error");
            }
        }
        catch (Exception e)
        {
            map.put("result", "fail");
            map.put("errorMessage", e.getMessage());
        }
        return map;
    }

    @ApiOperation(value = "读取一条通知",notes="这里只能读取未读的消息")
    @GetMapping("/readAnotice")
    public Map readAnotice(int id)
    {
        HashMap<String,Object> map=new HashMap<>();

        try {
            if(id!=0)
            {
                int temp=noticeService.readANotice(id);
                map.put("result","success");
                map.put("data",temp);
            }
            else{
                map.put("result", "fail");
                map.put("errorMessage", "data format Error");
            }
        }
        catch (Exception e)
        {
            map.put("result", "fail");
            map.put("errorMessage", e.getMessage());
        }
        return map;
    }
    @ApiOperation(value = "读取全部通知",notes="这里只能读取未读的消息")
    @GetMapping("/readAllnotice")
    public Map readAllnotice(String openid)
    {
        HashMap<String,Object> map=new HashMap<>();

        try {
            if(openid!=null)
            {
                int temp=noticeService.readAllNotice(openid);
                map.put("result","success");
                map.put("data",temp);
            }
            else{
                map.put("result", "fail");
                map.put("errorMessage", "data format Error");
            }
        }
        catch (Exception e)
        {
            map.put("result", "fail");
            map.put("errorMessage", e.getMessage());
        }
        return map;
    }
    @Resource
    CollectionService collectionService;
    @ApiOperation(value = "获取我的收藏",notes="读取我的收藏")
    @GetMapping("/getMyCollections")
    public Map getMyCollections(String openid,HttpServletRequest request)
    {
        HashMap<String,Object> map=new HashMap<>();
        ArrayList<Object> list1=new ArrayList<>();
        ArrayList<Object> list2=new ArrayList<>();
        try {
            if(openid!=null)
            {
                ArrayList<Collection> temp=collectionService.searchMyCollection(openid);
                for(Collection i :temp)
                {
                    if(i.getCollectionType())
                    {
                        list1.add(partimeJobService.selectById(i.getObjectId()));
                    }
                    else
                    {
                        list2.add(companyService.selectById(i.getObjectId()));
                    }
                }

                map.put("result","success");
                map.put("company",list1);
                map.put("parttimejob",list2);
            }
            else{
                map.put("result", "fail");
                map.put("errorMessage", "data format Error");
            }
        }
        catch (Exception e)
        {
            map.put("result", "fail");
            map.put("errorMessage", e.getMessage());
        }
        return map;
    }

    @ApiOperation(value = "添加到我的收藏",notes="根据类型存储")
    @PostMapping("/AddToMyCollections")
    public int  AddToMyCollections(Collection collection,HttpServletRequest request)
    {
        try{
            int tag=0;

            for(Collection i:collectionService.searchMyCollection(collection.getUserId()))
            {
                if(i.getObjectId()==collection.getObjectId()&&i.getUserId().equals(collection.getUserId())) {
                    tag = 1;
                    break;
                }
            }
            if(tag!=1)
                return collectionService.insert(collection);
            else
                return 0;

        }
        catch (Exception e)
        {
            return -1;
        }

    }
    @ApiOperation(value = "删除一项收藏")
    @PostMapping("/deletACollection")
    public int DeleteACollection(int id,HttpServletRequest request)
    {
        try {

            return collectionService.delete(id);
        }
        catch (
                Exception e
        )
        {
            return -1;
        }
    }
    @Resource
    DiliveryService diliveryService;
    @ApiOperation(value = "查询我的投递内容")
    @GetMapping("/getMyDilivery")
    public Map getMyDilivery(String openid,HttpServletRequest request)
    {
        HashMap<String,Object> map=new HashMap<>();
        ArrayList<DiliverViewModel> data=new ArrayList<>();
        try{

            for(Dilivery i:diliveryService.seletMyDilivery(openid)){
                DiliverViewModel temp=new DiliverViewModel();
                temp.setDilivery(i);
                temp.setJob(partimeJobService.selectById(i.getId()));
                data.add(temp);
            }
            map.put("result","success");
            map.put("data",data);
        }catch (Exception e){
            map.put("result", "fail");
            map.put("errorMessage", e.getMessage());
        }
        return map;
    }
    @ApiOperation(value = "兼职投递")
    @PostMapping("/dilivery")
    public int AddDilivery(Dilivery dilivery,HttpServletRequest request)
    {
        try{
            diliveryService.insert(dilivery);
            return 1;
        }catch (Exception e)
        {
            return 0;
        }
    }
    @ApiOperation(value = "审核投递")
    @PostMapping("/dilivery/review")
    public int UpdateDilivery(Dilivery dilivery,HttpServletRequest request)
    {
        try{
            diliveryService.upadate(dilivery);
            return 1;
        }catch (Exception e)
        {
            return 0;
        }
    }
    @Resource
    AccountService accountService;
    @ApiOperation(value = "查询我的账户",notes = "通过用户的openid")
    @GetMapping("/myAccount")
    public Acount myAccount(String openid){
        try{
            return accountService.select(openid);
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
