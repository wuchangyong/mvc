<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath",basePath);
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="view/js/jquery-1.9.1.min.js"></script>
	<style type="text/css">
		.bt{
			display: block;
			float: left;
			width: 80px;
			height: 20px;
			background-color:cornflowerblue;
			border-radius: 5px;
			color: #ffffff;text-align:center;
			text-decoration: none;
			margin-left: 10px;
			padding-top: 5px;
			padding-bottom: 8px;
		}
		.bt:hover{
			opacity: 0.7;
			cursor: pointer;
		}
	</style>
	<script type="text/javascript">
		//$(document).ready(function(){});
		$(function(){});
		$(function(){
			//jQuery的事件添加一般都写在页面加载事件之内
			/*
			$(".bt").click(function(){
				alert('你好');
			});
			$(".bt").mouseover(function(){
				alert('jinru');
			});

			//hover事件  其实是输入移进和鼠标移出两个事件综合
			$(".bt").hover(function(){
				alert(1);
			},function(){
				alert(2);
			});
			$(".bt").mouseover(function(){

			}).mouseout(function(){

			});
			
			$(".bt").bind("click",function(){
				alert(1);
			});
			$(".bt").live("click",function(){
				alert(1);
			});
			
			//live方法绑定事件可以为后来用js代码动态生成的标签元素都会有这个事件
			//live方法绑定事件只有jQuery1.9版本以前可以使用，在1.9或1.9版本
			//以后，live方法被on方法取代。
			$(".bt").live("click",function(){
				alert(1);
			});
			
			//#d表示要添加事件的按钮的父级元素，click表示事件类型，.bt表示要添加
			//事件的元素的选择器。
			$("#d").on("click",".bt",function(){
				alert(1);
			});

			$("#d").append("<span class='bt'>测试</span>");
			*/
			//用js代码方式触发某些元素上的某个事件。
			//$(".bt").trigger("click");
			//$(".bt").click();

			
			$(".bt").click(function(){
				/*$.ajax({
					type   : 'GET',
					url    : '${basePath}testAJAX.do',
					data   : {methodName:'testAJAX'},
					dataType:'text',
					success: function(data){
						alert(data);
					}
				});
				$.get('${basePath}testAJAX.do',{methodName:'testAJAX'},function(data){
					alert(data);
				},"text");

				$.getJSON('${basePath}testAJAX.do',{methodName:'testAJAX'},function(data){
					alert(data.address);
				});

				$.post('${basePath}testAJAX.do',{methodName:'testAJAX'},function(data){
					//将json格式的字符串转换为json对象
					//var o = eval("("+data+")");
					alert(data.address);
				},"json");*/

				

				
			});
			
		});
	</script>
  </head>
  
  <body>
  	  <div id="d">
  	  	  <span class='bt'>测试</span>
  	  </div>
  </body>
</html>
