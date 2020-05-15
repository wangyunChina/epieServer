package com.muc.mapper;

import com.muc.bean.EpieSex;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface EpieSexMapper {
    @Delete({
        "delete from sex",
        "where id = #{id,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(Byte id);

    @Insert({
        "insert into sex (id, val)",
        "values (#{id,jdbcType=TINYINT}, #{val,jdbcType=VARCHAR})"
    })
    int insert(EpieSex record);

    @InsertProvider(type= EpieSexSqlProvider.class, method="insertSelective")
    int insertSelective(EpieSex record);

    @Select({
        "select",
        "id, val",
        "from sex",
        "where id = #{id,jdbcType=TINYINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.TINYINT, id=true),
        @Result(column="val", property="val", jdbcType=JdbcType.VARCHAR)
    })
    EpieSex selectByPrimaryKey(Byte id);

    @UpdateProvider(type= EpieSexSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EpieSex record);

    @Update({
        "update sex",
        "set val = #{val,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(EpieSex record);
}