package com.muc.mapper;

import com.muc.bean.EpieSex;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class EpieSexSqlProvider {

    public String insertSelective(EpieSex record) {
        BEGIN();
        INSERT_INTO("sex");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=TINYINT}");
        }
        
        if (record.getVal() != null) {
            VALUES("val", "#{val,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(EpieSex record) {
        BEGIN();
        UPDATE("sex");
        
        if (record.getVal() != null) {
            SET("val = #{val,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=TINYINT}");
        
        return SQL();
    }
}