<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收藏商品</title>
<style type="text/css">
	body {
		background: url("/ShoppingMall/img/userbg.jpg") no-repeat;
		background-size:cover;	
	}
</style>
</head>
<body>
	<table border="1" width="100%">
		<c:forEach items="${collectGoods}" var="collectGood">
			<tr>
			<td><a href="/ShoppingMall/user/lookGoodLine.do?good_id=${collectGood.good_id}">
			<img alt="商品图片" src="../${collectGood.image_route}">
			</a>
			</td>
			<td><a href="/ShoppingMall/user/lookGoodLine.do?good_id=${collectGood.good_id}">
				${collectGood.good_name}
			</a>
			</td>
			<td>
				<form action="/ShoppingMall/user/deleteCollectGood.do" method="get">
					<input name="collect_id" value="${collectGood.collect_id}" hidden="hidden">
					<input type="submit" value="删除此收藏">
				</form>
			</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>