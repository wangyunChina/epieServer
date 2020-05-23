package com.muc.mapper;

import com.muc.bean.Dilivery;
import com.muc.viewModel.DiliverViewModel;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.ArrayList;

public interface DiliveryMapper {
    @Delete({
        "delete from diliver",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into diliver (id, diliver_job_id, ",
        "diliver_user_id, diliver_option_time, ",
        "diliver_status_id)",
        "values (#{id,jdbcType=INTEGER}, #{diliverJobId,jdbcType=INTEGER}, ",
        "#{diliverUserId,jdbcType=VARCHAR}, #{diliverOptionTime,jdbcType=TIMESTAMP}, ",
        "#{diliverStatusId,jdbcType=INTEGER})"
    })
    int insert(Dilivery record);

    @InsertProvider(type=DiliverySqlProvider.class, method="insertSelective")
    int insertSelective(Dilivery record);

    @Select({
        "select",
        "id, diliver_job_id, diliver_user_id, diliver_option_time, diliver_status_id",
        "from diliver",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="diliver_job_id", property="diliverJobId", jdbcType=JdbcType.INTEGER),
        @Result(column="diliver_user_id", property="diliverUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="diliver_option_time", property="diliverOptionTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="diliver_status_id", property="diliverStatusId", jdbcType=JdbcType.INTEGER)
    })
    Dilivery selectByPrimaryKey(Integer id);

    @UpdateProvider(type=DiliverySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Dilivery record);

    @Update({
        "update diliver",
        "set diliver_job_id = #{diliverJobId,jdbcType=INTEGER},",
          "diliver_user_id = #{diliverUserId,jdbcType=VARCHAR},",
          "diliver_option_time = #{diliverOptionTime,jdbcType=TIMESTAMP},",
          "diliver_status_id = #{diliverStatusId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Dilivery record);

    @Select({
            "select",
            "id, diliver_job_id, diliver_user_id, diliver_option_time, diliver_status_id",
            "from diliver",
            "where diliver_user_id = #{openid,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="diliver_job_id", property="diliverJobId", jdbcType=JdbcType.INTEGER),
            @Result(column="diliver_user_id", property="diliverUserId", jdbcType=JdbcType.VARCHAR),
            @Result(column="diliver_option_time", property="diliverOptionTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="diliver_status_id", property="diliverStatusId", jdbcType=JdbcType.INTEGER)
    })
   ArrayList<Dilivery> selectByOpenid(String openid);
    @Select({
     "select * from diliver_view where userid=#{openid,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="diliverid", property="diliverid", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="userid", property="userid", jdbcType=JdbcType.VARCHAR),
            @Result(column="jobid", property="jobid", jdbcType=JdbcType.INTEGER),
            @Result(column="optiontime", property="optiontime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="statu", property="statu", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_name", property="jobname", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_logo", property="companylogo", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_name", property="companyname", jdbcType=JdbcType.VARCHAR)

    })
    ArrayList<DiliverViewModel> selectByOpenidView(String openid);
}