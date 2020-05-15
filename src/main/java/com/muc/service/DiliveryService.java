package com.muc.service;

import com.muc.bean.Dilivery;

import java.util.ArrayList;

public interface DiliveryService {
    public int insert(Dilivery dilivery);
    public ArrayList<Dilivery> seletMyDilivery(String openid);
    public int upadate(Dilivery dilivery);
}
