<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	body {
	background: url("/ShoppingMall/img/storebg.jpg") no-repeat;
	background-size:cover; 
}
</style>
<title>展示商品</title>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<td>商品名称</td>
			<td>所属店铺</td>
		</tr>
		<c:forEach items="${sessionScope.queryGoods}" var="queryGood">
			<tr>
			<td><a href="/ShoppingMall/store/lookGoodLine.do?good_id=${queryGood.good_id}" style="cursor: pointer;" target="_blank">${queryGood.good_name}</a></td>
			<td>${queryGood.store_name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>