<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看评价</title>
<style type="text/css">
	body {
		background: url("/ShoppingMall/img/userbg.jpg") no-repeat;
		background-size:cover;	
	}
</style>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<td>商品</td>
			<td>评价人</td>
			<td>评价时间</td>
			<td>评价内容</td>
		</tr>
		<c:forEach items="${requestScope.goodAssesses}" var="goodAssess">
			<tr>
			<td><a href="/ShoppingMall/user/lookGoodLine.do?good_id=${goodAssess.good_id}" style="cursor: pointer;" target="_blank"><img alt="商品图片" src="../${goodAssess.image_route }"/><p>${goodAssess.good_name}</p></a></td>
			<td>${goodAssess.user_name}</td>
			<td>${goodAssess.assess_time}</td>
			<td>${goodAssess.assess_content}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>