package com.muc.bean;

import java.io.Serializable;

public class Notice implements Serializable {
    private Integer id;

    private String sendpeople;

    private String acceptpeople;

    private String noticeContext;

    private String noticeTargetUrl;

    private Boolean noticeStatus;

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

    public String getNoticeContext() {
        return noticeContext;
    }

    public void setNoticeContext(String noticeContext) {
        this.noticeContext = noticeContext == null ? null : noticeContext.trim();
    }

    public String getNoticeTargetUrl() {
        return noticeTargetUrl;
    }

    public void setNoticeTargetUrl(String noticeTargetUrl) {
        this.noticeTargetUrl = noticeTargetUrl == null ? null : noticeTargetUrl.trim();
    }

    public Boolean getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(Boolean noticeStatus) {
        this.noticeStatus = noticeStatus;
    }
}