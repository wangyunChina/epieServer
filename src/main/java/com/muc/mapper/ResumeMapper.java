package com.muc.mapper;

import com.muc.bean.Resume;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.ArrayList;

public interface ResumeMapper {
    @Delete({
        "delete from user_resume",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user_resume (id, openid, ",
        "file_path, title, ",
        "resume_desc, poster_path)",
        "values (#{id,jdbcType=INTEGER}, #{openid,jdbcType=VARCHAR}, ",
        "#{filePath,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR}, ",
        "#{resumeDesc,jdbcType=VARCHAR}, #{posterPath,jdbcType=VARCHAR})"
    })
    int insert(Resume record);

    @InsertProvider(type=ResumeSqlProvider.class, method="insertSelective")
    int insertSelective(Resume record);

    @Select({
        "select",
        "id, openid, file_path, title, resume_desc, poster_path",
        "from user_resume",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_path", property="filePath", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="resume_desc", property="resumeDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="poster_path", property="posterPath", jdbcType=JdbcType.VARCHAR)
    })
    Resume selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ResumeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Resume record);

    @Update({
        "update user_resume",
        "set openid = #{openid,jdbcType=VARCHAR},",
          "file_path = #{filePath,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "resume_desc = #{resumeDesc,jdbcType=VARCHAR},",
          "poster_path = #{posterPath,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Resume record);
    @Select({
            "select",
            "id, openid, file_path, title, resume_desc, poster_path",
            "from user_resume",
            "where openid = #{openid,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
            @Result(column="file_path", property="filePath", jdbcType=JdbcType.VARCHAR),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="resume_desc", property="resumeDesc", jdbcType=JdbcType.VARCHAR),
            @Result(column="poster_path", property="posterPath", jdbcType=JdbcType.VARCHAR)
    })
    ArrayList<Resume> selectByOpenid(String openid);
}