package com.muc.mapper;

import com.muc.bean.IndustryLevelTwo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface IndustryLevelTwoMapper {
    @Delete({
        "delete from industry_level_two",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into industry_level_two (id, pid, ",
        "val)",
        "values (#{id,jdbcType=INTEGER}, #{pid,jdbcType=INTEGER}, ",
        "#{val,jdbcType=VARCHAR})"
    })
    int insert(IndustryLevelTwo record);

    @InsertProvider(type=IndustryLevelTwoSqlProvider.class, method="insertSelective")
    int insertSelective(IndustryLevelTwo record);

    @Select({
        "select",
        "id, pid, val",
        "from industry_level_two",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="val", property="val", jdbcType=JdbcType.VARCHAR)
    })
    IndustryLevelTwo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=IndustryLevelTwoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(IndustryLevelTwo record);

    @Update({
        "update industry_level_two",
        "set pid = #{pid,jdbcType=INTEGER},",
          "val = #{val,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(IndustryLevelTwo record);
}