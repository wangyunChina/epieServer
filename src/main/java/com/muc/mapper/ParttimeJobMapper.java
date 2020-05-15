package com.muc.mapper;

import com.muc.bean.ParttimeJob;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ParttimeJobMapper {
    @Delete({
        "delete from parttimejob",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into parttimejob (id, companyid, ",
        "job_name, job_reginal, ",
        "job_cycle, job_internship, ",
        "job_education_id, job_wages_confirm_way, ",
        "job_wages_low, job_wages_high, ",
        "job_location, job_type_level1, ",
        "job_type_level2, job_review_status, ",
        "job_create_time, job_end_type)",
        "values (#{id,jdbcType=INTEGER}, #{companyid,jdbcType=INTEGER}, ",
        "#{jobName,jdbcType=VARCHAR}, #{jobReginal,jdbcType=VARCHAR}, ",
        "#{jobCycle,jdbcType=INTEGER}, #{jobInternship,jdbcType=INTEGER}, ",
        "#{jobEducationId,jdbcType=INTEGER}, #{jobWagesConfirmWay,jdbcType=VARCHAR}, ",
        "#{jobWagesLow,jdbcType=DOUBLE}, #{jobWagesHigh,jdbcType=DOUBLE}, ",
        "#{jobLocation,jdbcType=VARCHAR}, #{jobTypeLevel1,jdbcType=INTEGER}, ",
        "#{jobTypeLevel2,jdbcType=INTEGER}, #{jobReviewStatus,jdbcType=INTEGER}, ",
        "#{jobCreateTime,jdbcType=TIMESTAMP}, #{jobEndType,jdbcType=INTEGER})"
    })
    int insert(ParttimeJob record);

    @InsertProvider(type=ParttimeJobSqlProvider.class, method="insertSelective")
    int insertSelective(ParttimeJob record);

    @Select({
        "select",
        "id, companyid, job_name, job_reginal, job_cycle, job_internship, job_education_id, ",
        "job_wages_confirm_way, job_wages_low, job_wages_high, job_location, job_type_level1, ",
        "job_type_level2, job_review_status, job_create_time, job_end_type",
        "from parttimejob",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="companyid", property="companyid", jdbcType=JdbcType.INTEGER),
        @Result(column="job_name", property="jobName", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_reginal", property="jobReginal", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_cycle", property="jobCycle", jdbcType=JdbcType.INTEGER),
        @Result(column="job_internship", property="jobInternship", jdbcType=JdbcType.INTEGER),
        @Result(column="job_education_id", property="jobEducationId", jdbcType=JdbcType.INTEGER),
        @Result(column="job_wages_confirm_way", property="jobWagesConfirmWay", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_wages_low", property="jobWagesLow", jdbcType=JdbcType.DOUBLE),
        @Result(column="job_wages_high", property="jobWagesHigh", jdbcType=JdbcType.DOUBLE),
        @Result(column="job_location", property="jobLocation", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_type_level1", property="jobTypeLevel1", jdbcType=JdbcType.INTEGER),
        @Result(column="job_type_level2", property="jobTypeLevel2", jdbcType=JdbcType.INTEGER),
        @Result(column="job_review_status", property="jobReviewStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="job_create_time", property="jobCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="job_end_type", property="jobEndType", jdbcType=JdbcType.INTEGER)
    })
    ParttimeJob selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ParttimeJobSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ParttimeJob record);

    @Update({
        "update parttimejob",
        "set companyid = #{companyid,jdbcType=INTEGER},",
          "job_name = #{jobName,jdbcType=VARCHAR},",
          "job_reginal = #{jobReginal,jdbcType=VARCHAR},",
          "job_cycle = #{jobCycle,jdbcType=INTEGER},",
          "job_internship = #{jobInternship,jdbcType=INTEGER},",
          "job_education_id = #{jobEducationId,jdbcType=INTEGER},",
          "job_wages_confirm_way = #{jobWagesConfirmWay,jdbcType=VARCHAR},",
          "job_wages_low = #{jobWagesLow,jdbcType=DOUBLE},",
          "job_wages_high = #{jobWagesHigh,jdbcType=DOUBLE},",
          "job_location = #{jobLocation,jdbcType=VARCHAR},",
          "job_type_level1 = #{jobTypeLevel1,jdbcType=INTEGER},",
          "job_type_level2 = #{jobTypeLevel2,jdbcType=INTEGER},",
          "job_review_status = #{jobReviewStatus,jdbcType=INTEGER},",
          "job_create_time = #{jobCreateTime,jdbcType=TIMESTAMP},",
          "job_end_type = #{jobEndType,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ParttimeJob record);

    /*名字模糊收索兼职*/
    @Select({
            "select",
            "id, companyid, job_name, job_reginal, job_cycle, job_internship, job_education_id, ",
            "job_wages_confirm_way, job_wages_low, job_wages_high, job_location, job_type_level1, ",
            "job_type_level2, job_review_status, job_create_time, job_end_type",
            "from parttimejob",
            "where job_name like '%'||#{name,jdbcType=VARCHAR}||'%' and job_review_status=3"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="companyid", property="companyid", jdbcType=JdbcType.INTEGER),
            @Result(column="job_name", property="jobName", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_reginal", property="jobReginal", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_cycle", property="jobCycle", jdbcType=JdbcType.INTEGER),
            @Result(column="job_internship", property="jobInternship", jdbcType=JdbcType.INTEGER),
            @Result(column="job_education_id", property="jobEducationId", jdbcType=JdbcType.INTEGER),
            @Result(column="job_wages_confirm_way", property="jobWagesConfirmWay", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_wages_low", property="jobWagesLow", jdbcType=JdbcType.DOUBLE),
            @Result(column="job_wages_high", property="jobWagesHigh", jdbcType=JdbcType.DOUBLE),
            @Result(column="job_location", property="jobLocation", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_type_level1", property="jobTypeLevel1", jdbcType=JdbcType.INTEGER),
            @Result(column="job_type_level2", property="jobTypeLevel2", jdbcType=JdbcType.INTEGER),
            @Result(column="job_review_status", property="jobReviewStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="job_create_time", property="jobCreateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="job_end_type", property="jobEndType", jdbcType=JdbcType.INTEGER)
    })
    List<ParttimeJob> selectByName(String name);
    /*通过地域收索兼职*/
    @Select({
            "select *",

            "from parttimejob",
            "where job_reginal like '%'||#{riginal,jdbcType=VARCHAR}||'%' and job_review_status=3 ",
            " or  job_location like '%'||#{riginal,jdbcType=VARCHAR}||'%' and job_review_status=3 "
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="companyid", property="companyid", jdbcType=JdbcType.INTEGER),
            @Result(column="job_name", property="jobName", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_reginal", property="jobReginal", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_cycle", property="jobCycle", jdbcType=JdbcType.INTEGER),
            @Result(column="job_internship", property="jobInternship", jdbcType=JdbcType.INTEGER),
            @Result(column="job_education_id", property="jobEducationId", jdbcType=JdbcType.INTEGER),
            @Result(column="job_wages_confirm_way", property="jobWagesConfirmWay", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_wages_low", property="jobWagesLow", jdbcType=JdbcType.DOUBLE),
            @Result(column="job_wages_high", property="jobWagesHigh", jdbcType=JdbcType.DOUBLE),
            @Result(column="job_location", property="jobLocation", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_type_level1", property="jobTypeLevel1", jdbcType=JdbcType.INTEGER),
            @Result(column="job_type_level2", property="jobTypeLevel2", jdbcType=JdbcType.INTEGER),
            @Result(column="job_review_status", property="jobReviewStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="job_create_time", property="jobCreateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="job_end_type", property="jobEndType", jdbcType=JdbcType.INTEGER)
    })
    List<ParttimeJob> selectByOrigin(String riginal);


    /**
     * @Desc
     * */
    @Select({
            "select",
            "id, companyid, job_name, job_reginal, job_cycle, job_internship, job_education_id, ",
            "job_wages_confirm_way, job_wages_low, job_wages_high, job_location, job_type_level1, ",
            "job_type_level2, job_review_status, job_create_time, job_end_type",
            "from parttimejob",
            "where job_end_type like '%'||#{type,jdbcType=INTEGER}||'%' and job_review_status=3"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="companyid", property="companyid", jdbcType=JdbcType.INTEGER),
            @Result(column="job_name", property="jobName", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_reginal", property="jobReginal", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_cycle", property="jobCycle", jdbcType=JdbcType.INTEGER),
            @Result(column="job_internship", property="jobInternship", jdbcType=JdbcType.INTEGER),
            @Result(column="job_education_id", property="jobEducationId", jdbcType=JdbcType.INTEGER),
            @Result(column="job_wages_confirm_way", property="jobWagesConfirmWay", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_wages_low", property="jobWagesLow", jdbcType=JdbcType.DOUBLE),
            @Result(column="job_wages_high", property="jobWagesHigh", jdbcType=JdbcType.DOUBLE),
            @Result(column="job_location", property="jobLocation", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_type_level1", property="jobTypeLevel1", jdbcType=JdbcType.INTEGER),
            @Result(column="job_type_level2", property="jobTypeLevel2", jdbcType=JdbcType.INTEGER),
            @Result(column="job_review_status", property="jobReviewStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="job_create_time", property="jobCreateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="job_end_type", property="jobEndType", jdbcType=JdbcType.INTEGER)
    })
    List<ParttimeJob> selectByWagesEndType(int type);

    /*通过地域和关键字收索兼职*/
    @Select({
            "select",
            "id, companyid, job_name, job_reginal, job_cycle, job_internship, job_education_id, ",
            "job_wages_confirm_way, job_wages_low, job_wages_high, job_location, job_type_level1, ",
            "job_type_level2, job_review_status, job_create_time, job_end_type",
            "from parttimejob",
            "where job_name like '%'||#{name,jdbcType=VARCHAR}||'%' and job_reginal like '%'#{riginal,jdbcType=VARCHAR}'%' and job_review_status=3"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="companyid", property="companyid", jdbcType=JdbcType.INTEGER),
            @Result(column="job_name", property="jobName", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_reginal", property="jobReginal", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_cycle", property="jobCycle", jdbcType=JdbcType.INTEGER),
            @Result(column="job_internship", property="jobInternship", jdbcType=JdbcType.INTEGER),
            @Result(column="job_education_id", property="jobEducationId", jdbcType=JdbcType.INTEGER),
            @Result(column="job_wages_confirm_way", property="jobWagesConfirmWay", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_wages_low", property="jobWagesLow", jdbcType=JdbcType.DOUBLE),
            @Result(column="job_wages_high", property="jobWagesHigh", jdbcType=JdbcType.DOUBLE),
            @Result(column="job_location", property="jobLocation", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_type_level1", property="jobTypeLevel1", jdbcType=JdbcType.INTEGER),
            @Result(column="job_type_level2", property="jobTypeLevel2", jdbcType=JdbcType.INTEGER),
            @Result(column="job_review_status", property="jobReviewStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="job_create_time", property="jobCreateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="job_end_type", property="jobEndType", jdbcType=JdbcType.INTEGER)
    })
    List<ParttimeJob> selectByOriginAndName(String riginal,String name);
    /*通过地域收索兼职*/
    @Select({
            "select *",
            "from parttimejob",
            "where 1=1 limit #{limit,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="companyid", property="companyid", jdbcType=JdbcType.INTEGER),
            @Result(column="job_name", property="jobName", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_reginal", property="jobReginal", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_cycle", property="jobCycle", jdbcType=JdbcType.INTEGER),
            @Result(column="job_internship", property="jobInternship", jdbcType=JdbcType.INTEGER),
            @Result(column="job_education_id", property="jobEducationId", jdbcType=JdbcType.INTEGER),
            @Result(column="job_wages_confirm_way", property="jobWagesConfirmWay", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_wages_low", property="jobWagesLow", jdbcType=JdbcType.DOUBLE),
            @Result(column="job_wages_high", property="jobWagesHigh", jdbcType=JdbcType.DOUBLE),
            @Result(column="job_location", property="jobLocation", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_type_level1", property="jobTypeLevel1", jdbcType=JdbcType.INTEGER),
            @Result(column="job_type_level2", property="jobTypeLevel2", jdbcType=JdbcType.INTEGER),
            @Result(column="job_review_status", property="jobReviewStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="job_create_time", property="jobCreateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="job_end_type", property="jobEndType", jdbcType=JdbcType.INTEGER)
    })
    List<ParttimeJob> selectAll(int limit);
    @Select({
            "select *",
            "from parttimejob",
            "where companyid = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="companyid", property="companyid", jdbcType=JdbcType.INTEGER),
            @Result(column="job_name", property="jobName", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_reginal", property="jobReginal", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_cycle", property="jobCycle", jdbcType=JdbcType.INTEGER),
            @Result(column="job_internship", property="jobInternship", jdbcType=JdbcType.INTEGER),
            @Result(column="job_education_id", property="jobEducationId", jdbcType=JdbcType.INTEGER),
            @Result(column="job_wages_confirm_way", property="jobWagesConfirmWay", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_wages_low", property="jobWagesLow", jdbcType=JdbcType.DOUBLE),
            @Result(column="job_wages_high", property="jobWagesHigh", jdbcType=JdbcType.DOUBLE),
            @Result(column="job_location", property="jobLocation", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_type_level1", property="jobTypeLevel1", jdbcType=JdbcType.INTEGER),
            @Result(column="job_type_level2", property="jobTypeLevel2", jdbcType=JdbcType.INTEGER),
            @Result(column="job_review_status", property="jobReviewStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="job_create_time", property="jobCreateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="job_end_type", property="jobEndType", jdbcType=JdbcType.INTEGER)
    })
    List<ParttimeJob> selectByCompanyId(int id);
}