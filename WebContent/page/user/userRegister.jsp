<!DOCTYPE html>
<html lang="zh-CN">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>             
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
<title>购衣系统注册</title>
<link rel="stylesheet" href="/ShoppingMall/css/style.css">
<body>
<div class="register-container">
	<h1>*****User-Register*****</h1>
	
	<div class="connect">
		<p>Link the world. Share to world.</p>
	</div>
	
	<form action="" method="" id="registerForm">
		<div>
			<input type="text" name="role_name" class="username" placeholder="您的用户名" autocomplete="off" id="role_name"/>
		</div>
		<div>
			<input type="password" name="role_pwd" class="password" placeholder="输入密码" oncontextmenu="return false" onpaste="return false" id="role_pwd"/>
		</div>
		<div>
			<input type="password" name="pwd_again" class="confirm_password" placeholder="再次输入密码" oncontextmenu="return false" onpaste="return false" id="pwd_again"/>
		</div>
		<div>
			<input type="text" name="role_tel" class="phone_number" placeholder="输入手机号码" autocomplete="off" id="role_tel"/>
			<input type="button" value="获取验证码" onclick="getYzm()" style="cursor: pointer;">
		</div>
		<div>
			<input type="text" name="role_yzm" class="phone_yzm" placeholder="输入验证码" autocomplete="off" id="yzm"/>
		</div>
		

		<button id="register" type="submit" onclick="selRegister()">注 册</button>
	</form>
	<a href="/ShoppingMall/page/roleLogin.jsp">
		<button type="button" class="register-tis">已经有账号？</button>
	</a>

</div>

</body>
<script src="/ShoppingMall/js/jquery.min.js"></script>
<script src="/ShoppingMall/js/common.js"></script>
<!--背景图片自动更换-->
<script src="/ShoppingMall/js/supersized.3.2.7.min.js"></script>
<script src="/ShoppingMall/js/supersized-init.js"></script>
<!--表单验证-->
<script src="/ShoppingMall/js/jquery.validate.min.js?var1.14.0"></script>
<!-- ajax发送验证码 -->
<script src="/ShoppingMall/js/jquery-3.2.1.js" type="text/javascript"></script>
<script type="text/javascript" src="/ShoppingMall/js/jquery.form.js"></script>
<script type="text/javascript">
	var xmlHttp;
	function createXmlHttpRequest(){
		if(window.ActiveXObject){
			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		}else{
			xmlHttp=new XMLHttpRequest();
		}
	}
	function handleStateChange(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				var result=xmlHttp.responseText;
				alert(result);
			}
		}
	}
	function createSendData(){
		var role_name=document.getElementById("role_name").value;
		var role_tel=document.getElementById("role_tel").value;
		var data="rolename="+role_name+"&roletel="+role_tel;
		return data;
	}
	function getYzm(){
		alert("短信已发送，请注意查收");
		var role_name=document.getElementById("role_name").value;
		var role_tel=document.getElementById("role_tel").value;
		if(role_name==null||role_name==""){
			alert("请输入用户名");
		}else{
			 if(role_tel==null||role_tel==""){
				alert("请输入手机号码");
			}else{ 
				createXmlHttpRequest();
				var url="/ShoppingMall/user/getyzm.do";
				xmlHttp.open("get", url+"?"+createSendData());
				xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				xmlHttp.send(null);
				xmlHttp.onreadystatechange=handleStateChange();
			}
		}
	}
	function selRegister(){
		var role_name=document.getElementById("role_name").value;
		var role_pwd=document.getElementById("role_pwd").value;
		var pwd_again=document.getElementById("pwd_again").value;
		var role_tel=document.getElementById("role_tel").value;
		var yzm=document.getElementById("yzm").value;
		
		if(role_name==null||role_name==""){
			alert("请输入用户名");
		}else{
			if(role_pwd==null||role_pwd==""){
				alert("请输入密码");
			}else{
				if(pwd_again==null||pwd_again==""){
					alert("请再次输入密码");
				}else{
					if(role_pwd!=pwd_again){
						alert("两次输入的密码不一致");
					}else{
						if(role_tel==null||role_tel==""){
							alert("请输入手机号码");
						}else{
							if(yzm==null||yzm==""){
								alert("请输入验证码");
							}else{
								document.getElementById("registerForm").action="/ShoppingMall/user/userRegist.do";
								document.getElementById("registerForm").method="post";
								document.getElementById("registerForm").submit();
							}
						}
					}
				}
			}
		}
		
	}

</script>
</html>