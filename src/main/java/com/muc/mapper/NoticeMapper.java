package com.muc.mapper;

import com.muc.bean.Notice;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.ArrayList;

public interface NoticeMapper {
    @Delete({
        "delete from notice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into notice (id, sendpeople, ",
        "acceptpeople, notice_context, ",
        "notice_target_url, notice_status)",
        "values (#{id,jdbcType=INTEGER}, #{sendpeople,jdbcType=VARCHAR}, ",
        "#{acceptpeople,jdbcType=VARCHAR}, #{noticeContext,jdbcType=VARCHAR}, ",
        "#{noticeTargetUrl,jdbcType=VARCHAR}, #{noticeStatus,jdbcType=BIT})"
    })
    int insert(Notice record);

    @InsertProvider(type=NoticeSqlProvider.class, method="insertSelective")
    int insertSelective(Notice record);

    @Select({
        "select",
        "id, sendpeople, acceptpeople, notice_context, notice_target_url, notice_status",
        "from notice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sendpeople", property="sendpeople", jdbcType=JdbcType.VARCHAR),
        @Result(column="acceptpeople", property="acceptpeople", jdbcType=JdbcType.VARCHAR),
        @Result(column="notice_context", property="noticeContext", jdbcType=JdbcType.VARCHAR),
        @Result(column="notice_target_url", property="noticeTargetUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="notice_status", property="noticeStatus", jdbcType=JdbcType.BIT)
    })
    Notice selectByPrimaryKey(Integer id);

    @UpdateProvider(type=NoticeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Notice record);

    @Update({
        "update notice",
        "set sendpeople = #{sendpeople,jdbcType=VARCHAR},",
          "acceptpeople = #{acceptpeople,jdbcType=VARCHAR},",
          "notice_context = #{noticeContext,jdbcType=VARCHAR},",
          "notice_target_url = #{noticeTargetUrl,jdbcType=VARCHAR},",
          "notice_status = #{noticeStatus,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Notice record);
    /*查询用户的通知*/
    @Select({
            "select",
            "id, sendpeople, acceptpeople, notice_context, notice_target_url, notice_status",
            "from notice",
            "where acceptpeople = #{openid,jdbcType=VARCHAR} and notice_status=0"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="sendpeople", property="sendpeople", jdbcType=JdbcType.VARCHAR),
            @Result(column="acceptpeople", property="acceptpeople", jdbcType=JdbcType.VARCHAR),
            @Result(column="notice_context", property="noticeContext", jdbcType=JdbcType.VARCHAR),
            @Result(column="notice_target_url", property="noticeTargetUrl", jdbcType=JdbcType.VARCHAR),
            @Result(column="notice_status", property="noticeStatus", jdbcType=JdbcType.BIT)
    })
    ArrayList<Notice> selectByAcceptPeopel(String  openid);

    @Update({
            "update notice",
            "set notice_status=1",
            "where acceptpeople = #{openid,jdbcType=VARCHAR} and notice_status=0 "
    })
    int updateAcceptPeopel(String openid);
    /*通过id设置通知已读*/
    @Update({
            "update notice",
            "set notice_status=1",
            "where id = #{id,jdbcType=INTEGER} and notice_status=0 "
    })
    int updateById(Integer id);


}