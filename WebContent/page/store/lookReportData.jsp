<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看报表</title>
<style type="text/css">
	body {
	background: url("/ShoppingMall/img/storebg.jpg") no-repeat;
	background-size:cover; 
}
</style>
</head>
<body>
	<table border="1" width="100%">
		<thead>
			<tr>
				<th>用户名</th>
				<th>下单时间</th>
				<th>订单状态</th>
				<th>金额</th>
				<th>支付方式</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.reportData}" var="data">
				<tr>
					<td>${data.user_name}</td>
					<td><span class="amount">${data.order_time }</span></td>
					<td>
					<span> 
					<c:choose>
						<c:when test="${data.order_state=='0'}">待付款</c:when>
						<c:when test="${data.order_state=='1'}">待发货</c:when>
                        <c:when test="${data.order_state=='2'}">待收货</c:when>
                        <c:when test="${data.order_state=='3'}">待评价</c:when>
                        <c:when test="${data.order_state=='4'}">待退款</c:when> 
                        <c:when test="${data.order_state=='Y'}">已完成</c:when>                           		
					</c:choose>
					</span>
					</td>
					<td>${data.order_money}</td>
					<td>
					<span> 
					<c:choose>
						<c:when test="${data.pay_type=='1'}">支付宝支付</c:when>
                        <c:when test="${data.pay_type=='2'}">微信支付</c:when>
                        <c:when test="${data.pay_type=='3'}">货到付款</c:when>
					</c:choose>
					</span>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<td>总计：${requestScope.totalMoney}</td>
		</tfoot>
	</table>
</body>
</html>