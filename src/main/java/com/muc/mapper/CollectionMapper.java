package com.muc.mapper;

import com.muc.bean.Collection;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.ArrayList;

public interface CollectionMapper {
    @Delete({
        "delete from collection",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into collection (id, collection_type, ",
        "object_id, user_id)",
        "values (#{id,jdbcType=INTEGER}, #{collectionType,jdbcType=BIT}, ",
        "#{objectId,jdbcType=INTEGER}, #{userId,jdbcType=VARCHAR})"
    })
    int insert(Collection record);

    @InsertProvider(type=CollectionSqlProvider.class, method="insertSelective")
    int insertSelective(Collection record);

    @Select({
        "select",
        "id, collection_type, object_id, user_id",
        "from collection",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="collection_type", property="collectionType", jdbcType=JdbcType.BIT),
        @Result(column="object_id", property="objectId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR)
    })
    Collection selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CollectionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Collection record);

    @Update({
        "update collection",
        "set collection_type = #{collectionType,jdbcType=BIT},",
          "object_id = #{objectId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Collection record);
    @Select({
            "select",
            "id, collection_type, object_id, user_id",
            "from collection",
            "where user_id= #{openid,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="collection_type", property="collectionType", jdbcType=JdbcType.BIT),
            @Result(column="object_id", property="objectId", jdbcType=JdbcType.INTEGER),
            @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR)
    })
    ArrayList<Collection> selectByUserId(String  openid);

}