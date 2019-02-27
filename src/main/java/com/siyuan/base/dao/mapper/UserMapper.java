package com.siyuan.base.dao.mapper;

import com.siyuan.base.dao.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "sex",  column = "sex"),
            @Result(property = "name", column = "name")
    })
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "sex",  column = "sex"),
            @Result(property = "name", column = "name")
    })
    User getOne(Long id);

    @Insert("INSERT INTO user(userName,passWord,sex) VALUES(#{userName}, #{passWord}, #{sex})")
    void insert(User user);

    @Update("UPDATE user SET userName=#{userName},name=#{name} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);

    // This example creates a prepared statement, something like select * from teacher where name = ?;
    @Select("Select * from user where name = #{name}")
    List<User> selectUserByName(@Param("name") String name);

    // This example creates n inlined statement, something like select * from teacher where name = 'someName';
    @Select("Select * from user where name = '${name}'")
    List<User> selectUserByName1(@Param("name") String name);
}
