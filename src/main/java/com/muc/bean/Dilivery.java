package com.muc.bean;

import java.io.Serializable;
import java.util.Date;

public class Dilivery implements Serializable {
    private Integer id;

    private Integer diliverJobId;

    private String diliverUserId;

    private Date diliverOptionTime;

    private Integer diliverStatusId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiliverJobId() {
        return diliverJobId;
    }

    public void setDiliverJobId(Integer diliverJobId) {
        this.diliverJobId = diliverJobId;
    }

    public String getDiliverUserId() {
        return diliverUserId;
    }

    public void setDiliverUserId(String diliverUserId) {
        this.diliverUserId = diliverUserId == null ? null : diliverUserId.trim();
    }

    public Date getDiliverOptionTime() {
        return diliverOptionTime;
    }

    public void setDiliverOptionTime(Date diliverOptionTime) {
        this.diliverOptionTime = diliverOptionTime;
    }

    public Integer getDiliverStatusId() {
        return diliverStatusId;
    }

    public void setDiliverStatusId(Integer diliverStatusId) {
        this.diliverStatusId = diliverStatusId;
    }
}