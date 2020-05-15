package com.muc.service;

import com.muc.bean.EpieChat;
import com.muc.mapper.EpieChatMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
@Service
public class EpieChatServiceImp implements EpieChatService {
    @Resource
    EpieChatMapper epieChatMapper;
    @Override
    public ArrayList<EpieChat> getMessageAll(String openid) {

        return epieChatMapper.selectByAcceptPeople(openid);
    }

    @Override
    public ArrayList<EpieChat> getMessageAcceptOnePerson(String send, String accept) {
        return epieChatMapper.selectAcceptFromOne(accept,send);

    }

    @Override
    public ArrayList<EpieChat> getMessageSendOnePerson(String send, String accept) {
        return epieChatMapper.selectAcceptFromOne(send,accept);
    }

    @Override
    public int sendMessage(String send, String accept, String Message) {
        return epieChatMapper.insertByproperty(send,accept,Message);
    }

    @Override
    public ArrayList<EpieChat> getHistoryMessage(String send, String accept) {
        return epieChatMapper.selectChatMessage(send,accept);
    }

    @Override
    public int setMessageHasRead(String send, String accept) {
        return epieChatMapper.setMessageHasRead(send,accept);
    }
}
