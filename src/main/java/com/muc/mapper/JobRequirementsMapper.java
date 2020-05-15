package com.muc.mapper;

import com.muc.bean.JobRequirements;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface JobRequirementsMapper {
    @Delete({
        "delete from job_requirements",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into job_requirements (id, job_id, ",
        "job_requirements_val)",
        "values (#{id,jdbcType=INTEGER}, #{jobId,jdbcType=INTEGER}, ",
        "#{jobRequirementsVal,jdbcType=VARCHAR})"
    })
    int insert(JobRequirements record);

    @InsertProvider(type=JobRequirementsSqlProvider.class, method="insertSelective")
    int insertSelective(JobRequirements record);

    @Select({
        "select",
        "id, job_id, job_requirements_val",
        "from job_requirements",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="job_id", property="jobId", jdbcType=JdbcType.INTEGER),
        @Result(column="job_requirements_val", property="jobRequirementsVal", jdbcType=JdbcType.VARCHAR)
    })
    JobRequirements selectByPrimaryKey(Integer id);

    @UpdateProvider(type=JobRequirementsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(JobRequirements record);

    @Update({
        "update job_requirements",
        "set job_id = #{jobId,jdbcType=INTEGER},",
          "job_requirements_val = #{jobRequirementsVal,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(JobRequirements record);
    @Select({
            "select",
            "id, job_id, job_requirements_val",
            "from job_requirements",
            "where job_id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="job_id", property="jobId", jdbcType=JdbcType.INTEGER),
            @Result(column="job_requirements_val", property="jobRequirementsVal", jdbcType=JdbcType.VARCHAR)
    })
    List<JobRequirements> selectByJobId(Integer id);

}