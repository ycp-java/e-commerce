/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: InterceptorConfig
 * Author:   徐绍岚
 * Date:     2020/10/12 17:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.config;

import com.ytc.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns("/**");//所有路径都被拦截
        registration.excludePathPatterns(//springboot不能跳页面只能通过方法跳页面
                //"/login/show.html",      // 登录页不拦截
                "/service/**",            // 登录相关接口(逻辑服务接口)不拦截
                "/login"  ,              //登录请求不拦截
                "/imgCode",             //验证码返回前台不拦截
                "/loginUser",          //登录请求不拦截
                "/indexZhuCe",        //跳转注册页面不拦截
                "/zhuce",             //注册用户请求
                "/toindex",
                "/payzhuce",
                "/tologin",
                "/toReg",
                "/queryMerchantByName"
        );
        registration.excludePathPatterns("" +
                "/assets/**",             //assets文件夹里文件不拦截
                "/**/*.js",              //js静态资源不拦截
                "/**/*.css",            //css静态资源不拦截
                "/**/*.html"           //html静态资源不拦截
        );
    }

}
