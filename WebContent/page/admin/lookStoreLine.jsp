<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>店铺详情</title>
<style type="text/css">
	body {
	background: url("/ShoppingMall/img/adminbg.jpg") no-repeat;
	background-size:cover; 
}
</style>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<td>店铺名</td>
			<td>联系人</td>
			<td>联系电话</td>
			<td>店铺状态</td>
			<td>店铺地址</td>
			<td>店铺照片</td>
			<td>联系人照片</td>
			<td>营业执照</td>
		</tr>
		<tr>
			<td>${requestScope.storeinfo.store_name}</td>
			<td>${requestScope.storeinfo.linkman_name}</td>
			<td>${requestScope.store.role_tel}</td>
			<td>
			<c:choose>
				<c:when test="${requestScope.storeinfo.store_state=='0'}">
					待审核
				</c:when>
				<c:when test="${requestScope.storeinfo.store_state=='1'}">
					营业中
				</c:when>
				<c:when test="${requestScope.storeinfo.store_state=='2'}">
					已打烊
				</c:when>
			</c:choose>
			</td>
			<td>
				<c:forEach items="${requestScope.storeAddresses}" var="storeAddress">
					${storeAddress.address_name }
				</c:forEach>
			</td>
			<td><img alt="店铺照片" src="/ShoppingMall/${requestScope.storeinfo.store_image}"></td>
			<td><img alt="联系人照片" src="/ShoppingMall/${requestScope.storeinfo.store_men_image}"/></td>
			<td><img alt="营业执照" src="/ShoppingMall/${requestScope.storeinfo.store_license}"></td>
		</tr>
		<tr>
			<td>
			<c:choose>
				<c:when test="${requestScope.storeinfo.store_state=='0'}">
					<form action="/ShoppingMall/admin/updateStoreState.do" method="get">
						<input name="store_state" value="2" hidden="hidden">
						<input name="store_id" value="${requestScope.store.role_id}" hidden="hidden">
						<input type="submit" value="同意开店">
					</form>
					<form action="/ShoppingMall/admin/refuseOpenStore.do" method="get">
						<input name="role_id" value="${requestScope.store.role_id}" hidden="hidden">
						<input type="submit" value="拒绝开店">
					</form>
				</c:when>
				<c:when test="${requestScope.storeinfo.store_state=='1'}">
					<form action="/ShoppingMall/admin/updateStoreState.do" method="get">
						<input name="store_state" value="0" hidden="hidden">
						<input name="store_id" value="${requestScope.store.role_id}" hidden="hidden">
						<input type="submit" value="强制关停">
					</form>
					<form action="/ShoppingMall/admin/updateStoreState.do" method="get">
						<input name="store_state" value="2" hidden="hidden">
						<input name="store_id" value="${requestScope.store.role_id}" hidden="hidden">
						<input type="submit" value="强制打烊">
					</form>
				</c:when>
				<c:when test="${requestScope.storeinfo.store_state=='2'}">
					<form action="/ShoppingMall/admin/updateStoreState.do" method="get">
						<input name="store_state" value="0" hidden="hidden">
						<input name="store_id" value="${requestScope.store.role_id}" hidden="hidden">
						<input type="submit" value="强制关停">
					</form>
					<form action="/ShoppingMall/admin/updateStoreState.do" method="get">
						<input name="store_state" value="1" hidden="hidden">
						<input name="store_id" value="${requestScope.store.role_id}" hidden="hidden">
						<input type="submit" value="强制营业">
					</form>
				</c:when>
			</c:choose>
			</td>
		</tr>
		<c:forEach items="${goodinfos}" var="goodinfo" varStatus="status">
		<c:if test="${(status.index+1) % 2 == 1}">
			<tr>
		</c:if>
			<td colspan="5"><a href="/ShoppingMall/admin/lookGoodLine.do?good_id=${goodinfo.good.good_id}" style="cursor: pointer;" target="_blank"><img alt="商品图片" src="/ShoppingMall/${goodinfo.goodImage.image_route }"/><p>${goodinfo.good.good_name}</p></a></td>
		<c:if test="${(status.index+1) % 2 == 0}">
			</tr>
		</c:if>		
		</c:forEach>
		
	</table>
</body>
</html>