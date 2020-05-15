package com.muc.websocket;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;


import com.muc.service.EpieChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@ServerEndpoint("/websocket/{user}")
@ServerEndpoint("/websocket/{param}")
@Component
public class WebSocketServer implements ApplicationContextAware {
    class ChatArea{
        private WebSocketServer personOne;
        private WebSocketServer personTwo;

        public WebSocketServer getPersonOne() {
            return personOne;
        }

        public void setPersonOne(WebSocketServer personOne) {
            this.personOne = personOne;
        }

        public WebSocketServer getPersonTwo() {
            return personTwo;
        }

        public void setPersonTwo(WebSocketServer personTwo) {
            this.personTwo = personTwo;
        }

    }
    private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //静态变量，记录正在相互聊天的对数
    private static int chatSpace = 0;
    private String openid;
    private String aimopenid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getAimopenid() {
        return aimopenid;
    }

    public void setAimopenid(String aimopenid) {
        this.aimopenid = aimopenid;
    }

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();
    private static CopyOnWriteArraySet<ChatArea> chatAreas=new CopyOnWriteArraySet<>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    private static ApplicationContext applicationContext = null;
    /**
     * 连接建立成功调用的方法
     */
    public String getParam(String url,String key)
    {   String value=null;
        log.info("url:"+url);
        if(url!=null) {
            String[] a = url.split("&");
            for (String i :
                    a) {

                String[] b = i.split("=");
                if (b[0].equals(key))
                    value = b[1];


            }
        }
        log.info("url:"+value);
        return value;
    }
    @OnOpen
    public void onOpen(@PathParam("param") String param, Session session) {
        this.session = session;
        this.openid=param;
        System.out.println(param);
        String aim=this.getParam(session.getQueryString(),"aimopenid");

        this.aimopenid=aim;
        log.info("item："+this.openid+" aim:"+this.aimopenid+" sessionid:"+session.getId());

        if(aimopenid!=null)
        {
            ChatArea chatArea=null;
            /*目标不为空的时候查看是否是再次连接，如是，这关闭之前的会话,加入新的绘画，然后看聊天对象是否在set中*/
            for (WebSocketServer item : webSocketSet)
            {
                if(item.getOpenid()!=null&&item.getOpenid().equals(this.openid)&&item.getAimopenid()!=null)
                {
                    webSocketSet.remove(item);
                    log.info("之前已经加入过群聊会话，现在正在移除！");
                    WebSocketServer.onlineCount--;
                    item.onClose();

                }
                if(item.getOpenid().equals(this.aimopenid)&&item.getAimopenid()!=null&&item.getAimopenid().equals(this.openid))
                {
                    chatArea=new ChatArea();
                    chatArea.setPersonOne(this);
                    chatArea.setPersonTwo(item);

                }


            }
            /*如果聊天对象在set中,那么查询这两人是否在聊天的set中，如果是，则移除旧的聊天会话，加入新的聊天*/
            if(chatArea!=null)
            {
                for (ChatArea area:WebSocketServer.chatAreas)
                {
                    if(area.getPersonOne().getOpenid().equals(chatArea.getPersonOne().getOpenid())&&area.getPersonTwo().getOpenid().equals(chatArea.getPersonTwo().getOpenid())||
                            area.getPersonOne().getOpenid().equals(chatArea.getPersonTwo().getOpenid())&&area.getPersonTwo().getOpenid().equals(chatArea.getPersonOne().getOpenid()))
                    {
                        chatAreas.remove(area);
                        chatSpace--;
                    }
                }
                log.info("目标在线！加入会话！");
                chatAreas.add(chatArea);
                chatSpace++;
                log.info("当前正在聊天的有"+chatSpace+"对");

            }


            webSocketSet.add(this);
            onlineCount++;
            log.info("当前连接到服务器的有"+onlineCount+"人");
        }
        else{
            for (WebSocketServer item : webSocketSet)
            {
                if(item.getOpenid()!=null&&item.getOpenid().equals(this.openid)&&item.getAimopenid()==null)
                {
                    webSocketSet.remove(item);
                }
            }
            webSocketSet.add(this);
            onlineCount++;
            log.info("当前连接到服务器的有"+onlineCount+"人");
        }
        //加入set中
        log.info("有新连接加入！当前在线人数为" + getOnlineCount());
        log.info("当前正在聊天的有"+chatSpace+"对");
        log.info("连接成功");
    }
    //	//连接打开时执行
    //	@OnOpen
    //	public void onOpen(@PathParam("user") String user, Session session) {
    //		currentUser = user;
    //		System.out.println("Connected ... " + session.getId());
    //	}

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
        for (ChatArea area:WebSocketServer.chatAreas)
        {
            if(area.getPersonOne().getOpenid().equals(this.openid)&&area.getPersonTwo().getOpenid().equals(aimopenid)||area.getPersonOne().getOpenid().equals(aimopenid)&&area.getPersonTwo().getOpenid().equals(openid))
            {
                chatAreas.remove(area);
            }
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        log.info("来自客户端的消息:" + message);
        log.info("发送目标" + this.aimopenid);
        log.info("sessionid" + this.session.getId());
        //群发消息

        /*是否和聊天目标在聊天会话set中*/

        ChatArea chatArea=null;
        for (ChatArea area:WebSocketServer.chatAreas)
        {
            if(area.getPersonOne().getOpenid().equals(this.openid)&&area.getPersonTwo().getOpenid().equals(this.aimopenid)||area.getPersonOne().getOpenid().equals(this.aimopenid)&&area.getPersonTwo().getOpenid().equals(this.openid))
            {
                chatArea=area;
            }
        }
        if(chatArea!=null)
        {
            /*发送消息给目标session*/
            if(chatArea.getPersonOne().getOpenid().equals(this.aimopenid))
            {
                chatArea.getPersonOne().sendMessage(message);
                log.info(chatArea.getPersonOne().getOpenid()+"1这里发出" );
            }
            else{
                chatArea.getPersonTwo().sendMessage(message);
                log.info(chatArea.getPersonTwo().getOpenid()+"2这里发出" );
            }
            log.info(this.openid+"发送消息："+message+"给"+aimopenid);
        }
        else
        {
            EpieChatService epieChatService=WebSocketServer.getBean(EpieChatService.class);

            /*发消息到数据库并且查询目标是否在群里会话中*/
            epieChatService.sendMessage(openid,aimopenid,message);
            for (WebSocketServer item : webSocketSet)
            {
                log.info("item："+item.getOpenid()+" aim:"+this.aimopenid+" itemAim:"+item.getAimopenid()+"sessionid:"+item.getSession().getId());
                if(item.getOpenid()!=null&&item.getOpenid().equals(this.aimopenid)&&item.getAimopenid()==null)
                {
                    item.sendMessage("您收到一条新的未读消息，请前往消息界面查看！");

                }
                else{
                    log.info("目标不在线！");

                }
            }
        }

    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message) {
        log.info(message);
        for (WebSocketServer item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException ignored) {
            }
        }
    }

    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(WebSocketServer.applicationContext==null){
            WebSocketServer.applicationContext=applicationContext;
        }
    }
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);

    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
}
