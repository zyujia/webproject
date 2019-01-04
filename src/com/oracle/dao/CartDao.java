package com.oracle.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.entity.Cart;
import com.oracle.entity.Goods;

public class CartDao {
	public List<Cart> list(Integer id) throws Exception{
		String sql="SELECT * FROM CART WHERE USER=?";
		PreparedStatement ps=DbUtils.getConn().prepareStatement(sql);
		ps.setInt(1, id);
		List<Cart> ls=new ArrayList<Cart>();
		Cart cart=null;
		ResultSet rs=ps.executeQuery();
		Goods goods=null;
		while(rs.next()){
			goods=new Goods();
			goods.setId(rs.getInt("goods"));
			cart=new Cart(rs.getInt("id"), rs.getString("image"), rs.getString("name"), rs.getDouble("price"), rs.getInt("num"), goods, null);
			ls.add(cart);
		}
		return ls;
	}
	public int add(Cart cart) throws Exception{
		String sql="INSERT INTO CART VALUES(NULL,?,?,?,?,?,?)";
		PreparedStatement ps=DbUtils.getConn().prepareStatement(sql);
		ps.setInt(5, cart.getGoods().getId());
		ps.setInt(6, cart.getUser().getId());
		ps.setInt(4, cart.getNum());
		ps.setDouble(3, cart.getPrice());
		ps.setString(2, cart.getName());
		ps.setString(1, cart.getImage());
		return ps.executeUpdate();
	}

	public Cart getCartByUserAndGoods(Integer userId, Integer goodsId) throws SQLException, ClassNotFoundException {
		
		String sql=" SELECT C.ID AS CID,C.NUM AS CNUM,C.PRICE AS CPRICE, C.NAME AS CNAME,C.IMAGE AS CIMAGE,"
				+ " G.ID AS GID,G.NAME AS GNAME,G.IMAGE AS GIMAGE,G.NUM AS GNUM,G.PRICE AS GPRICE"
				+ "  FROM CART C LEFT JOIN GOODS G ON(G.ID=C.GOODS) WHERE USERS=? AND GOODS=?";
		PreparedStatement ps=DbUtils.getConn().prepareStatement(sql);
		ps.setInt(1, userId);
		ps.setInt(2, goodsId);
		ResultSet rs=ps.executeQuery();
		Cart cart=null;
		Goods goods=null;
		if (rs.next()) {
			goods=new Goods(rs.getInt("GID"), rs.getString("GNAME"), rs.getInt("GNUM"), rs.getDouble("GPRICE"), null, rs.getString("GIMAGE"), null, null);
			cart=new Cart(rs.getInt("CID"), rs.getString("CIMAGE"), rs.getString("CNAME"), rs.getDouble("CPRICE"), rs.getInt("CNUM"), goods, null);
		}
		return cart;
	}

	public int updateNum(Cart cart) throws Exception{
		String sql="UPDATE CART SET NUM=? WHERE ID=?";
		PreparedStatement ps=DbUtils.getConn().prepareStatement(sql);
		ps.setInt(1, cart.getNum());
		ps.setInt(2, cart.getId());
		return  ps.executeUpdate();
	}
	public int deleteCart(Integer id) throws Exception{
		String sql="DELETE CART WHERE ID=?";
		PreparedStatement ps=DbUtils.getConn().prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate();
		
	}
}
