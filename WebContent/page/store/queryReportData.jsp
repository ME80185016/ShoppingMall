<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看报表</title>
<style type="text/css">
	#startDiv{
		position: absolute;
		top:100px;
		left:20px;
	}
	#endDiv{
		position: absolute;
		top:100px;
		left: 300px;
	}
	#query{
		position: absolute;
		top:100px;
		left: 550px;
	}
	#lookReportData{
		position: absolute;
		top:150px;
		left:20px;
	}
	
body {
	background: url("/ShoppingMall/img/storebg.jpg") no-repeat;
	background-size:cover; 
}
</style>
</head>
<body>
<center>
	<h2>查看报表数据</h2>
</center>
<form action="/ShoppingMall/store/storeLookReportData.do" method="post">
<div id="startDiv">
开始时间
<select id="startDateData" name="start_date">
	<option value="">-请选择-</option>
	<option value="2017年11月01号00:00:00">2017年11月01号00:00:00</option>
	<option value="2017年12月01号00:00:00">2017年12月01号00:00:00</option>
	<option value="2018年01月01号00:00:00">2018年01月01号00:00:00</option>
	<option value="2018年02月01号00:00:00">2018年02月01号00:00:00</option>
	<option value="2018年03月01号00:00:00">2018年03月01号00:00:00</option>
	<option value="2018年04月01号00:00:00">2018年04月01号00:00:00</option>
	<option value="2018年05月01号00:00:00">2018年05月01号00:00:00</option>
	<option value="2018年06月01号00:00:00">2018年06月01号00:00:00</option>
	<option value="2018年07月01号00:00:00">2018年07月01号00:00:00</option>
	<option value="2018年08月01号00:00:00">2018年08月01号00:00:00</option>
	<option value="2018年09月01号00:00:00">2018年09月01号00:00:00</option>
	<option value="2018年10月01号00:00:00">2018年10月01号00:00:00</option>
	<option value="2018年11月01号00:00:00">2018年11月01号00:00:00</option>
	<option value="2018年12月01号00:00:00">2018年12月01号00:00:00</option>
	<option value="2019年01月01号00:00:00">2019年01月01号00:00:00</option>
	<option value="2019年02月01号00:00:00">2019年02月01号00:00:00</option>
	<option value="2019年03月01号00:00:00">2019年03月01号00:00:00</option>
	<option value="2019年04月01号00:00:00">2019年04月01号00:00:00</option>
	<option value="2019年05月01号00:00:00">2019年05月01号00:00:00</option>
	<option value="2019年06月01号00:00:00">2019年06月01号00:00:00</option>
	<option value="2019年07月01号00:00:00">2019年07月01号00:00:00</option>
	<option value="2019年08月01号00:00:00">2019年08月01号00:00:00</option>
	<option value="2019年09月01号00:00:00">2019年09月01号00:00:00</option>
	<option value="2019年10月01号00:00:00">2019年10月01号00:00:00</option>
	<option value="2019年11月01号00:00:00">2019年11月01号00:00:00</option>
	<option value="2019年12月01号00:00:00">2019年12月01号00:00:00</option>
</select>
</div>
<div id="endDiv">
结束时间
<select id="endDateData" name="end_date">
	<option value="">-请选择-</option>
	<option value="2017年11月01号00:00:00">2017年11月01号00:00:00</option>
	<option value="2017年12月01号00:00:00">2017年12月01号00:00:00</option>
	<option value="2018年01月01号00:00:00">2018年01月01号00:00:00</option>
	<option value="2018年02月01号00:00:00">2018年02月01号00:00:00</option>
	<option value="2018年03月01号00:00:00">2018年03月01号00:00:00</option>
	<option value="2018年04月01号00:00:00">2018年04月01号00:00:00</option>
	<option value="2018年05月01号00:00:00">2018年05月01号00:00:00</option>
	<option value="2018年06月01号00:00:00">2018年06月01号00:00:00</option>
	<option value="2018年07月01号00:00:00">2018年07月01号00:00:00</option>
	<option value="2018年08月01号00:00:00">2018年08月01号00:00:00</option>
	<option value="2018年09月01号00:00:00">2018年09月01号00:00:00</option>
	<option value="2018年10月01号00:00:00">2018年10月01号00:00:00</option>
	<option value="2018年11月01号00:00:00">2018年11月01号00:00:00</option>
	<option value="2018年12月01号00:00:00">2018年12月01号00:00:00</option>
	<option value="2019年01月01号00:00:00">2019年01月01号00:00:00</option>
	<option value="2019年02月01号00:00:00">2019年02月01号00:00:00</option>
	<option value="2019年03月01号00:00:00">2019年03月01号00:00:00</option>
	<option value="2019年04月01号00:00:00">2019年04月01号00:00:00</option>
	<option value="2019年05月01号00:00:00">2019年05月01号00:00:00</option>
	<option value="2019年06月01号00:00:00">2019年06月01号00:00:00</option>
	<option value="2019年07月01号00:00:00">2019年07月01号00:00:00</option>
	<option value="2019年08月01号00:00:00">2019年08月01号00:00:00</option>
	<option value="2019年09月01号00:00:00">2019年09月01号00:00:00</option>
	<option value="2019年10月01号00:00:00">2019年10月01号00:00:00</option>
	<option value="2019年11月01号00:00:00">2019年11月01号00:00:00</option>
	<option value="2019年12月01号00:00:00">2019年12月01号00:00:00</option>
</select>
</div>
<div id="query">
<input type="submit" value="查询">
</div>
</form>
<!-- <div id="lookReportData">
	<iframe src="/ShoppingMall/page/store/lookReportData.jsp"></iframe>
</div> -->
</body>
</html>