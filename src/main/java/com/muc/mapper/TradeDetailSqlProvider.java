package com.muc.mapper;

import com.muc.bean.TradeDetail;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class TradeDetailSqlProvider {

    public String insertSelective(TradeDetail record) {
        BEGIN();
        INSERT_INTO("trade_detail");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTradeMasterAcountId() != null) {
            VALUES("trade_master_acount_id", "#{tradeMasterAcountId,jdbcType=INTEGER}");
        }
        
        if (record.getTradeSlaveAcountId() != null) {
            VALUES("trade_slave_acount_id", "#{tradeSlaveAcountId,jdbcType=INTEGER}");
        }
        
        if (record.getTradeTypeId() != null) {
            VALUES("trade_type_id", "#{tradeTypeId,jdbcType=INTEGER}");
        }
        
        if (record.getTradeMoney() != null) {
            VALUES("trade_money", "#{tradeMoney,jdbcType=DOUBLE}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(TradeDetail record) {
        BEGIN();
        UPDATE("trade_detail");
        
        if (record.getTradeMasterAcountId() != null) {
            SET("trade_master_acount_id = #{tradeMasterAcountId,jdbcType=INTEGER}");
        }
        
        if (record.getTradeSlaveAcountId() != null) {
            SET("trade_slave_acount_id = #{tradeSlaveAcountId,jdbcType=INTEGER}");
        }
        
        if (record.getTradeTypeId() != null) {
            SET("trade_type_id = #{tradeTypeId,jdbcType=INTEGER}");
        }
        
        if (record.getTradeMoney() != null) {
            SET("trade_money = #{tradeMoney,jdbcType=DOUBLE}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}