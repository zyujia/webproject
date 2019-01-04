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
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.wid{width:40px; }
	</style>
<script type="text/javascript">
	function goToPage(currentPage){
	
		var type=document.getElementById("type").value;
		var name=document.getElementById("name").value;
		
		window.location.href="<%=path%>/admin/goods/list?currentPage="+currentPage+"&type="+type+"&name="+name;
	}
</script>
  </head>
  
  <body>
    	<table align="center">
		 	<tr>
		 		<form action="admin/goods/list" method="post">
		 		<td>
		 			名称:<input name="name"/>
		 			编号:<input name="sn"/>
		 			库存:<input name="minNum" class="wid"/>-<input name="maxNum" class="wid"/>
		 			单价:<input name="minPrice" class="wid"/>-<input name="maxPrice" class="wid"/>
		 			类型:<select name="type">
		 					<option value="0">请选择</option>
		 					<c:forEach items="${typeList}" var="t">
		 						<option value="${t.id}">${t.name}</option>
		 					</c:forEach>
		 				</select>
		 			<input type="submit" value="检索"/>
		 		</td>
		 		</form>
		 	</tr>
		 </table>
		 <table align="center">
		 	<tr>
		 		<th>序号</th>
		 		<th>商品名称</th>
		 		<th>库存数量</th>
		 		<th>商品价格</th>
		 		<th>商品类型</th>
		 		<th>商品编号</th>
		 		<th>上架日期</th>
		 		<th>修改</th>
		 	</tr>
		 	<c:forEach items="${goodsList}" var="g" varStatus="v">
		 	<tr>
		 		<td>${v.count}</td>
		 		<td>${g.name}</td>
		 		<td>${g.num}</td>
		 		<td>${g.price}</td>
		 		<td>${g.type.name}</td>
		 		<td>${g.sn}</td>
		 		<td><fmt:formatDate value="${g.creatdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		 		<td><a href="<%=path%>/admin/goods/update">编辑</a></td>
		 	</tr>
		 	</c:forEach>
		 	<tr>
   				<td>
   					共${pageInfo.count}条记录 
   					共${pageInfo.totalPage}页 
   					当前第${pageInfo.currentPage}页 
   					
   					<c:if test="${pageInfo.currentPage ne 1}">
   						<a href="javascript:goToPage(${pageInfo.currentPage-1})">上一页</a>
   						<a href="javascript:goToPage(${1})">首页</a>
   					</c:if>
   					<c:if test="${pageInfo.totalPage ne pageInfo.currentPage }">
   						<a href="javascript:goToPage(${pageInfo.currentPage+1})">下一页</a>
   						<a href="javascript:goToPage(${pageInfo.totalPage})">末页</a>
   					</c:if>
   					
   				</td>
   			</tr>
		 </table>
		 <div>
		 	<input type="hidden" id="type" value="${sgb.type==null?0:sgb.type}"/>
		 	<input type="hidden" id="name" value="${sgb.name}"/>
		 </div>
  </body>
</html>
