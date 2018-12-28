<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>购衣商城系统登录</title>
<link rel="stylesheet" href="/ShoppingMall/css/style.css">
</head>
<body>

<div class="login-container">
	<h1>*****ROLE-LOGIN*****</h1>
	
	<!-- <div class="connect">
		<p>www.moke8.com</p>
	</div> -->
	
	<form action="" method="post" id="loginForm">
		<div>
			<input type="text" name="role_name" class="username" placeholder="用户名" autocomplete="off" id="loginBy"/>
		</div>
		<div>
			<input type="password" name="role_pwd" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" id="role_pwd"/>
		</div>
		<div id="roleType" onclick="funRoleType()">
			<label><input type="radio" name="roleType" value="user" checked="checked"/>用户</label>
			<label><input type="radio" name="roleType" value="store"/>店铺</label>
			<label><input type="radio" name="roleType" value="admin"/>管理</label>
		</div>
		<button id="submit" type="submit" onclick="funLogin()">登 陆</button>
		<select id="loginType"" onclick="funLoginType()">
			<option value="" >登录方式</option>
			<option value="loginByName">用户名登录</option>
			<option value="loginByTel">手机号登录</option>
		</select>
		
	</form>

	<a href="/ShoppingMall/page/user/userRegister.jsp">
		<button type="button" class="register-tis">还没有账号？</button>
	</a>

</div>

<script src="/ShoppingMall/js/jquery.min.js"></script>
<script src="/ShoppingMall/js/common.js"></script>
<!--背景图片自动更换-->
<script src="/ShoppingMall/js/supersized.3.2.7.min.js"></script>
<script src="/ShoppingMall/js/supersized-init.js"></script>
<!--表单验证-->
<script src="/ShoppingMall/js/jquery.validate.min.js?var1.14.0"></script>
<!--
	作者：offline
	时间：2018-03-11
	描述：js验证哪个角色使用哪个登录方式进行登录
-->
<script type="text/javascript">
	/**
	 * 判断是哪个角色进行登录
	 */
	function funRoleType(){
		var values=document.getElementsByName("roleType");
		var checkedValue=null;
		   for(var i=0;i<values.length;i++){
			        if(values[i].checked==true)
					 checkedValue=values[i].value;
				} 
				return checkedValue;
			}
	/**
	 * 判断角色使用哪种登录方式进行登录
	 */
	function funLoginType(){
		var loginType=document.getElementById("loginType");
		var index=loginType.selectedIndex;
		var loginby=document.getElementById("loginBy");
			//alert(values[i].value);
			if(loginType.options[index].value=="loginByTel"){
				loginby.name="role_tel";
				loginby.placeholder="请输入手机号";
			}else if (loginType.options[index].value=="loginByName") {
				loginby.name="role_name";
				loginby.placeholder="请输入用户名";
			}
		return loginType.options[index].value;
	}
	/**
	 * 该方法在判断出角色以及登录方式以后，将对应的action传到form表单
	 */
	function funLogin(){
		var roleType=funRoleType();
		var loginType=funLoginType();
		var loginForm=document.getElementById("loginForm");
		var role_name=document.getElementById("loginBy").value;
		var role_pwd=document.getElementById("role_pwd").value;
		if(role_name==null||role_name==""){
			alert("请输入用户名");
		}else{
			if(role_pwd==null||role_pwd==""){
				alert("请输入密码");
			}else{
				if(roleType=="user"){
					if(loginType=="loginByName"){
						/* alert("userlogin"); */
						loginForm.action="/ShoppingMall/user/userLoginByName.do";
						loginForm.submit();
					}else if(loginType=="loginByTel"){
						loginForm.action="/ShoppingMall/user/userLoginByTel.do";
						loginForm.submit();
					}else{
						alert("请选择登录方式");
					}
				}else if(roleType=="store"){
					if(loginType=="loginByName"){
						loginForm.action="/ShoppingMall/store/storeLoginByName.do";
						loginForm.submit();
					}else if(loginType=="loginByTel"){
						loginForm.action="/ShoppingMall/store/storeLoginByTel.do";
						loginForm.submit();
					}else{
						alert("请选择登录方式");
					}
					
				}else{
					if(loginType=="loginByName"){
						loginForm.action="/ShoppingMall/admin/adminLoginByName.do";
						loginForm.submit();
					}else if(loginType=="loginByTel"){
						loginForm.action="/ShoppingMall/admin/adminLoginByTel.do";
						loginForm.submit();
					}else{
						alert("请选择登录方式");
					}
				}
			}
		}
		
	}
</script>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<p>诚邀优秀商家前来开店，欢迎文明顾客前来购物。</p>
<p>Copyright &copy; 2017hds</p>
</div>
</body>
</html>