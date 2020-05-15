package com.muc.mapper;

import com.muc.bean.Education;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class EducationSqlProvider {

    public String insertSelective(Education record) {
        BEGIN();
        INSERT_INTO("education");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getVal() != null) {
            VALUES("val", "#{val,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Education record) {
        BEGIN();
        UPDATE("education");
        
        if (record.getVal() != null) {
            SET("val = #{val,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}