<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div>
  			<c:if test="${empty user}">
  				<a href="<%=path%>/user/login.jsp">[登录]</a>
  				<a href="<%=path%>/user/reg.jsp">[注册]</a>
  			</c:if>
  			<c:if test="${not empty user}">
  			<a href="<%=path%>/user/goods/cart">[我的购物车]</a>
  				<a href="<%=path%>/user/logout">[退出登录]</a>
  			</c:if>	
  		</div>
  </body>
</html>
