package com.muc.service;

import com.muc.bean.JobRequirements;

import java.util.List;

public interface JobRequirementsService {
    public int insert(JobRequirements jobRequirements);
    public int delete(int id);
    public int update(JobRequirements jobRequirements);
    public List<JobRequirements> selectByJobId(int id);
}
