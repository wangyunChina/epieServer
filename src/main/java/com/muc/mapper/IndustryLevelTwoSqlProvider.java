package com.muc.mapper;

import com.muc.bean.IndustryLevelTwo;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class IndustryLevelTwoSqlProvider {

    public String insertSelective(IndustryLevelTwo record) {
        BEGIN();
        INSERT_INTO("industry_level_two");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getPid() != null) {
            VALUES("pid", "#{pid,jdbcType=INTEGER}");
        }
        
        if (record.getVal() != null) {
            VALUES("val", "#{val,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(IndustryLevelTwo record) {
        BEGIN();
        UPDATE("industry_level_two");
        
        if (record.getPid() != null) {
            SET("pid = #{pid,jdbcType=INTEGER}");
        }
        
        if (record.getVal() != null) {
            SET("val = #{val,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}