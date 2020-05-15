package com.muc.mapper;

import com.muc.bean.Company;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class CompanySqlProvider {

    public String insertSelective(Company record) {
        BEGIN();
        INSERT_INTO("company");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getOpenid() != null) {
            VALUES("openid", "#{openid,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyName() != null) {
            VALUES("company_name", "#{companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyDesc() != null) {
            VALUES("company_desc", "#{companyDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyDetail() != null) {
            VALUES("company_detail", "#{companyDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyLocation() != null) {
            VALUES("company_location", "#{companyLocation,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyLogo() != null) {
            VALUES("company_logo", "#{companyLogo,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyReviewStatus() != null) {
            VALUES("company_review_status", "#{companyReviewStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyTypeLevel1() != null) {
            VALUES("company_type_level1", "#{companyTypeLevel1,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyTypeLevel2() != null) {
            VALUES("company_type_level2", "#{companyTypeLevel2,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyLicenceUrl() != null) {
            VALUES("company_licence_url", "#{companyLicenceUrl,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Company record) {
        BEGIN();
        UPDATE("company");
        
        if (record.getOpenid() != null) {
            SET("openid = #{openid,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyName() != null) {
            SET("company_name = #{companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyDesc() != null) {
            SET("company_desc = #{companyDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyDetail() != null) {
            SET("company_detail = #{companyDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyLocation() != null) {
            SET("company_location = #{companyLocation,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyLogo() != null) {
            SET("company_logo = #{companyLogo,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyReviewStatus() != null) {
            SET("company_review_status = #{companyReviewStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyTypeLevel1() != null) {
            SET("company_type_level1 = #{companyTypeLevel1,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyTypeLevel2() != null) {
            SET("company_type_level2 = #{companyTypeLevel2,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyLicenceUrl() != null) {
            SET("company_licence_url = #{companyLicenceUrl,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}