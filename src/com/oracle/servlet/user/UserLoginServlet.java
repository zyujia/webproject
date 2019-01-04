package com.oracle.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oracle.entity.User;
import com.oracle.service.UserService;
@WebServlet("/userlogin")
public class UserLoginServlet extends HttpServlet {

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
			request.getRequestDispatcher("user/login.jsp").forward(request, response);
			return;
		}
		if (null==pwd||"".equals(pwd)) {
			request.setAttribute("loginError", "密码不能为空");
			request.getRequestDispatcher("user/login.jsp").forward(request, response);
			return;
		}
		User user=new User(null, null, loginName, pwd);
		UserService us=new UserService();
		try {
			if (us.login(user)) {
				HttpSession session=request.getSession();//获取session
				session.setAttribute("user", user);
				response.sendRedirect(request.getContextPath()+"/home");
				return;
			}else {
				request.setAttribute("loginError", "用户名不存在或密码不匹配");
				request.setAttribute("user", user);
				request.getRequestDispatcher("user/login.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
