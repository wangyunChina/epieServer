package com.muc.mapper;

import com.muc.bean.Acount;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class AcountSqlProvider {

    public String insertSelective(Acount record) {
        BEGIN();
        INSERT_INTO("acount");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getAcountUserId() != null) {
            VALUES("acount_user_id", "#{acountUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getAcountMoney() != null) {
            VALUES("acount_money", "#{acountMoney,jdbcType=DOUBLE}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Acount record) {
        BEGIN();
        UPDATE("acount");
        
        if (record.getAcountUserId() != null) {
            SET("acount_user_id = #{acountUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getAcountMoney() != null) {
            SET("acount_money = #{acountMoney,jdbcType=DOUBLE}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}