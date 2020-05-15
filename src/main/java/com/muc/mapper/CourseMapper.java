package com.muc.mapper;

import com.muc.bean.Course;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface CourseMapper {
    @Delete({
        "delete from course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into course (id, course_name, ",
        "course_time, course_teacher_name, ",
        "course_create_user_id, course_type)",
        "values (#{id,jdbcType=INTEGER}, #{courseName,jdbcType=VARCHAR}, ",
        "#{courseTime,jdbcType=VARCHAR}, #{courseTeacherName,jdbcType=VARCHAR}, ",
        "#{courseCreateUserId,jdbcType=VARCHAR}, #{courseType,jdbcType=BIT})"
    })
    int insert(Course record);

    @InsertProvider(type=CourseSqlProvider.class, method="insertSelective")
    int insertSelective(Course record);

    @Select({
        "select",
        "id, course_name, course_time, course_teacher_name, course_create_user_id, course_type",
        "from course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="course_name", property="courseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_time", property="courseTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_teacher_name", property="courseTeacherName", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_create_user_id", property="courseCreateUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_type", property="courseType", jdbcType=JdbcType.BIT)
    })
    Course selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CourseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Course record);

    @Update({
        "update course",
        "set course_name = #{courseName,jdbcType=VARCHAR},",
          "course_time = #{courseTime,jdbcType=VARCHAR},",
          "course_teacher_name = #{courseTeacherName,jdbcType=VARCHAR},",
          "course_create_user_id = #{courseCreateUserId,jdbcType=VARCHAR},",
          "course_type = #{courseType,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Course record);
}