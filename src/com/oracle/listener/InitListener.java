package com.oracle.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.oracle.service.TypeService;

@WebListener
public class InitListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("------------服务器启动--------------");
		//调用商品业务层 获取商品数据
		ServletContext sc=arg0.getServletContext();
		TypeService ts=new TypeService();
		try {
			sc.setAttribute("typeList", ts.list());//类型存放进app
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
