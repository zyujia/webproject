package com.oracle.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.entity.User;
import com.oracle.service.UserService;
@WebServlet("/user/reg")
public class UserRegServlet extends HttpServlet {

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
		String userName=request.getParameter("userName");
		String loginName=request.getParameter("loginName");
		String pwd=request.getParameter("pwd");
		
		if (null==userName||"".equals(userName)) {
			request.setAttribute("loginError", "用户名不能为空");
			request.getRequestDispatcher("user/reg.jsp").forward(request, response);
			return;
		}
		if (null==loginName||"".equals(loginName)) {
			request.setAttribute("loginError", "登录名不能为空");
			request.getRequestDispatcher("user/reg.jsp").forward(request, response);
			return;
		}
		if (null==pwd||"".equals(pwd)) {
			request.setAttribute("loginError", "密码不能为空");
			request.getRequestDispatcher("user/reg.jsp").forward(request, response);
			return;
		}
		User user=new User(null, userName, loginName, pwd);
		UserService us=new UserService();
		try {
			if (us.reg(user)) {
				if (us.register(user)) {
					response.sendRedirect(request.getContextPath()+"/user/login.jsp");
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
