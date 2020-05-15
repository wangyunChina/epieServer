package com.muc.mapper;

import com.muc.bean.EpieChat;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class EpieChatSqlProvider {

    public String insertSelective(EpieChat record) {
        BEGIN();
        INSERT_INTO("epie_chat");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getSendpeople() != null) {
            VALUES("sendpeople", "#{sendpeople,jdbcType=VARCHAR}");
        }
        
        if (record.getAcceptpeople() != null) {
            VALUES("acceptpeople", "#{acceptpeople,jdbcType=VARCHAR}");
        }
        
        if (record.getMessage() != null) {
            VALUES("message", "#{message,jdbcType=VARCHAR}");
        }
        
        if (record.getSendtime() != null) {
            VALUES("sendtime", "#{sendtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsread() != null) {
            VALUES("isread", "#{isread,jdbcType=BIT}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(EpieChat record) {
        BEGIN();
        UPDATE("epie_chat");
        
        if (record.getSendpeople() != null) {
            SET("sendpeople = #{sendpeople,jdbcType=VARCHAR}");
        }
        
        if (record.getAcceptpeople() != null) {
            SET("acceptpeople = #{acceptpeople,jdbcType=VARCHAR}");
        }
        
        if (record.getMessage() != null) {
            SET("message = #{message,jdbcType=VARCHAR}");
        }
        
        if (record.getSendtime() != null) {
            SET("sendtime = #{sendtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsread() != null) {
            SET("isread = #{isread,jdbcType=BIT}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}