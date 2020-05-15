package com.muc.mapper;

import com.muc.bean.JobDescription;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface JobDescriptionMapper {
    @Delete({
        "delete from job_desc",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into job_desc (id, job_id, ",
        "job_desc_val)",
        "values (#{id,jdbcType=INTEGER}, #{jobId,jdbcType=INTEGER}, ",
        "#{jobDescVal,jdbcType=VARCHAR})"
    })
    int insert(JobDescription record);

    @InsertProvider(type=JobDescriptionSqlProvider.class, method="insertSelective")
    int insertSelective(JobDescription record);

    @Select({
        "select",
        "id, job_id, job_desc_val",
        "from job_desc",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="job_id", property="jobId", jdbcType=JdbcType.INTEGER),
        @Result(column="job_desc_val", property="jobDescVal", jdbcType=JdbcType.VARCHAR)
    })
    JobDescription selectByPrimaryKey(Integer id);

    @UpdateProvider(type=JobDescriptionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(JobDescription record);

    @Update({
        "update job_desc",
        "set job_id = #{jobId,jdbcType=INTEGER},",
          "job_desc_val = #{jobDescVal,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(JobDescription record);

    @Select({
            "select",
            "id, job_id, job_desc_val",
            "from job_desc",
            "where job_id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="job_id", property="jobId", jdbcType=JdbcType.INTEGER),
            @Result(column="job_desc_val", property="jobDescVal", jdbcType=JdbcType.VARCHAR)
    })
    List<JobDescription> selectByJobId(Integer id);
}