package com.muc.mapper;

import com.muc.bean.WagesEndType;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class WagesEndTypeSqlProvider {

    public String insertSelective(WagesEndType record) {
        BEGIN();
        INSERT_INTO("wages_end_type");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getVal() != null) {
            VALUES("val", "#{val,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(WagesEndType record) {
        BEGIN();
        UPDATE("wages_end_type");
        
        if (record.getVal() != null) {
            SET("val = #{val,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}