package com.muc.service;

import com.muc.bean.UserWork;

import java.util.ArrayList;

public interface UserWorkService {
    public UserWork selectById(int id);
    public ArrayList<UserWork> selectByOpenid(String openid);
    public int delete(int id);
    public int insert(UserWork userWork);

}
