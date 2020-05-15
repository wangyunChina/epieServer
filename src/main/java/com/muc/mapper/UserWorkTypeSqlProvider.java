package com.muc.mapper;

import com.muc.bean.UserWorkType;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class UserWorkTypeSqlProvider {

    public String insertSelective(UserWorkType record) {
        BEGIN();
        INSERT_INTO("user_work_type");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getVal() != null) {
            VALUES("val", "#{val,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(UserWorkType record) {
        BEGIN();
        UPDATE("user_work_type");
        
        if (record.getVal() != null) {
            SET("val = #{val,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}