package com.muc.service;

import com.muc.bean.Education;
import com.muc.mapper.EducationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EducationServiceImp implements EducationService{
    @Resource
    EducationMapper educationMapper;
    @Override
    public Education selectById(int id) {
        return educationMapper.selectByPrimaryKey(id);
    }
}
