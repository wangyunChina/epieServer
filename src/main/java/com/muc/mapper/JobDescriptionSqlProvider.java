package com.muc.mapper;

import com.muc.bean.JobDescription;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class JobDescriptionSqlProvider {

    public String insertSelective(JobDescription record) {
        BEGIN();
        INSERT_INTO("job_desc");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getJobId() != null) {
            VALUES("job_id", "#{jobId,jdbcType=INTEGER}");
        }
        
        if (record.getJobDescVal() != null) {
            VALUES("job_desc_val", "#{jobDescVal,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(JobDescription record) {
        BEGIN();
        UPDATE("job_desc");
        
        if (record.getJobId() != null) {
            SET("job_id = #{jobId,jdbcType=INTEGER}");
        }
        
        if (record.getJobDescVal() != null) {
            SET("job_desc_val = #{jobDescVal,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}