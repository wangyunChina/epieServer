package com.muc.mapper;

import com.muc.bean.IndustryLevelOne;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface IndustryLevelOneMapper {
    @Delete({
        "delete from industry_level_one",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into industry_level_one (id, val)",
        "values (#{id,jdbcType=INTEGER}, #{val,jdbcType=VARCHAR})"
    })
    int insert(IndustryLevelOne record);

    @InsertProvider(type=IndustryLevelOneSqlProvider.class, method="insertSelective")
    int insertSelective(IndustryLevelOne record);

    @Select({
        "select",
        "id, val",
        "from industry_level_one",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="val", property="val", jdbcType=JdbcType.VARCHAR)
    })
    IndustryLevelOne selectByPrimaryKey(Integer id);

    @UpdateProvider(type=IndustryLevelOneSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(IndustryLevelOne record);

    @Update({
        "update industry_level_one",
        "set val = #{val,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(IndustryLevelOne record);
}