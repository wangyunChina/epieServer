package com.muc.mapper;

import com.muc.bean.Company;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CompanyMapper {
    @Delete({
        "delete from company",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into company (id, openid, ",
        "company_name, company_desc, ",
        "company_detail, company_location, ",
        "company_logo, company_review_status, ",
        "company_type_level1, company_type_level2, ",
        "company_licence_url)",
        "values (#{id,jdbcType=INTEGER}, #{openid,jdbcType=VARCHAR}, ",
        "#{companyName,jdbcType=VARCHAR}, #{companyDesc,jdbcType=VARCHAR}, ",
        "#{companyDetail,jdbcType=VARCHAR}, #{companyLocation,jdbcType=VARCHAR}, ",
        "#{companyLogo,jdbcType=VARCHAR}, #{companyReviewStatus,jdbcType=INTEGER}, ",
        "#{companyTypeLevel1,jdbcType=INTEGER}, #{companyTypeLevel2,jdbcType=INTEGER}, ",
        "#{companyLicenceUrl,jdbcType=VARCHAR})"
    })
    int insert(Company record);

    @InsertProvider(type=CompanySqlProvider.class, method="insertSelective")
    int insertSelective(Company record);

    @Select({
        "select",
        "id, openid, company_name, company_desc, company_detail, company_location, company_logo, ",
        "company_review_status, company_type_level1, company_type_level2, company_licence_url",
        "from company",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_desc", property="companyDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_detail", property="companyDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_location", property="companyLocation", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_logo", property="companyLogo", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_review_status", property="companyReviewStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="company_type_level1", property="companyTypeLevel1", jdbcType=JdbcType.INTEGER),
        @Result(column="company_type_level2", property="companyTypeLevel2", jdbcType=JdbcType.INTEGER),
        @Result(column="company_licence_url", property="companyLicenceUrl", jdbcType=JdbcType.VARCHAR)
    })
    Company selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, openid, company_name, company_desc, company_detail, company_location, company_logo, ",
            "company_review_status, company_type_level1, company_type_level2, company_licence_url",
            "from company",
            "where openid = #{openid,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_desc", property="companyDesc", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_detail", property="companyDetail", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_location", property="companyLocation", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_logo", property="companyLogo", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_review_status", property="companyReviewStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="company_type_level1", property="companyTypeLevel1", jdbcType=JdbcType.INTEGER),
            @Result(column="company_type_level2", property="companyTypeLevel2", jdbcType=JdbcType.INTEGER),
            @Result(column="company_licence_url", property="companyLicenceUrl", jdbcType=JdbcType.VARCHAR)
    })
    Company selectByOpenid(String openid);

    @Select({
            "select",
            "id, openid, company_name, company_desc, company_detail, company_location, company_logo, ",
            "company_review_status, company_type_level1, company_type_level2, company_licence_url",
            "from company",
            "where 1 = 1 limit #{limit,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_desc", property="companyDesc", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_detail", property="companyDetail", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_location", property="companyLocation", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_logo", property="companyLogo", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_review_status", property="companyReviewStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="company_type_level1", property="companyTypeLevel1", jdbcType=JdbcType.INTEGER),
            @Result(column="company_type_level2", property="companyTypeLevel2", jdbcType=JdbcType.INTEGER),
            @Result(column="company_licence_url", property="companyLicenceUrl", jdbcType=JdbcType.VARCHAR)
    })
    List<Company> selectAll(int limit);

    @Select({
            "select",
            "id, openid, company_name, company_desc, company_detail, company_location, company_logo, ",
            "company_review_status, company_type_level1, company_type_level2, company_licence_url",
            "from company",
            "where company_location like '%'||#{localtion,jdbcType=VARCHAR}||'%'"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_desc", property="companyDesc", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_detail", property="companyDetail", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_location", property="companyLocation", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_logo", property="companyLogo", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_review_status", property="companyReviewStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="company_type_level1", property="companyTypeLevel1", jdbcType=JdbcType.INTEGER),
            @Result(column="company_type_level2", property="companyTypeLevel2", jdbcType=JdbcType.INTEGER),
            @Result(column="company_licence_url", property="companyLicenceUrl", jdbcType=JdbcType.VARCHAR)
    })
    List<Company> selectByLocation(String localtion);


    @UpdateProvider(type=CompanySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Company record);

    @Update({
        "update company",
        "set openid = #{openid,jdbcType=VARCHAR},",
          "company_name = #{companyName,jdbcType=VARCHAR},",
          "company_desc = #{companyDesc,jdbcType=VARCHAR},",
          "company_detail = #{companyDetail,jdbcType=VARCHAR},",
          "company_location = #{companyLocation,jdbcType=VARCHAR},",
          "company_logo = #{companyLogo,jdbcType=VARCHAR},",
          "company_review_status = #{companyReviewStatus,jdbcType=INTEGER},",
          "company_type_level1 = #{companyTypeLevel1,jdbcType=INTEGER},",
          "company_type_level2 = #{companyTypeLevel2,jdbcType=INTEGER},",
          "company_licence_url = #{companyLicenceUrl,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Company record);
}