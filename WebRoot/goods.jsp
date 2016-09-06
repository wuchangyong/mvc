<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goods.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="view/js/jquery-1.9.1.min.js"></script>
	<style type="text/css">
		.goods{
			width:242px;height:164px;
			background-color:#faebd7;
			float: left;
			margin-left: 10px;
			margin-top: 10px;
		}
		.goods img{
			width:242px;
		}
		.goods p{
			font-size:14px;
			margin-top:0px;
		}
		.goods b{
			color:red;font-style:italic;
		}
		.goods a{
			display: block;float: left;
			width:80px;
			background-color: #df2a4c;
			font-size: 14px;color:#ffffff;
			border-radius:4px;font-weight: bolder;
			margin-left: 30px; text-align: center;
			text-decoration: none;
			padding-top: 5px;padding-bottom: 7px;
			box-shadow:4px 4px gray;
		}
		.goods a:hover{
			opacity:0.7;
		}
		.bg{
			position:absolute;top:0;left:0;
			width: 100%;height: 100%;
			background-color: black;
			opacity:0.6;z-index:200;
			display: none;
		}
		.details{
			width:311px;height:181px;
			background-color: #F0F8FF;
			border-radius:5px;
			margin-left:350px;margin-top:200px;
			position: absolute;z-index:201;
			display: none;
		}
		.details a{
			display: block;float: right;
			width:40px;background-color: #DE2B50;
			text-align: center;text-decoration: none;
			color:#ffffff;font-weight: bolder;
			border-radius:2px;box-shadow:2px 2px gray;
		}
	</style>
	<script type="text/javascript">
		function showDiv(objid){
			$("#bg").show();
			$("#details").show();
			$("#goodsName").text($("#"+objid).text());
		}
		function hideDiv(){
			$("#bg").hide();
			$("#details").hide();
		}
	</script>
  </head>
  
  <body>
  	  <div class="bg" id="bg"></div>
  	  <div class="details" id="details">
  	  	  <a href="javascript:hideDiv();">X</a>
  	  	  <p>商品名称-&gt;<span id="goodsName"></span></p>
  	  </div>
      <div class="goods">
      	  <img alt="" src="view/images/1457420604669510544.jpg">
      	  <p>
      	  	  <span><label id="g1">飞利浦电动剃须刀1</label>&nbsp;&nbsp;售价：<b>188</b>元</span>
      	  	  <br/>
      	  	  <a href="javascript:showDiv('g1');">放入购物车</a>
      	  	  <a href="javascript:showDiv();">立即购买</a>
      	  </p>
      </div>
      <div class="goods">
      	  <img alt="" src="view/images/1457468248674480791.jpg">
      	  <p>
      	  	  <span><label id="g2">飞利浦电动剃须刀2</label>&nbsp;&nbsp;售价：<b>188</b>元</span>
      	  	  <br/>
      	  	  <a href="javascript:showDiv('g2');">放入购物车</a>
      	  	  <a href="javascript:showDiv();">立即购买</a>
      	  </p>
      </div>
      <div class="goods">
      	  <img alt="" src="view/images/1457555161576194341.jpg">
     	  <p>
      	  	  <span><label id="g3">飞利浦电动剃须刀3</label>&nbsp;&nbsp;售价：<b>188</b>元</span>
      	  	  <br/>
      	  	  <a href="javascript:showDiv('g3');">放入购物车</a>
      	  	  <a href="javascript:showDiv();">立即购买</a>
      	  </p>
      </div>
      <div class="goods">
      	  <img alt="" src="view/images/1457587068231173970.jpg">
      	  <p>
      	  	  <span><label id="g4">飞利浦电动剃须刀4</label>&nbsp;&nbsp;售价：<b>188</b>元</span>
      	  	  <br/>
      	  	  <a href="javascript:showDiv('g4');">放入购物车</a>
      	  	  <a href="javascript:showDiv();">立即购买</a>
      	  </p>
      </div>
      <div class="goods">
      	  <img alt="" src="view/images/1457588385552445336.jpg">
      	  <p>
      	  	  <span><label id="g5">飞利浦电动剃须刀5</label>&nbsp;&nbsp;售价：<b>188</b>元</span>
      	  	  <br/>
      	  	  <a href="javascript:showDiv('g5');">放入购物车</a>
      	  	  <a href="javascript:showDiv();">立即购买</a>
      	  </p>
      </div>
      <div class="goods">
      	  <img alt="" src="view/images/1458784359096338581.jpg">
      	  <p>
      	  	  <span><label id="g6">飞利浦电动剃须刀6</label>&nbsp;&nbsp;售价：<b>188</b>元</span>
      	  	  <br/>
      	  	  <a href="javascript:showDiv('g6');">放入购物车</a>
      	  	  <a href="javascript:showDiv();">立即购买</a>
      	  </p>
      </div>
      <div class="goods">
      	  <img alt="" src="view/images/1458871974615020364.jpg">
      	  <p>
      	  	  <span><label id="g7">飞利浦电动剃须刀7</label>&nbsp;&nbsp;售价：<b>188</b>元</span>
      	  	  <br/>
      	  	  <a href="javascript:showDiv('g7');">放入购物车</a>
      	  	  <a href="javascript:showDiv();">立即购买</a>
      	  </p>
      </div>
  </body>
</html>
