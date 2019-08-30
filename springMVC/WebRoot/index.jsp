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
    	<h3>以下表单用于测试对象绑定</h3>
    	<form action="test/objectbinding" method="post">
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
    	<br>
    	<h3>以下表单用于测试ModelAttribute注解修改数据</h3>
    	<form action="test/modelattribute" method="post">
    		name:<input name="name" type="text">
    		<br>
    		age:<input name="age" type="text">
    		<br>
    		homeAddress:<input name="homeAddress" type="text">
    		<br>
    		schoolAddress:<input name="schoolAddress" type="text">
    		<br>
    		<input type="submit" value="修改信息"> 
    	</form>
    	<br>
    	<h3>以下用于测试请求重定向</h3>
    	<a href="test/redirect">first mvc welcome</a>
    	<br>
    	<h3>以下表单用于测试自定义的类型转换（将String转换为Student对象）</h3>
    	<form action="test/converter" method="post">
    		格式：name--age--homeAddress--schoolAddress<br>
    		<input name="student" type="text">
    		<input type="submit" value="转换"> 
    	</form>
    	<br>
    	<h3>以下表单用于测试类型转换（将String转换为Student对象）成功后跳转到响应页面（显示输入的数据）</h3>
    	<form action="test/responseconvert" method="post">
    		格式：name-age-homeAddress-schoolAddress<br>
    		<input name="student" type="text">
    		<input type="submit" value="转换"> 
    	</form>
    	<br>
    	<h3>以下表单用于测试日期格式化</h3>
    	<form action="test/datetimeformat" method="post">
    		name:<input name="name" type="text">
    		<br>
    		sex:<input name="sex" type="text">
    		<br>
    		birthday:<input name="birthday" type="text">
    		<br>
    		<input type="submit" value="日期格式化"> 
    	</form>
    	<br>
    	<br>
    	<h3>以下表单用于测试日期格式化错误处理</h3>
    	<form action="test/errordeal" method="post">
    		name:<input name="name" type="text">
    		<br>
    		sex:<input name="sex" type="text">
    		<br>
    		birthday:<input name="birthday" type="text">
    		<br>
    		<input type="submit" value="日期格式化"> 
    	</form>
    	<br>
    	<h3>以下表单用于测试文件上传功能</h3>
    	<!-- 文件上传只能使用post方式，且enctype的值必须为multipart/form-data -->
    	<form action="test/upload" method="post" enctype="multipart/form-data">
    		文件:<input name="file" type="file">
    		<br>
    		描述:<input name="desc" type="text">
    		<br>
    		<input type="submit" value="文件上传"> 
    	</form>
    	<br>
    	<h3>以下表单用于测试拦截器功能（被拦截器拦截且不放行 ）</h3>
    	<span>提示：不放行响应的页面是空白的</span>
    	<!-- 被拦截器拦截且不放行 -->
    	<form action="test/interceptor" method="post">
    		<input type="submit" value="拦截测试"> 
    	</form>
    	<br>
    	<h3>以下表单用于测试ExceptionHandler注解</h3>
    	<span>提示：测试局部异常处理（只处理当前类抛出的异常）</span>
    	<form action="test/partexceptionhandler" method="GET">
    		<input type="submit" value="局部异常处理"> 
    	</form>
    	<br>
    	<h3>以下表单用于测试ControllerAdvice注解</h3>
    	<span>提示：测试全局异常处理（处理所有类抛出的异常）</span>
    	<form action="test/exceptionhandler" method="GET">
    		<input type="submit" value="全局异常处理"> 
    	</form>
  </body>
</html>
