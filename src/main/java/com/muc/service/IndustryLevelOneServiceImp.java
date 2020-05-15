package com.muc.service;

import com.muc.bean.IndustryLevelOne;
import com.muc.mapper.IndustryLevelOneMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IndustryLevelOneServiceImp implements IndustryLevelOneService{
    @Resource
    IndustryLevelOneMapper industryLevelOneMapper;
    @Override
    public IndustryLevelOne selectById(int id) {
        return industryLevelOneMapper.selectByPrimaryKey(id);
    }
}
