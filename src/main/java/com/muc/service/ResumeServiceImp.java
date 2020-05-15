package com.muc.service;

import com.muc.bean.Resume;
import com.muc.mapper.ResumeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
@Service
public class ResumeServiceImp implements ResumeService {
    @Resource
    ResumeMapper resumeMapper;
    @Override
    public ArrayList<Resume> selectByOpenid(String openid) {
        return resumeMapper.selectByOpenid(openid);
    }

    @Override
    public int insert(Resume resume) {
        return resumeMapper.insert(resume);
    }

    @Override
    public int delete(int id) {
        return resumeMapper.deleteByPrimaryKey(id);
    }
}
