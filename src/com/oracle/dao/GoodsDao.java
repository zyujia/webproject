package com.oracle.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.oracle.bean.SearchGoodsBean;
import com.oracle.entity.Goods;
import com.oracle.entity.Type;

public class GoodsDao {
	public List<Goods> list(String name) throws Exception{
		String sql="SELECT * FROM GOODS WHERE 1=1";
		StringBuffer sb=new StringBuffer(sql);
		if (name!=null&&!"".equals(name)) {
			sb.append(" AND NAME LIKE ?");
		}
		sb.append(" LIMIT 0,5");
		PreparedStatement ps=DbUtils.getConn().prepareStatement(sb.toString());
		if (name!=null&&!"".equals(name)) {
			ps.setString(1, "%"+name+"%");
		}
		ResultSet rs=ps.executeQuery();
		Goods goods=null;
		List<Goods> ls=new ArrayList<Goods>();
		while (rs.next()) {
			goods=new Goods(rs.getInt("id"), rs.getString("name"), rs.getInt("num"), rs.getDouble("price"), null, rs.getString("image"), rs.getDate("creatdate"), rs.getString("sn"));
			ls.add(goods);
		}
		
		return ls;
	}

	public Goods getGoodsById(Integer id) throws Exception {
		String sql="SELECT * FROM GOODS WHERE ID=?";
		PreparedStatement ps=DbUtils.getConn().prepareStatement(sql);
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		Goods goods=null;
		if (rs.next()) {
			goods=new Goods(rs.getInt("id"), rs.getString("name"), rs.getInt("num"), rs.getDouble("price"), null, rs.getString("image"), rs.getDate("creatdate"), rs.getString("sn"));
		}
		return goods;
	}

	public void save(Goods goods) throws ClassNotFoundException, SQLException {
		String sql="INSERT INTO GOODS VALUES(NULL,?,?,?,?,?,NOW(),?)";
		PreparedStatement ps=DbUtils.getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1,goods.getName());
		ps.setInt(2, goods.getNum());
		ps.setDouble(3, goods.getPrice());
		ps.setInt(4, goods.getType().getId());
		ps.setString(5, goods.getImage());
		ps.setString(6, goods.getSn());
		ps.executeUpdate();
		ResultSet rs=ps.getGeneratedKeys();//获取主键
		if (rs.next()) {
			goods.setId(rs.getInt(1));
		}
	}		
		public List<Goods> lists(SearchGoodsBean sgb) throws Exception{
			String sql=" SELECT "
					+ " G.ID AS GID,G.NAME AS GNAME,G.NUM AS NUM,G.PRICE AS GPRICE, G.CREATDATE AS CREATDATE,G.SN AS GSN,T.ID AS TID ,T.NAME AS TNAME"
					+ " FROM GOODS G "
					+ " LEFT JOIN TYPE T ON(G.TYPE=T.ID) WHERE 1=1";
			StringBuffer sb=new StringBuffer(sql);
			if (sgb.getName()!=null&&!"".equals(sgb.getName())) {
				sb.append(" AND G.NAME LIKE ?");
			}
			if (sgb.getSn()!=null&&!"".equals(sgb.getSn())) {
				sb.append(" AND G.SN=?");
			}
			if (sgb.getMinNum()!=null) {
				sb.append(" AND NUM > ?");
			}
			if (sgb.getMaxNum()!=null) {
				sb.append(" AND NUM < ?");
			}
			if (sgb.getMinPrice()!=null) {
				sb.append(" AND G.PRICE > ?");
			}
			if (sgb.getMaxPrice()!=null) {
				sb.append(" AND G.PRICE < ?");
			}
			if (sgb.getType()!=null) {
				sb.append(" AND T.ID = ?");
			}
			sb.append(" LIMIT ?,?");
			
			PreparedStatement ps=DbUtils.getConn().prepareStatement(sb.toString());
			int i=1;
			if (sgb.getName()!=null&&!"".equals(sgb.getName())) {
				ps.setString(i, "%"+sgb.getName()+"%");
				i++;
			}
			if (sgb.getSn()!=null&&!"".equals(sgb.getSn())) {
				ps.setString(i, sgb.getSn());
				i++;
			}
			if (sgb.getMinNum()!=null) {
				ps.setInt(i, sgb.getMinNum());
				i++;
			}
			if (sgb.getMaxNum()!=null) {
				ps.setInt(i, sgb.getMaxNum());
				i++;
			}
			if (sgb.getMinPrice()!=null) {
				ps.setDouble(i, sgb.getMinPrice());
				i++;
			}
			if (sgb.getMaxPrice()!=null) {
				ps.setDouble(i, sgb.getMaxPrice());
				i++;
			}
			if (sgb.getType()!=null) {
				ps.setInt(i, sgb.getType());
				i++;
			}
			ps.setInt(i, sgb.getOffSet());
			i++;
			ps.setInt(i, sgb.getLength());
			List<Goods> ls=new ArrayList<Goods>();
			ResultSet rs=ps.executeQuery();
			Goods goods=null;
			Type type=null;
			while (rs.next()) {
				type=new Type(rs.getInt("tid"), rs.getString("tname"));
				goods=new Goods(rs.getInt("gid"), rs.getString("gname"), rs.getInt("num"), rs.getDouble("gprice"), type,null, rs.getDate("creatdate"), rs.getString("gsn"));
				ls.add(goods);
			}
			
			return ls;
		}

		public Integer countGoods(SearchGoodsBean sgb) throws ClassNotFoundException, SQLException {
			String sql=" SELECT COUNT(G.ID) AS C FROM GOODS G "
					+ " LEFT JOIN TYPE T ON(G.TYPE=T.ID) WHERE 1=1";
			StringBuffer sb=new StringBuffer(sql);
			if (sgb.getName()!=null&&!"".equals(sgb.getName())) {
				sb.append(" AND G.NAME LIKE ?");
			}
			if (sgb.getSn()!=null&&!"".equals(sgb.getSn())) {
				sb.append(" AND G.SN=?");
			}
			if (sgb.getMinNum()!=null) {
				sb.append(" AND NUM > ?");
			}
			if (sgb.getMaxNum()!=null) {
				sb.append(" AND NUM < ?");
			}
			if (sgb.getMinPrice()!=null) {
				sb.append(" AND G.PRICE > ?");
			}
			if (sgb.getMaxPrice()!=null) {
				sb.append(" AND G.PRICE < ?");
			}
			if (sgb.getType()!=null) {
				sb.append(" AND T.ID = ?");
			}
			
			
			PreparedStatement ps=DbUtils.getConn().prepareStatement(sb.toString());
			int i=1;
			if (sgb.getName()!=null&&!"".equals(sgb.getName())) {
				ps.setString(i, "%"+sgb.getName()+"%");
				i++;
			}
			if (sgb.getSn()!=null&&!"".equals(sgb.getSn())) {
				ps.setString(i, sgb.getSn());
				i++;
			}
			if (sgb.getMinNum()!=null) {
				ps.setInt(i, sgb.getMinNum());
				i++;
			}
			if (sgb.getMaxNum()!=null) {
				ps.setInt(i, sgb.getMaxNum());
				i++;
			}
			if (sgb.getMinPrice()!=null) {
				ps.setDouble(i, sgb.getMinPrice());
				i++;
			}
			if (sgb.getMaxPrice()!=null) {
				ps.setDouble(i, sgb.getMaxPrice());
				i++;
			}
			if (sgb.getType()!=null) {
				ps.setInt(i, sgb.getType());
			}
			
			
			ResultSet rs=ps.executeQuery();
			Integer count=0;
			if (rs.next()) {
				count=rs.getInt("C");
			}
			
			return count;
		}
	

}
