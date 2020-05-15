package com.muc.service;

import com.muc.bean.JobDescription;

import java.util.List;

public interface JobDescriptionService {
    public int insert(JobDescription description);
    public int delete(int id);
    public int update(JobDescription description);
    public List<JobDescription> selectByJobId(int id);


}
