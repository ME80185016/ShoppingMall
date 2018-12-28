<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店铺添加商品</title>
<style type="text/css">
	body {
	background: url("/ShoppingMall/img/storebg.jpg") no-repeat;
	background-size:cover; 
}
</style>
<script src="js/jquery-3.2.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript">
//点击添加商品时触发方法，获取action，获取加密方式，并提交
	function selAddGood() {
		var good_name=document.getElementById("good_name").value;
		var price_num=document.getElementById("price_num").value;
		var color_name=document.getElementById("color_name").value;
		var size_name=document.getElementById("size_name").value;
		var good_men=document.getElementById("good_men").value;
		var good_age=document.getElementById("good_age").value;
		var good_topOrDown=document.getElementById("good_topOrDown").value;
		var good_season=document.getElementById("good_season").value;
		var good_type=document.getElementById("good_type").value;
		var good_total=document.getElementById("good_total").value;
		var imageRoute=document.getElementById("imageRoute").value;
		if(good_name==null||good_name==""){
			alert("请输入商品名");
		}else{
			if(price_num==null||price_num==""){
				alert("请输入商品价格");
			}else{
				if(color_name==null||color_name==""){
					alert("请输入商品颜色");
				}else{
					if(size_name==null||size_name==""){
						alert("请输入商品大小");
					}else{
						if(good_men==null||good_men==""){
							alert("请输入男女装");
						}else{
							if(good_age==null||good_age==""){
								alert("请输入商品适用人群");
							}else{
								if(good_topOrDown==null||good_topOrDown==""){
									alert("请输入商品上下衣");
								}else{
									if(good_season==null||good_season==""){
										alert("请输入商品适用季节");
									}else{
										if(good_type==null||good_type==""){
											alert("请输入商品类型");
										}else{
											if(good_total==null||good_total==""){
												alert("请输入商品总量");
											}else{
												if(imageRoute==null||imageRoute==""){
													alert("请上传商品图片");
												}else{
													document.getElementById("addGood").enctype='application/x-www-form-urlencoded';
													document.getElementById("addGood").action='/ShoppingMall/store/addGood.do';
													document.getElementById("addGood").submit();
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	function uploadPic() {  
			alert("触发onchange方法");
   			 // 上传设置  
    		var options = {  
            // 规定把请求发送到那个URL  
            url: "/ShoppingMall/upload/uploadGoodImage.do",  
            // 请求方式  
            type: "post",  
            // 服务器响应的数据类型  
            dataType: "json",  
            // 请求成功时执行的回调函数  
            success: function(data, status, xhr) {  
                // 图片显示地址  
                $("#defaultImage").attr("src",data.path); 
                $("#imageRoute").attr("value",data.path);
                alert(data.path);
            }  
    };  
      
    $("#uploadAction").ajaxSubmit(options);  
}  
</script>
</head>

<body>
	<div style="margin-left: 30px; margin-top: 30px">
		<form action="" method="post" enctype="" id="addGood">

			<h3>添加商品</h3>
			<p>
				商品名：<input name="good.good_name" id="good_name">
			</p>
			<p>
				商品价格：<input name="goodPrice.price_num" id="price_num">
			</p>
			<p>
				商品颜色：<input name="goodProperties.color_name" id="color_name">
			</p>
			<p>
				商品大小：	<input name="goodProperties.size_name" id="size_name">
			</p>
			<p>
				男女装：<input name="goodProperties.good_men" id="good_men">
			</p>
			<p>
				适用人群：<input name="goodProperties.good_age" id="good_age">
			</p>
			<p>
				上下衣：<input name="goodProperties.good_topOrDown" id="good_topOrDown">
			</p>
			<p>
				季节：<input name="goodProperties.good_season" id="good_season">
			</p>
			<p>
				类型：<input name="goodProperties.good_type" id="good_type">
			</p>
			<p>
				总量：<input name="goodProperties.good_total" id="good_total">
			</p>
			<input id="imageRoute" type="text" value="" name="imageRoute" style="width: 400px" hidden="hidden">
			<p>
				<input type="submit" value="添加商品" onclick="selAddGood()">
			</p>
		</form>
		<div style="position: absolute; top: 85px; left: 300px;">
			<form action="" method="post" enctype="multipart/form-data" id="uploadAction">
				<input id="changeImage" type="file" onchange="uploadPic()" name="goodImage"
					style="position: absolute; float: left; z-index: 10; opacity: 0; width: 100px; height: 100px;">
				<img id="defaultImage" src="/ShoppingMall/upload/defaultHead.png" title="商品图片"
					style="position: absolute; z-index: 9; float: left; width: 100px; height: 100px"><br>
					商品图片
			</form>
		</div>
	</div>
</body>
</html>