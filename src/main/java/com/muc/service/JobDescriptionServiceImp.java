package com.muc.service;

import com.muc.bean.JobDescription;
import com.muc.mapper.JobDescriptionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class JobDescriptionServiceImp implements JobDescriptionService {
    @Resource
    JobDescriptionMapper jobDescriptionMapper;
    @Override
    public int insert(JobDescription description) {

        return jobDescriptionMapper.insert(description);
    }

    @Override
    public int delete(int id) {
        return jobDescriptionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(JobDescription description) {
        return jobDescriptionMapper.updateByPrimaryKey(description);
    }

    @Override
    public List<JobDescription> selectByJobId(int id) {
        return jobDescriptionMapper.selectByJobId(id);
    }
}
