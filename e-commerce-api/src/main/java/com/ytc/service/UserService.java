package com.ytc.service;

import com.ytc.model.User;

public interface UserService {

    //查询用户
    User queryUser(User user);
    //新增用户
    void zhuce(User u);

    User queryUsercf(User u);
}
