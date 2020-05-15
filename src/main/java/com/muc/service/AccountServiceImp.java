package com.muc.service;

import com.muc.bean.Acount;
import com.muc.mapper.AcountMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImp implements AccountService {
    @Resource
    AcountMapper acountMapper;
    @Override
    public int create(Acount acount) {
        return acountMapper.insert(acount);
    }

    @Override
    public int update(Acount acount) {
        return acountMapper.updateByPrimaryKey(acount);
    }

    @Override
    public Acount select(String userid) {
        return acountMapper.selectByUserId(userid);
    }
}
