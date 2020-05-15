package com.muc.mapper;

import com.muc.bean.EpieUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface EpieUserMapper {
    @Delete({
        "delete from epie_user",
        "where openid = #{openid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String openid);

    @Insert({
        "insert into epie_user (openid, nickname, ",
        "avatarurl, sex)",
        "values (#{openid,jdbcType=VARCHAR}, #{nickname,jdbcType=VARCHAR}, ",
        "#{avatarurl,jdbcType=VARCHAR}, #{sex,jdbcType=TINYINT})"
    })
    int insert(EpieUser record);

    @InsertProvider(type= EpieUserSqlProvider.class, method="insertSelective")
    int insertSelective(EpieUser record);

    @Select({
        "select",
        "openid, nickname, avatarurl, sex",
        "from epie_user",
        "where openid = #{openid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatarurl", property="avatarurl", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT)
    })
    EpieUser selectByPrimaryKey(String openid);

    @UpdateProvider(type= EpieUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EpieUser record);

    @Update({
        "update epie_user",
        "set nickname = #{nickname,jdbcType=VARCHAR},",
          "avatarurl = #{avatarurl,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=TINYINT}",
        "where openid = #{openid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(EpieUser record);
}