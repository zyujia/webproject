<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
			*{
				margin-top: 20px;
				margin: 0px ; padding: 0px;
			}
			body{
				background:url(img/1.jpg) no-repeat;
				background-size: cover;
			}
			#login{
				width: 272px;
				height: 300px;
				background: rgba(0,0,0,0.5);
				border-radius: 10px;
				font-family: "微软雅黑";
				position: absolute;
				left: 40%;
				top: 120px;/*init 50px*/
			}
			.titile{
				font-size: 30px;
				font-weight: bold;
				color: #fff;
				text-align: center;
				margin-bottom: 30px;
				cursor: move;
			}
			#login input.txt{
				width: 270px;
				height: 42px;
				color: #fff;
				border-radius: 6px;
				background: rgba(45,45,45,0.15);
				margin-bottom: 15px;
				border: 1px solid rgba(255,255,255,0.15);
				box-shadow: 0 2px 3px rgba(0,0,0,0.1) inset;
			}
			#login input.but{
				width: 272px;
				height: 44px;
				background: #ef4300;
				border: 0;
				border-radius: 6px;
				box-shadow: 0 15px 30px rgba(255,255,255,0.25) inset;
				color: #fff;
				font-size: 20px;
			}
			#login input:focus{
				outline: none;
			}
		</style>
  </head>
  
  <body>
     <div id="login">
			<h3 class="titile">Login</h3>
			<h5 style="color:red">${loginError}</h5>
			<form action="<%=path%>/admin/login" method="post">
				<input id="" class="txt" name="loginName" type="text" placeholder="userName" value="${admin.loginName}"/><br/>
				<input id="" class="txt" name="pwd" type="password" placeholder="password"/><br/>
				<input id="" class="but" name="" type="submit" value="sign in"/><br/>
			</form>
		</div>
  </body>
</html>
