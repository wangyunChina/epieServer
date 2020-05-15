package com.muc.mapper;

import com.muc.bean.Course;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class CourseSqlProvider {

    public String insertSelective(Course record) {
        BEGIN();
        INSERT_INTO("course");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCourseName() != null) {
            VALUES("course_name", "#{courseName,jdbcType=VARCHAR}");
        }
        
        if (record.getCourseTime() != null) {
            VALUES("course_time", "#{courseTime,jdbcType=VARCHAR}");
        }
        
        if (record.getCourseTeacherName() != null) {
            VALUES("course_teacher_name", "#{courseTeacherName,jdbcType=VARCHAR}");
        }
        
        if (record.getCourseCreateUserId() != null) {
            VALUES("course_create_user_id", "#{courseCreateUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getCourseType() != null) {
            VALUES("course_type", "#{courseType,jdbcType=BIT}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Course record) {
        BEGIN();
        UPDATE("course");
        
        if (record.getCourseName() != null) {
            SET("course_name = #{courseName,jdbcType=VARCHAR}");
        }
        
        if (record.getCourseTime() != null) {
            SET("course_time = #{courseTime,jdbcType=VARCHAR}");
        }
        
        if (record.getCourseTeacherName() != null) {
            SET("course_teacher_name = #{courseTeacherName,jdbcType=VARCHAR}");
        }
        
        if (record.getCourseCreateUserId() != null) {
            SET("course_create_user_id = #{courseCreateUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getCourseType() != null) {
            SET("course_type = #{courseType,jdbcType=BIT}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}