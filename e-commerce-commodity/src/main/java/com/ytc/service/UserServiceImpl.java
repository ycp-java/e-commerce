/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: OrderServiceImpl
 * Author:   ycp
 * Date:     2020/10/7 15:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ytc.mapper.UserMapper;
import com.ytc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service
@Component
public class UserServiceImpl implements UserService{

    //注入
    @Autowired
    private UserMapper userMapper;

    //查询用户
    @Override
    public User queryUser(User user) {
        User users = userMapper.queryUser(user);
        return users;
    }

    //新增用户
    @Override
    public void zhuce(User u) {

        //System.out.println(u.getJurisdiction().getJurisdictionid());
        //新增出主表并且返回一个主表的主键  给对应的id给副表

        int userId = userMapper.zhuce(u);

        //System.out.println(userId);

        if(userId > 0){

            //System.out.println(userId);

            //地址表新增
            userMapper.dizhi(u);

        }
    }

    //防止用户名重复
    @Override
    public User queryUsercf(User u) {

        User user = userMapper.queryUsercf(u);

        return user;
    }
}