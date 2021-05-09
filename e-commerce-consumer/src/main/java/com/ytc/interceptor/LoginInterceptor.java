/** 
 * <pre>项目名称:ssm-user-wdd 
 * 文件名称:LoginInterceptor.java 
 * 包名:com.jk.wdd.interceptor 
 * 创建日期:2019年6月5日上午10:08:05 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.ytc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/** 
 * <pre>项目名称：ssm-user-wdd    
 * 类名称：LoginInterceptor    
 * 类描述：    
 * 创建人：wdd   
 * 创建时间：2019年6月5日 上午10:08:05    
 * 修改人：wdd 
 * 修改时间：2019年6月5日 上午10:08:05    
 * 修改备注：       
 * @version </pre>    
 */

@Component
public class LoginInterceptor implements HandlerInterceptor{

	/**
	 * 整个请求完成之后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	/**
	 * 进入controller之后
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	/**
	 * 进入controller之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//从session中获取，判断用户是否存在
		Object object = request.getSession().getAttribute("user");
		if(object==null){//没有登录
			//跳转登录页面
			//request.getRequestDispatcher("login/show.html").forward(request, response);//转发到登录页面
			//springboot不能跳页面只能通过方法跳页面
			response.sendRedirect(request.getContextPath()+"/toindex");
			return false;
		}
		return true;
	}

}
