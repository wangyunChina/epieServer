package com.muc.mapper;

import com.muc.bean.UserWorkType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface UserWorkTypeMapper {
    @Delete({
        "delete from user_work_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user_work_type (id, val)",
        "values (#{id,jdbcType=INTEGER}, #{val,jdbcType=VARCHAR})"
    })
    int insert(UserWorkType record);

    @InsertProvider(type=UserWorkTypeSqlProvider.class, method="insertSelective")
    int insertSelective(UserWorkType record);

    @Select({
        "select",
        "id, val",
        "from user_work_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="val", property="val", jdbcType=JdbcType.VARCHAR)
    })
    UserWorkType selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserWorkTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserWorkType record);

    @Update({
        "update user_work_type",
        "set val = #{val,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserWorkType record);
}