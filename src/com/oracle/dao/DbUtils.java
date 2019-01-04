package com.oracle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
	private static final String USER_NAME="root";
	private static final String PASSWORD="root";
	private static final String URL="jdbc:mysql://localhost:3306/test1?useUnicode=true&characterEncoding=UTF-8";
	private static final String DRIVER="com.mysql.jdbc.Driver";
	
	private static Connection conn=null;

	public static Connection getConn() throws SQLException, ClassNotFoundException{
		if(conn==null||conn.isClosed()){
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		}
		return conn;
	}
	
	public static void closeConn() throws SQLException{
		if(conn!=null&&!conn.isClosed()){
			conn.close();
		}
	}
	
}
