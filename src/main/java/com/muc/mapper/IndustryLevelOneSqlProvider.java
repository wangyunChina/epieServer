package com.muc.mapper;

import com.muc.bean.IndustryLevelOne;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class IndustryLevelOneSqlProvider {

    public String insertSelective(IndustryLevelOne record) {
        BEGIN();
        INSERT_INTO("industry_level_one");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getVal() != null) {
            VALUES("val", "#{val,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(IndustryLevelOne record) {
        BEGIN();
        UPDATE("industry_level_one");
        
        if (record.getVal() != null) {
            SET("val = #{val,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}