package com.muc.service;

import com.muc.bean.EpieUser;
import com.muc.bean.WeChatTool;
import com.muc.bean.WeChatToolCom;
import com.muc.mapper.EpieUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImp  implements  UserService{
    @Override
    public String loginByWeixin(String code, String encryptedData, String iv) {
        Map<String, Object> map = new HashMap<String, Object>();
        //发送    https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code 获取用户的openid和session_key
        //注意这个是 WeChatTool.wxspAppid 是微信小程序的appid 从微信小程序后台获取 WeChatTool.wxspSecret 这个也一样，我这里是用了常量来进行保存方便多次使用
        String params = "appid=" + WeChatTool.wxspAppid + "&secret=" + WeChatTool.wxspSecret + "&js_code=" + code + "&grant_type=authorization_code";
        String sendGet = Httprequests.sendGet(WeChatTool.url, params); //发起请求拿到key和openid
        return sendGet;
    }

    @Override
    public String loginByWeixinCom(String code, String encryptedData, String iv) {
        Map<String, Object> map = new HashMap<String, Object>();
        //发送    https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code 获取用户的openid和session_key
        //注意这个是 WeChatTool.wxspAppid 是微信小程序的appid 从微信小程序后台获取 WeChatTool.wxspSecret 这个也一样，我这里是用了常量来进行保存方便多次使用
        String params = "appid=" + WeChatToolCom.wxspAppid + "&secret=" + WeChatToolCom.wxspSecret + "&js_code=" + code + "&grant_type=authorization_code";
        String sendGet = Httprequests.sendGet(WeChatToolCom.url, params); //发起请求拿到key和openid
        return sendGet;
    }

    @Resource
    EpieUserMapper epieUserMapper;
    @Override
    public EpieUser check(String openid) {
       return epieUserMapper.selectByPrimaryKey(openid);

    }

    @Override
    public int reg(EpieUser epieUser) {
        return epieUserMapper.insert(epieUser);
    }

}
