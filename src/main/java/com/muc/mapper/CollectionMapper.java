package com.muc.mapper;

import com.muc.bean.Collection;
import com.muc.viewModel.CollectionCompanyViewModel;
import com.muc.viewModel.CollectionJobViewModel;
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


    @Select({
            "select collectionid,jobid,job_name,job_reginal,job_cycle,job_internship,job_wages_low,job_wages_high,company_name,company_logo,industry_level_one.val typelevelone,industry_level_two.val typeleveltwo from " +
                    "(select collectionid,jobid,job_name,job_reginal,job_cycle,job_internship,job_wages_low,job_wages_high,company_name,company_logo,company_type_level1,company_type_level2 from " +
                    "(select collectionid,id jobid,job_name,job_reginal,job_cycle,job_internship,job_wages_low,job_wages_high,companyid \n" +
                    "from " +
                    "(select id collectionid,object_id from collection where collection_type=1 and user_id= #{openid,jdbcType=VARCHAR}) a,parttimejob " +
                    "where object_id=id) b,company where companyid=id) c,industry_level_one,industry_level_two " +
                    "where c.company_type_level1=industry_level_one.id and c.company_type_level2=industry_level_two.id"
    })
    @Results({
            @Result(column="jobid", property="jobid", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="collectionid", property="collectionid", jdbcType=JdbcType.INTEGER),
            @Result(column="job_name", property="jobname", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_reginal", property="jobreginal", jdbcType=JdbcType.VARCHAR),
            @Result(column="job_cycle", property="jobcycle", jdbcType=JdbcType.INTEGER),
            @Result(column="job_internship", property="jobinternship", jdbcType=JdbcType.INTEGER),
            @Result(column="job_wages_low", property="jobWagesLow", jdbcType=JdbcType.DOUBLE),
            @Result(column="job_wages_high", property="jobWagesHigh", jdbcType=JdbcType.DOUBLE),
            @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_logo", property="companyLogo", jdbcType=JdbcType.VARCHAR),
            @Result(column="typelevelone", property="companyTypeLevelOne", jdbcType=JdbcType.VARCHAR),
            @Result(column="typeleveltwo", property="companyTypeLevelTwo", jdbcType=JdbcType.VARCHAR),
    })
    ArrayList<CollectionJobViewModel> selectJobByUserId(String  openid);


    @Select({
            "select collectionid,parttimejob.companyid,company_name,company_desc,company_logo,typelevelone,typeleveltwo,count(id) positions " +
                    "from(select collectionid,companyid,company_name,company_desc,company_logo,industry_level_one.val typelevelone,industry_level_two.val typeleveltwo " +
                    "from(select collectionid,id companyid,company_name,company_desc,company_logo,company_type_level1,company_type_level2 from(SELECT id collectionid,object_id " +
                    "FROM epie.collection where collection_type=0 and user_id= #{openid,jdbcType=VARCHAR})a,company where a.object_id=company.id) b,industry_level_one,industry_level_two " +
                    "where b.company_type_level1=industry_level_one.id and b.company_type_level2=industry_level_two.id) c,parttimejob " +
                    "where c.companyid=parttimejob.companyid and parttimejob.job_review_status=3 group by c.companyid  ;"
    })
    @Results({
            @Result(column="collectionid", property="collectionid", jdbcType=JdbcType.INTEGER),
            @Result(column="companyid", property="companyId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_desc", property="companyDesc", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_logo", property="companyLogo", jdbcType=JdbcType.VARCHAR),
            @Result(column="typelevelone", property="typeLevelOne", jdbcType=JdbcType.VARCHAR),
            @Result(column="typeleveltwo", property="typeLevelTwo", jdbcType=JdbcType.VARCHAR),
            @Result(column="positions", property="positions", jdbcType=JdbcType.INTEGER),
    })
    ArrayList<CollectionCompanyViewModel> selectCompanyByUserId(String  openid);

}