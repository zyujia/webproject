package com.oracle.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.bean.Page;
import com.oracle.bean.SearchGoodsBean;
import com.oracle.entity.Goods;
import com.oracle.service.GoodsService;
@WebServlet("/admin/goods/list")
public class AdminGoodsList extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		if (request.getMethod().equals("GET")) {
			if (name!=null) {
				name=new String(name.getBytes("ISO-8859-1"),"utf-8");
			}
		}
		String sn=request.getParameter("sn");
		String strMinNum=request.getParameter("minNum");
		String strMaxNum=request.getParameter("maxNum");
		String strMinPrice=request.getParameter("minPrice");
		String strMaxPrice=request.getParameter("maxPrice");
		String strType=request.getParameter("type");
		String strCurrentPage=request.getParameter("currentPage");
		
		Integer currentPage=1;
		Integer pageSize=3;
		
		if (strCurrentPage!=null&&!"".equals(strCurrentPage)) {
			currentPage=Integer.parseInt(strCurrentPage);
		}
		
		Integer minNum=null,maxNum=null,type=null;
		Double minPrice=null,maxPrice=null;
		if (strMinNum!=null&&!"".equals(strMinNum)) {
			minNum=Integer.parseInt(strMinNum);
		}
		if (strMaxNum!=null&&!"".equals(strMaxNum)) {
			maxNum=Integer.parseInt(strMaxNum);
		}
		if (strMinPrice!=null&&!"".equals(strMinPrice)) {
			minPrice=Double.parseDouble(strMinPrice);
		}
		if (strMaxPrice!=null&&!"".equals(strMaxPrice)) {
			maxPrice=Double.parseDouble(strMaxPrice);
		}

		if (strType!=null&&!"0".equals(strType)) {
			type=Integer.parseInt(strType);
		}
		
		SearchGoodsBean sgb=new SearchGoodsBean(name, sn, minNum, maxNum, minPrice, maxPrice, type);
		sgb.setCurrentPage(currentPage);
		sgb.setPageSize(pageSize);
		GoodsService gs=new GoodsService();
		try {
			Page<Goods> page=gs.lists(sgb);
			List<Goods> listData=page.getList();
			request.setAttribute("goodsList", listData);
			request.setAttribute("pageInfo", page);
			request.setAttribute("sgb", sgb);
			request.getRequestDispatcher("list.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
