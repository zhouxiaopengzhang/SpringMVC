<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  	<!-- 交给SpringMVCServlet控制器的welcome方法会处理这个请求，下面的链接是get请求 -->
  	<br>
    	<h3>以下用于测试链接的使用</h3>
    <a href="test/welcome">first mvc welcome</a>
    	<br>
    	<h3>以下表单用于测试RequestParam注解的使用</h3>
    	<form action="test/param" method="post">
    		name:<input name="name" type="text">
    		<br>
    		age:<input name="age" type="text">
    		<br>
    		<input type="submit"> 
    	</form>
    	<br>
    	<h3>以下表单用于测试RequestBody注解的使用</h3>
    	<form action="test/requestbody" method="post">
    		name:<input name="name" type="text">
    		<br>
    		age:<input name="age" type="text">
    		<br>
    		homeAddress:<input name="homeAddress" type="text">
    		<br>
    		schoolAddress:<input name="schoolAddress" type="text">
    		<br>
    		<input type="submit"> 
    	</form>
    	<br>
    	<h3>以下表单用于测试原生ServletAPI的使用</h3>
    	<form action="test/servlet" method="post">
    		name:<input name="name" type="text">
    		<br>
    		age:<input name="age" type="text">
    		<br>
    		<input type="submit"> 
    	</form>
    	<br>
    	<h3>以下用于测试包含参数的页面跳转</h3>
    	<a href="test/modelandview">modelandview</a>
    	<br>
    	<a href="test/modelmap">modelmap</a>
    	<br>
    	<a href="test/model">model</a>
    	<br>
    	<a href="test/map">map</a>
  </body>
</html>
