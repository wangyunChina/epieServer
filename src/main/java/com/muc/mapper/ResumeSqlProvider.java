package com.muc.mapper;

import com.muc.bean.Resume;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ResumeSqlProvider {

    public String insertSelective(Resume record) {
        BEGIN();
        INSERT_INTO("user_resume");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getOpenid() != null) {
            VALUES("openid", "#{openid,jdbcType=VARCHAR}");
        }
        
        if (record.getFilePath() != null) {
            VALUES("file_path", "#{filePath,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getResumeDesc() != null) {
            VALUES("resume_desc", "#{resumeDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getPosterPath() != null) {
            VALUES("poster_path", "#{posterPath,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Resume record) {
        BEGIN();
        UPDATE("user_resume");
        
        if (record.getOpenid() != null) {
            SET("openid = #{openid,jdbcType=VARCHAR}");
        }
        
        if (record.getFilePath() != null) {
            SET("file_path = #{filePath,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getResumeDesc() != null) {
            SET("resume_desc = #{resumeDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getPosterPath() != null) {
            SET("poster_path = #{posterPath,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}