package com.soft1721.jianyue.api.mapper;

import com.soft1721.jianyue.api.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
@Component
public interface UserMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "password", column = "password"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar"),
            @Result(property = "status", column = "status"),
            @Result(property = "regtime", column = "regtime"),
            @Result(property = "token", column = "token")
    })
    @Select("SELECT * FROM t_user WHERE mobile = #{mobile} ")
    User getUserByMobile(String mobile);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "password", column = "password"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar"),
            @Result(property = "status", column = "status"),
            @Result(property = "regtime", column = "regtime"),
            @Result(property = "token", column = "token")
    })
    @Select("SELECT * FROM t_user WHERE id = #{id} " )
    User getUserById(int userId);

    @Update("UPDATE t_user SET password=#{password},nickname=#{nickname},avatar=#{avatar},status=#{status},token=#{token} WHERE id =#{id}" )
    void update(User user);

    @Update("UPDATE t_user SET nickname=#{nickname} WHERE id =#{id}" )
    void updateUser1(User user);

    @Insert("INSERT INTO t_user(mobile,password,nickname,avatar,status,regtime) VALUES(#{mobile},#{password},#{nickname},#{avatar},#{status},#{regtime})" )
    void insert(User user);


}