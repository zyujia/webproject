package com.oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.oracle.entity.User;


public class UserDao {

	public User getUserByLoginName(String loginName) throws Exception{
		String sql="SELECT * FROM USERS WHERE LOGINNAME=?";
		PreparedStatement ps=DbUtils.getConn().prepareStatement(sql);
		ps.setString(1, loginName);
		User user=null;
		ResultSet rs=ps.executeQuery();
		if (rs.next()) {
			user=new User(rs.getInt("id"), rs.getString("username"), loginName, rs.getString("pwd"));
		}
		return user;
		
	}
	
	public int reg(User user) throws Exception{
		String sql="INSERT INTO USERS VALUES (NULL,?,?,?)";
		Connection connection=DbUtils.getConn();
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getLoginName());
		ps.setString(3, user.getPwd());
		return ps.executeUpdate();
	}
}
