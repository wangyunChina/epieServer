package com.muc.util;

import net.sf.json.JSONObject;

public class GetWageMessage {
   public static String wagesMessageTempId="YCqqfkTnsuKMznt670NXVOmD2i-8lcfuZvSD9plSFqE";
   public static String getData(Double money,String access_token,String touser,String template_id,String page, String miniprogram_state)
   {
       String str="{'access_token':'"+access_token+"',   'touser':'"+touser+"',"+"'template_id':'"+template_id+"','page':'pages/index/index','miniprogram_state':'"+miniprogram_state+"','data':"+"{ 'amount1':{ 'value':"+money+ " }, 'thing3':{ 'value':'工资到账提醒' } }}";


        return str;
   }
}
