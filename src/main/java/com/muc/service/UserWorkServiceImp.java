package com.muc.service;

import com.muc.bean.EpieUser;
import com.muc.bean.UserWork;
import com.muc.mapper.UserWorkMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
@Service
public class UserWorkServiceImp implements UserWorkService{
    @Resource
    UserWorkMapper userWorkMapper;
    @Override
    public UserWork selectById(int id) {
        return userWorkMapper.selectByPrimaryKey(id);
    }

    @Override
    public ArrayList<UserWork> selectByOpenid(String openid) {
        return userWorkMapper.selectByOpenId(openid);
    }

    @Override
    public int delete(int id) {
        return userWorkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserWork userWork) {
        return userWorkMapper.insert(userWork);
    }
}
