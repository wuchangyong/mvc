<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		body{
			margin:0;
			background-color: #eee;
		}
		#top{
			height:100px;
			margin-top:-16px;
			border-bottom: 2px solid orange;
		}
		#left{
			width:200px;
			height:800px;
			float:left;
			border-right: 2px solid orange;
		}
		#center{
			width:805px;
			height:800px;
			float:left;
		}
		#left a{
			text-decoration: none;
			color:teal;
			font-size:16px;
			font-weight: bold;
			font-family: serif;
			display:block;
			margin-top:5px;
			padding-left:15px;
		}
		#left a:hover{
			background-color: maroon;
			color:#ffffff;
		}
	</style>

  </head>
  
  <body>
  	  
  	  
  	  <c:if test="${num>5}">你好</c:if>
  
      <div id="top">
      	  <p>欢迎你，${loginUser.userName},<a href="<%=basePath%>logout.do?methodName=logout">退出</a></p>
      </div>
      <div id="left">
      	  <ul>
      	  	  <c:forEach items="${menuList}" var="m2">
      	  	  	  <c:if test="${m2.level==2}">
      	  	  	  	  <li>
		      	  	  	  <span>${m2.name}</span>
		      	  	  	  <ul>
		      	  	  	  	  <c:forEach items="${menuList}" var="m3">
		      	  	  	  	  	  <c:if test="${m3.parentid==m2.mid}">
		      	  	  	  	  	  	  <li><a href="<%=basePath%>${m3.url}" target="cc">${m3.name}</a></li>
		      	  	  	  	  	  </c:if>
		      	  	  	  	  </c:forEach>
		      	  	  	  </ul>
		      	  	  </li>
      	  	  	  </c:if>
      	  	  </c:forEach>
      	  </ul>
      </div>
      <div id="center">
      	  <iframe name="cc" frameborder="0" scrolling="auto" width="100%" height="100%"></iframe>
      </div>
  </body>
</html>
