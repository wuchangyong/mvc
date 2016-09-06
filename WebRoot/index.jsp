<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<script type="text/javascript" src="view/js/jquery-1.9.1.min.js"></script>
	<style type="text/css">
		.bt{
			display: block;
			float: left;
			width: 80px;
			height: 20px;
			background-color:cornflowerblue;
			border-radius: 5px;
			color: #ffffff;
			text-decoration: none;
			margin-left: 10px;
			padding-top: 5px;
			padding-bottom: 8px;
		}
		.bt:hover{
			opacity: 0.7;
			cursor: pointer;
		}
		.in{
			width: 200px;
			height: 25px;
			border: 1px solid #6495ED;
			border-radius: 3px;
		}
		.in:hover{
			border: 1px solid aquamarine;
			box-shadow: 1px 1px 1px 1px aquamarine;
		}
		.errorMsg{
			color: red;
			font-weight: bolder;
			font-size: 12px;
		}
	</style>
	<script type="text/javascript">
		function sub(){
			//var d = $('#d');//document.getElementById("d")
			//var ds = $('div');//document.getElementsByTagName("div")
			//var dds = $('.dd');//document.getElementsByClassName("dd");
			//alert(ds.length);
			//ds.css({"width":"200px","height":"200px","background-color":"red"});
			//var v = $("#un").val();
			//var sex = $("input[name='sex']:checked").val();
			var hobbys = $("input[name='hobby']:checked");
			var hs = new Array();
			hobbys.each(function(){
				hs.push($(this).val());
			});
			hs = hs.join(",");
	
			var sp = $("#un").parent().parent().find(".errorMsg").eq(0);
		}
		function aaa(bol){
			if(bol){
				$("#d").fadeIn("slow");//.slideDown(2000);//.show(3000);
			}else{
				$("#d").fadeOut("slow");//.slideUp(2000);//.hide(3000);
			}
		}
	</script>
  </head>
  
  <body>
  	  <input type="button" value="显示" onclick="aaa(true);">
  	  <input type="button" value="隐藏" onclick="aaa(false);">
  	  <div id="d" style="width:200px;height:200px;background-color:red;"></div>
      <form action="">
      	  <input type="hidden" id="aaa" name="aaa" value="123" />
			<table>
				<tr>
					<td><label>帐号：</label></td>
					<td>
						<input type="text" name="userName" placeholder="请输入帐号" class="in aaa" id="un" 
							onblur="inBlur(this,/^[a-zA-Z]{1}\w{5,11}$/,'userNameError',0);"/>
					</td>
					<td><span class="errorMsg" id="userNameError"></span></td>
				</tr>
				<tr>
					<td><label>密码：</label></td>
					<td>
						<input type="password" name="userPass" placeholder="请输入密码" class="in" id="up" 
							onblur="inBlur(this,/^[\w\W]{6,12}$/,'userPassError',1);"/>
					</td>
					<td><span class="errorMsg" id="userPassError"></span></td>
				</tr>
				<tr>
					<td><label>手机：</label></td>
					<td>
						<input type="text" name="phone" placeholder="请输入手机号" class="in" id="phone" 
							onblur="inBlur(this,/^1(3|4|5|7|8)\d{9}$/,'phoneError',2);"/>
					</td>
					<td><span class="errorMsg" id="phoneError"></span></td>
				</tr>
				<tr>
					<td><label>性别：</label></td>
					<td>
						<input type="radio" name="sex" value="1" checked />男
						<input type="radio" name="sex" value="2"/>女
					</td>
					<td></td>
				</tr>
				<tr>
					<td><label>爱好：</label></td>
					<td>
						<input type="checkbox" name="hobby" value="1"/>体育
						<input type="checkbox" name="hobby" value="2"/>音乐
						<input type="checkbox" name="hobby" value="3"/>旅游
						<input type="checkbox" name="hobby" value="4"/>电影
					</td>
					<td></td>
				</tr>
				<tr>
					<td><label>学历：</label></td>
					<td>
						<select name="education" id="education" class="in" style="width: 205px;height: 30px;">
							<option value="-1">请选择学历</option>
							<option value="0">幼儿班</option>
							<option value="1">小学未毕业</option>
							<option value="2">初中辍学</option>
							<option value="3">高中</option>
							<option value="4">大砖</option>
							<option value="5">笨科</option>
							<option value="6">研究僧</option>
						</select>
					</td>
					<td></td>
				</tr>
				<tr>
					<td><label>简介：</label></td>
					<td>
						<textarea name="description" id="description" class="in" style="height:80px;"></textarea>
					</td>
					<td></td>
				</tr>
				<tr>
					<td colspan="3" style="text-align: center;">
						<span onclick="sub();" class="bt">注册</span>
						<span onclick="res();" class="bt">重置</span>
					</td>
				</tr>
	  	  </table>
      </form>
  </body>
</html>
