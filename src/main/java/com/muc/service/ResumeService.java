package com.muc.service;

import com.muc.bean.Resume;

import java.util.ArrayList;

public interface ResumeService {
    public ArrayList<Resume> selectByOpenid(String openid);
    public int insert(Resume resume);
    public int delete(int id);
}
