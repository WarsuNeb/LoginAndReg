package com.hzit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzit.entity.User;

public class RegServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取前端传输的参数
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		String agestr = req.getParameter("age");
		int age = Integer.parseInt(agestr.trim());
		//将其封装成一个对象
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setAge(age);
		
		//将此对象添加进数据库
		
		
	}
}
