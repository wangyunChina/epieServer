package com.muc.service;

import org.springframework.stereotype.Service;

@Service
public class TempMessageDiliveryServiceImp implements TempMessageDiliveryService
{


    @Override
    public String sendWageMessage(String url, String param){
         return Httprequests.sendPost(url,param);
    }
}
