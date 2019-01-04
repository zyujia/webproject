<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'cart.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script>
	function isChecked(){
		var isOk=document.getElementById("all").checked;
		//获取所有商品复选框对象
		var goods=document.getElementsByName("goods");
		for(var i=0 ;i<goods.length;i++){
			
			goods[i].checked=isOk;
			
			}
			
		}
		function isChecked2(){
			var isOk=document.getElementById("all");
			//获取所有商品复选框对象
			var goods=document.getElementsByName("goods");
			if(goods[0].checked&&goods[1].checked&&goods[2].checked&&goods[3].checked){
				isOk.checked=true;
				}else{
				isOk.checked=false;
					}
			
			}
</script>
</head>

<body>
	
	<div id="goods_img">
		<table>
			<tr>
				<th><input name="all" id="all" type="checkbox" value=""
					onClick="isChecked()" />全选</th>
				<th>商品图片</th>
				<th>商品名称</th>
				<th>价格</th>
			</tr>
			<tr>
				<c:forEach items="${cartList}" var="c">
					<td><input name="goods" type="checkbox" value="" onClick="isChecked2()"/></td>
					<td><img src="<%=path%>/upload/${c.image}"></td>
					<td>${c.name}</td>
					<td>${c.price}</td>
				</c:forEach>
				
			</tr>
		</table>


		
	</div>

</body>
</html>
