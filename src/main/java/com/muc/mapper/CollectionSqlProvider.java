package com.muc.mapper;

import com.muc.bean.Collection;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class CollectionSqlProvider {

    public String insertSelective(Collection record) {
        BEGIN();
        INSERT_INTO("collection");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCollectionType() != null) {
            VALUES("collection_type", "#{collectionType,jdbcType=BIT}");
        }
        
        if (record.getObjectId() != null) {
            VALUES("object_id", "#{objectId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Collection record) {
        BEGIN();
        UPDATE("collection");
        
        if (record.getCollectionType() != null) {
            SET("collection_type = #{collectionType,jdbcType=BIT}");
        }
        
        if (record.getObjectId() != null) {
            SET("object_id = #{objectId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}