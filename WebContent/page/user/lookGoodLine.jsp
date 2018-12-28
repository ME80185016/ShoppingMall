<%@page import="com.hds.entity.StoreInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
<style type="text/css">
	body {
		background: url("/ShoppingMall/img/userbg.jpg") no-repeat;
		background-size:cover;	
	}
</style>
<script type="text/javascript">
	 window.onload=function(){
		document.getElementById("buyNow").onclick=function(){
			window.location.href="/ShoppingMall/page/user/userPay.jsp";
		}
		var state=${sessionScope.storeInfo.store_state};
		if(state=='1'){
			document.getElementById("buyNow").disabled="";
		}else if(state=='0'){
			document.getElementById("addShoppingCar").disabled="disabled";
			document.getElementById("collectGood").disabled="disabled";
		}
	} 
</script>
</head>
<body>
	<%StoreInfo storeinfo=(StoreInfo)session.getAttribute("storeInfo"); %>
	<table border="1" width="100%">
			<th style="fontsize:20px;color:red" colspan="5">${sessionScope.goodinfo.good.good_name}</th>
			<tr>
			<td rowspan="3"><img alt="商品图片" src="../${sessionScope.goodinfo.goodImage.image_route }"/></td>
			<td>商品价格<p>${sessionScope.goodinfo.goodPrice.price_num}</p></td>
			<td>商品总量<p>${sessionScope.goodinfo.goodProperties.good_total}</p></td>
			<td>商品销量<p>${sessionScope.goodinfo.goodSale.sale_num}</p></td>
			<td>商品余量<p>${sessionScope.goodinfo.goodMargin.margin_num}</p></td>
			</tr>
			<tr>
				<td>商品颜色<p>${sessionScope.goodinfo.goodProperties.color_name}</p></td>
				<td>商品大小<p>${sessionScope.goodinfo.goodProperties.size_name}</p></td>
				<td>适用人群<p>${sessionScope.goodinfo.goodProperties.good_age}</p></td>
				<td>上下衣<p>${sessionScope.goodinfo.goodProperties.good_topOrDown}</p></td>
			</tr>
			<tr>
				<td>服装季节<p>${sessionScope.goodinfo.goodProperties.good_season}</p></td>
				<td>服装类型<p>${sessionScope.goodinfo.goodProperties.good_type}</p></td>
				<td>男装女装<p>${sessionScope.goodinfo.goodProperties.good_men}</p></td>
				<td>所属店铺<p>${sessionScope.goodinfo.good.store_name}</p></td>
			</tr>
			<tr>
				<td><b>评价人</b></td>
				<td><b>评价时间</b></td>
				<td colspan="2"><b>评价内容</b></td>
				<td><b>商品名</b></td>
			</tr>
			<c:forEach items="${sessionScope.goodinfo.goodAssesses}" var="goodAssess">
			<tr>
				<td>${goodAssess.user_name}</td>
				<td>${goodAssess.assess_time}</td>
				<td colspan="2">${goodAssess.assess_content}</td>
				<td>${goodAssess.good_name}</td>
			</tr>
			</c:forEach>
			<tr>
				<c:choose>
					<c:when test="${currvalRole.role_type!=null&&currvalRole.role_type=='2'}">
						<td>
							<input type="button" value="立即购买" id="buyNow" disabled="disabled" style="cursor: pointer;">
						</td>
				<td>
					<form action="/ShoppingMall/user/userAddShoppingCar.do" method="post">
						<input name="good_id" value="${goodinfo.good.good_id}" hidden="hidden">
						<input name="goodnum" placeholder="加入购物车的数量" value="1">
						<input type="submit" value="加入购物车" id="addShoppingCar">
					</form>
				</td>
				<td colspan="3">
					<form action="/ShoppingMall/user/userAddCollectGood.do" method="post">
						<input name="good_id" value="${goodinfo.good.good_id}" hidden="hidden">
						<button type="submit" id="collectGood">收藏此商品</button>
					</form>
				</td>
					</c:when>
					<c:when test="${currvalRole.role_type!=null&&currvalRole.role_type=='1'}">
						<td><a href="/ShoppingMall/page/roleLogin.jsp">您当前为店铺登录，请切换为用户</a></td>
					</c:when>
					<c:when test="${currvalRole.role_type!=null&&currvalRole.role_type=='0'}">
						<td><a href="/ShoppingMall/page/roleLogin.jsp">您当前为管理员登录，请切换为用户</a></td>
					</c:when>
					<c:otherwise>
						<td><a href="/ShoppingMall/page/roleLogin.jsp">请先登录再进行购物</a></td>
					</c:otherwise>
				</c:choose>
				
			</tr>
		
	</table>
</body>
</html>