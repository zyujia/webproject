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
    
    <title>My JSP 'update.jsp' starting page</title>
    
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
    	<form action="<%=path%>/admin/goods/update" method="post" enctype="multipart/form-data">
    	商品名称:<input name="name"/><br>
    	商品库存:<input name="num"/><br>
    	商品单价:<input name="price"/><br>
    	商品类型:<select name="type">
    				<c:forEach items="${typeList}" var="t">
    					<option value="${t.id}">${t.name}</option>
    				</c:forEach>
    			</select>
    			<br>
    		商品封面:<input name="coverImg" type="file"/><br>
    		商品附属图1:<input name="img" type="file"/><br>
    		商品附属图2:<input name="img" type="file"/><br>
    		商品附属图3:<input name="img" type="file"/><br>
    		商品附属图4:<input name="img" type="file"/><br>
    		商品附属图5:<input name="img" type="file"/><br>
    		<input type="submit" value="提交"/>
    </form>
  </body>
</html>
