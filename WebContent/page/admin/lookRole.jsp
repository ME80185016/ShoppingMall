<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示角色</title>
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
			<td>角色名称</td>
			<td>角色类型</td>
			<td>联系方式</td>
		</tr>
			<tr>
			<td>
				<c:choose>
					<c:when test="${requestScope.role.role_type=='1'}">
						<a href="/ShoppingMall/admin/adminLookStoreLine.do?store_id=${requestScope.role.role_id}" target="_blank">${requestScope.role.role_name}</a>
					</c:when>
					<c:when test="${requestScope.role.role_type=='2'}">
						${requestScope.role.role_name}
					</c:when>
				</c:choose>
			</td>
			<td>
				<c:choose>
					<c:when test="${requestScope.role.role_type=='1'}">
						类型：店铺
					</c:when>
					<c:when test="${requestScope.role.role_type=='2'}">
						类型：用户
					</c:when>
				</c:choose>
			</td>
			<td>${requestScope.role.role_tel}</td>
			</tr>
			<tr>
				<c:choose>
					<c:when test="${requestScope.role.role_type=='1'}">
						<form action="/ShoppingMall/admin/adminLookStoreLine.do" method="get">
							<input name="store_id" value="${requestScope.role.role_id}" hidden="hidden">
							<input type="submit" value="查看店铺详细信息">
						</form>
					</c:when>
					<c:when test="${requestScope.role.role_type=='2'}">
						<form action="/ShoppingMall/admin/deleteRoleById.do" method="get">
							<input name="role_id" value="${requestScope.role.role_id}" hidden="hidden">
							<input type="submit" value="删除此用户">
						</form>
					</c:when>
				</c:choose>	
			</tr>
	</table>
</body>
</html>