package com.muc.mapper;

import com.muc.bean.JobRequirements;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class JobRequirementsSqlProvider {

    public String insertSelective(JobRequirements record) {
        BEGIN();
        INSERT_INTO("job_requirements");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getJobId() != null) {
            VALUES("job_id", "#{jobId,jdbcType=INTEGER}");
        }
        
        if (record.getJobRequirementsVal() != null) {
            VALUES("job_requirements_val", "#{jobRequirementsVal,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(JobRequirements record) {
        BEGIN();
        UPDATE("job_requirements");
        
        if (record.getJobId() != null) {
            SET("job_id = #{jobId,jdbcType=INTEGER}");
        }
        
        if (record.getJobRequirementsVal() != null) {
            SET("job_requirements_val = #{jobRequirementsVal,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}