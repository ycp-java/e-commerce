package com.ytc.mapper;

import com.ytc.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    //查询用户
    User queryUser(@Param("user") User user);
    //注册用户
    int zhuce(@Param("u") User u);
    //新增地址
    void dizhi(@Param("u") User u);
    //防止用户名重复
    User queryUsercf(@Param("u") User u);
}