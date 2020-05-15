package com.muc.mapper;

import com.muc.bean.ParttimeJob;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ParttimeJobSqlProvider {

    public String insertSelective(ParttimeJob record) {
        BEGIN();
        INSERT_INTO("parttimejob");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyid() != null) {
            VALUES("companyid", "#{companyid,jdbcType=INTEGER}");
        }
        
        if (record.getJobName() != null) {
            VALUES("job_name", "#{jobName,jdbcType=VARCHAR}");
        }
        
        if (record.getJobReginal() != null) {
            VALUES("job_reginal", "#{jobReginal,jdbcType=VARCHAR}");
        }
        
        if (record.getJobCycle() != null) {
            VALUES("job_cycle", "#{jobCycle,jdbcType=INTEGER}");
        }
        
        if (record.getJobInternship() != null) {
            VALUES("job_internship", "#{jobInternship,jdbcType=INTEGER}");
        }
        
        if (record.getJobEducationId() != null) {
            VALUES("job_education_id", "#{jobEducationId,jdbcType=INTEGER}");
        }
        
        if (record.getJobWagesConfirmWay() != null) {
            VALUES("job_wages_confirm_way", "#{jobWagesConfirmWay,jdbcType=VARCHAR}");
        }
        
        if (record.getJobWagesLow() != null) {
            VALUES("job_wages_low", "#{jobWagesLow,jdbcType=DOUBLE}");
        }
        
        if (record.getJobWagesHigh() != null) {
            VALUES("job_wages_high", "#{jobWagesHigh,jdbcType=DOUBLE}");
        }
        
        if (record.getJobLocation() != null) {
            VALUES("job_location", "#{jobLocation,jdbcType=VARCHAR}");
        }
        
        if (record.getJobTypeLevel1() != null) {
            VALUES("job_type_level1", "#{jobTypeLevel1,jdbcType=INTEGER}");
        }
        
        if (record.getJobTypeLevel2() != null) {
            VALUES("job_type_level2", "#{jobTypeLevel2,jdbcType=INTEGER}");
        }
        
        if (record.getJobReviewStatus() != null) {
            VALUES("job_review_status", "#{jobReviewStatus,jdbcType=INTEGER}");
        }
        
        if (record.getJobCreateTime() != null) {
            VALUES("job_create_time", "#{jobCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getJobEndType() != null) {
            VALUES("job_end_type", "#{jobEndType,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(ParttimeJob record) {
        BEGIN();
        UPDATE("parttimejob");
        
        if (record.getCompanyid() != null) {
            SET("companyid = #{companyid,jdbcType=INTEGER}");
        }
        
        if (record.getJobName() != null) {
            SET("job_name = #{jobName,jdbcType=VARCHAR}");
        }
        
        if (record.getJobReginal() != null) {
            SET("job_reginal = #{jobReginal,jdbcType=VARCHAR}");
        }
        
        if (record.getJobCycle() != null) {
            SET("job_cycle = #{jobCycle,jdbcType=INTEGER}");
        }
        
        if (record.getJobInternship() != null) {
            SET("job_internship = #{jobInternship,jdbcType=INTEGER}");
        }
        
        if (record.getJobEducationId() != null) {
            SET("job_education_id = #{jobEducationId,jdbcType=INTEGER}");
        }
        
        if (record.getJobWagesConfirmWay() != null) {
            SET("job_wages_confirm_way = #{jobWagesConfirmWay,jdbcType=VARCHAR}");
        }
        
        if (record.getJobWagesLow() != null) {
            SET("job_wages_low = #{jobWagesLow,jdbcType=DOUBLE}");
        }
        
        if (record.getJobWagesHigh() != null) {
            SET("job_wages_high = #{jobWagesHigh,jdbcType=DOUBLE}");
        }
        
        if (record.getJobLocation() != null) {
            SET("job_location = #{jobLocation,jdbcType=VARCHAR}");
        }
        
        if (record.getJobTypeLevel1() != null) {
            SET("job_type_level1 = #{jobTypeLevel1,jdbcType=INTEGER}");
        }
        
        if (record.getJobTypeLevel2() != null) {
            SET("job_type_level2 = #{jobTypeLevel2,jdbcType=INTEGER}");
        }
        
        if (record.getJobReviewStatus() != null) {
            SET("job_review_status = #{jobReviewStatus,jdbcType=INTEGER}");
        }
        
        if (record.getJobCreateTime() != null) {
            SET("job_create_time = #{jobCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getJobEndType() != null) {
            SET("job_end_type = #{jobEndType,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}