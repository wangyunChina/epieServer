package com.muc.mapper;

import com.muc.bean.TradeType;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class TradeTypeSqlProvider {

    public String insertSelective(TradeType record) {
        BEGIN();
        INSERT_INTO("trade_type");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTradeTypeVal() != null) {
            VALUES("trade_type_val", "#{tradeTypeVal,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(TradeType record) {
        BEGIN();
        UPDATE("trade_type");
        
        if (record.getTradeTypeVal() != null) {
            SET("trade_type_val = #{tradeTypeVal,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}