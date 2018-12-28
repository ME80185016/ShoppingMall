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
	background: url("/ShoppingMall/img/adminbg.jpg") no-repeat;
	background-size:cover; 
}
</style>
</head>
<body>
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
				<td colspan="5" height="200px">评价</td>
			</tr>
			<tr>
				<form action="/ShoppingMall/admin/deleteGoodInfo.do" method="get">
					<input name="good_id" value="${sessionScope.goodinfo.good.good_id}" hidden="hidden">
					<input type="submit" value="强制下架">
				</form>
			</tr>
		
	</table>
</body>
</html>