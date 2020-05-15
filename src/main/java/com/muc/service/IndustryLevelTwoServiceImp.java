package com.muc.service;

import com.muc.bean.IndustryLevelTwo;
import com.muc.mapper.IndustryLevelTwoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IndustryLevelTwoServiceImp implements IndustryLevelTwoService{
    @Resource
    IndustryLevelTwoMapper industryLevelTwoMapper;
    @Override
    public IndustryLevelTwo selectById(int id) {
        return industryLevelTwoMapper.selectByPrimaryKey(id);
    }
}
