package com.muc.mapper;

import com.muc.bean.Dilivery;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class DiliverySqlProvider {

    public String insertSelective(Dilivery record) {
        BEGIN();
        INSERT_INTO("diliver");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getDiliverJobId() != null) {
            VALUES("diliver_job_id", "#{diliverJobId,jdbcType=INTEGER}");
        }
        
        if (record.getDiliverUserId() != null) {
            VALUES("diliver_user_id", "#{diliverUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getDiliverOptionTime() != null) {
            VALUES("diliver_option_time", "#{diliverOptionTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDiliverStatusId() != null) {
            VALUES("diliver_status_id", "#{diliverStatusId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Dilivery record) {
        BEGIN();
        UPDATE("diliver");
        
        if (record.getDiliverJobId() != null) {
            SET("diliver_job_id = #{diliverJobId,jdbcType=INTEGER}");
        }
        
        if (record.getDiliverUserId() != null) {
            SET("diliver_user_id = #{diliverUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getDiliverOptionTime() != null) {
            SET("diliver_option_time = #{diliverOptionTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDiliverStatusId() != null) {
            SET("diliver_status_id = #{diliverStatusId,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}