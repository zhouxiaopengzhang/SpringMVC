<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
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
  以下是requestScope：<br>
   ${requestScope.student.name}
   ${requestScope.student.age}
   <br>
    ${requestScope.student2.name}
   ${requestScope.student2.age}
   <br>
    ${requestScope.student3.name}
   ${requestScope.student3.age}
   <br>
    ${requestScope.student4.name}
   ${requestScope.student4.age}
   <br>
   以下是sessionScope：<br>
    ${sessionScope.student.name}
   ${sessionScope.student.age}
   <br>
    ${sessionScope.student2.name}
   ${sessionScope.student2.age}
   <br>
    ${sessionScope.student3.name}
   ${sessionScope.student3.age}
   <br>
    ${sessionScope.student4.name}
   ${sessionScope.student4.age}
   <br>
  </body>
</html>
