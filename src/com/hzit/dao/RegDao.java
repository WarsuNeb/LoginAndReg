package com.hzit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hzit.entity.User;
import com.hzit.utils.JDBCTools;

public class RegDao {
	public void add(User user){
		Connection conn = JDBCTools.getConnection();
		String sql = "insert into user (name,password,age) values(?,?,?)";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			statement.setInt(3, user.getAge());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTools.release(conn);
		}
	}
	
	
	
	
}
