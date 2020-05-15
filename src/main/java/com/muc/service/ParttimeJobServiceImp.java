package com.muc.service;

import com.muc.bean.ParttimeJob;
import com.muc.mapper.ParttimeJobMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ParttimeJobServiceImp implements PartimeJobService {
    @Resource
    ParttimeJobMapper parttimeJobMapper;
    @Override
    public List<ParttimeJob> selectByName(String name) {
        return parttimeJobMapper.selectByName(name);
    }

    @Override
    public ParttimeJob selectById(int id) {
        return parttimeJobMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ParttimeJob> selectByReginal(String reginal) {
        return parttimeJobMapper.selectByOrigin(reginal);
    }

    @Override
    public List<ParttimeJob> selectByWagesEndType(int type) {
        return parttimeJobMapper.selectByWagesEndType(type);
    }

    @Override
    public List<ParttimeJob> selectByReginalAndName(String reginal, String name) {
        return parttimeJobMapper.selectByOriginAndName(reginal,name);
    }

    @Override
    public List<ParttimeJob> selectAll(int limit) {
        return parttimeJobMapper.selectAll(limit);
    }

    @Override
    public List<ParttimeJob> selectByCompanyId(int id) {
        return parttimeJobMapper.selectByCompanyId(id);
    }

    @Override
    public int insert(ParttimeJob job) {
        return parttimeJobMapper.insert(job);
    }

    @Override
    public int delete(int id) {
        return parttimeJobMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(ParttimeJob job) {
        return parttimeJobMapper.updateByPrimaryKey(job);
    }
}
