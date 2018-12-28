<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>店铺首页</title>
<style type="text/css">
	body {
	background: url("/ShoppingMall/img/storebg.jpg") no-repeat;
	background-size:cover; 
}
</style>
</head>
<body>
		
	<center>
		<img alt="店铺头像" src="/ShoppingMall/${sessionScope.currvalRole.role_head}">
		<span>${sessionScope.currvalRole.role_name}</span>
	</center>
	<p>
		<a href="/ShoppingMall/index.jsp">回到首页</a>
	</p>
	<p>
		<form action="/ShoppingMall/store/loginOut.do" method="get">
			<input type="submit" value="退出登录">
		</form>
	</p>
	<p>
		<form action="/ShoppingMall/store/queryGoodByName.do" method="post" target="_blank">
			<input type="text" placeholder="请输入自家商品名关键字..." name="good_name">
			<input type="submit" value="搜索商品" style="cursor: pointer">
		</form>
	</p>
	<p>
		<form action="/ShoppingMall/store/storeLookGood.do" method="get" target="_blank">
			<input type="submit" value="浏览自家商品" style="cursor: pointer">
		</form>
	</p>
	<p>
		<form action="/ShoppingMall/store/storeLookOrder.do" method="post" target="_blank">
			<input type="submit" value="查看订单" style="cursor: pointer">
		</form>
	</p>
	<p>
		<form action="/ShoppingMall/store/storeLookWaitDeliver.do" method="post" target="_blank">
			<input type="submit" value="查看待发货订单" style="cursor: pointer">
		</form>
	</p>
	<p>
		<form action="/ShoppingMall/store/storeLookWaitReceipt.do" method="post" target="_blank">
			<input type="submit" value="查看待收货订单" style="cursor: pointer">
		</form>
	</p>
	<p>
		<form action="/ShoppingMall/store/storeLookWaitAssess.do" method="post" target="_blank">
			<input type="submit" value="查看待评价订单" style="cursor: pointer">
		</form>
	</p>
	<p>
		<form action="/ShoppingMall/store/storeLookWaitBackMoney.do" method="post" target="_blank">
			<input type="submit" value="查看待退款订单" style="cursor: pointer">
		</form>
	</p>
	<p>
		<form action="/ShoppingMall/store/storeLookBackMoney.do" method="post" target="_blank">
			<input type="submit" value="查看已退款订单" style="cursor: pointer">
		</form>
	</p>
	<p>
		<form action="/ShoppingMall/store/storeLookOverOrder.do" method="post" target="_blank">
			<input type="submit" value="查看已完成订单" style="cursor: pointer">
		</form>
	</p>
	<p>
		<form action="/ShoppingMall/store/lookStoreInfo.do" method="get">
			<input type="submit" value="查看信息">
		</form>
	</p>
	<p>
	<a href="/ShoppingMall/addGood.jsp" target="_blank">上架商品</a>
	</p>
	<p>
	<a href="/ShoppingMall/page/store/queryReportData.jsp" target="_blank" cousor="pointer">查看报表</a>
	</p>
	<p>
		<a href="/ShoppingMall/page/store/storeAddAddress.jsp" style="cursor: pointer" target="_blank">添加地址</a>
	</p>
</body>
</html>