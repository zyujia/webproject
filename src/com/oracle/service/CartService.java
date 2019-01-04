package com.oracle.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.dao.CartDao;
import com.oracle.dao.DbUtils;
import com.oracle.dao.GoodsDao;
import com.oracle.entity.Cart;
import com.oracle.entity.Goods;
import com.oracle.entity.User;


public class CartService {
	CartDao cd=new CartDao();
	GoodsDao gd=new GoodsDao();
	public boolean add(Integer goodsId,Integer userId) throws Exception{
		Cart cart=cd.getCartByUserAndGoods(userId, goodsId);
		
		if (cart==null) {
			Goods goods=gd.getGoodsById(goodsId);
			if (goods==null) {
				DbUtils.closeConn();
				return false;
			}
			User user=new User();
			user.setId(userId);
			Cart cart2=new Cart(null, goods.getImage(), goods.getName(), goods.getPrice(), 1, goods, user);
			if (cd.add(cart2)>0) {
				DbUtils.closeConn();
				return  false;
			}
		}else {
			cart.setNum(cart.getNum()+1);
			if (cd.updateNum(cart)>0) {
				DbUtils.closeConn();
				return  false;
			}
		}
		return true;
		
	}
	public List<Cart> list(Integer id) throws Exception{
		List<Cart> ls=cd.list(id);
		DbUtils.closeConn();
		return ls;
	}
//	public boolean delete(Integer id) throws SQLException{
//		boolean bln=true;
//		try {
//			if (cd.delete(id)>0) {
//			} else {
//				bln=false;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			DbUtils.closeConn();
//		}
//		return bln;
//	}
}
