package com.muc.mapper;

import com.muc.bean.DiliveryStatus;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface DiliveryStatusMapper {
    @Delete({
        "delete from dilivery_status",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into dilivery_status (id, dilivery_val)",
        "values (#{id,jdbcType=INTEGER}, #{diliveryVal,jdbcType=VARCHAR})"
    })
    int insert(DiliveryStatus record);

    @InsertProvider(type=DiliveryStatusSqlProvider.class, method="insertSelective")
    int insertSelective(DiliveryStatus record);

    @Select({
        "select",
        "id, dilivery_val",
        "from dilivery_status",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="dilivery_val", property="diliveryVal", jdbcType=JdbcType.VARCHAR)
    })
    DiliveryStatus selectByPrimaryKey(Integer id);

    @UpdateProvider(type=DiliveryStatusSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(DiliveryStatus record);

    @Update({
        "update dilivery_status",
        "set dilivery_val = #{diliveryVal,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DiliveryStatus record);
}