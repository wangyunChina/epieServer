package com.muc.service;

import com.muc.bean.ReviewStatus;
import com.muc.mapper.ReviewStatusMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReviewStatusServiceImp implements ReviewStatusService {
    @Resource
    ReviewStatusMapper reviewStatusMapper;
    @Override
    public ReviewStatus selectById(int id) {
        return reviewStatusMapper.selectByPrimaryKey(id);
    }
}
