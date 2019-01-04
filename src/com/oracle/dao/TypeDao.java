package com.oracle.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oracle.entity.Type;

public class TypeDao {

	public List<Type> list() throws Exception{
		String sql=" SELECT * FROM TYPE";
		PreparedStatement ps=DbUtils.getConn().prepareStatement(sql);
		List<Type> ls=new ArrayList<Type>();
		ResultSet rs=ps.executeQuery();
		Type type=null;
		while (rs.next()) {
			type=new Type(rs.getInt("id"), rs.getString("name"));
			ls.add(type);
		}
		
		return ls;
	}
}
