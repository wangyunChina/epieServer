package com.muc.bean;

import java.io.Serializable;

public class DiliveryStatus implements Serializable {
    private Integer id;

    private String diliveryVal;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiliveryVal() {
        return diliveryVal;
    }

    public void setDiliveryVal(String diliveryVal) {
        this.diliveryVal = diliveryVal == null ? null : diliveryVal.trim();
    }
}