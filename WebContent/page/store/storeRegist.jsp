<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店铺注册</title>
<style type="text/css">
	body {
	background: url("/ShoppingMall/img/storebg.jpg") no-repeat;
	background-size:cover; 
}
</style>

</head>

<body>
	<div style="margin-left: 30px; margin-top: 30px">
		<form action="" method="post" enctype="" id="storeRegist">
			<div style="position:absolute; top:40px; left:38px;">
			<h3>店铺注册</h3>
			<p>
				店铺名：<input name="role_name" id="role_name" required="required">
			</p>
			<p>
				店铺密码：<input name="role_pwd" required="required" id="role_pwd">
			</p>
			<p>
				店铺联系人：<input name="linkman_name" required="required" id="linkman_name">
			</p>
			</div>
			<p style="position:absolute; top:200px; left:38px">
				<input name="role_tel" id="role_tel" placeholder="输入手机号码" required="required">
				<input type="button" value="获取验证码" onclick="getYzm()" style="cursor: pointer;">
			</p>
			<p style="position:absolute; top:240px; left:38px">
				请输入收到的验证码：<input name="role_yzm" placeholder="输入验证码" required="required"/>
			</p>
			<div style="position:absolute; top:280px; left:38px;">
			<p>
				店铺营业执照图片路径<input id="storeLicenseRoute" name="store_license" type="text" value="" style="width: 400px" hidden="hidden">
			</p>
			<p>
				店主手持身份证图片路径<input id="storeMenRoute" name="store_men_image" type="text" value="" style="width: 400px" hidden="hidden">
			</p>
			<p>
				店铺图片路径<input id="storeImageRoute" name="store_image" type="text" value="" style="width: 400px" hidden="hidden">
			</p>
			<p>
				<input type="submit" value="注册店铺" onclick="selStoreRegist()">
			</p>
			</div>
		</form>
		<div style="position: absolute; top: 50px; left: 800px;">
					上传店主手持身份证照片
					<form action="" method="post" enctype="multipart/form-data" id="uploadStoreMen">
						<input id="changeStoreMen" type="file" onchange="uploadStoreMen()" name="storeMenImage"
							style="position: absolute; z-index: 10; opacity: 0; width: 100px; height: 100px;">
						<img id="defaultStoreMen" src="/ShoppingMall/upload/defaultHead.png" title="点击上传图片"
							style="position: absolute; z-index: 9; float: left; width: 100px; height: 100px"><br>
							点击上传图片
					</form>
		</div>
		<div style="position: absolute; top: 200px; left: 800px;">
					上传营业执照照片
					<form action="" method="post" enctype="multipart/form-data" id="uploadStoreLicense">
						<input id="changeStoreLicense" type="file" onchange="uploadStoreLicense()" name="storeLicenseImage"
							style="position: absolute; z-index: 10; opacity: 0; width: 100px; height: 100px;">
						<img id="defaultStoreLicense" src="/ShoppingMall/upload/defaultHead.png" title="点击上传图片"
							style="position: absolute; z-index: 9; float: left; width: 100px; height: 100px"><br>
							点击上传图片
					</form>
		</div>
		<div style="position: absolute; top: 350px; left: 800px;">
					上传店铺图片
					<form action="" method="post" enctype="multipart/form-data" id="uploadStoreImage">
						<input id="changeStoreImage" type="file" onchange="uploadStoreImage()" name="storeImage"
							style="position: absolute; z-index: 10; opacity: 0; width: 100px; height: 100px;">
						<img id="defaultStoreImage" src="/ShoppingMall/upload/defaultHead.png" title="点击上传图片"
							style="position: absolute; z-index: 9; float: left; width: 100px; height: 100px"><br>
							点击上传图片
					</form>
		</div>
		<!-- <div style="position:absolute; top:210px; left:38px">
			<form action="" method="post" id="getYzm">
					请输入手机号：<input name="role_tel">
					<input type="submit" value="获取验证码" onclick="getyzm()">
			</form>
		</div> -->
	</div>
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
	var role_name=document.getElementById("role_name").value;
	var role_tel=document.getElementById("role_tel").value;
	if(role_name==null||role_name==""){
		alert("请输入用户名");
	}else{
		 if(role_tel==null||role_tel==""){
			alert("请输入手机号码");
		}else{ 
			createXmlHttpRequest();
			var url="/ShoppingMall/store/getyzm.do";
			xmlHttp.open("get", url+"?"+createSendData());
			xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xmlHttp.send(null);
			xmlHttp.onreadystatechange=handleStateChange();
		}
	
	}
	
}
function selStoreRegist() {
	var role_name=document.getElementById("role_name").value;
	var role_pwd=document.getElementById("role_pwd").value;
	var linkman_name=document.getElementById("linkman_name").value;
	var role_tel=document.getElementById("role_tel").value;
	var storeLicenseRoute=document.getElementById("storeLicenseRoute").value;
	var storeMenRoute=document.getElementById("storeMenRoute").value;
	var storeImageRoute=document.getElementById("storeImageRoute").value;
	if(role_name==null||role_name==""){
		alert("请输入用户名");
	}else{
		if(role_pwd==null||role_pwd==""){
			alert("请输入密码");
		}else{
			if(linkman_name==null||linkman_name==""){
				alert("请输入联系人姓名");
			}else{
				if(role_tel==null||role_tel==""){
					alert("请输入手机号码");
				}else{
					if(storeLicenseRoute==null||storeLicenseRoute==""){
						alert("请上传营业执照图片");
					}else{
						if(storeMenRoute==null||storeMenRoute==""){
							alert("请上传店主手持身份证图片");
						}else{
							if(storeImageRoute==null||storeImageRoute==""){
								alert("请上传店铺图片");
							}else{
								document.getElementById("storeRegist").enctype='application/x-www-form-urlencoded';
								document.getElementById("storeRegist").action='/ShoppingMall/store/storeRegist.do';
								document.getElementById("storeRegist").submit();
							}
						}
					}
				}
			}
		}
	}
	
}

//上传店铺营业执照照片
function uploadStoreLicense() {  
	alert("上传店铺营业执照照片");
		 // 上传设置  
	var options = {  
    // 规定把请求发送到那个URL  
    url: "/ShoppingMall/upload/uploadStoreLicense.do",  
    // 请求方式  
    type: "post",  
    // 服务器响应的数据类型  
    dataType: "json",  
    // 请求成功时执行的回调函数  
    success: function(data, status, xhr) {  
        // 图片显示地址  
        $("#defaultStoreLicense").attr("src","/ShoppingMall/"+data.path); 
        $("#storeLicenseRoute").attr("value",data.path);
        alert(data.path);
        
    }  
};  

$("#uploadStoreLicense").ajaxSubmit(options);  
}  

//上传店主手持身份证图片
function uploadStoreMen() {  
	alert("上传店主手持身份证照片");
		 // 上传设置  
	var options = {  
    // 规定把请求发送到那个URL  
    url: "/ShoppingMall/upload/uploadStoreMenImage.do",  
    // 请求方式  
    type: "post",  
    // 服务器响应的数据类型  
    dataType: "json",  
    // 请求成功时执行的回调函数  
    success: function(data, status, xhr) {  
        // 图片显示地址  
        $("#defaultStoreMen").attr("src","/ShoppingMall/"+data.path); 
        $("#storeMenRoute").attr("value",data.path);
        alert(data.path);
        
    }  
};  

$("#uploadStoreMen").ajaxSubmit(options);  
}  

//上传店内图片
function uploadStoreImage() {  
	alert("上传店内照片");
		 // 上传设置  
	var options = {  
    // 规定把请求发送到那个URL  
    url: "/ShoppingMall/upload/uploadStoreImage.do",  
    // 请求方式  
    type: "post",  
    // 服务器响应的数据类型  
    dataType: "json",  
    // 请求成功时执行的回调函数  
    success: function(data, status, xhr) {  
        // 图片显示地址  
        $("#defaultStoreImage").attr("src","/ShoppingMall/"+data.path); 
        $("#storeImageRoute").attr("value",data.path);
        alert(data.path);
        
    }  
};  

$("#uploadStoreImage").ajaxSubmit(options);  
}
</script>
</body>
</html>