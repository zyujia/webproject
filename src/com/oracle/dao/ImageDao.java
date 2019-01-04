package com.oracle.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.entity.Goods;
import com.oracle.entity.Images;

public class ImageDao {
	public List<Images> listImage(Integer goodsId) throws Exception{
		String sql="SELECT * FROM IMAGES WHERE GOODS=?";
		PreparedStatement ps=DbUtils.getConn().prepareStatement(sql);
		ps.setInt(1,goodsId);
		ResultSet rs=ps.executeQuery();
		Images images=null;
		List<Images> ls=new ArrayList<Images>();
		while (rs.next()) {
			images=new Images(rs.getInt("id"), rs.getString("uuidname"), rs.getInt("goods"));
			ls.add(images);
		}
		return ls;
	}
	public void save(Images images) throws ClassNotFoundException, SQLException{
		String sql="INSERT INTO IMAGES VALUES(NULL,?,?)";
		PreparedStatement ps=DbUtils.getConn().prepareStatement(sql);
		ps.setString(1, images.getUuidName());
		ps.setInt(2, images.getGoods());
		ps.executeUpdate();
		
	}
}
