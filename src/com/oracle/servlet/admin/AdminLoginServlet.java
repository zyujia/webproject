package com.oracle.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.entity.Admin;
import com.oracle.service.AdminService;
@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {

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
		String loginName=request.getParameter("loginName");
		String pwd=request.getParameter("pwd");
		
		if (null==loginName||"".equals(loginName)) {
			request.setAttribute("loginError", "登录名不能为空");
			request.getRequestDispatcher("admin/login.jsp").forward(request, response);
			return;
		}
		if (null==pwd||"".equals(pwd)) {
			request.setAttribute("loginError", "密码不能为空");
			request.getRequestDispatcher("admin/login.jsp").forward(request, response);
			return;
		}
		Admin admin=new Admin(null, null, loginName, pwd);
		AdminService as=new AdminService();
		try {
			if (as.login(admin)) {
				HttpSession session=request.getSession();//获取session
				session.setAttribute("admin", admin);
				response.sendRedirect(request.getContextPath()+"/admin/main.jsp");
//				response.sendRedirect(request.getContextPath()+"/main.jsp");
				return;
			}else {
				request.setAttribute("loginError", "用户名不存在或密码不匹配");
				request.setAttribute("admin", admin);
				request.getRequestDispatcher("admin/login.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
