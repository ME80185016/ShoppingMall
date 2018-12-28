<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户添加地址</title>
<style type="text/css">
	body {
		background: url("/ShoppingMall/img/userbg.jpg") no-repeat;
		background-size:cover;	
	}
</style>
</head>
<body>
	<div style="margin-left: 30px; margin-top: 30px">
		<form action="/ShoppingMall/user/addUserAddress.do" method="post" enctype="application/x-www-form-urlencoded">

			<h3>添加地址</h3>
			<p>
				地址描述：<textarea rows="3" cols="100" name="address_name"></textarea>
			</p>
			<p>
				邮政编码(不清楚请填000000)：<input name="address_code">
			</p>
			<p>
				联系人姓名：<input name="linkman_name">
			</p>
			<p>
				联系人电话：<input name="linkman_tel">
			</p>
			
			<p>
				<input type="submit" value="添加地址">
			</p>
		</form>
	</div>
</body>
</html>