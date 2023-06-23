package com.example.onlinerent.mapper;

import com.example.onlinerent.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User loadUserByUsername(String username);

    Integer getTotal(String name);

    List<User> getUserByPage(@Param("offset") int offset,
                          @Param("size") Integer size,
                          @Param("name") String name);

    int addUser(User user);

    int deleteUserById(Integer id);

    User getUserById(Integer id);

    User getUserByUserName(String username);

    int updateUser(User user);
}
