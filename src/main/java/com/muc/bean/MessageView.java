package com.muc.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class MessageView implements Serializable {
    private EpieUser sendPeople;
    private ArrayList<EpieChat> messageArray;
    private int unread;

    public EpieUser getSendPeople() {
        return sendPeople;
    }

    public void setSendPeople(EpieUser sendPeople) {
        this.sendPeople = sendPeople;
    }

    public ArrayList<EpieChat> getMessageArray() {
        return messageArray;
    }

    public void setMessageArray(ArrayList<EpieChat> messageArray) {
        this.messageArray = messageArray;
    }

    public int getUnread() {
        return unread;
    }

    public void setUnread(int unread) {
        this.unread = unread;
    }
}
