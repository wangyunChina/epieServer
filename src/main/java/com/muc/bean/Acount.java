package com.muc.bean;

import java.io.Serializable;

public class Acount implements Serializable {
    private Integer id;

    private String acountUserId;

    private Double acountMoney;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcountUserId() {
        return acountUserId;
    }

    public void setAcountUserId(String acountUserId) {
        this.acountUserId = acountUserId == null ? null : acountUserId.trim();
    }

    public Double getAcountMoney() {
        return acountMoney;
    }

    public void setAcountMoney(Double acountMoney) {
        this.acountMoney = acountMoney;
    }
}