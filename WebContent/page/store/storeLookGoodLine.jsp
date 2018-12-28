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
	background: url("/ShoppingMall/img/storebg.jpg") no-repeat;
	background-size:cover; 
}
</style>
</head>
<body>
	<table border="1" width="100%">
		<form action="/ShoppingMall/store/updateGoodInfo.do" method="post">
			<th style="fontsize:20px;color:red" colspan="5"><input name="good.good_name" value="${requestScope.goodinfo.good.good_name}"/></th>
			<input name="good.good_id" value="${requestScope.goodinfo.good.good_id}" hidden="hidden">
			<input name="goodPrice.good_id" value="${requestScope.goodinfo.good.good_id}" hidden="hidden">
			<input name="goodProperties.good_id" value="${requestScope.goodinfo.good.good_id}" hidden="hidden">
			<tr>
			<td rowspan="3"><img alt="商品图片" src="../${requestScope.goodinfo.goodImage.image_route }"/></td>
			<td>商品价格<p><input name="goodPrice.price_num" value="${requestScope.goodinfo.goodPrice.price_num}"/></p></td>
			<td>商品总量<p><input name="goodProperties.good_total" value="${requestScope.goodinfo.goodProperties.good_total}"/></p></td>
			<td>商品销量<p>${requestScope.goodinfo.goodSale.sale_num}</p></td>
			<td>商品余量<p>${requestScope.goodinfo.goodMargin.margin_num}</p></td>
			</tr>
			<tr>
				<td>商品颜色<p><input name="goodProperties.color_name" value="${requestScope.goodinfo.goodProperties.color_name}"/></p></td>
				<td>商品大小<p><input name="goodProperties.size_name" value="${requestScope.goodinfo.goodProperties.size_name}"/></p></td>
				<td>适用人群<p><input name="goodProperties.good_age" value="${requestScope.goodinfo.goodProperties.good_age}"/></p></td>
				<td>上下衣<p><input name="goodProperties.good_topOrDown" value="${requestScope.goodinfo.goodProperties.good_topOrDown}"/></p></td>
			</tr>
			<tr>
				<td>服装季节<p><input name="goodProperties.good_season" value="${requestScope.goodinfo.goodProperties.good_season}"/></p></td>
				<td>服装类型<p><input name="goodProperties.good_type" value="${requestScope.goodinfo.goodProperties.good_type}"/></p></td>
				<td>男装女装<p><input name="goodProperties.good_men" value="${requestScope.goodinfo.goodProperties.good_men}"/></p></td>
				<td>所属店铺<p>${requestScope.goodinfo.good.store_name}</p></td>
			</tr>
			<tr>
				<td colspan="5" height="200px">评价</td>
			</tr>
			<tr>
				<input type="submit" value="确认修改" style="cursor: pointer;"/>	
			</tr>
		</form>
		<tr>
			<form action="/ShoppingMall/store/deleteGoodInfo.do" method="get">
				<input type="text" name="good_id" value="${requestScope.goodinfo.good.good_id}" hidden="hidden">
				<input type="submit" value="下架此商品">
			</form>
		</tr>
	</table>
</body>
</html>