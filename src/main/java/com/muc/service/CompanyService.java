package com.muc.service;

import com.muc.bean.Company;

import java.util.List;

public interface CompanyService {
    public Company selectById(int id);
    public Company selectByOpenId(String openid);
    public List<Company> selectAll(int limit);
    public List<Company> selectByLocation(String location);
    public int update(Company record);
    public int delete(int id);
    public int insert(Company company);
}
