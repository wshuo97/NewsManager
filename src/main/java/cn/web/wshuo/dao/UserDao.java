package cn.web.wshuo.dao;

import cn.web.wshuo.entity.UserEntity;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Apex_WS at 15:33 on 2017/12/30.
 */

public interface UserDao {
    //mysql -- show all users
    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userName", column = "user_name"),
            @Result(property = "passWord", column = "pass_word"),
            @Result(property = "powerGroup", column = "power_group")
    })
    List<UserEntity> getAllUsers();

    //mysql -- show a user by userName
    @Select("SELECT * FROM users WHERE user_name = #{username}")
    @Results({
            @Result(property = "userName", column = "user_name"),
            @Result(property = "passWord", column = "pass_word"),
            @Result(property = "powerGroup", column = "power_group")
    })
    UserEntity getUserByName(@Param("username") String userName);

    //mysql -- show a user by userName
    @Select("SELECT * FROM users WHERE user_name = #{username} AND pass_word = #{password}")
    @Results({
            @Result(property = "userName", column = "user_name"),
            @Result(property = "passWord", column = "pass_word"),
            @Result(property = "powerGroup", column = "power_group")
    })
    UserEntity getUserByNameAndPasswd(@Param("username") String userName, @Param("password") String passWord);

    //mysql -- create a user
    @Insert("INSERT INTO users(user_name, pass_word, power_group) VALUES(#{username}, #{password}, #{powergroup})")
    void insertUser(@Param("username") String userName, @Param("password") String passWord, @Param("powergroup") String powerGroup);

    //mysql -- update a user's power
    @Update("UPDATE users SET power_group = #{power} WHERE user_name=#{name}")
    void updateUser(@Param("power") String powerGroup, @Param("name") String userName);

    //mysql -- delete a user by userName
    @Delete("DELETE FROM users WHERE user_name = #{userName}")
    void deleteUser(String userName);
}
