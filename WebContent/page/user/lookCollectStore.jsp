<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收藏店铺</title>
<style type="text/css">
	body {
		background: url("/ShoppingMall/img/userbg.jpg") no-repeat;
		background-size:cover;	
	}
</style>
</head>
<body>
	<table border="1" width="100%">
		<c:forEach items="${requestScope.collectStores}" var="collectStore">
			<tr>
			<td>
			<a href="/ShoppingMall/user/userLookStoreLine.do?store_id=${collectStore.store_id}">
			<p>${collectStore.store_name}</p>
			</a>
			</td>
			<td>
				<form action="/ShoppingMall/user/deleteCollectStore.do" method="get">
					<input name="collect_id" value="${collectStore.collect_id}" hidden="hidden">
					<input type="submit" value="删除此收藏">
				</form>
			</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>