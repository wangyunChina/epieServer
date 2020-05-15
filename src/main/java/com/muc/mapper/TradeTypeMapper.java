package com.muc.mapper;

import com.muc.bean.TradeType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface TradeTypeMapper {
    @Delete({
        "delete from trade_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into trade_type (id, trade_type_val)",
        "values (#{id,jdbcType=INTEGER}, #{tradeTypeVal,jdbcType=VARCHAR})"
    })
    int insert(TradeType record);

    @InsertProvider(type=TradeTypeSqlProvider.class, method="insertSelective")
    int insertSelective(TradeType record);

    @Select({
        "select",
        "id, trade_type_val",
        "from trade_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="trade_type_val", property="tradeTypeVal", jdbcType=JdbcType.VARCHAR)
    })
    TradeType selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TradeTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TradeType record);

    @Update({
        "update trade_type",
        "set trade_type_val = #{tradeTypeVal,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TradeType record);
}