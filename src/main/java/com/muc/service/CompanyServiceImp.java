package com.muc.service;

import com.muc.bean.Company;
import com.muc.mapper.CompanyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CompanyServiceImp implements CompanyService {
    @Resource
    CompanyMapper companyMapper;
    @Override
    public Company selectById(int id) {
        return companyMapper.selectByPrimaryKey(id);
    }

    @Override
    public Company selectByOpenId(String openid) {
        return companyMapper.selectByOpenid(openid);
    }

    @Override
    public List<Company> selectAll( int limit) {
        return companyMapper.selectAll( limit);
    }

    @Override
    public List<Company> selectByLocation(String location) {
        return companyMapper.selectByLocation(location);
    }

    @Override
    public int update(Company record) {
        return companyMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delete(int id) {
        return companyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Company company) {
        return companyMapper.insert(company);
    }
}
