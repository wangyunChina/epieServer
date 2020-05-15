package com.muc.bean;

import java.io.Serializable;

public class TradeType implements Serializable {
    private Integer id;

    private String tradeTypeVal;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradeTypeVal() {
        return tradeTypeVal;
    }

    public void setTradeTypeVal(String tradeTypeVal) {
        this.tradeTypeVal = tradeTypeVal == null ? null : tradeTypeVal.trim();
    }
}