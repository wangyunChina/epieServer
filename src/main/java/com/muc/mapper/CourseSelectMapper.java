package com.muc.mapper;

import com.muc.bean.CourseSelect;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface CourseSelectMapper {
    @Delete({
        "delete from course_select",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into course_select (id, course_select_user_id, ",
        "course_id, score)",
        "values (#{id,jdbcType=INTEGER}, #{courseSelectUserId,jdbcType=VARCHAR}, ",
        "#{courseId,jdbcType=INTEGER}, #{score,jdbcType=BIT})"
    })
    int insert(CourseSelect record);

    @InsertProvider(type=CourseSelectSqlProvider.class, method="insertSelective")
    int insertSelective(CourseSelect record);

    @Select({
        "select",
        "id, course_select_user_id, course_id, score",
        "from course_select",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="course_select_user_id", property="courseSelectUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER),
        @Result(column="score", property="score", jdbcType=JdbcType.BIT)
    })
    CourseSelect selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CourseSelectSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CourseSelect record);

    @Update({
        "update course_select",
        "set course_select_user_id = #{courseSelectUserId,jdbcType=VARCHAR},",
          "course_id = #{courseId,jdbcType=INTEGER},",
          "score = #{score,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CourseSelect record);
}