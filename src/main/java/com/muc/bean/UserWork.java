package com.muc.bean;

import java.io.Serializable;

public class UserWork implements Serializable {
    private Integer id;

    private String openid;

    private Integer workType;

    private String workTitel;

    private String workDesc;

    private String workPoster;

    private String workPath;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public String getWorkTitel() {
        return workTitel;
    }

    public void setWorkTitel(String workTitel) {
        this.workTitel = workTitel == null ? null : workTitel.trim();
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc == null ? null : workDesc.trim();
    }

    public String getWorkPoster() {
        return workPoster;
    }

    public void setWorkPoster(String workPoster) {
        this.workPoster = workPoster == null ? null : workPoster.trim();
    }

    public String getWorkPath() {
        return workPath;
    }

    public void setWorkPath(String workPath) {
        this.workPath = workPath == null ? null : workPath.trim();
    }
}