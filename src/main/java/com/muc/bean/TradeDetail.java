package com.muc.bean;

import java.io.Serializable;

public class TradeDetail implements Serializable {
    private Integer id;

    private Integer tradeMasterAcountId;

    private Integer tradeSlaveAcountId;

    private Integer tradeTypeId;

    private Double tradeMoney;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTradeMasterAcountId() {
        return tradeMasterAcountId;
    }

    public void setTradeMasterAcountId(Integer tradeMasterAcountId) {
        this.tradeMasterAcountId = tradeMasterAcountId;
    }

    public Integer getTradeSlaveAcountId() {
        return tradeSlaveAcountId;
    }

    public void setTradeSlaveAcountId(Integer tradeSlaveAcountId) {
        this.tradeSlaveAcountId = tradeSlaveAcountId;
    }

    public Integer getTradeTypeId() {
        return tradeTypeId;
    }

    public void setTradeTypeId(Integer tradeTypeId) {
        this.tradeTypeId = tradeTypeId;
    }

    public Double getTradeMoney() {
        return tradeMoney;
    }

    public void setTradeMoney(Double tradeMoney) {
        this.tradeMoney = tradeMoney;
    }
}