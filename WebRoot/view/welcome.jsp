<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath",basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'easyui.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="<%=basePath%>easyui/themes/default/easyui.css"/>
	<link type="text/css" rel="stylesheet" href="<%=basePath%>easyui/themes/icon.css"/>
	<script type="text/javascript" src="<%=basePath%>easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
  	<style type="text/css">
  		.north img{height:90px;}
  		.logo {width:500px;float:left;}
  		#logo2{float:right;text-align: right;padding-top:20px;padding-right:20px;}
  	</style>
  	<script type="text/javascript">
  	function addTab(title,url){
  		$('#tabs').tabs('add',{
  			title   : title,
  			selected: true,
  			closable: true,
  			content : "<iframe width='100%' height='100%' frameborder='0' scrolling='auto' src='"+url+"'></iframe>"
  	  	});
  	}
  	</script>
  </head>
  
  <body class="easyui-layout">
      <div data-options="region:'north',split:true" style="height:100px;" class="north">
      	  <div class="logo">
      	  	  <img src="<%=basePath%>view/images/lovologo.png">
      	  </div>
      	  <div class="logo" id="logo2">欢迎你，${loginUser.userName},<a href="<%=basePath%>logout.do?methodName=logout">退出</a></div>
      </div>   
      <div data-options="region:'west',title:'系统菜单',split:true" style="width:200px;">
			<%--
			<div id="aa" class="easyui-accordion" style="width:300px;" data-options="fit:true">
				<div title="Title1" data-options="iconCls:'icon-save'"
					style="overflow: auto; padding: 10px;">
					<h3 style="color: #0099FF;">Accordion for jQuery</h3>
					<p>
						Accordion is a part of easyui framework for jQuery. It lets you
						define your accordion component on web page more easily.
					</p>
				</div>
				<div title="Title2" data-options="iconCls:'icon-reload',selected:true" style="padding: 10px;">
					
				</div>
				<div title="Title3">content3</div>
			</div>
			--%>
			<ul id="tt" class="easyui-tree">  
				<c:forEach items="${menuList}" var="m2">
					<c:if test="${m2.level==2}">
      	  	  	  	    <li>
		      	  	  	    <span>${m2.name}</span>
		      	  	  	    <ul>
		      	  	  	  	    <c:forEach items="${menuList}" var="m3">
		      	  	  	  	  	    <c:if test="${m3.parentid==m2.mid}">
		      	  	  	  	  	  	    <li><a href="javascript:void(0);" onclick="addTab('${m3.name}','${basePath}${m3.url}');">${m3.name}</a></li>
		      	  	  	  	  	    </c:if>
		      	  	  	  	    </c:forEach>
		      	  	  	    </ul>
		      	  	    </li>
      	  	  	    </c:if>
				</c:forEach> 
			</ul>
		</div>   
      <div data-options="region:'center'" style="padding:5px;background:#eee;">
      	  <div id="tabs" class="easyui-tabs" data-options="fit:true">   
		      <div title="欢迎" style="padding:20px;">   
		          <span>欢迎你</span>
		      </div>   
		  </div>
      </div>
  </body>
</html>
