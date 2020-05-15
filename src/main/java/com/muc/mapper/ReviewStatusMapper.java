package com.muc.mapper;

import com.muc.bean.ReviewStatus;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface ReviewStatusMapper {
    @Delete({
        "delete from review_status",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into review_status (id, val)",
        "values (#{id,jdbcType=INTEGER}, #{val,jdbcType=VARCHAR})"
    })
    int insert(ReviewStatus record);

    @InsertProvider(type=ReviewStatusSqlProvider.class, method="insertSelective")
    int insertSelective(ReviewStatus record);

    @Select({
        "select",
        "id, val",
        "from review_status",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="val", property="val", jdbcType=JdbcType.VARCHAR)
    })
    ReviewStatus selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ReviewStatusSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ReviewStatus record);

    @Update({
        "update review_status",
        "set val = #{val,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ReviewStatus record);
}