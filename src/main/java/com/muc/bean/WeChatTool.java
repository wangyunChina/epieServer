package com.muc.bean;

import java.io.Serializable;

public class WeChatTool implements Serializable {
   public static String wxspAppid="wx985e0af01a927a06";
    public static String wxspSecret="a95786946c1738c121f955ceff88e51e";
    /*获取唯一openid的提醒*/
    public static String url="https://api.weixin.qq.com/sns/jscode2session";
    /*获取access_token的接口；
@Param grant_type	string		是	填写 client_credential
@Param appid	string		是	小程序唯一凭证，即 AppID，可在「微信公众平台 - 设置 - 开发设置」页中获得。（需要已经成为开发者，且帐号没有异常状态）
@Param secret	string		是	小程序唯一凭证密钥，即 AppSecret，获取方式同 appid
返回值*/
    public static String access_token="https://api.weixin.qq.com/cgi-bin/token";
    /*
   属性	类型	默认值	必填	说明
access_token	string		是	接口调用凭证
touser	string		是	接收者（用户）的 openid
template_id	string		是	所需下发的订阅模板id
page	string		否	点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转。
data	Object		是	模板内容，格式形如 { "key1": { "value": any }, "key2": { "value": any } }
miniprogram_state	string		否	跳转小程序类型：developer为开发版；trial为体验版；formal为正式版；默认为正式版
lang	string		否	进入小程序查看”的语言类型，支持zh_CN(简体中文)、en_US(英文)、zh_HK(繁体中文)、zh_TW(繁体中文)，默认为zh_CN*/
    public static String senMessageUrl="https://api.weixin.qq.com/cgi-bin/message/subscribe/send";
}
