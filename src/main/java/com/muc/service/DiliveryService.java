package com.muc.service;

import com.muc.bean.Dilivery;
import com.muc.viewModel.DiliverViewModel;

import java.util.ArrayList;

public interface DiliveryService {
    public int insert(Dilivery dilivery);
    public int upadate(Dilivery dilivery);
    public ArrayList<DiliverViewModel> seletMyDiliveryView(String openid);
    public ArrayList<Dilivery> seletMyDilivery(String openid);
}
