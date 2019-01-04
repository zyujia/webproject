package com.oracle.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.oracle.entity.Admin;


public class AdminDao {

	public Admin getAdminByLoginName(String loginName) throws Exception{
		String sql="SELECT * FROM ADMIN WHERE LOGINNAME=?";
		PreparedStatement ps=DbUtils.getConn().prepareStatement(sql);
		ps.setString(1, loginName);
		Admin admin=null;
		ResultSet rs=ps.executeQuery();
		if (rs.next()) {
			admin=new Admin(rs.getInt("id"), rs.getString("username"), loginName, rs.getString("pwd"));
		}
		return admin;
		
	}
}
