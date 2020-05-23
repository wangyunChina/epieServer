package com.muc.service;

import com.muc.bean.Dilivery;
import com.muc.mapper.DiliveryMapper;
import com.muc.viewModel.DiliverViewModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
@Service
public class DiliveryServiceImp implements DiliveryService {
    @Resource
    DiliveryMapper diliveryMapper;
    @Override
    public int insert(Dilivery dilivery) {
        return diliveryMapper.insertSelective(dilivery);
    }



    @Override
    public int upadate(Dilivery dilivery) {
        return diliveryMapper.updateByPrimaryKey(dilivery);
    }

    @Override
    public ArrayList<DiliverViewModel> seletMyDiliveryView(String openid) {
        return diliveryMapper.selectByOpenidView(openid);
    }

    @Override
    public ArrayList<Dilivery> seletMyDilivery(String openid) {
        return diliveryMapper.selectByOpenid(openid);
    }
}
