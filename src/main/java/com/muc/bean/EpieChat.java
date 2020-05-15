package com.muc.bean;

import java.io.Serializable;
import java.util.Date;

public class EpieChat implements Serializable {
    private Integer id;

    private String sendpeople;

    private String acceptpeople;

    private String message;

    private Date sendtime;

    private Boolean isread;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSendpeople() {
        return sendpeople;
    }

    public void setSendpeople(String sendpeople) {
        this.sendpeople = sendpeople == null ? null : sendpeople.trim();
    }

    public String getAcceptpeople() {
        return acceptpeople;
    }

    public void setAcceptpeople(String acceptpeople) {
        this.acceptpeople = acceptpeople == null ? null : acceptpeople.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Boolean getIsread() {
        return isread;
    }

    public void setIsread(Boolean isread) {
        this.isread = isread;
    }
}