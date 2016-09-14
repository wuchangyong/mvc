<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showUsers.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="<%=basePath%>easyui/themes/default/easyui.css"/>
	<link type="text/css" rel="stylesheet" href="<%=basePath%>easyui/themes/icon.css"/>
	<script type="text/javascript" src="<%=basePath%>easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>easyui/locale/easyui-lang-zh_CN.js"></script>
  	<style type="text/css">
  	#ff table{
  		width:100%;margin:auto;
  	}
  	#ff .labelTD{
  		text-align: right;
  		font-size: 14px;
  	}
  	#ff .in{width:200px;}
  	</style>
  	<script type="text/javascript">
  	$(function(){
  		//$('#win').window('close');  // close a window 
  		$('#dg').datagrid({    
  		    url:'showUsers.user?methodName=showUsers',
  		    frozenColumns:[[{field:'hhhh',checkbox:true}]],
  		    rownumbers:true,
  		    striped:true,
  		    pagination:true,
  		    columns:[[    
  		        {field:'uid',hidden:true},    
  		        {field:'userName',title:'用户名',width:100,align:'center'},    
  		        {field:'sex',title:'性别',width:100,align:'center'},
  		        {field:'email',title:'邮箱',width:100,align:'center'},
  		    	{field:'education',title:'学历',width:100,align:'center'},
  		  	    {field:'hobbys',title:'爱好',width:100,align:'center'},
	  		  	{field:'description',title:'简介',width:100,align:'center'},
	  		  	{field:'avatar',title:'头像图片地址',width:100,align:'center'}    
  		    ]],
	  		toolbar: [{
				text:'导出为Excel报表',
				iconCls:'icon-export',
				handler:function(){
					window.location.href = "<%=basePath%>exportReport.user?methodName=exportReport";
				}
		  	}]
	  	  		    
  		});
  		var pager = $('#dg').datagrid("getPager");
  		pager.pagination({
  			onSelectPage:function(pageNumber, pageSize){
  				refreshData(pageNumber, pageSize);
  			}
  		});

  	});
  	//刷新表格数据
  	function refreshData(pageNo, pageSize){
  		$('#dg').datagrid('loading');
		$.post("showUsers.user",{
			methodName:'showUsers',
			pageNo:pageNo,
			pageSize:pageSize
		},function(data){
			$("#dg").datagrid("loadData",{
				rows:data.rows,
				total:data.total
			});
			$('#dg').datagrid('loaded');
  		},"json");
		
  	}
  	</script>
  </head>
  
  <body>
      <table id="dg"></table>
  </body>
</html>
