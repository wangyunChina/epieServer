package com.muc.service;

import com.muc.bean.EpieChat;

import java.util.ArrayList;

public interface EpieChatService {
    public ArrayList<EpieChat> getMessageAll(String openid);
    public ArrayList<EpieChat> getMessageAcceptOnePerson(String send,String accept);
    public ArrayList<EpieChat> getMessageSendOnePerson(String accept,String send);
    public int sendMessage(String send,String accept,String Message);
    public ArrayList<EpieChat> getHistoryMessage(String send,String accept);
    public int setMessageHasRead(String send,String accept);

}
