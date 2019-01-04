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
    
    <title>My JSP 'goods.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script type="text/javascript">
		function changeImg(obj){
			var objimg=document.getElementById("img");
			objimg.src=obj.src;
		}
		
	</script>
	<style type="text/css">
	img{border: 1px solid;}
		#img{width: 250px; height: 200px;}
		.img2{width: 50px; height: 50px;}
		*{margin:0,auto; padding: 1px;}
		#goods_img{float: left;}
		#goods_mes{float: left;}
	</style>
  </head>
  
  <body>
   		<div id="goods">
   			<div id="goods_img">
   				<img src="<%=path%>/upload/${goods.image}" id="img"><br><br>
   				
   				<c:forEach items="${goods.listImages}" var="images">
   					<img class="img2"  onclick="changeImg(this)" src="<%=path%>/upload/${images.uuidName}"/> 
   				</c:forEach>
   			</div>
   			<div id="goods_mes">
   				<p>${goods.name}</p>
   				<div>
   					售价:<span>${goods.price}</span><a href="#">降价通知</a>
   				</div>
   				<a href='<c:if test="${empty user}"><%=path%>/user/login.jsp</c:if>
   							<c:if test="${not empty user}"><%=path%>/user/goods?goodsid=${goods.id}&userid=${user.id}</c:if>'>加入购物车</a>
   			</div>
   		</div>
  </body>
</html>
