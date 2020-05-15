package com.muc.mapper;

import com.muc.bean.Education;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface EducationMapper {
    @Delete({
        "delete from education",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into education (id, val)",
        "values (#{id,jdbcType=INTEGER}, #{val,jdbcType=VARCHAR})"
    })
    int insert(Education record);

    @InsertProvider(type=EducationSqlProvider.class, method="insertSelective")
    int insertSelective(Education record);

    @Select({
        "select",
        "id, val",
        "from education",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="val", property="val", jdbcType=JdbcType.VARCHAR)
    })
    Education selectByPrimaryKey(Integer id);

    @UpdateProvider(type=EducationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Education record);

    @Update({
        "update education",
        "set val = #{val,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Education record);
}