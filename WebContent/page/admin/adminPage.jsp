<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员首页</title>
<style type="text/css">
	body {
	background: url("/ShoppingMall/img/adminbg.jpg") no-repeat;
	background-size:cover; 
}
</style>
</head>
<body>
		<center>
			<img alt="用户头像" src="/ShoppingMall/${sessionScope.currvalRole.role_head}">
			<span>${sessionScope.currvalRole.role_name}</span>
		</center>
		<p>
			<a href="/ShoppingMall/index.jsp">回到首页</a>
		</p>
		<p>
			<form action="/ShoppingMall/admin/loginOut.do" method="get">
				<input type="submit" value="退出登录">
			</form>
		</p>
		<p>
			<form action="/ShoppingMall/admin/queryGoodByName.do" method="post" target="_blank">
				<input type="text" placeholder="请输入商品名关键字..." name="good_name">
				<input type="submit" value="搜索商品" style="cursor: pointer">
			</form>
		</p>
		<p>
		<form action="/ShoppingMall/admin/queryRoleById.do" method="post" target="_blank">
			<input type="text" placeholder="请输入角色id..." name="role_id">
			<input type="submit" value="查找">
		</form>
		</p>
		<p>
		<form action="/ShoppingMall/admin/queryRoleByName.do" method="post" target="_blank">
			<input type="text" placeholder="请输入角色名..." name="role_name">
			<input type="submit" value="查找">
		</form>
		</p>
		<p>
		<form action="/ShoppingMall/admin/adminLookGood.do" method="get" target="_blank">
			<input type="submit" value="浏览商品" style="cursor: pointer">
		</form>
		</p>
		<p>
		<form action="/ShoppingMall/admin/adminLookStore.do" method="get" target="_blank">
			<input type="submit" value="浏览店铺" style="cursor: pointer">
		</form>
		</p>
		<p>
		<form action="/ShoppingMall/admin/lookApplyStore.do" method="get" target="_blank">
			<input type="submit" value="查看申请开店" style="cursor: pointer">
		</form>
		</p>
		
</body>
</html>