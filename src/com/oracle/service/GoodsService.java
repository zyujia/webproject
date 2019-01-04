package com.oracle.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.bean.Page;
import com.oracle.bean.SearchGoodsBean;
import com.oracle.dao.DbUtils;
import com.oracle.dao.GoodsDao;
import com.oracle.dao.ImageDao;
import com.oracle.entity.Goods;
import com.oracle.entity.Images;

public class GoodsService {
	GoodsDao gd=new GoodsDao();
	ImageDao iid=new ImageDao();
	public List<Goods> list(String name) throws Exception{
		
		List<Goods> list=gd.list(name);
		DbUtils.closeConn();
		return list;
	}

	public Goods getGoodsById(Integer id) throws Exception{
		Goods goods=gd.getGoodsById(id);
		List<Images> ls=iid.listImage(id);
		goods.setListImages(ls);
		return goods;
	}

	public void save(Goods goods) throws ClassNotFoundException, SQLException {
		gd.save(goods);
		for (int i = 0; i <goods.getListImages().size(); i++) {
			goods.getListImages().get(i).setGoods(goods.getId());
			iid.save(goods.getListImages().get(i));
			
		}
	}

	public Page<Goods> lists(SearchGoodsBean sgb) throws Exception {
		Integer count=gd.countGoods(sgb);
		Integer totalPage=Page.countPage(count, sgb.getPageSize());
		Integer offSet=Page.countOffSet(sgb.getPageSize(), sgb.getCurrentPage());
		Integer length=sgb.getPageSize();
		sgb.setLength(length);
		sgb.setOffSet(offSet);
		List<Goods> list=gd.lists(sgb);
		Page<Goods> page=new Page<Goods>(count, totalPage, sgb.getPageSize(), sgb.getCurrentPage(), list);
//		DbUtils.closeConn();
		return page;
	}

}
