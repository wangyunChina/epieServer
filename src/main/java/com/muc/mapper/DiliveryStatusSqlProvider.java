package com.muc.mapper;

import com.muc.bean.DiliveryStatus;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class DiliveryStatusSqlProvider {

    public String insertSelective(DiliveryStatus record) {
        BEGIN();
        INSERT_INTO("dilivery_status");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getDiliveryVal() != null) {
            VALUES("dilivery_val", "#{diliveryVal,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(DiliveryStatus record) {
        BEGIN();
        UPDATE("dilivery_status");
        
        if (record.getDiliveryVal() != null) {
            SET("dilivery_val = #{diliveryVal,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}