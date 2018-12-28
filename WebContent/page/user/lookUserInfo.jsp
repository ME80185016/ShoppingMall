<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
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
			<td>用户名</td>
			<td>密码</td>
			<td>头像</td>
			<td>电话</td>
		</tr>
		<tr>
			<form action="/ShoppingMall/user/updateUserInfo.do" method="post">
				<td><input name="role_name" value="${sessionScope.currvalRole.role_name}"/></td>
				<td><input name="role_pwd"/ value="${sessionScope.currvalRole.role_pwd}"></td>
				<td><img alt="头像" src="../../${sessionScope.currvalRole.role_head}" /></td>
				<input name="role_head" value="${sessionScope.currvalRole.role_head}" hidden="hidden"}"/>
				<input name="role_id" value="${sessionScope.currvalRole.role_id}" hidden="hidden"}"/>
				<td><input name="role_tel" value="${sessionScope.currvalRole.role_tel}"/></td>
				<td><input type="submit" value="确认修改"/></td>
			</form>		
		</tr>
	</table>
</body>
</html>