package com.muc.mapper;

import com.muc.bean.EpieUser;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class EpieUserSqlProvider {

    public String insertSelective(EpieUser record) {
        BEGIN();
        INSERT_INTO("epie_user");
        
        if (record.getOpenid() != null) {
            VALUES("openid", "#{openid,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            VALUES("nickname", "#{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatarurl() != null) {
            VALUES("avatarurl", "#{avatarurl,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            VALUES("sex", "#{sex,jdbcType=TINYINT}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(EpieUser record) {
        BEGIN();
        UPDATE("epie_user");
        
        if (record.getNickname() != null) {
            SET("nickname = #{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatarurl() != null) {
            SET("avatarurl = #{avatarurl,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            SET("sex = #{sex,jdbcType=TINYINT}");
        }
        
        WHERE("openid = #{openid,jdbcType=VARCHAR}");
        
        return SQL();
    }
}