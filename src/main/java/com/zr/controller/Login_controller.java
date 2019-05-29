package com.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.service.*;
import com.model.*;
@SuppressWarnings("serial")
public class Login_controller extends HttpServlet{
	User user = new User();
	Login_service login_s = new Login_service();
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {

		// TODO 自动生成的方法存根
		ServletRequest request = null;
		ServletResponse response = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username==""){
			request.setAttribute("string", "null1");
			request.getRequestDispatcher("login.jsp").forward(request,response);			
		}
		else if(password==""){
			request.setAttribute("string", "nunll2");
			request.getRequestDispatcher("login.jsp").forward(request,response);
			
		}
		doPost(req,resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		//将页面数据封装进model对象中
		user.setUser_name(req.getParameter("name"));
		user.setUser_password(req.getParameter("password"));
		user.setUser_power(Integer.parseInt(req.getParameter("power")));
		//调用业务逻辑层
		login_s.setUser(user);
		List<User> list = new ArrayList<User>();
		User user = new User();
		list.add(user);
		HttpServletRequest request = null;
		@SuppressWarnings("null")
		HttpSession session = request.getSession() ;
		session.setAttribute("users",list) ;
		if(login_s.query())
		//页面跳转
		resp.sendRedirect("main.jsp");
		else 
		{
			
		}
	}

}
