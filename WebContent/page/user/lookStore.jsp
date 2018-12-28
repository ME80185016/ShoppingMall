<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示店铺</title>
<style type="text/css">
	body {
		background: url("/ShoppingMall/img/userbg.jpg") no-repeat;
		background-size:cover;	
	}
</style>
</head>
<body>
	<table border="1" width="100%">
		<c:forEach items="${sessionScope.storeinfos}" var="storeinfo" varStatus="status">
		<c:if test="${(status.index+1) % 2 == 1}">
			<tr>
		</c:if>
			<%-- <td>${storeinfo.store_image}</td>
			<td>${storeinfo.store_name }</td> --%>
			<td><a href="/ShoppingMall/user/userLookStoreLine.do?store_id=${storeinfo.store_id}" style="cursor: pointer;" target="_blank"><img alt="店铺图片" src="/ShoppingMall/${storeinfo.store_image }"/><p>${storeinfo.store_name}</p></a></td>
		<c:if test="${(status.index+1) % 2 == 0}">
			</tr>
		</c:if>		
		</c:forEach>
		<tr>
			<td><a href="/ShoppingMall/user/userLookStoreBack.do" disable="disable">上一页</a></td>
			<td><form action="/ShoppingMall/user/userLookStoreJump.do" method="get">
					<input name="jumpPage" placeholder="输入要跳转的页数"/><input type="submit" value="跳转"/>
					<span>共${sessionScope.storePageCount}页</span>
				</form>
			</td>
			<td><a href="/ShoppingMall/user/userLookStoreNext.do">下一页</a></td>
		</tr>
	</table>
</body>
</html>