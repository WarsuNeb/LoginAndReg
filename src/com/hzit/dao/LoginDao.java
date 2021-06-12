package com.hzit.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hzit.entity.User;
import com.hzit.utils.JDBCTools;

public class LoginDao {
//	public static void main(String[] args) {
//		JDBCTools.getConnection();
//	}
	public User login(String name,String password){
		Connection conn = JDBCTools.getConnection();
		String sql ="select * from user where name=? and password =?";
		QueryRunner runner = new QueryRunner();
		BeanHandler rsh = new BeanHandler(User.class);
		User user = null;
		try {
			user = runner.query(conn, sql, rsh,name,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTools.release(conn);
		}
		return user;
		
	}
	
	
	
//	public static void main(String[] args) {
//		LoginDao test = new LoginDao();
//		User user = test.login("zhangsan", "123123");
//		System.out.println(user);
//	}

}
