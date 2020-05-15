package com.muc.mapper;

import com.muc.bean.ReviewStatus;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ReviewStatusSqlProvider {

    public String insertSelective(ReviewStatus record) {
        BEGIN();
        INSERT_INTO("review_status");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getVal() != null) {
            VALUES("val", "#{val,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(ReviewStatus record) {
        BEGIN();
        UPDATE("review_status");
        
        if (record.getVal() != null) {
            SET("val = #{val,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}