package com.muc.service;

import com.muc.bean.ParttimeJob;

import java.util.List;

public interface PartimeJobService {
    /*查询方法*/
    public List<ParttimeJob> selectByName(String name);
    public ParttimeJob selectById(int id);
    public List<ParttimeJob> selectByReginal(String reginal);
    public List<ParttimeJob> selectByWagesEndType(int type);
    public List<ParttimeJob> selectByReginalAndName(String reginal,String name);
    public List<ParttimeJob> selectAll(int limit);
    public List<ParttimeJob> selectByCompanyId(int id);
    /*创建方法*/
    public int insert(ParttimeJob job);
    /*删除*/
    public int delete(int id);
    /*更新*/
    public int update(ParttimeJob job);

}
