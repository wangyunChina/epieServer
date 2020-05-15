package com.muc.mapper;

import com.muc.bean.UserWork;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.ArrayList;

public interface UserWorkMapper {
    @Delete({
        "delete from user_work",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user_work (id, openid, ",
        "work_type, work_titel, ",
        "work_desc, work_poster, ",
        "work_path)",
        "values (#{id,jdbcType=INTEGER}, #{openid,jdbcType=VARCHAR}, ",
        "#{workType,jdbcType=INTEGER}, #{workTitel,jdbcType=VARCHAR}, ",
        "#{workDesc,jdbcType=VARCHAR}, #{workPoster,jdbcType=VARCHAR}, ",
        "#{workPath,jdbcType=VARCHAR})"
    })
    int insert(UserWork record);

    @InsertProvider(type=UserWorkSqlProvider.class, method="insertSelective")
    int insertSelective(UserWork record);

    @Select({
        "select",
        "id, openid, work_type, work_titel, work_desc, work_poster, work_path",
        "from user_work",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="work_type", property="workType", jdbcType=JdbcType.INTEGER),
        @Result(column="work_titel", property="workTitel", jdbcType=JdbcType.VARCHAR),
        @Result(column="work_desc", property="workDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="work_poster", property="workPoster", jdbcType=JdbcType.VARCHAR),
        @Result(column="work_path", property="workPath", jdbcType=JdbcType.VARCHAR)
    })
    UserWork selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserWorkSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserWork record);

    @Update({
        "update user_work",
        "set openid = #{openid,jdbcType=VARCHAR},",
          "work_type = #{workType,jdbcType=INTEGER},",
          "work_titel = #{workTitel,jdbcType=VARCHAR},",
          "work_desc = #{workDesc,jdbcType=VARCHAR},",
          "work_poster = #{workPoster,jdbcType=VARCHAR},",
          "work_path = #{workPath,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserWork record);

    @Select({
            "select",
            "id, openid, work_type, work_titel, work_desc, work_poster, work_path",
            "from user_work",
            "where openid = #{openid,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
            @Result(column="work_type", property="workType", jdbcType=JdbcType.INTEGER),
            @Result(column="work_titel", property="workTitel", jdbcType=JdbcType.VARCHAR),
            @Result(column="work_desc", property="workDesc", jdbcType=JdbcType.VARCHAR),
            @Result(column="work_poster", property="workPoster", jdbcType=JdbcType.VARCHAR),
            @Result(column="work_path", property="workPath", jdbcType=JdbcType.VARCHAR)
    })
    ArrayList<UserWork> selectByOpenId(String openid);
}