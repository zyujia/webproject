package com.oracle.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.entity.Goods;
import com.oracle.service.CartService;
import com.oracle.service.GoodsService;
@WebServlet("/user/goods")
public class GoodsCartServlet extends HttpServlet {

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

		Integer goodsid=Integer.parseInt(request.getParameter("goodsid"));
		Integer userid=Integer.parseInt(request.getParameter("userid"));
	  	GoodsService gs=new GoodsService();
	  	CartService cs=new CartService();
	  	try {
			Goods goods=gs.getGoodsById(goodsid);
			if (cs.add(goods.getId(), userid)) {
				response.sendRedirect(request.getContextPath()+"/user/goods.jsp");
				return;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	  	
			
	}

}
