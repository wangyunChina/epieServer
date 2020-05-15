package com.muc.service;

import com.muc.bean.Dilivery;
import com.muc.mapper.DiliveryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
@Service
public class DiliveryServiceImp implements DiliveryService {
    @Resource
    DiliveryMapper diliveryMapper;
    @Override
    public int insert(Dilivery dilivery) {
        return diliveryMapper.insert(dilivery);
    }

    @Override
    public ArrayList<Dilivery> seletMyDilivery(String openid) {
        return diliveryMapper.selectByOpenid(openid);
    }

    @Override
    public int upadate(Dilivery dilivery) {
        return diliveryMapper.updateByPrimaryKey(dilivery);
    }
}
