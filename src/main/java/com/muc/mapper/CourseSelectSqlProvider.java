package com.muc.mapper;

import com.muc.bean.CourseSelect;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class CourseSelectSqlProvider {

    public String insertSelective(CourseSelect record) {
        BEGIN();
        INSERT_INTO("course_select");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCourseSelectUserId() != null) {
            VALUES("course_select_user_id", "#{courseSelectUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getCourseId() != null) {
            VALUES("course_id", "#{courseId,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            VALUES("score", "#{score,jdbcType=BIT}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(CourseSelect record) {
        BEGIN();
        UPDATE("course_select");
        
        if (record.getCourseSelectUserId() != null) {
            SET("course_select_user_id = #{courseSelectUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getCourseId() != null) {
            SET("course_id = #{courseId,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            SET("score = #{score,jdbcType=BIT}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}