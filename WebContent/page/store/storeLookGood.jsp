<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示商品</title>
<style type="text/css">
	body {
	background: url("/ShoppingMall/img/storebg.jpg") no-repeat;
	background-size:cover; 
}
</style>
</head>
<body>
	<table border="1" width="100%">
		<c:forEach items="${sessionScope.goodinfos}" var="goodinfo" varStatus="status">
		<c:if test="${(status.index+1) % 2 == 1}">
			<tr>
		</c:if>
			<td><a href="/ShoppingMall/store/lookGoodline.do?good_id=${goodinfo.good.good_id}" style="cursor: pointer;" target="_blank"><img alt="商品图片" src="../${goodinfo.goodImage.image_route }"/><p>${goodinfo.good.good_name}</p></a></td>
		<c:if test="${(status.index+1) % 2 == 0}">
			</tr>
		</c:if>		
		</c:forEach>
		<tr>
			<td><a href="/ShoppingMall/store/storeLookGoodBack.do" disable="disable">上一页</a></td>
			<td><form action="/ShoppingMall/store/storeLookGoodJump.do" method="get">
					<input name="jumpPage" placeholder="输入要跳转的页数"/><input type="submit" value="跳转"/>
					<span>共${sessionScope.pageCount}页</span>
				</form>
			</td>
			<td><a href="/ShoppingMall/store/storeLookGoodNext.do">下一页</a></td>
		</tr>
	</table>
</body>
</html>