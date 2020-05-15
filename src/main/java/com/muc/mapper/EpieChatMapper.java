package com.muc.mapper;

import com.muc.bean.EpieChat;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.ArrayList;

public interface EpieChatMapper {
    @Delete({
        "delete from epie_chat",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into epie_chat (id, sendpeople, ",
        "acceptpeople, message, ",
        "sendtime, isread)",
        "values (#{id,jdbcType=INTEGER}, #{sendpeople,jdbcType=VARCHAR}, ",
        "#{acceptpeople,jdbcType=VARCHAR}, #{message,jdbcType=VARCHAR}, ",
        "#{sendtime,jdbcType=TIMESTAMP}, #{isread,jdbcType=BIT})"
    })
    int insert(EpieChat record);
    @Insert({
            "insert into epie_chat ( sendpeople, ",
            "acceptpeople, message ",
            ")",
            "values (#{send,jdbcType=VARCHAR}, ",
            "#{accept,jdbcType=VARCHAR}, #{message,jdbcType=VARCHAR} ",
            ")"
    })
    int insertByproperty(String send, String accept,String message);

    @InsertProvider(type= EpieChatSqlProvider.class, method="insertSelective")
    int insertSelective(EpieChat record);

    @Select({
        "select",
        "id, sendpeople, acceptpeople, message, sendtime, isread",
        "from epie_chat",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sendpeople", property="sendpeople", jdbcType=JdbcType.VARCHAR),
        @Result(column="acceptpeople", property="acceptpeople", jdbcType=JdbcType.VARCHAR),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR),
        @Result(column="sendtime", property="sendtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="isread", property="isread", jdbcType=JdbcType.BIT)
    })
    EpieChat selectByPrimaryKey(Integer id);


    @Select({
            "select",
            "id, sendpeople, acceptpeople, message, sendtime, isread",
            "from epie_chat",
            "where acceptpeople = #{acceptPeople,jdbcType=INTEGER} group by sendpeople"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="sendpeople", property="sendpeople", jdbcType=JdbcType.VARCHAR),
            @Result(column="acceptpeople", property="acceptpeople", jdbcType=JdbcType.VARCHAR),
            @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR),
            @Result(column="sendtime", property="sendtime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="isread", property="isread", jdbcType=JdbcType.BIT)
    })
    ArrayList<EpieChat>  selectByAcceptPeople(String acceptPeople);

    @Select({
            "select",
            "id, sendpeople, acceptpeople, message, sendtime, isread",
            "from epie_chat",
            "where sendpeople = #{send,jdbcType=INTEGER} and acceptpeople = #{acceptPeople,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="sendpeople", property="sendpeople", jdbcType=JdbcType.VARCHAR),
            @Result(column="acceptpeople", property="acceptpeople", jdbcType=JdbcType.VARCHAR),
            @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR),
            @Result(column="sendtime", property="sendtime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="isread", property="isread", jdbcType=JdbcType.BIT)
    })
    ArrayList<EpieChat>  selectAcceptFromOne(String send,String acceptPeople);

    @Select({
            "select",
            "id, sendpeople, acceptpeople, message, sendtime, isread",
            "from epie_chat",
            "where sendpeople = #{send,jdbcType=INTEGER} and acceptpeople = #{acceptPeople,jdbcType=INTEGER}",
            "or sendpeople = #{acceptPeople,jdbcType=INTEGER} and acceptpeople = #{send,jdbcType=INTEGER} order by id"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="sendpeople", property="sendpeople", jdbcType=JdbcType.VARCHAR),
            @Result(column="acceptpeople", property="acceptpeople", jdbcType=JdbcType.VARCHAR),
            @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR),
            @Result(column="sendtime", property="sendtime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="isread", property="isread", jdbcType=JdbcType.BIT)
    })
    ArrayList<EpieChat>  selectChatMessage(String send,String acceptPeople);




    @UpdateProvider(type= EpieChatSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EpieChat record);

    @Update({
        "update epie_chat",
        "set sendpeople = #{sendpeople,jdbcType=VARCHAR},",
          "acceptpeople = #{acceptpeople,jdbcType=VARCHAR},",
          "message = #{message,jdbcType=VARCHAR},",
          "sendtime = #{sendtime,jdbcType=TIMESTAMP},",
          "isread = #{isread,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(EpieChat record);
    @Update({
            "update epie_chat",
            "set ",
            "isread = 1",
            "where sendpeople = #{send,jdbcType=VARCHAR}",
            "and acceptpeople = #{accept,jdbcType=VARCHAR}"
    })
    int setMessageHasRead(String send,String accept);
}