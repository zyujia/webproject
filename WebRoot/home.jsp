<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'home.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=path%>/js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".goods").click(function(){
				var id=$(this).attr("name");
				var url="<%=path%>/user/goods/goods?id="+id;
				window.location.href=url;
			})
		})
	</script>
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/list-goods.css">
		<style type="text/css">
		*{
				margin: 0px auto;
				padding: 0px;
			}
			html,body{
				width: 1024px;
				height: 768px;
				background-color: #000000;
			}
			#content{
				margin: 0px auto;
				width: 100%;
			}
	</style>
  </head>
  
  <body>
  	
  		<jsp:include page="top.jsp"></jsp:include>
    <div id="content">
	   <div id="list" align="center">
		<c:forEach items="${goodsList}" var="g">
			<div class="goods" name="${g.id}">
					<img src="<%=path%>/upload/${g.image}" />
					<p class="price">楼 <fmt:formatNumber pattern="#,###.00" value="${g.price}"></fmt:formatNumber></p>
					<a href="goods.html">${g.name}</a>
			</div>
		</c:forEach>
	  </div>
  	</div>
  </body>
</html>
