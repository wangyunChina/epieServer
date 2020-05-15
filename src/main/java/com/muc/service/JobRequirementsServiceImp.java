package com.muc.service;

import com.muc.bean.JobRequirements;
import com.muc.mapper.JobRequirementsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class JobRequirementsServiceImp implements JobRequirementsService {
    @Resource
    JobRequirementsMapper jobRequirementsMapper;
    @Override
    public int insert(JobRequirements jobRequirements) {
        return jobRequirementsMapper.insert(jobRequirements);
    }

    @Override
    public int delete(int id) {
        return jobRequirementsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(JobRequirements jobRequirements) {
        return jobRequirementsMapper.updateByPrimaryKey(jobRequirements);
    }

    @Override
    public List<JobRequirements> selectByJobId(int id) {
        return jobRequirementsMapper.selectByJobId(id);
    }
}
