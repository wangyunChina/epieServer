package com.muc.mapper;

import com.muc.bean.Notice;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class NoticeSqlProvider {

    public String insertSelective(Notice record) {
        BEGIN();
        INSERT_INTO("notice");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getSendpeople() != null) {
            VALUES("sendpeople", "#{sendpeople,jdbcType=VARCHAR}");
        }
        
        if (record.getAcceptpeople() != null) {
            VALUES("acceptpeople", "#{acceptpeople,jdbcType=VARCHAR}");
        }
        
        if (record.getNoticeContext() != null) {
            VALUES("notice_context", "#{noticeContext,jdbcType=VARCHAR}");
        }
        
        if (record.getNoticeTargetUrl() != null) {
            VALUES("notice_target_url", "#{noticeTargetUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getNoticeStatus() != null) {
            VALUES("notice_status", "#{noticeStatus,jdbcType=BIT}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Notice record) {
        BEGIN();
        UPDATE("notice");
        
        if (record.getSendpeople() != null) {
            SET("sendpeople = #{sendpeople,jdbcType=VARCHAR}");
        }
        
        if (record.getAcceptpeople() != null) {
            SET("acceptpeople = #{acceptpeople,jdbcType=VARCHAR}");
        }
        
        if (record.getNoticeContext() != null) {
            SET("notice_context = #{noticeContext,jdbcType=VARCHAR}");
        }
        
        if (record.getNoticeTargetUrl() != null) {
            SET("notice_target_url = #{noticeTargetUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getNoticeStatus() != null) {
            SET("notice_status = #{noticeStatus,jdbcType=BIT}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}