package com.muc.mapper;

import com.muc.bean.TradeDetail;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface TradeDetailMapper {
    @Delete({
        "delete from trade_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into trade_detail (id, trade_master_acount_id, ",
        "trade_slave_acount_id, trade_type_id, ",
        "trade_money)",
        "values (#{id,jdbcType=INTEGER}, #{tradeMasterAcountId,jdbcType=INTEGER}, ",
        "#{tradeSlaveAcountId,jdbcType=INTEGER}, #{tradeTypeId,jdbcType=INTEGER}, ",
        "#{tradeMoney,jdbcType=DOUBLE})"
    })
    int insert(TradeDetail record);

    @InsertProvider(type=TradeDetailSqlProvider.class, method="insertSelective")
    int insertSelective(TradeDetail record);

    @Select({
        "select",
        "id, trade_master_acount_id, trade_slave_acount_id, trade_type_id, trade_money",
        "from trade_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="trade_master_acount_id", property="tradeMasterAcountId", jdbcType=JdbcType.INTEGER),
        @Result(column="trade_slave_acount_id", property="tradeSlaveAcountId", jdbcType=JdbcType.INTEGER),
        @Result(column="trade_type_id", property="tradeTypeId", jdbcType=JdbcType.INTEGER),
        @Result(column="trade_money", property="tradeMoney", jdbcType=JdbcType.DOUBLE)
    })
    TradeDetail selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TradeDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TradeDetail record);

    @Update({
        "update trade_detail",
        "set trade_master_acount_id = #{tradeMasterAcountId,jdbcType=INTEGER},",
          "trade_slave_acount_id = #{tradeSlaveAcountId,jdbcType=INTEGER},",
          "trade_type_id = #{tradeTypeId,jdbcType=INTEGER},",
          "trade_money = #{tradeMoney,jdbcType=DOUBLE}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TradeDetail record);
}