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
  		$('#win').window('close');  // close a window 
  		$('#dg').datagrid({    
  		    url:'showEmps.user?methodName=showEmps&pageNo=1&pageSize=10',
  		    frozenColumns:[[{field:'hhhh',checkbox:true}]],
  		    rownumbers:true,
  		    striped:true,
  		    pagination:true,
  		    columns:[[    
  		        {field:'eid',hidden:true},    
  		        {field:'ename',title:'员工姓名',width:100,align:'center'},    
  		        {field:'jobName',title:'职位',width:100,align:'center'},
  		        {field:'managerName',title:'直属领导',width:100,align:'center'},
  		    	{field:'hireDate',title:'入职日期',width:100,align:'center'},
  		  	    {field:'salary',title:'工资',width:100,align:'center'},
	  		  	{field:'comm',title:'津贴',width:100,align:'center'},
	  		  	{field:'deptName',title:'所属部门',width:100,align:'center'}    
  		    ]],
	  		toolbar: "#bar"
	  	  		    
  		});
  		var pager = $('#dg').datagrid("getPager");
  		pager.pagination({
  			onSelectPage:function(pageNumber, pageSize){
  				refreshData(pageNumber, pageSize);
  			}
  		});

  		//搜索和新增员工时下拉列表准备数据
  		$("#searchJob").combobox({
			url:'loadAllJob.user?methodName=loadAllJob',
			textField:'jname',
			valueField:'jid',
			value:'-1'
  	  	});
  		$("#searchDept").combobox({
			url:'loadAllDept.user?methodName=loadAllDept',
			textField:'deptName',
			valueField:'deptid',
			value:'-1'
  	  	});
  	});
  	//刷新表格数据
  	function refreshData(pageNo, pageSize){
  		$('#dg').datagrid('loading');
		$.post("showEmps.user",{
			methodName:'showEmps',
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
  	//组合条件搜索
  	function search(){
		$.post("showEmps.user",{
			methodName :'showEmps',
			pageNo     :1,
			pageSize   :10,
			searchName :$("#searchName").val(),
			searchJob  :$("#searchJob").combo("getValue"),
			searchDept :$("#searchDept").combo("getValue")
		},function(data){
			$('#dg').datagrid('loading');
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
      
      <div id="bar">
      	  <form id="searchForm">
      	  	  <table>
      	  	  	  <tr>
      	  	  	  	  <td><label>姓名：</label></td>
      	  	  	  	  <td><input type="text" id="searchName" style="width:150px;"/></td>
      	  	  	  	  <td><label>职位：</label></td>
      	  	  	  	  <td><select id="searchJob" style="width:150px;"></select></td>
      	  	  	  	  <td><label>部门：</label></td>
      	  	  	  	  <td><select id="searchDept" style="width:150px;"></select></td>
      	  	  	  </tr>
      	  	  	  <tr>
      	  	  	  	 <td colspan="6">
      	  	  	  	     <a href="" class="easyui-linkbutton" data-options="iconCls:'icon-add2'">添加</a>
      	  	  	  	     <a href="" class="easyui-linkbutton" data-options="iconCls:'icon-modify'">修改</a>
      	  	  	  	     <a href="" class="easyui-linkbutton" data-options="iconCls:'icon-delete'">删除</a>
      	  	  	  	     <a href="" class="easyui-linkbutton" data-options="iconCls:'icon-refresh'">刷新</a>
      	  	  	  	     <a href="javascript:search();" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
      	  	  	  	 </td> 
      	  	  	  </tr>
      	  	  </table>
      	  </form>
      </div>
      
      
      
      
      
      <div id="win" class="easyui-window" title="新增菜单" style="width:400px;height:300px;top:50px;" data-options="iconCls:'icon-add2',modal:true,collapsible:false,minimizable:false,maximizable:false,resizable:false">  
          <form id="ff">
          	  <table>
	      	  	  <tr>
	      	  	  	  <td class="labelTD"><label for="name">菜单名称：</label></td>
	      	  	  	  <td><input type="text" name="name" id="name" class="easyui-validatebox in" required /></td>
	      	  	  </tr>
	      	  	  <tr>
	      	  	  	  <td class="labelTD"><label for="url">菜单URL：</label></td>
	      	  	  	  <td><input type="text" name="url" id="url" class="easyui-validatebox in" required/></td>
	      	  	  </tr>
	      	  	  <tr>
	      	  	  	  <td class="labelTD"><label>是否展示：</label></td>
	      	  	  	  <td>
	      	  	  	  	  <input type="radio" name="isshow" value="1"/>展示
	      	  	  	  	  <input type="radio" name="isshow" value="0"/>不展示
	      	  	  	  </td>
	      	  	  </tr>
	      	  	  <tr>
	      	  	  	  <td class="labelTD"><label for="parentid">父级菜单：</label></td>
	      	  	  	  <td>
	      	  	  	  	  <select name="parentid" id="parentid" class="easyui-combobox in" style="width:205px;"></select>
	      	  	  	  </td>
	      	  	  </tr>
	      	  	  <tr>
	      	  	  	  <td colspan="2" style="text-align:center;">
	      	  	  	  	  <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add2'">添加菜单</a>
	      	  	  	  </td>
	      	  	  </tr>
	      	  </table>
          </form> 
	  </div>
  </body>
</html>
