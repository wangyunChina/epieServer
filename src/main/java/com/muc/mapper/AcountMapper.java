package com.muc.mapper;

import com.muc.bean.Acount;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface AcountMapper {
    @Delete({
        "delete from acount",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into acount (id, acount_user_id, ",
        "acount_money)",
        "values (#{id,jdbcType=INTEGER}, #{acountUserId,jdbcType=VARCHAR}, ",
        "#{acountMoney,jdbcType=DOUBLE})"
    })
    int insert(Acount record);

    @InsertProvider(type=AcountSqlProvider.class, method="insertSelective")
    int insertSelective(Acount record);

    @Select({
        "select",
        "id, acount_user_id, acount_money",
        "from acount",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="acount_user_id", property="acountUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="acount_money", property="acountMoney", jdbcType=JdbcType.DOUBLE)
    })
    Acount selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AcountSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Acount record);

    @Update({
        "update acount",
        "set acount_user_id = #{acountUserId,jdbcType=VARCHAR},",
          "acount_money = #{acountMoney,jdbcType=DOUBLE}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Acount record);
}