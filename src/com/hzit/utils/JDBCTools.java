package com.hzit.utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 通过c3p0获取连接对象
 * @author zhaoqu
 *
 */
public class JDBCTools {
	//c3p0通过接口引入
	private static DataSource dataSource = null;
	static{
		//接口通过实现类实例化   传入的是c3p0-config.xml  <name-config name = "c3p0test">
		dataSource = new ComboPooledDataSource("test");
	}
	
	//获取连接
	public static Connection getConnection(){
		Connection  conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//释放资源
	public static void release(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		JDBCTools.getConnection();
	}
}
