<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>查看订单</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
		<!-- favicon
		============================================ -->		
        <link rel="shortcut icon" type="image/x-icon" href="/ShoppingMall/img/favicon.ico">
		
		<!-- Bootstrap CSS
		============================================ -->		
        <link rel="stylesheet" href="/ShoppingMall/css/bootstrap.min.css">
        
        <!-- Nivo slider CSS
		============================================ -->
		<link rel="stylesheet" type="text/css" href="/ShoppingMall/lib/custom-slider/css/nivo-slider.css" media="screen" />	
		<link rel="stylesheet" type="text/css" href="/ShoppingMall/lib/custom-slider/css/preview.css" media="screen" />
		
		<!-- Fontawsome CSS
		============================================ -->
        <link rel="stylesheet" href="/ShoppingMall/css/font-awesome.min.css">
          
        <!-- material iconic CSS
		============================================ -->
        <link rel="stylesheet" href="/ShoppingMall/css/material-design-iconic-font.css">
        <link rel="stylesheet" href="/ShoppingMall/css/material-design-iconic-font.min.css">
                       
		<!-- owl.carousel CSS
		============================================ -->
        <link rel="stylesheet" href="/ShoppingMall/css/owl.carousel.css">
        
		<!-- jquery-ui CSS
		============================================ -->
        <link rel="stylesheet" href="/ShoppingMall/css/jquery-ui.css">
        
		<!-- meanmenu CSS
		============================================ -->
        <link rel="stylesheet" href="/ShoppingMall/css/meanmenu.min.css">
        
		<!-- animate CSS
		============================================ -->
        <link rel="stylesheet" href="/ShoppingMall/css/animate.css">

        <!-- Color Switcher CSS
		============================================ -->
        <link rel="stylesheet" href="/ShoppingMall/css/color.css">
        <link rel="stylesheet" href="/ShoppingMall/css/color-switcher.css">
          
        <!-- Animate headline CSS
		============================================ -->
        <link rel="stylesheet" href="/ShoppingMall/css/animate-heading.css">
        <link rel="stylesheet" href="/ShoppingMall/css/reset.css">
        
		<!-- Video CSS
		============================================ -->
        <link rel="stylesheet" href="/ShoppingMall/css/jquery.mb.YTPlayer.css">
        
		<!-- style CSS
		============================================ -->
        <link rel="stylesheet" href="/ShoppingMall/style.css">
        
		<!-- responsive CSS
		============================================ -->
        <link rel="stylesheet" href="/ShoppingMall/css/responsive.css">
        
		<!-- modernizr JS
		============================================ -->		
        <script src="/ShoppingMall/js/vendor/modernizr-2.8.3.min.js"></script>
        
        <!-- Color Css Files Start -->
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/color-one.css" title="color-one" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/color-two.css" title="color-two" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/color-three.css" title="color-three" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/color-four.css" title="color-four" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/color-five.css" title="color-five" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/color-six.css" title="color-six" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/color-seven.css" title="color-seven" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/color-eight.css" title="color-eight" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/color-nine.css" title="color-nine" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/color-ten.css" title="color-ten" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/color-ten.css" title="color-ten" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/pattren1.css" title="pattren1" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/pattren2.css" title="pattren2" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/pattren3.css" title="pattren3" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/pattren4.css" title="pattren4" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/pattren5.css" title="pattren5" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/background1.css" title="background1" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/background2.css" title="background2" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/background3.css" title="background3" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/background4.css" title="background4" media="screen" />
        <link rel="alternate stylesheet" type="text/css" href="/ShoppingMall/switcher/background5.css" title="background5" media="screen" />
        <!-- Color Css Files End -->
        <script type="text/javascript">
        window.onload=function(){
    		document.getElementById("search").onclick=function(){
    			document.getElementById("searchForm").submit();
    		}
        }
        </script>
    </head>
    <body>
<!-- PreLoader============================================ -->
        <div class="preloader">
            <div class="loading-center">
                <div class="loading-center-absolute">
                    <div class="object object_one"></div>
                    <div class="object object_two"></div>
                    <div class="object object_three"></div>
                </div>
            </div>
        </div>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

        <div class="as-mainwrapper">
            <div class="bg-white">
                <!-- header start -->
                <header class="header-area">
                    <div class="header-top-area ptb-10 hidden-sm hidden-xs">
                        <div class="container">
                            <div class="row">
                               <div class="col-md-4">
                                    <div class="account-usd text-left">
                                        <ul>
                                            <li><a href="#">我的账号<i class="fa fa-angle-down"></i></a>
                                                <ul class="submenu-mainmenu">
                                                    <li><a href="/ShoppingMall/page/roleLogin.jsp"><i class="fa fa-circle"></i>登录</a></li>
                                                    <li><a href="/ShoppingMall/page/store/storePage.jsp"><i class="fa fa-circle"></i>我的首页</a></li>
                                                    <li><a href="/ShoppingMall/page/queryReportData.jsp"><i class="fa fa-circle"></i>查看报表</a></li>
                                                    <li><a href="/ShoppingMall/page/store/lookStoreInfo.jsp"><i class="fa fa-circle"></i>查看信息</a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </div>
                               </div>
                               <div class="col-md-4">
                                   <div class="social-icons text-center">
                                       <ul>
                                           <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                           <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                           <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                           <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                           <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                                       </ul>
                                   </div>
                               </div>
                               <div class="col-md-4">
                                    <div class="top-right">
                                        <div class="top-login-cart">
                                            <ul>
                                                <li class=" hidden-xs"><a href="/ShoppingMall/page/roleLogin.jsp">登录/注册</a></li>
                                    			<li><a href="/ShoppingMall/store/storeLookGood.do" target="_blank">浏览商品</a></li>
                                            </ul>
                                        </div>
                                   </div>    
                               </div>
                            </div>
                        </div>   
                    </div>
                    <div class="logo-info-area ptb-35">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-3 col-sm-6 col-xs-12">
                                    <div class="header-logo">
                                        <a href="index.html"><img src="img/logo/1.png" alt="shofixe"></a>
                                    </div>
                                </div>
                                <div class="col-md-3 hidden-sm hidden-xs">
                                    <div class="info">
                                        <div class="info-icon">

                                        </div>
                                        <div class="info-text">
                                            <h4>+86 1888888888</h4>
                                            <p>telphone</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 hidden-sm hidden-xs">
                                    <div class="info">
                                        <div class="info-icon">

                                        </div>
                                        <div class="info-text">
                                            <h4>hds@shofixe.com</h4>
                                            <p>You can mail us</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6 col-xs-12">
                                    <div class="search-box">
                                        <img src="/ShoppingMall/img/icon/search.png" alt="搜索" style="cursor: pointer" id="search">
                                        <form action="/ShoppingMall/store/queryGoodByName.do" id="searchForm" target="_blank" method="post">
                                            <input type="text" placeholder="搜索..." name="good_name">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mainmenu-area text-center hidden-sm hidden-xs">
                        <nav>
                            <div class="mainmenu">
                                <ul>
                                    <li><a href="/ShoppingMall/index.jsp">商城首页</a></li>
									<li><a href="/ShoppingMall/page/store/storePage.jsp">我的首页</a></li>
									<li><a href="/ShoppingMall/page/store/queryReportData.jsp">查看报表</a></li>
                                    <li><a href="/ShoppingMall/page/store/lookStoreInfo.jsp">我的信息</a></li>
                                </ul>
                            </div>
                        </nav>                  
                    </div>    
                    <!-- Mobile Menu Area start -->
                    <div class="mobile-menu-area">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <div class="mobile-menu">
                                        <nav id="dropdown">
                                            <ul>
                                                <li><a href="/ShoppingMall/index.jsp">商城首页</a></li>
												<li><a href="/ShoppingMall/page/store/storePage.jsp">我的首页</a></li>
												<li><a href="/ShoppingMall/page/store/queryReportData.jsp">查看报表</a></li>
                                   				<li><a href="/ShoppingMall/page/store/lookStoreInfo.jsp">我的信息</a></li>
                                            </ul>
                                        </nav>
                                    </div>					
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Mobile Menu Area end -->		   
                </header>
                <!-- header end -->
                <!-- banner start -->
                <div class="banner-area cart ptb-110">
                    <div class="container">  
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="banner-text text-center">
                                    <div class="banner-title">
                                        <h2 class="text-uppercase">ORDER</h2>
                                    </div>
                                    <div class="breadcrumbs">
                                        <ul>
                                            <li class="text-capitalize"><a href="/ShoppingMall/index.jsp">商城首页</a> ></li>
                                            <li class="text-capitalize"><a href="/ShoppingMall/store/storeLookGood.do">浏览商品</a> ></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- banner end -->
                <!-- cart start -->
                <div class="cart-area-start mt-90">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12 col-sm-12">
                                <div class="cart-tab-menu section-tab-menu pb-50 text-center">
                                    <ul>
                                        <li class="text-uppercase"><a href="/ShoppingMall/store/storeLookWaitDeliver.do">待发货</a></li>
                                        <li class="text-uppercase"><a href="/ShoppingMall/store/storeLookWaitReceipt.do">待收货</a></li>
                                        <li class="text-uppercase"><a href="/ShoppingMall/store/storeLookWaitAssess.do">待评价</a></li>
                                        <li class="text-uppercase"><a href="/ShoppingMall/store/storeLookWaitBackMoney.do">待退款</a></li>
                                        <li class="text-uppercase"><a href="/ShoppingMall/store/storeLookBackMoney.do">已退款</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                    <div class="cart-table table-responsive">
                                        <table>
                                            <thead>
                                                <tr>
                                                    <th class="p-name">用户名</th>
                                                    <th class="p-amount">下单时间</th>
                                                    <th class="p-quantity">订单状态</th>
                                                    <th class="p-total">总价</th>
                                                </tr>
                                            </thead>
                                            <tbody class="pt-30">
                                               <c:forEach items="${requestScope.storeLookWaitDeliver}" var="storeLookOrder">
                                                <tr>
                                                    <td class="p-name">
                                                        ${storeLookOrder.user_name}
                                                    </td>
                                                    <td class="p-amount"><span class="amount">${storeLookOrder.order_time }</span></td>
                                                    <td class="p-quantity">
                                                    <span>
                                                    	<c:choose>
                                                    		<c:when test="${storeLookOrder.order_state=='0'}">
                                                    			待付款
                                                    		</c:when>
                                                    		<c:when test="${storeLookOrder.order_state=='1'}">
                                                    			待发货
                                                    		</c:when>
                                                    		<c:when test="${storeLookOrder.order_state=='2'}">
                                                    			待收货
                                                    		</c:when>
                                                    		<c:when test="${storeLookOrder.order_state=='3'}">
                                                    			待评价
                                                    		</c:when>
                                                    		<c:when test="${storeLookOrder.order_state=='4'}">
                                                    			待退款
                                                    		</c:when>
                                                    		<c:when test="${storeLookOrder.order_state=='5'}">
                                                    			已退款
                                                    		</c:when>
                                                    		<c:when test="${storeLookOrder.order_state=='Y'}">
                                                    			已完成
                                                    		</c:when>
                                                    	</c:choose>
                                                    </span>
                                                    </td>
                                                    <td class="p-total">${storeLookOrder.order_money} <a href="/ShoppingMall/store/deleteOrderById.do?order_id=${storeLookOrder.order_id}"><i class="fa fa-trash"></i></a></td>
                                                    <td>
                                                    	<form action="/ShoppingMall/store/lookOrderLine.do" method="post">
                                                    		<input name="order_id" value="${storeLookOrder.order_id}" hidden="hidden">
                                                    		<input type="submit" value="查看详情"/>
                                                    	</form>
                                                    </td>
                                                </tr>
                                               </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                            </div>
                        </div>
                        
                <!-- client area end -->
                <!-- service area end -->
                <div class="service-area mb-10">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-3 col-sm-4 col-xs-12">
                                <div class="single-service text-center">
                                    <div class="single-service-content ptb-40">
                                        <div class="single-service-icon-wrapper">
                                            <div class="single-service-icon">
                                                <img src="/ShoppingMall/img/icon/5.png" alt="">
                                            </div>
                                        </div>    
                                        <div class="single-service-info">
                                            <h4 class="text-uppercase">free shipping</h4>
                                            <p>Free for all product</p>
                                        </div> 
                                    </div>
                                </div>
                            </div> 
                            <div class="col-md-3 col-sm-4 col-xs-12">   
                                <div class="single-service text-center">
                                    <div class="single-service-content ptb-40">
                                        <div class="single-service-icon-wrapper">
                                            <div class="single-service-icon">
                                                <img src="/ShoppingMall/img/icon/7.png" alt="">
                                            </div>
                                        </div>    
                                        <div class="single-service-info">
                                            <h4 class="text-uppercase">order online</h4>
                                            <p>www.shofixe.com</p>
                                        </div>
                                    </div>    
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-4 col-xs-12">    
                                <div class="single-service text-center">
                                    <div class="single-service-content ptb-40">
                                        <div class="single-service-icon-wrapper">
                                            <div class="single-service-icon">
                                                <img src="/ShoppingMall/img/icon/9.png" alt="">
                                            </div>
                                        </div>    
                                        <div class="single-service-info">
                                            <h4 class="text-uppercase">money back</h4>
                                            <p>money back guarantee</p>
                                        </div>
                                    </div>    
                                </div>
                            </div>
                            <div class="col-md-3 hidden-sm col-xs-12">    
                                <div class="single-service text-center">
                                    <div class="single-service-content ptb-40">
                                        <div class="single-service-icon-wrapper">
                                            <div class="single-service-icon">
                                                <img src="/ShoppingMall/img/icon/10.png" alt="">
                                            </div>
                                        </div>    
                                        <div class="single-service-info">
                                            <h4 class="text-uppercase">gift coupon</h4>
                                            <p>surprise gift coupon</p>
                                        </div>
                                    </div>    
                                </div>
                            </div>    
                        </div>
                    </div>
                </div>
                <!-- service area end -->
                <!-- touch area end -->
                <div class="touch-area ptb-90">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="touch-left">
                                    <div class="touch-logo mb-35">
                                        <img src="img/logo/2.png" alt="">
                                    </div>
                                    <div class="social-icon">
                                        <ul>
                                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                            <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                                            <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                            <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="touch-right">
                                    <h2 class="text-uppercase">与我联系</h2>
                                    <form id="contact-form" action="mail.do" method="post">
                                        <input type="text" placeholder="在这输入您的名字..." name="name">
                                        <input type="text" placeholder="在这输入电子邮件地址..." name="email">
                                        <textarea class="mtb-25" cols="30" rows="10" placeholder="在这输入反馈信息..." name="message"></textarea>
                                        <button class="section-button" type="submit">发送</button>
                                    </form>
                                    <p class="form-message"></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>    
                <!-- touch area end -->
                <!-- footer start -->
                <footer class="footer-area">
                    <div class="footer-middle-area ptb-60">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-4 col-sm-6 col-xs-12">
                                    <div class="footer-widget">
                                        <h5>联系方式</h5>
                                        <div class="single-footer-contact">
                                            <div class="footer-icon">
                                                <i class="fa fa-map-marker"></i>
                                            </div>
                                            <div class="footer-contact-info">
                                                <p>天界花果山 </p>
                                                <p>人间水帘洞</p>
                                            </div>
                                        </div>
                                        <div class="single-footer-contact">
                                            <div class="footer-icon">
                                                <i class="fa fa-phone"></i>
                                            </div>
                                            <div class="footer-contact-info">
                                                <p>电话 : (801) 4256  9856</p>
                                                <p>电话 : (801) 4256  9658</p>
                                            </div>
                                        </div>
                                        <div class="single-footer-contact">
                                            <div class="footer-icon">
                                                <i class="fa fa-globe"></i>
                                            </div>
                                            <div class="footer-contact-info">
                                                <p>电子邮箱 : <a href="#">admin@power-boosts.com</a></p>
                                                <p>网址 : <a href="http://www.taobao.com/">www.gyweb.com</a></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-xs-12">
                                    <div class="footer-widget">
                                        <h5>公司</h5>
                                        <ul>
                                            <li><a href="index.html"><i class="fa fa-circle"></i>首页</a></li>
                                            <li><a href="#"><i class="fa fa-circle"></i>关于我们</a></li>
                                            <li><a href="contact.html"><i class="fa fa-circle"></i>联系我们</a></li>
                                            <li><a href="#"><i class="fa fa-circle"></i>我们的博客</a></li>
                                            <li><a href="#"><i class="fa fa-circle"></i>支持中心</a></li>
                                            <li><a href="#"><i class="fa fa-circle"></i>隐私权政策</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-md-3 hidden-sm col-xs-12">
                                    <div class="footer-widget">
                                        <h5>支持</h5>
                                        <ul>
                                            <li><a href="#"><i class="fa fa-circle"></i>传递信息</a></li>
                                            <li><a href="#"><i class="fa fa-circle"></i>订单跟踪</a></li>
                                            <li><a href="#"><i class="fa fa-circle"></i>产品收益</a></li>
                                            <li><a href="#"><i class="fa fa-circle"></i>礼品卡</a></li>
                                            <li><a href="#"><i class="fa fa-circle"></i>送货上门</a></li>
                                            <li><a href="#"><i class="fa fa-circle"></i>在线支持</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-md-2 col-sm-3 col-xs-12">
                                    <div class="footer-widget">
                                        <h5>信息</h5>
                                        <ul>
                                            <li><a href="#"><i class="fa fa-circle"></i>付款选项</a></li>
                                            <li><a href="#"><i class="fa fa-circle"></i>航空运输</a></li>
                                            <li><a href="checkout.html"><i class="fa fa-circle"></i>结算</a></li>
                                            <li><a href="#"><i class="fa fa-circle"></i>优惠</a></li>
                                            <li><a href="#"><i class="fa fa-circle"></i>网站地图</a></li>
                                            <li><a href="#"><i class="fa fa-circle"></i>服务</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="footer-bottom-area ptb-25">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-4 col-sm-6">
                                    <div class="copyright">
                                        <p>Copyright &copy; 2017.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">ç½é¡µ</a></p>
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-6">
                                    <div class="footer-menu text-center">
                                        <nav>
                                            <ul>
                                                <li><a href="">网址地图</a></li>
                                                <li><a href="contact.html">联系我们</a></li>
                                                <li class="hidden-md hidden-xs"><a href="#">购物列表</a></li>
                                                <li><a href="#">通讯</a></li>
                                            </ul>
                                        </nav>
                                    </div>
                                </div>
                                <div class="col-md-4 hidden-sm">
                                    <div class="payment text-right">
                                        <img src="img/payment/1.png" alt="">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </footer>
                <!-- footer end -->
            </div>    
        </div>    
        
        <!-- Color Switcher -->
        <div class="ec-colorswitcher">
            <a class="ec-handle" href="#"><i class="zmdi zmdi-settings"></i></a>
            <h3>风格切换</h3>
            <div class="ec-switcherarea">
                <h6>选择布局</h6>
                <div class="layout-btn">
                    <a href="#" class="ec-boxed"><span>盒子布局</span></a>
                    <a href="#" class="ec-wide"><span>宽度布局</span></a>
                </div>
                <h6>选择颜色</h6>
                <ul class="ec-switcher">
                    <li><a href="#" class="cs-color-1 styleswitch" data-rel="color-one"></a></li>
                    <li><a href="#" class="cs-color-2 styleswitch" data-rel="color-two"></a></li>
                    <li><a href="#" class="cs-color-3 styleswitch" data-rel="color-three"></a></li>
                    <li><a href="#" class="cs-color-4 styleswitch" data-rel="color-four"></a></li>
                    <li><a href="#" class="cs-color-5 styleswitch" data-rel="color-five"></a></li>
                    <li><a href="#" class="cs-color-6 styleswitch" data-rel="color-six"></a></li>
                    <li><a href="#" class="cs-color-7 styleswitch" data-rel="color-seven"></a></li>
                    <li><a href="#" class="cs-color-8 styleswitch" data-rel="color-eight"></a></li>
                    <li><a href="#" class="cs-color-9 styleswitch" data-rel="color-nine"></a></li>
                    <li><a href="#" class="cs-color-10 styleswitch" data-rel="color-ten"></a></li>
                </ul>
                <div class="ec-pattren">
                    <h6>选择模式</h6>
                    <div class="pattren-wrap">
                        <a href="#" data-rel="pattren1" class="styleswitch"><img src="img/ec-pattren/pattren1.jpg" alt=""></a>
                        <a href="#" data-rel="pattren2" class="styleswitch"><img src="img/ec-pattren/pattren2.jpg" alt=""></a>
                        <a href="#" data-rel="pattren3" class="styleswitch"><img src="img/ec-pattren/pattren3.jpg" alt=""></a>
                        <a href="#" data-rel="pattren4" class="styleswitch"><img src="img/ec-pattren/pattren4.jpg" alt=""></a>
                        <a href="#" data-rel="pattren5" class="styleswitch"><img src="img/ec-pattren/pattren5.jpg" alt=""></a>
                    </div>
                </div>
                <div class="ec-background">
                    <h6>选择背景</h6>
                    <div class="background-wrap">
                        <a href="#" data-rel="background1" class="styleswitch"><img src="img/ec-background/bg-1.jpg" alt=""></a>
                        <a href="#" data-rel="background2" class="styleswitch"><img src="img/ec-background/bg-2.jpg" alt=""></a>
                        <a href="#" data-rel="background3" class="styleswitch"><img src="img/ec-background/bg-3.jpg" alt=""></a>
                        <a href="#" data-rel="background4" class="styleswitch"><img src="img/ec-background/bg-4.jpg" alt=""></a>
                        <a href="#" data-rel="background5" class="styleswitch"><img src="img/ec-background/bg-5.jpg" alt=""></a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Color Switcher end -->	
       	<!-- jquery
		============================================ -->		
        <script src="/ShoppingMall/js/vendor/jquery-1.12.4.min.js"></script>
		<!-- bootstrap JS
		============================================ -->		
        <script src="/ShoppingMall/js/bootstrap.min.js"></script>		
		<!-- meanmenu JS
		============================================ -->		
        <script src="/ShoppingMall/js/jquery.meanmenu.js"></script>
		<!-- wow JS
		============================================ -->		
        <script src="/ShoppingMall/js/wow.min.js"></script>
		<!-- owl.carousel JS
		============================================ -->		
        <script src="/ShoppingMall/js/owl.carousel.min.js"></script>
		<!-- counterdown JS
		============================================ -->		
        <script src="/ShoppingMall/js/jquery.countdown.min.js"></script>
        <!-- Video Player JS
		============================================ -->		
        <script src="/ShoppingMall/js/jquery.mb.YTPlayer.js"></script>
        <!-- AJax Chimp JS
        ============================================ -->		
        <script src="/ShoppingMall/js/jquery.ajaxchimp.min.js"></script>
		<!-- price slider JS
		============================================ -->		
        <script src="/ShoppingMall/js/jquery-price-slider.js"></script> 
		<!-- elevator JS
		============================================ -->		
        <script src="/ShoppingMall/js/jquery.elevateZoom-3.0.8.min.js"></script> 
		<!-- scrollUp JS
		============================================ -->		
        <script src="/ShoppingMall/js/jquery.scrollUp.min.js"></script>
		<!-- plugins JS
		============================================ -->		
        <script src="/ShoppingMall/js/plugins.js"></script>
   		<!-- Nevo Slider js
		============================================ -->         
		<script type="text/javascript" src="/ShoppingMall/lib/custom-slider/js/jquery.nivo.slider.js"></script>
        <script type="text/javascript" src="/ShoppingMall/lib/custom-slider/home.js"></script>          		 
		<!-- textillate js
		============================================ -->         
        <script src="/ShoppingMall/js/jquery.textillate.js"></script>      		 
        <script src="/ShoppingMall/js/jquery.lettering.js"></script>  
        <!-- animated headline js
		============================================ -->         
        <script src="/ShoppingMall/js/animate-heading.js"></script>  
        <!-- ajax js
		============================================ -->         
        <script src="/ShoppingMall/js/ajax-mail.js"></script>     		 
		<!-- main JS
		============================================ -->		
        <script src="/ShoppingMall/js/styleswitch.js"></script>	
        <script src="/ShoppingMall/js/main.js"></script>
    </body>
</html>

