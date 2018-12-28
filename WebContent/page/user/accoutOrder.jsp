<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户付款</title>
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
				<td>
					<form action="/ShoppingMall/user/accountShoppingCar.do" method="post" id="buyGoodAction">
						<input name="order_id" value="${sessionScope.lookOrderLine.order_id}" hidden="hidden">
						<input name="good_price" value="${sessionScope.lookOrderLine.good_price}" hidden="hidden">
						<input name="good_num" value="${sessionScope.lookOrderLine.good_num}" hidden="hidden">
						<input name="good_name" value="${sessionScope.lookOrderLine.good_name}" hidden="hidden">
						<h3>请选择支付方式</h3>
						<label><input name="pay_type" type="radio" value="1" checked="checked">支付宝支付</label>
						<label><input name="pay_type" type="radio" value="2">微信支付</label>
						<label><input name="pay_type" type="radio" value="3">货到付款</label>
						<h3>请选择要邮寄的地址</h3>
						<select name="address_id" id="address_id">
							<option value="">请选择</option>
							<c:forEach items="${sessionScope.userAddresses}" var="address">
								<option value="${address.address_id}">${address.address_name}</option>
							</c:forEach>
						</select>
						<input type="button" value="确认购买" onclick="funone()">
					</form>
				</td>
			</tr>
	</table>
	
<script type="text/javascript">
function funone(){
	var address=document.getElementById("address_id");
	var index=address.selectedIndex;
	var value=address.options[index].value;
	if(value==""||value==null){
		alert("请选择配送地址");
	}else{
		document.getElementById("buyGoodAction").submit();
	}
}
	
</script>    
</body>
</html>