package com.muc.mapper;

import com.muc.bean.UserWork;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class UserWorkSqlProvider {

    public String insertSelective(UserWork record) {
        BEGIN();
        INSERT_INTO("user_work");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getOpenid() != null) {
            VALUES("openid", "#{openid,jdbcType=VARCHAR}");
        }
        
        if (record.getWorkType() != null) {
            VALUES("work_type", "#{workType,jdbcType=INTEGER}");
        }
        
        if (record.getWorkTitel() != null) {
            VALUES("work_titel", "#{workTitel,jdbcType=VARCHAR}");
        }
        
        if (record.getWorkDesc() != null) {
            VALUES("work_desc", "#{workDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getWorkPoster() != null) {
            VALUES("work_poster", "#{workPoster,jdbcType=VARCHAR}");
        }
        
        if (record.getWorkPath() != null) {
            VALUES("work_path", "#{workPath,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(UserWork record) {
        BEGIN();
        UPDATE("user_work");
        
        if (record.getOpenid() != null) {
            SET("openid = #{openid,jdbcType=VARCHAR}");
        }
        
        if (record.getWorkType() != null) {
            SET("work_type = #{workType,jdbcType=INTEGER}");
        }
        
        if (record.getWorkTitel() != null) {
            SET("work_titel = #{workTitel,jdbcType=VARCHAR}");
        }
        
        if (record.getWorkDesc() != null) {
            SET("work_desc = #{workDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getWorkPoster() != null) {
            SET("work_poster = #{workPoster,jdbcType=VARCHAR}");
        }
        
        if (record.getWorkPath() != null) {
            SET("work_path = #{workPath,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}