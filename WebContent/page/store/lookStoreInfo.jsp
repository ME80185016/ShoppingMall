<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>店铺信息</title>
<style type="text/css">
	body {
	background: url("/ShoppingMall/img/storebg.jpg") no-repeat;
	background-size:cover; 
}
</style>
<script type="text/javascript">
	window.onload=function(){
		var state=${sessionScope.currvalRoleInfo.store_state};
		if(state=='0'){
			document.getElementById("openStore").disabled="disabled";
			document.getElementById("closeStore").disabled="disabled";
		}
	}
</script>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<td>店铺名</td>
			<td>密码</td>
			<td>头像</td>
			<td>营业执照</td>
			<td>店铺图片</td>
			<td>联系人图片</td>
			<td>电话</td>
			<td>联系人</td>
			<td>地址</td>
		</tr>
		<tr>
			<form action="/ShoppingMall/store/updateStoreInfo.do" method="post">
				<td><input name="role_name"
					value="${sessionScope.currvalRole.role_name}" /></td>
				<td><input name="role_pwd"
					 value="${sessionScope.currvalRole.role_pwd}"></td>
				<td><img alt="头像"
					src="/ShoppingMall/${sessionScope.currvalRole.role_head}" /></td>
				<td><img alt="营业执照"
					src="/ShoppingMall/${sessionScope.currvalRoleInfo.store_license}" /></td>
				<td><img alt="店铺图片"
					src="/ShoppingMall/${sessionScope.currvalRoleInfo.store_image}" /></td>
				<td><img alt="联系人图片"
					src="/ShoppingMall/${sessionScope.currvalRoleInfo.store_men_image}" /></td>
					<input name="role_id"
					value="${sessionScope.currvalRole.role_id}" hidden="hidden" }"/>
				<td><input name="role_tel"
					value="${sessionScope.currvalRole.role_tel}" /></td>
					<td><input name="linkman_name"
					value="${sessionScope.currvalRoleInfo.linkman_name}" /></td>
					<td>
						<c:forEach items="${sessionScope.storeAddresses}" var="address">
							${address.address_name}
						</c:forEach>
					</td>
				<td><c:choose>
						<c:when test="${sessionScope.currvalRoleInfo.store_state=='0'}">
                                                    			待管理员审核
                                                    		</c:when>
						<c:when test="${sessionScope.currvalRoleInfo.store_state=='1'}">
                                                    			营业中
                                                    		</c:when>
						<c:when test="${sessionScope.currvalRoleInfo.store_state=='2'}">
                                                    			已打烊
                                                    		</c:when>
					</c:choose></td>
				<td><input type="submit" value="确认修改" /></td>
			</form>
		</tr>
		<tr>
			<td>
				<c:choose>
						<c:when test="${sessionScope.currvalRoleInfo.store_state=='1'}">
                         <form action="/ShoppingMall/store/updateStoreState.do" method="get">
                         	<input name="store_state" value="2" hidden="hidden">
                         	<input type="submit" value="打烊" id="closeStore" style="cursor: pointer;">
                         </form>                           			
                         </c:when>                           		
						<c:when test="${sessionScope.currvalRoleInfo.store_state=='2'}">
                          <form action="/ShoppingMall/store/updateStoreState.do" method="get">
                         	<input name="store_state" value="1" hidden="hidden">
                         	<input type="submit" value="营业" id="openStore" style="cursor: pointer;">
                         </form>                           			
                        </c:when>                            		
					</c:choose>
			</td>
		</tr>
	</table>
</body>
</html>