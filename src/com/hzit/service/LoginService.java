package com.hzit.service;

import com.hzit.dao.LoginDao;
import com.hzit.entity.User;

public class LoginService {
	LoginDao loginDao = new LoginDao();
	public User login(String name,String password){
		
		User user = loginDao.login(name, password);
		return user;
	}

}
