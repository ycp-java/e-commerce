/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: EcommerceController
 * Author:   ycp
 * Date:     2020/10/7 14:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ytc.model.User;
import com.ytc.service.UserService;
import com.ytc.uitl.CheckImgUtil;

import com.ytc.util.Md5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class EcommerceController {

    @Reference
    private UserService userService;

    //跳转登录页面
    @RequestMapping("login")
    public String login(){
        return "login/show.html";
    }
    //跳转首页
    @RequestMapping("toindex")
    public String toindex(){
        return "index.html";
    }

    //跳转注册页面
    @RequestMapping("indexZhuCe")
    public String indexZhuCe(){
        return "zhuce/show.html";
    }

    //验证码生成字符串返回前台
    @RequestMapping("imgCode")
    @ResponseBody
    public String imgCode(HttpServletRequest request, HttpServletResponse response){
        //System.out.println(1);
        String checkImg = "";
        try {
            checkImg = CheckImgUtil.checkImg(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkImg;
    }

    //移除session里的登录用户
    @RequestMapping("removeUser")
    public String removeUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "index.html";
    }

    //登录用户
    @RequestMapping("loginUser")
    @ResponseBody
    public String loginUser(User user,String imgcode,HttpServletRequest request){

        //System.out.println(user);
        //System.out.println(imgcode);
        user.setUserpwd(Md5Util.getMd516(user.getUserpwd()));
        //获取session里的验证码
        HttpSession session = request.getSession();
        String yanzheng = (String)session.getAttribute("checkcode");
        if( !(yanzheng.equals(imgcode)) ){
            //验证码错误
            return "1";
        }

        //查询用户是否存在数据库用户名是否正确
        User queryUser = userService.queryUser(user);

        //System.out.println(queryUser);

        if(queryUser!=null){//判断用户名是否正确

            if(queryUser.getUserpwd().equals(user.getUserpwd())){//判断密码是否正确
                session.setAttribute("user",queryUser);
                //登录成功
                return "4";
            }else {
                //密码错误
                return "3";
            }
        }else{
            //用户名错误
            return "2";
        }

    }


    //注册用户（新增用户）
    @RequestMapping("zhuce")
    @ResponseBody
    public String zhuce(User u){
        //查询用户名是否存在
        User user = userService.queryUsercf(u);

        //用户密码加密
        u.setUserpwd(Md5Util.getMd516(u.getUserpwd()));

        //System.out.println(u.getUserpwd());

        if(user==null) {
            //新增用户
            userService.zhuce(u);
            return "2";
        }
        return "1";
    }





}