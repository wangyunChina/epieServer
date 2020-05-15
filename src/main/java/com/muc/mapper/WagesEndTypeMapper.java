package com.muc.mapper;

import com.muc.bean.WagesEndType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface WagesEndTypeMapper {
    @Delete({
        "delete from wages_end_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into wages_end_type (id, val)",
        "values (#{id,jdbcType=INTEGER}, #{val,jdbcType=VARCHAR})"
    })
    int insert(WagesEndType record);

    @InsertProvider(type=WagesEndTypeSqlProvider.class, method="insertSelective")
    int insertSelective(WagesEndType record);

    @Select({
        "select",
        "id, val",
        "from wages_end_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="val", property="val", jdbcType=JdbcType.VARCHAR)
    })
    WagesEndType selectByPrimaryKey(Integer id);

    @UpdateProvider(type=WagesEndTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WagesEndType record);

    @Update({
        "update wages_end_type",
        "set val = #{val,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WagesEndType record);
}