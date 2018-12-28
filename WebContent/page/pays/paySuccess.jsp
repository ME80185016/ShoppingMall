<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付成功</title>
<style type="text/css">
	body {
		background: url("/ShoppingMall/img/userbg.jpg") no-repeat;
		background-size:cover;	
	}
</style>
</head>
<body>
	<center>
		<c:choose>
			<c:when test="${sessionScope.currvalOrder.pay_type=='1'}">
				<h2>恭喜，您已支付成功,支付方式为：支付宝支付</h2>
			</c:when>
			<c:when test="${sessionScope.currvalOrder.pay_type=='2'}">
				<h2>恭喜，您已支付成功,支付方式为：微信支付</h2>
			</c:when>
			<c:when test="${sessionScope.currvalOrder.pay_type=='3'}">
				<h2>恭喜，订单已下单，支付方式为：货到付款</h2>
			</c:when>
		</c:choose>
		
		<p>
		<h3><a href="/ShoppingMall/index.jsp">返回商城首页</a></h3>
		</p>
		<p>
		<h3><a href="/ShoppingMall/page/user/userPage.jsp">返回用户首页</a></h3>
		</p>
	</center>
</body>
</html>