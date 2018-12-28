<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户首页</title>
<style type="text/css">
	body {
		background: url("/ShoppingMall/img/userbg.jpg") no-repeat;
		background-size:cover;	
	}
</style>
</head>
<body>
		<center>
			<img alt="用户头像" src="/ShoppingMall/${sessionScope.currvalRole.role_head}">
			<span>${sessionScope.currvalRole.role_name}</span>
		</center>
		<p>
			<a href="/ShoppingMall/index.jsp">回到首页</a>
		</p>
		<p>
		<form action="/ShoppingMall/user/loginOut.do" method="get">
			<input type="submit" value="退出登录">
		</form>
		</p>
		<p>
			<form action="/ShoppingMall/user/queryGoodByName.do" method="post" target="_blank">
				<input type="text" placeholder="请输入商品名关键字..." name="good_name">
				<input type="submit" value="搜索商品" style="cursor: pointer">
			</form>
		</p>
		<p>
		<form action="/ShoppingMall/user/userLookGood.do" method="get" target="_blank">
			<input type="submit" value="浏览商品" style="cursor: pointer">
		</form>
		</p>
		<p>
		<form action="/ShoppingMall/user/userLookStore.do" method="get" target="_blank">
			<input type="submit" value="浏览店铺" style="cursor: pointer">
		</form>
		</p>
		<p>
		<form action="/ShoppingMall/user/userLookOrder.do" method="post" target="_blank">
			<input type="submit" value="查看订单" style="cursor: pointer">
		</form>
		</p>
		<p>
		<form action="/ShoppingMall/user/userLookShoppingCar.do" method="post" target="_blank">
			<input type="submit" value="我的购物车" style="cursor: pointer">
		</form>
		</p>
		<p>
		<form action="/ShoppingMall/user/userLookWaitDeliver.do" method="post" target="_blank">
			<input type="submit" value="我的待发货" style="cursor: pointer">
		</form>
		</p>
		<p>
		<form action="/ShoppingMall/user/userLookWaitReceipt.do" method="post" target="_blank">
			<input type="submit" value="我的待收货" style="cursor: pointer">
		</form>
		</p>
		<p>
		<form action="/ShoppingMall/user/userLookWaitAssess.do" method="post" target="_blank">
			<input type="submit" value="我的待评价" style="cursor: pointer">
		</form>
		</p>
		<p>
		<form action="/ShoppingMall/user/userLookWaitBackMoney.do" method="post" target="_blank">
			<input type="submit" value="我的待退款" style="cursor: pointer">
		</form>
		</p>
		<p>
		<form action="/ShoppingMall/user/userLookBackMoney.do" method="post" target="_blank">
			<input type="submit" value="我的已退款" style="cursor: pointer">
		</form>
		</p>
		<p>
		<form action="/ShoppingMall/user/userLookOverOrder.do" method="post" target="_blank">
			<input type="submit" value="我的已完成" style="cursor: pointer">
		</form>
		</p>
		<p>
		<form action="/ShoppingMall/user/userLookGoodAssess.do" method="post" target="_blank">
			<input type="submit" value="我的评价" style="cursor: pointer">
		</form>
		</p>
		<p>
		<form action="/ShoppingMall/user/userLookCollectGood.do" method="post" target="_blank">
			<input type="submit" value="收藏商品" style="cursor: pointer">
		</form>
		</p>
		<p>
		<form action="/ShoppingMall/user/userLookCollectStore.do" method="post" target="_blank">
			<input type="submit" value="收藏店铺" style="cursor: pointer">
		</form>
		</p>
		<p>
		<form action="/ShoppingMall/user/deleteUser.do" method="post">
			<input type="submit" value="清除账号" style="cursor: pointer">
		</form>
		</p>
		<p>
		<a href="/ShoppingMall/page/user/lookUserInfo.jsp" style="cursor: pointer" target="_blank">查看信息</a>
		</p>
		<p>
		<a href="/ShoppingMall/page/user/userAddAddress.jsp" style="cursor: pointer" target="_blank">添加地址</a>
		</p>
</body>
</html>