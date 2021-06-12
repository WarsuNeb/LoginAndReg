package com.hzit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzit.entity.User;
import com.hzit.service.LoginService;

public class LoginServlet extends HttpServlet{
	
	LoginService loginService = new LoginService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		User user = loginService.login(name, password);
		req.setAttribute("user", user);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
