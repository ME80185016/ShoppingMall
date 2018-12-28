<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>购物商城首页</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--导入所需css文件-->
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
        		/* var list=document.getElementById("goods1").getElementsByTagName("a");
        		for(var i=0;i<list.length;i++){
        			list[i].onclick=function(){
        				alert("goods1为超链接添加点击事件");
        				if('${sessionScope.currvalRole}'==null||'${currvalRole}'==""){
        					list[i].href="/ShoppingMall/page/roleLogin.jsp";
        					alert(list[i].href);
        				}
        			}
        		} */
        		
        	}
        	
        </script>
    </head>
    <body>

         

        <!-- Pre Loader
        ============================================ -->
        <div class="preloader">
            <div class="loading-center">
                <div class="loading-center-absolute">
                    <div class="object object_one"></div>
                    <div class="object object_two"></div>
                    <div class="object object_three"></div>
                </div>
            </div>
        </div>

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
                                                	<c:choose>
                                                		<c:when test="${sessionScope.currvalRole!=null }">
                                                			<img src="${sessionScope.currvalRole.role_head}" alt="头像"/>
                                                			<span>${sessionScope.currvalRole.role_name }</span>
                                                		</c:when>
                                                		<c:otherwise>
                                                			<li><a href="/ShoppingMall/page/roleLogin.jsp"><i class="fa fa-circle"></i>登录</a></li>
                                                		</c:otherwise>
                                                	</c:choose>
                                                    <c:choose>
                                                		<c:when test="${sessionScope.currvalRole!=null&&sessionScope.currvalRole.role_type=='2'}">
                                                			<li><a href="/ShoppingMall/page/user/userPage.jsp"><i class="fa fa-circle"></i>我的首页</a></li>
                                                    		<li><a href="/ShoppingMall/user/userLookOrder.do"><i class="fa fa-circle"></i>我的订单</a></li>
                                                    		<li><a href="/ShoppingMall/user/userLookShoppingCar.do"><i class="fa fa-circle"></i>购物车</a></li>
                                                    		<li><a href="/ShoppingMall/page/user/lookUserInfo.jsp"><i class="fa fa-circle"></i>修改信息</a></li>
                                                		</c:when>
                                                		<c:when test="${sessionScope.currvalRole!=null&&sessionScope.currvalRole.role_type=='1'}">
                                                			<li><a href="/ShoppingMall/page/store/storePage.jsp"><i class="fa fa-circle"></i>我的首页</a></li>
                                                    		<li><a href="/ShoppingMall/store/storeLookOrder.do"><i class="fa fa-circle"></i>我的订单</a></li>
                                                    		<li><a href="/ShoppingMall/page/store/lookStoreInfo.jsp"><i class="fa fa-circle"></i>修改信息</a></li>
                                                		</c:when>
                                                		<c:when test="${sessionScope.currvalRole!=null&&sessionScope.currvalRole.role_type=='0'}">
                                                			<li><a href="/ShoppingMall/page/admin/adminPage.jsp"><i class="fa fa-circle"></i>我的首页</a></li>
                                                    		<li><a href="/ShoppingMall/admin/adminLookStore.do"><i class="fa fa-circle"></i>浏览店铺</a></li>
                                                    		<li><a href="/ShoppingMall/admin/adminLookGood.do"><i class="fa fa-circle"></i>浏览商品</a></li>
                                                    		<li><a href="/ShoppingMall/admin/loginOut.do"><i class="fa fa-circle"></i>退出登录</a></li>
                                                		</c:when>
                                                		<c:otherwise>
                                                			<li><a href="/ShoppingMall/page/roleLogin.jsp"><i class="fa fa-circle"></i>我的首页</a></li>
                                                    		<li><a href="/ShoppingMall/page/roleLogin.jsp"><i class="fa fa-circle"></i>我的订单</a></li>
                                                    		<li><a href="/ShoppingMall/page/roleLogin.jsp"><i class="fa fa-circle"></i>购物车</a></li>
                                                   			 <li><a href="/ShoppingMall/page/roleLogin.jsp"><i class="fa fa-circle"></i>修改信息</a></li>
                                                		</c:otherwise>
                                                	</c:choose>
                                                    
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
                                            		
                                            		<c:choose>
                                                		<c:when test="${sessionScope.currvalRole!=null }">
                                                			<img src="${sessionScope.currvalRole.role_head}" alt="头像"/>
                                                			<span style="color: white">${sessionScope.currvalRole.role_name }</span>
                                                			<li class=" hidden-xs"><a href="/ShoppingMall/index.jsp">返回首页</a></li> 
                                                		</c:when>
                                                		<c:otherwise>
															<li class=" hidden-xs"><a href="/ShoppingMall/page/roleLogin.jsp">登录/注册</a></li> 
															<li class=" hidden-xs"><a href="/ShoppingMall/index.jsp">返回首页</a></li> 
														</c:otherwise>
                                                	</c:choose>
                                                	<c:choose>
                                                		<c:when test="${sessionScope.currvalRole!=null&&sessionScope.currvalRole.role_type=='2'}">
                                                			<li class=" hidden-xs"><a href="/ShoppingMall/user/userLookCollectGood.do">收藏夹</a></li>
                                                			<li><a href="/ShoppingMall/user/userLookShoppingCar.do">购物车</a></li>
                                                			<li><a href="/ShoppingMall/user/loginOut.do">退出登录</a></li>
                                                		</c:when>
                                                		<c:when test="${sessionScope.currvalRole!=null&&sessionScope.currvalRole.role_type=='1'}">
                                                			<li class=" hidden-xs"><a href="/ShoppingMall/store/storeLookGood.do">我的商品</a></li>
                                                			<li><a href="/ShoppingMall/store/storeLookWaitDeliver.do" target="_blank"><img src="img/icon/cart_red.png" alt="cart">新订单</a></li>
                                                			<li class=" hidden-xs"><a href="/ShoppingMall/page/store/queryReportData.jsp">月度报表</a></li>
                                                			<li><a href="/ShoppingMall/store/loginOut.do">退出登录</a></li>
                                                		</c:when>
                                                		<c:when test="${sessionScope.currvalRole!=null&&sessionScope.currvalRole.role_type=='0'}">
                                                			<li class=" hidden-xs"><a href="/ShoppingMall/admin/adminLookGood.do">浏览商品</a></li>
                                                			<li class=" hidden-xs"><a href="/ShoppingMall/admin/adminLookStore.do">浏览店铺</a></li>
                                                			<li><a href="/ShoppingMall/admin/loginOut.do">退出登录</a></li>
                                                		</c:when>
                                                		<c:otherwise>
															<li class="hidden-xs"><a href="/ShoppingMall/page/roleLogin.jsp">收藏夹</a></li>
                                                			<li><a href="/ShoppingMall/page/roleLogin.jsp">购物车</a></li>
                                                			<li><a href="/ShoppingMall/page/store/storeRegist.jsp">店铺注册</a></li>
														</c:otherwise>
                                                	</c:choose>
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
                                    <div class="search-box">
                                        <img src="img/icon/search.png" alt="搜索" style="cursor: pointer" id="search">
                                        <form action="/ShoppingMall/user/queryGoodByName.do" id="searchForm" target="_blank" method="post">
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
									<li><a href="/ShoppingMall/user/userLookStore.do" target="_blank">浏览店铺</a></li>
                                    <li><a href="/ShoppingMall/user/userLookGood.do" target="_blank">浏览商品</a></li>
									<c:choose>
										<c:when test="${sessionScope.currvalRole!=null}">
											<li><a href="/ShoppingMall/user/userLookShoppingCar.do" target="_blank">购物车</a></li>
											<li><a href="/ShoppingMall/user/userLookCollectGood.do" target="_blank">收藏夹</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="/ShoppingMall/page/roleLogin.jsp">购物车</a></li>
											<li><a href="/ShoppingMall/page/roleLogin.jsp">收藏夹</a></li>
										</c:otherwise>
									</c:choose>
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
												<li><a href="shop.html">浏览店铺</a></li>
												<li><a href="cart.html">浏览商品</a></li>
												<c:choose>
													<c:when test="${sessionScope.currvalRole!=null}">
														<li><a href="/ShoppingMall/user/userLookShoppingCar.do">购物车</a></li>
														<li><a href="/ShoppingMall/user/userLookCollectGood.do">收藏夹</a></li>
													</c:when>
													<c:otherwise>
														<li><a href="/ShoppingMall/page/roleLogin.jsp">购物车</a></li>
														<li><a href="/ShoppingMall/page/roleLogin.jsp">收藏夹</a></li>
													</c:otherwise>
												</c:choose>
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
                 <!-- slider start -->
                <div class="slider-wrap">
                    <div class="preview-2">
                        <div id="nivoslider" class="slides"> 
                             <img src="img/slider/1.jpg" alt="" title="#slider-direction-1"  />
                             <img src="img/slider/2.jpg" alt="" title="#slider-direction-2"  />
                        </div>
                        <!-- direction 1 -->
                        <div id="slider-direction-1" class="slider-direction">
                            <div class="banner-content">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="nivo_text">       
                                                <div class="nivo_text-wrapper">       
                                                    <div class="slider-content slider-text-1 text-left">
                                                        <div class="wow bounceInDown" data-wow-duration="3s" data-wow-delay="0.3s">
                                                            <h2>独家珍藏</h2>
                                                        </div>
                                                    </div>     
                                                    <div class="slider-content slider-text-2 text-left hidden-xs">
                                                        <div class="wow bounceInDown" data-wow-duration="3s" data-wow-delay="0.3s">
                                                            <h1>男士T恤</h1>
                                                        </div>
                                                    </div>     
                                                    <div class="slider-content slider-text-3 text-left hidden-xs">
                                                        <div class="wow bounceInDown" data-wow-duration="3s" data-wow-delay="0.3s">
                                                            <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie<br> 
                                                            consequat  vel illum dolore eu feugiat nulla facilisis at vero eros.</p>
                                                        </div>
                                                    </div>
                                                    <div class="slider-content slider-text-4 text-left hidden-sm hidden-xs">
                                                        <div class="wow bounceInUp" data-wow-duration="3s" data-wow-delay="1s">
                                                            <a href='/ShoppingMall/user/lookGoodLine.do?good_id=88' class='slider-button'>立即查看</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>    
                                        </div>
                                    </div>            
                                </div>    
                            </div>    
                        </div>
                        <!-- direction 2 -->
                        <div id="slider-direction-2" class="slider-direction">
                           <div class="banner-content">
                               <div class="container">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="nivo_text">       
                                                <div class="nivo_text-wrapper">       
                                                    <div class="slider-content slider-text-1 text-left">
                                                        <div class="wow bounceInDown" data-wow-duration="3s" data-wow-delay="0.3s">
                                                            <h2 class="text-uppercase">全新风尚</h2>
                                                        </div>
                                                    </div>     
                                                    <div class="slider-content slider-text-2 text-left hidden-xs">
                                                        <div class="wow bounceInDown" data-wow-duration="3s" data-wow-delay="0.3s">
                                                            <h1 class="text-uppercase">for women - 2018 </h1>
                                                        </div>
                                                    </div>     
                                                    <div class="slider-content slider-text-3 text-left hidden-xs">
                                                        <div class="wow bounceInDown" data-wow-duration="3s" data-wow-delay="0.3s">
                                                            <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie 
            													consequat  vel illum dolore eu feugiat nulla facilisis at vero eros.</p>
                                                        </div>
                                                    </div>
                                                    <div class="slider-content slider-text-4 text-left hidden-sm hidden-xs">
                                                        <div class="wow bounceInUp" data-wow-duration="3s" data-wow-delay="1s">
                                                            <a href='/ShoppingMall/user/lookGoodLine.do?good_id=89' class='slider-button'>立即查看</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>    
                                        </div>
                                    </div>
                                </div>  
                            </div>      
                        </div>
                    </div>
                </div>
                <!-- slider end -->
                <!-- slider bottom start -->
                <div class="slider-bottom-area mt-10 text-left">
                    <div class="container-fluid">
                        <div class="row">
                               
                        </div>
                    </div>
                </div>
                <!--slider bottom end -->
                <!-- arrival start-->
                <div class="arrival-area clearfix pt-90" id="goods1">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="section-tab">
                                    <div class="section-tab-menu text-center mb-45">
                                        <ul role="tablist">
                                            <li role="presentation" class="active text-uppercase"><a href="#new" aria-controls="new" role="tab" data-toggle="tab">新品上市</a></li>
                                            <li role="presentation" class="text-uppercase"><a href="#featured" aria-controls="featured" role="tab" data-toggle="tab">特色</a></li>
                                            <li role="presentation" class="text-uppercase"><a href="#best" aria-controls="best" role="tab" data-toggle="tab">畅销</a></li>
                                        </ul>
                                    </div>
                                    <div class="clearfix"></div>
                                    <div class="tab-content row">
                                        <div id="new" role="tabpanel" class="active section-tab-item">
                                            <div class="tab-item-slider">
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item clearfix">
                                                            <div class="single-product-img clearfix">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=107">
                                                                    <img class="primary-image" src="img/product/1.jpg" alt="product">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>新品上架：欧美风男士T恤，站在时尚前沿的男人</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=107&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=107" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=107" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>  
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=107">欧美风男士T恤</a></h3>  
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=69">
                                                                    <img class="primary-image" src="img/product/2.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>新品上架：让你领略维密女模的魅力 </p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=69&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=69" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=69" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">   
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$130</span>
                                                                    <span class="old-price">$150</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=69">女士无袖连衣短裙</a></h3>  
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=70">
                                                                    <img class="primary-image" src="img/product/3.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>新品上架：青少年韩版流行T恤</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=70&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=70" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=70" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">     
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=70">青少年韩版流行T恤</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=71">
                                                                    <img class="primary-image" src="img/product/4.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>新品上架：中年妇女长袖宽大外套</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=71&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=71" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=71" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div>  
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=71">中年妇女宽大长袖外套</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix">
                                                                <a href="#">
                                                                    <img class="primary-image" src="img/product/5.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>新品上架：成熟男人必备，凸显男士魅力衬衣</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=72&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=72" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=72" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$100</span>
                                                                    <span class="old-price">$130</span>
                                                                </div>  
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=72">成熟男士衬衣</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=107">
                                                                    <img class="primary-image" src="img/product/1.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>新品上架：欧美风男士T恤，站在时尚前沿的男人</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=107&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=107" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=107" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div>      
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=107">欧美风男士T恤</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=69">
                                                                    <img class="primary-image" src="img/product/2.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>新品上架：让你领略维密女模的魅力</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=69&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=69" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=69" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating"> 
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div>     
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=69">女士无袖连衣短裙</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=70">
                                                                    <img class="primary-image" src="img/product/3.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>新品上架：青少年韩版流行T恤</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=70&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=70" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=70" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating"> 
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$100</span>
                                                                    <span class="old-price">$130</span>
                                                                </div>       
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=70">青少年韩版流行T恤</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="featured" role="tabpanel" class="section-tab-item">
                                            <div class="tab-item-slider">
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=72">
                                                                    <img class="primary-image" src="img/product/5.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>特色商品：成熟男人魅力衬衣 </p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=72&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=72" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=72" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating"> 
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div>     
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=72">成熟男人魅力衬衣</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=71">
                                                                    <img class="primary-image" src="img/product/4.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>特色商品：中年妇女宽大长袖外套</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=71&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=71" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=71" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">   
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$130</span>
                                                                    <span class="old-price">$150</span>
                                                                </div>       
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=71">中年妇女宽大长袖外套</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=70">
                                                                    <img class="primary-image" src="img/product/3.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>特色商品：青少年韩版流行T恤</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=70&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=70" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=70" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">     
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div>     
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=70">青少年韩版流行T恤</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=69">
                                                                    <img class="primary-image" src="img/product/2.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>特色商品：让你领略维密女模的魅力</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=69&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=69" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=69" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div>    
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=69">女士无袖连衣短裙</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=107">
                                                                    <img class="primary-image" src="img/product/1.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>特色商品：欧美风男士T恤，站在时尚前沿的男人</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=107&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=107" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=107" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating"> 
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$130</span>
                                                                    <span class="old-price">$150</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=107">欧美风男士T恤</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=72">
                                                                    <img class="primary-image" src="img/product/5.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>特色商品：成熟男人魅力衬衣</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=72&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=72" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=72" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating"> 
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div>  
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=72">成熟男人魅力衬衣</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=71">
                                                                    <img class="primary-image" src="img/product/4.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>特色商品：中年妇女宽大长袖外套</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=71&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=71" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=71" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating"> 
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$130</span>
                                                                    <span class="old-price">$150</span>
                                                                </div>        
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=71">中年妇女宽大长袖外套</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=70">
                                                                    <img class="primary-image" src="img/product/3.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>特色商品：青少年韩版流行T恤</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=70&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=70" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=70" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating"> 
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div>      
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=70">青少年韩版流行T恤</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="best" role="tabpanel" class="section-tab-item">
                                            <div class="tab-item-slider">
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=69">
                                                                    <img class="primary-image" src="img/product/2.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>畅销商品：让你领略维密女模的魅力</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=69&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=69" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=69" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating"> 
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                 </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div>      
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=69">女士无袖连衣短裙</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=71">
                                                                    <img class="primary-image" src="img/product/4.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>畅销商品：中年妇女宽大长袖外套</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=71&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=71" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=71" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating"> 
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$130</span>
                                                                    <span class="old-price">$150</span>
                                                                </div>     
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=71">中年妇女宽大长袖外套</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=107">
                                                                    <img class="primary-image" src="img/product/1.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>畅销商品：欧美风男士T恤，站在时尚前沿的男人</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=107&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=107" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=107" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating"> 
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div>      
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=107">欧美风男士T恤</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div> 
                                                <div class="col-xs-12 col-width">    
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=70">
                                                                    <img class="primary-image" src="img/product/3.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>畅销商品：青少年韩版流行T恤</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=70&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=70" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=70" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating"> 
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div>     
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=70">青少年韩版流行T恤</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=72">
                                                                    <img class="primary-image" src="img/product/5.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>畅销商品：成熟男人魅力衬衣</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=72&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=72" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=72" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating"> 
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div>  
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=72">成熟男人魅力衬衣</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=69">
                                                                    <img class="primary-image" src="img/product/2.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>畅销商品：让你领略维密女模的魅力</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=69&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=69" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=69" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating"> 
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div>     
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=69">女士无袖连衣短裙</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div> 
                                                <div class="col-xs-12 col-width"> 
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=71">
                                                                    <img class="primary-image" src="img/product/4.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p>畅销商品：中年妇女宽大长袖外套</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=71&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=71" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=71" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div>     
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=71">中年妇女宽大长袖外套</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>    
                                            </div>
                                        </div>    
                                    </div>     
                                </div>
                                <div class="arrival-button text-center mt-30">
                                    <a href='/ShoppingMall/user/userLookGood.do' class='section-button'>查看更多</a>
                                </div>    
                            </div>
                        </div>
                    </div>
                </div>
                <!-- arrival end -->
                <!-- featured start -->
                <div class="featured-area ptb-90" id="goods2">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="section-tab">
                                    <div class="section-tab-menu mb-45 text-center">
                                        <ul role="tablist">
                                            <li role="presentation" class="active text-uppercase"><a href="#featured1" aria-controls="featured1" role="tab" data-toggle="tab">特色</a></li>
                                            <li role="presentation" class="text-uppercase"><a href="#trendy" aria-controls="trendy" role="tab" data-toggle="tab">时尚</a></li>
                                            <li role="presentation" class="text-uppercase"><a href="#best1" aria-controls="best1" role="tab" data-toggle="tab">畅销</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-5 hidden-sm hidden-xs">
                                <div class="featured-left mt-2">
                                    <a href="#">
                                        <img src="img/product/b1.jpg" alt="">
                                    </a>
                                    <span class="red hidden-sm" style="margin-left: 35px">hot</span>
                                </div>
                                <div class="single-product-info clearfix">
                                    <div class="pro-title">  
                                    <h3><a href="#">唯美女士长裙</a></h3>  
                                    </div> 
                                    <div class="pro-price">
                                        <span class="new-price">$150</span>
                                        <span class="old-price">$180</span>
                                    </div>  
                                </div>
                            </div>
                            <div class="col-md-7">                      
                                <div class="clearfix"></div>
                                <div class="tab-content row">
                                    <div id="featured1" role="tabpanel" class="active section-tab-item">
                                        <div class="feature-slider">
                                            <div class="col-xs-12 col-width">  
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=74">
                                                                <img class="primary-image" src="img/product/6.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">橘黄色男士衬衣</p>
                                                                    <ul>
                                                                        	<li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=74&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=74" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=74" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=74">橘黄色男士衬衣</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="black hidden-sm">new</span>
                                                </div> 
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=127">
                                                                <img class="primary-image" src="img/product/9.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">女士点状花纹长裙</p>
                                                                    <ul>
                                                                        	<li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=127&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=127" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=127" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=127">点状花纹长裙</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="red hidden-sm">hot</span>
                                                </div>  
                                            </div>
                                            <div class="col-xs-12 col-width">
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=128">
                                                                <img class="primary-image" src="img/product/7.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">女士鲜艳大花吊带长裙</p>
                                                                    <ul>
                                                                        	<li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=128&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=128" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=128" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=128">鲜艳吊带长裙</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="black hidden-sm">new</span>
                                                    <!--<span class="red hidden-sm">hot</span>-->
                                                </div> 
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=148">
                                                                <img class="primary-image" src="img/product/10.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">青少年男士修身T恤</p>
                                                                    <ul>
                                                                        	<li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=148&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=148" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=148" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=148">男士修身T恤</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="green hidden-sm">sale</span>
                                                </div> 
                                            </div>
                                            <div class="col-xs-12 col-width">
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=149">
                                                                <img class="primary-image" src="img/product/8.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">男士圆领长袖秋衣</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=149&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=149" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=149" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=149">男士圆领秋衣</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="green hidden-sm">sale</span>
                                                </div>
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=150">
                                                                <img class="primary-image" src="img/product/11.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">女士修身横纹半袖</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=150&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=150" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=150" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=150">女士横纹半袖</a></h3>  
                                                            </div>  
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="black hidden-sm">new</span>
                                                </div> 
                                            </div>
                                            <div class="col-xs-12 col-width">  
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=74">
                                                                <img class="primary-image" src="img/product/6.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">橘黄色男士衬衣</p>
                                                                    <ul>
                                                                        	<li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=74&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=74" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=74" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=74">橘黄色男士衬衣</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="black hidden-sm">new</span>
                                                </div> 
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=127">
                                                                <img class="primary-image" src="img/product/9.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">女士点状花纹长裙</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=127&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=127" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=127" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=127">点状花纹长裙</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="red hidden-sm">hot</span>
                                                </div>  
                                            </div>
                                            <div class="col-xs-12 col-width">
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=128">
                                                                <img class="primary-image" src="img/product/7.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">女士鲜艳大花吊带长裙</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=128&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=128" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=128" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=128">鲜艳吊带长裙</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="black hidden-sm">new</span>
                                                    <!--<span class="red hidden-sm">hot</span>-->
                                                </div> 
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=148">
                                                                <img class="primary-image" src="img/product/10.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">青少年男士修身T恤</p>
                                                                    <ul>
                                                                        	<li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=148&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=148" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=148" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=148">男士修身T恤</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="green hidden-sm">sale</span>
                                                </div> 
                                            </div>
                                            <div class="col-xs-12 col-width">
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=149">
                                                                <img class="primary-image" src="img/product/8.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">男士圆领长袖秋衣</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=149&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=149" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=149" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=149">男士圆领秋衣</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="green hidden-sm">sale</span>
                                                </div>
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=150">
                                                                <img class="primary-image" src="img/product/11.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">女士修身横纹半袖</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=150&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=150" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=150" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=150">女士横纹半袖</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="black hidden-sm">new</span>
                                                </div> 
                                            </div>
                                        </div>
                                    </div>
                                    <div id="trendy" role="tabpanel" class="section-tab-item">
                                        <div class="feature-slider">
                                            <div class="col-xs-12 col-width">  
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=149">
                                                                <img class="primary-image" src="img/product/8.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">男士圆领长袖秋衣</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=149&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=149" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=149" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=149">男士圆领秋衣</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="black hidden-sm">new</span>
                                                </div> 
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=74">
                                                                <img class="primary-image" src="img/product/6.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">橘黄色男士衬衣</p>
                                                                    <ul>
                                                                         <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=74&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=74" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=74" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=74">橘黄色男士衬衣</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="red hidden-sm">hot</span>
                                                </div>  
                                            </div>
                                            <div class="col-xs-12 col-width">
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=150">
                                                                <img class="primary-image" src="img/product/11.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">女士修身横纹半袖</p>
                                                                    <ul>
                                                                         <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=150&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=150" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=150" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=150">女士横纹半袖</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <!--<span class="black hidden-sm">new</span>-->
                                                    <span class="red hidden-sm">hot</span>
                                                </div> 
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=74">
                                                                <img class="primary-image" src="img/product/6.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">橘黄色男士衬衣</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=74&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=74" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=74" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=74">橘黄色男士衬衣</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="green hidden-sm">sale</span>
                                                </div> 
                                            </div>
                                            <div class="col-xs-12 col-width">
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=149">
                                                                <img class="primary-image" src="img/product/8.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">男士圆领长袖秋衣</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=149&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=149" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=149" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=149">男士圆领秋衣</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="green hidden-sm">sale</span>
                                                </div>
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=127">
                                                                <img class="primary-image" src="img/product/9.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">女士点状花纹长裙</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=127&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=127" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=127" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=127">点状花纹长裙</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="black hidden-sm">new</span>
                                                </div> 
                                            </div>
                                            <div class="col-xs-12 col-width">  
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=149">
                                                                <img class="primary-image" src="img/product/8.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">男士圆领长袖秋衣</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=149&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=149" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=149" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=149">男士圆领秋衣</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="black hidden-sm">new</span>
                                                </div> 
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=74">
                                                                <img class="primary-image" src="img/product/6.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">橘黄色男士衬衣</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=74&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=74" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=74" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=74">橘黄色男士衬衣</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="red hidden-sm">hot</span>
                                                </div>  
                                            </div>
                                            <div class="col-xs-12 col-width">
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=150">
                                                                <img class="primary-image" src="img/product/11.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">女士修身横纹半袖</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=150&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=150" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=150" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=150">女士横纹半袖</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <!--<span class="black hidden-sm">new</span>-->
                                                    <span class="red hidden-sm">hot</span>
                                                </div> 
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=74">
                                                                <img class="primary-image" src="img/product/6.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">橘黄色男士衬衣</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=74&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=74" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=74" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=74">橘黄色男士衬衣</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="green hidden-sm">sale</span>
                                                </div> 
                                            </div>
                                            <div class="col-xs-12 col-width">
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=149">
                                                                <img class="primary-image" src="img/product/8.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">男士圆领长袖秋衣</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=149&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=149" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=149" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=149">男士圆领秋衣</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="green hidden-sm">sale</span>
                                                </div>
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=127">
                                                                <img class="primary-image" src="img/product/9.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">女士点状花纹长裙</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=127&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=127" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=127" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=127">点状花纹长裙</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="black hidden-sm">new</span>
                                                </div> 
                                            </div>
                                        </div>
                                    </div>
                                    <div id="best1" role="tabpanel" class="section-tab-item">
                                        <div class="feature-slider">
                                            <div class="col-xs-12 col-width">
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=149">
                                                                <img class="primary-image" src="img/product/8.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">男士圆领长袖秋衣</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=149&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=149" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=149" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=149">男士圆领秋衣</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="green hidden-sm">sale</span>
                                                </div>
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=150">
                                                                <img class="primary-image" src="img/product/11.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">女士修身横纹半袖</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=150&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=150" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=150" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=150">女士横纹半袖</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="black hidden-sm">new</span>
                                                </div> 
                                            </div>    
                                            <div class="col-xs-12 col-width">  
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=74">
                                                                <img class="primary-image" src="img/product/6.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">橘黄色男士衬衣</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=74&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=74" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=74" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=74">橘黄色男士衬衣</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="black hidden-sm">new</span>
                                                </div> 
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=127">
                                                                <img class="primary-image" src="img/product/9.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">女士点状花纹长裙</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=127&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=127" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=127" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=127">点状花纹长裙</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="red hidden-sm">hot</span>
                                                </div>  
                                            </div>
                                            <div class="col-xs-12 col-width">  
                                                <div class="single-product">
                                                    <div class="single-product-item">
                                                        <div class="single-product-img clearfix hover-effect">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=128">
                                                                <img class="primary-image" src="img/product/7.jpg" alt="">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">女士鲜艳大花吊带长裙</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=128&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=128" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=128" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-rating"> 
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                            </div>
                                                            <div class="pro-price">
                                                                <span class="new-price">$120</span>
                                                                <span class="old-price">$150</span>
                                                            </div>      
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=128">鲜艳吊带长裙</a></h3>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="single-product">
                                                    <div class="single-product-item">
                                                        <div class="single-product-img clearfix hover-effect">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=74">
                                                                <img class="primary-image" src="img/product/6.jpg" alt="">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">橘黄色男士衬衣</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=74&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=74" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=74" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-rating"> 
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                            </div>
                                                            <div class="pro-price">
                                                                <span class="new-price">$120</span>
                                                                <span class="old-price">$150</span>
                                                            </div>      
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=74">橘黄色男士衬衣</a></h3>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-12 col-width">
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=150">
                                                                <img class="primary-image" src="img/product/11.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">女士修身横纹半袖</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=150&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=150" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=150" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=150">女士横纹半袖</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <!--<span class="black hidden-sm">new</span>-->
                                                    <span class="red hidden-sm">hot</span>
                                                </div> 
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=148">
                                                                <img class="primary-image" src="img/product/10.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">青少年男士修身T恤</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=148&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=148" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=148" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=148">男士修身T恤</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="green hidden-sm">sale</span>
                                                </div> 
                                            </div>
                                            <div class="col-xs-12 col-width">
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=149">
                                                                <img class="primary-image" src="img/product/8.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">男士圆领长袖秋衣</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=149&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=149" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=149" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=149">男士圆领秋衣</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="green hidden-sm">sale</span>
                                                </div>
                                                <div class="single-product">
                                                    <div class="single-product-item clearfix">
                                                        <div class="single-product-img clearfix">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=150">
                                                                <img class="primary-image" src="img/product/9.jpg" alt="product">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">女士点状花纹长裙</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=150&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=150" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=150" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-title">  
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=150">点状花纹长裙</a></h3>  
                                                            </div> 
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                            </div>  
                                                        </div>
                                                    </div>
                                                    <span class="black hidden-sm">new</span>
                                                </div> 
                                            </div> 
                                            <div class="col-xs-12 col-width"> 
                                                <div class="single-product">
                                                    <div class="single-product-item">
                                                        <div class="single-product-img clearfix hover-effect">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=128">
                                                                <img class="primary-image" src="img/product/7.jpg" alt="">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">女士鲜艳大花吊带长裙</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=128&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=128" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=128" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-rating">
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                            </div>
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                                <span class="old-price">$180</span>
                                                            </div>     
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=128">鲜艳吊带长裙</a></h3>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="single-product">
                                                    <div class="single-product-item">
                                                        <div class="single-product-img clearfix hover-effect">
                                                            <a href="/ShoppingMall/user/lookGoodLine.do?good_id=148">
                                                                <img class="primary-image" src="img/product/10.jpg" alt="">
                                                            </a>
                                                            <div class="wish-icon-hover text-center clearfix">
                                                                <div class="hover-text">
                                                                    <p class="hidden-md">青少年男士修身T恤</p>
                                                                    <ul>
                                                                        <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=148&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=148" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=148" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                    </ul>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                        <div class="single-product-info clearfix">
                                                            <div class="pro-rating">
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                            </div>
                                                            <div class="pro-price">
                                                                <span class="new-price">$150</span>
                                                                <span class="old-price">$180</span>
                                                            </div>     
                                                            <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=148">男士修身T恤</a></h3>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>    
                                        </div>
                                    </div>    
                                </div>
                                <div class="arrival-button text-left">
                                    <a href='/ShoppingMall/user/userLookGood.do' class='section-button mt-30'>查看更多</a>
                                </div>    
                            </div>
                        </div>
                    </div>
                </div>
                <!-- featured end -->
                <!-- off banner area start -->
                <div class="off-banner-area">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="single-off-banner text-left">
                                <div class="off-img">
                                    <a href="#">
                                        <img src="img/off-banner/1.jpg" alt="">
                                    </a>
                                </div>
                                <div class="off-text">
                                    <h4 class="text-uppercase">GET 25% OFF</h4>
                                    <h2 class="text-uppercase">MEN’S </h2>
                                    <h4 class="text-uppercase">COLLECTION </h4>
                                    <a href="#" class="section-button">立即查看</a>
                                </div>
                            </div>
                            <div class="single-off-banner text-center">
                                <div class="off-img">
                                    <a href="#">
                                        <img src="img/off-banner/2.jpg" alt="">
                                    </a>
                                </div>
                                <div class="off-text">
                                    <h3 class="text-uppercase">EXCLUSIVE </h3>
                                    <h2 class="text-uppercase">MEN’S &amp; WOMEN's</h2>
                                    <h3 class="text-uppercase">COLLECTION </h3>
                                    <a href="#" class="section-button">立即查看</a>
                                </div>
                            </div>
                            <div class="single-off-banner text-left">
                                <div class="off-img">
                                    <a href="#">
                                        <img src="img/off-banner/3.jpg" alt="">
                                    </a>
                                </div>
                                <div class="off-text">
                                    <h4 class="text-uppercase">GET 25% OFF</h4>
                                    <h2 class="text-uppercase">WOMEN’S </h2>
                                    <h4 class="text-uppercase">COLLECTION </h4>
                                    <a href="#" class="section-button">立即查看</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="consultation-angle"></div>
                </div>
                <!-- off banner area end -->
                <!-- women area start -->
                <div class="women-area ptb-90">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="section-tab">
                                    <div class="section-tab-menu mb-45 text-center">
                                        <ul role="tablist">
                                            <li role="presentation" class="active text-uppercase"><a href="#dress" aria-controls="dress" role="tab" data-toggle="tab">连衣裙</a></li>
                                            <li role="presentation" class="text-uppercase"><a href="#tops" aria-controls="tops" role="tab" data-toggle="tab">吊带裙</a></li>
                                            <li role="presentation" class="text-uppercase"><a href="#handbags" aria-controls="handbags" role="tab" data-toggle="tab">长裙</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-7">                      
                                <div class="clearfix"></div>
                                    <div class="tab-content row">
                                        <div id="dress" role="tabpanel" class="active section-tab-item">
                                            <div class="feature-slider">
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item clearfix">
                                                            <div class="single-product-img clearfix">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=167">
                                                                    <img class="primary-image" src="img/product/12.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">天蓝色点状斑纹连衣裙</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=167&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=167" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=167" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>  
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=167">天蓝色连衣裙</a></h3>  
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=168">
                                                                    <img class="primary-image" src="img/product/13.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">玫瑰红典雅连衣裙</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=168&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=168" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=168" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">   
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$130</span>
                                                                    <span class="old-price">$150</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=168">玫瑰红连衣裙</a></h3>  
                                                            </div> 
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=169">
                                                                    <img class="primary-image" src="img/product/14.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">居家舒适休闲长袖外衣</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=169&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=169" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=169" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">     
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=169">居家休闲外衣</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=167">
                                                                    <img class="primary-image" src="img/product/12.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">天蓝色点状斑纹连衣裙</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=167&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=167" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=167" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div>  
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=167">天蓝色连衣裙</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=168">
                                                                    <img class="primary-image" src="img/product/13.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">玫瑰红典雅连衣裙</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=168&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=168" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=168" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$100</span>
                                                                    <span class="old-price">$130</span>
                                                                </div>  
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=168">玫瑰红连衣裙</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=169">
                                                                    <img class="primary-image" src="img/product/14.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">居家舒适休闲长袖外衣</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=169&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=169" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=169" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div>      
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=169">居家休闲外衣</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="tops" role="tabpanel" class="section-tab-item">
                                            <div class="feature-slider">
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item clearfix">
                                                            <div class="single-product-img clearfix">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=168">
                                                                    <img class="primary-image" src="img/product/13.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">玫瑰红典雅连衣裙</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=168&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=168" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=168" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>  
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=168">玫瑰红连衣裙</a></h3>  
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=167">
                                                                    <img class="primary-image" src="img/product/12.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">天蓝色点状斑纹连衣裙</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=167&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=167" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=167" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">   
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$130</span>
                                                                    <span class="old-price">$150</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=167">天蓝色连衣裙</a></h3>  
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=169">
                                                                    <img class="primary-image" src="img/product/14.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">居家舒适休闲长袖外衣</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=169&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=169" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=169" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">     
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=169">居家休闲外衣</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=169">
                                                                    <img class="primary-image" src="img/product/14.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">居家舒适休闲长袖外衣</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=169&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=169" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=169" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div>  
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=169">居家休闲外衣</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=167">
                                                                    <img class="primary-image" src="img/product/12.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">天蓝色点状斑纹连衣裙</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=167&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=167" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=167" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$100</span>
                                                                    <span class="old-price">$130</span>
                                                                </div>  
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=167">天蓝色连衣裙</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=168">
                                                                    <img class="primary-image" src="img/product/13.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">玫瑰红典雅连衣裙</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=168&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=168" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=168" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div>      
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=168">玫瑰红连衣裙</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="handbags" role="tabpanel" class="section-tab-item">
                                            <div class="feature-slider">
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item clearfix">
                                                            <div class="single-product-img clearfix">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=169">
                                                                    <img class="primary-image" src="img/product/14.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">居家舒适休闲长袖外衣</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=169&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=169" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=169" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>  
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=169">居家休闲外衣</a></h3>  
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=167">
                                                                    <img class="primary-image" src="img/product/12.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">天蓝色点状斑纹连衣裙</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=167&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=167" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=167" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">   
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$130</span>
                                                                    <span class="old-price">$150</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=167">天蓝色点状斑纹连衣裙</a></h3>  
                                                            </div> 
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=168">
                                                                    <img class="primary-image" src="img/product/13.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">玫瑰红典雅连衣裙</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=168&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=168" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=168" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">     
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=168">玫瑰红连衣裙</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=169">
                                                                    <img class="primary-image" src="img/product/14.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">居家舒适休闲长袖外衣 </p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=169&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=169" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=169" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div>  
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=169">居家休闲外衣</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=167">
                                                                    <img class="primary-image" src="img/product/12.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">天蓝色点状斑纹连衣裙</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=167&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=167" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=167" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$100</span>
                                                                    <span class="old-price">$130</span>
                                                                </div>  
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=167">天蓝色点状斑纹连衣裙</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=168">
                                                                    <img class="primary-image" src="img/product/13.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">玫瑰红典雅连衣裙</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=168&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=168" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=168" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div>      
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=168">玫瑰红连衣裙</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>    
                                    </div> 
                                <div class="arrival-button text-center mt-30">
                                    <a href='/ShoppingMall/user/userLookGood.do' class='section-button'>查看更多</a>
                                </div>    
                            </div>
                            <div class="col-md-5 hidden-sm hidden-xs">
                                <div class="featured-left mt-2 pull-right">
                                    <a href="#">
                                        <img src="img/product/b2.jpg" alt="">
                                        <div class="feature-info text-right">
                                            <h2 class="text-uppercase">women's</h2>
                                            <h3 class="text-uppercase">collection</h3>  
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- women area end -->
                <!-- offer area start -->
                <!--<div class="offer-area ptb-130">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-7 col-md-6 col-sm-5 col-xs-12">
                                <div class="offer-img">
                                    <img src="img/offer/1.png" alt="product"> 
                                </div>
                            </div>
                            <div class="col-lg-5 col-md-6 col-sm-7 col-xs-12">
                                <div class="offer-info mt-40 text-center">
                                    <h3>GET IT NOW</h3>
                                    <h1>LIMITED OFFER</h1>
                                    <h5 class="hidden-xs">HANDBAGS COLLECTION FOR WOMEN</h5>
                                </div>
                                <div class="timer">
                                    <div data-countdown="2017/02/01" class="timer-grid"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>-->
                <!-- offer area end -->
                <!-- men area start -->
                <div class="men-area ptb-90">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="section-tab">
                                    <div class="section-tab-menu mb-45 text-center">
                                        <ul role="tablist">
                                            <li role="presentation" class="active text-uppercase"><a href="#coats" aria-controls="coats" role="tab" data-toggle="tab">外套</a></li>
                                            <li role="presentation" class="text-uppercase"><a href="#shirts" aria-controls="shirts" role="tab" data-toggle="tab">衬衫</a></li>
                                            <li role="presentation" class="text-uppercase"><a href="#accessories" aria-controls="accessories" role="tab" data-toggle="tab">T恤</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-5 hidden-sm hidden-xs">
                                <div class="featured-left mt-2">
                                    <a href="#">
                                        <img src="img/product/b3.jpg" alt="">
                                        <div class="feature-info text-left">
                                            <h2 class="text-uppercase">men's</h2>
                                            <h3 class="text-uppercase">collection</h3>  
                                        </div>
                                    </a>
                                </div>
                            </div>
                            <div class="col-md-7">                      
                                <div class="clearfix"></div>
                                <div class="tab-content row">
                                        <div id="coats" role="tabpanel" class="active section-tab-item">
                                            <div class="feature-slider">
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item clearfix">
                                                            <div class="single-product-img clearfix">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=170">
                                                                    <img class="primary-image" src="img/product/15.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">天蓝色随性男士衬衫</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=170&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=170" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=170" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>  
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=170">天蓝色男士衬衫</a></h3>  
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=171">
                                                                    <img class="primary-image" src="img/product/16.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">深灰色魅力男士衬衫</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=171&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=171" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=171" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">   
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$130</span>
                                                                    <span class="old-price">$150</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=171">深灰色男士衬衫</a></h3>  
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=173">
                                                                    <img class="primary-image" src="img/product/17.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">青少年韩版修身T恤</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=173&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=173" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=173" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">     
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=173">青少年修身T恤</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=170">
                                                                    <img class="primary-image" src="img/product/15.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">天蓝色随性男士衬衫</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=170&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=170" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=170" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div>  
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=170">天蓝色男士衬衫</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=171">
                                                                    <img class="primary-image" src="img/product/16.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">深灰色魅力男士衬衫</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=171&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=171" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=171" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$100</span>
                                                                    <span class="old-price">$130</span>
                                                                </div>  
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=171">深灰色男士衬衫</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=173">
                                                                    <img class="primary-image" src="img/product/17.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">青少年韩版修身T恤</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=173&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=173" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=173" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div>      
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=173">青少年修身T恤</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="shirts" role="tabpanel" class="section-tab-item">
                                            <div class="feature-slider">
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item clearfix">
                                                            <div class="single-product-img clearfix">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=171">
                                                                    <img class="primary-image" src="img/product/16.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">深灰色魅力男士衬衫</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=171&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=171" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=171" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>  
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=171">深灰色男士衬衫</a></h3>  
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=173">
                                                                    <img class="primary-image" src="img/product/17.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">青少年韩版修身T恤</p>
                                                                        <ul>
                                                                             <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=173&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=173" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=173" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">   
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$130</span>
                                                                    <span class="old-price">$150</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=173">青少年修身T恤</a></h3>  
                                                            </div> 
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=170">
                                                                    <img class="primary-image" src="img/product/15.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">天蓝色随性男士衬衫</p>
                                                                        <ul>
                                                                             <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=170&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=170" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=170" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">     
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=170">天蓝色男士衬衫</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=171">
                                                                    <img class="primary-image" src="img/product/16.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">深灰色魅力男士衬衫</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=171&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=171" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=171" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div>  
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=171">深灰色男士衬衫</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=173">
                                                                    <img class="primary-image" src="img/product/17.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">青少年韩版修身T恤</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=173&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=173" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=173" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$100</span>
                                                                    <span class="old-price">$130</span>
                                                                </div>  
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=173">青少年修身T恤</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=170">
                                                                    <img class="primary-image" src="img/product/15.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">天蓝色随性男士衬衫</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=170&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=170" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=170" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div>      
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=170">天蓝色男士衬衫</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="accessories" role="tabpanel" class="section-tab-item">
                                            <div class="feature-slider">
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item clearfix">
                                                            <div class="single-product-img clearfix">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=173">
                                                                    <img class="primary-image" src="img/product/17.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">青少年韩版修身T恤</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=173&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=173" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=173" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>  
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=173">青少年修身T恤</a></h3>  
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=170">
                                                                    <img class="primary-image" src="img/product/15.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">天蓝色随性男士衬衫 </p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=170&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=170" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=170" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">   
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$130</span>
                                                                    <span class="old-price">$150</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=170">天蓝色男士衬衫</a></h3>  
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=171">
                                                                    <img class="primary-image" src="img/product/16.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">深灰色魅力男士衬衫 </p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=171&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=171" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=171" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">     
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div> 
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div> 
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=171">深灰色男士衬衫</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=173">
                                                                    <img class="primary-image" src="img/product/17.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">青少年韩版修身T恤</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=173&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=173" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=173" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$150</span>
                                                                    <span class="old-price">$180</span>
                                                                </div>  
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=173">青少年修身T恤</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=170">
                                                                    <img class="primary-image" src="img/product/15.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">天蓝色随性男士衬衫</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=170&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=170" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=170" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$100</span>
                                                                    <span class="old-price">$130</span>
                                                                </div>  
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=170">天蓝色男士衬衫</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-width">  
                                                    <div class="single-product">
                                                        <div class="single-product-item">
                                                            <div class="single-product-img clearfix hover-effect">
                                                                <a href="/ShoppingMall/user/lookGoodLine.do?good_id=170">
                                                                    <img class="primary-image" src="img/product/16.jpg" alt="">
                                                                </a>
                                                                <div class="wish-icon-hover text-center clearfix">
                                                                    <div class="hover-text">
                                                                        <p class="hidden-md">深灰色魅力男士衬衫</p>
                                                                        <ul>
                                                                            <li><a href="/ShoppingMall/user/userAddShoppingCar.do?good_id=171&goodnum=1" data-toggle="tooltip" title="加入购物车"><i class="fa fa-shopping-cart"></i></a></li>
                                                                            <li><a href="/ShoppingMall/page/user/userPayIndex.jsp?good_id=171" data-toggle="tooltip" title="立即购买"><i class="fa fa-refresh"></i></a></li>
                                                                            <li><a href="/ShoppingMall/user/userAddCollectGood.do?good_id=171" data-toggle="tooltip" title="喜欢"><i class="fa fa-heart"></i></a></li>
                                                                        </ul>
                                                                    </div>    
                                                                </div>
                                                            </div>
                                                            <div class="single-product-info clearfix">
                                                                <div class="pro-rating">  
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                </div>
                                                                <div class="pro-price">
                                                                    <span class="new-price">$120</span>
                                                                    <span class="old-price">$150</span>
                                                                </div>      
                                                                <h3><a href="/ShoppingMall/user/lookGoodLine.do?good_id=170">深灰色男士衬衫</a></h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>    
                                    </div> 
                                <div class="arrival-button text-center mt-30">
                                    <a href='/ShoppingMall/user/userLookGood.do' class='section-button'>查看更多</a>
                                </div>    
                            </div>
                        </div>
                    </div>
                </div>
                <!-- men area end -->
                <!-- newsletter area start -->
                <div class="newsletter-area ptb-110">
                    <div class="container">
                        <div class="row">
                            <div class="newsletter-info">
                                <div class="col-lg-4 col-md-5 col-sm-12 col-xs-12">
                                    <div class="news-left text-right">
                                        <a href="#" class="section-button">免费报名</a>
                                        <h3 class="text-uppercase">订阅实时资讯</h3>
                                    </div>    
                                </div>
                                <div class="col-lg-8 col-md-7 col-sm-12 col-xs-12">
                                    <div class="news-right text-center">
                                        <form action="#" id="mc-form" class="mc-form">
                                            <input id="mc-email" type="text" name="email" placeholder="请输入电子邮件地址...">
                                            <button id="mc-submit" type="submit" class="text-uppercase">发送</button>
                                            <span class="hidden-xs"><input type="checkbox" name="agree">您要订阅我们的咨询要同意接收我们的电子邮件!</span>
                                        </form>
                                        <!-- mailchimp-alerts Start -->
                                        <div class="mailchimp-alerts text-centre fix">
                                            <div class="mailchimp-submitting"></div><!-- mailchimp-submitting end -->
                                            <div class="mailchimp-success"></div><!-- mailchimp-success end -->
                                            <div class="mailchimp-error"></div><!-- mailchimp-error end -->
                                        </div>
                                        <!-- mailchimp-alerts end -->
                                    </div>    
                                </div>
                            </div>    
                        </div>
                    </div>
                </div>
                <!-- newsletter area end -->
                <!-- blog area start -->
                <div class="blog-area ptb-90">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="section-tab">
                                    <div class="section-tab-menu mb-45 text-center">
                                        <ul role="tablist">
                                            <li role="presentation" class="active text-uppercase"><a href="#blog" aria-controls="blog" role="tab" data-toggle="tab">博客</a></li>
                                            <li role="presentation" class="text-uppercase"><a href="#tweet" aria-controls="tweet" role="tab" data-toggle="tab">推特</a></li>
                                            <li role="presentation" class="text-uppercase"><a href="#instagram" aria-controls="instagram" role="tab" data-toggle="tab">美图秀</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="clearfix"></div>
                            <div class="tab-content row">
                                <div id="blog" role="tabpanel" class="active section-tab-item">
                                    <div class="col-md-4 col-sm-6 col-xs-12">
                                        <div class="single-blog">
                                            <div class="single-blog-img">
                                                <a href="#">
                                                    <img src="img/blog/1.jpg" alt="blog">
                                                </a>
                                                <div class="blog-date text-center">
                                                    <h2>05 <span>Feb</span></h2>    
                                                </div>
                                            </div>
                                            <div class="single-blog-info mt-25">
                                                <h4><a href="#">Beautiful Collection For Beauty</a></h4>
                                                <p>But I must explain to you how all this mistaken idea  of denouncing pleasure and praising pain was bornad will give you a complete pain was praising</p>
                                                <div class="button-comments">
                                                    <div class="read-button text-center">
                                                        <a class="read-more text-uppercase" href="#">阅读更多 <i class="fa fa-angle-double-right"></i></a>
                                                    </div>
                                                    <div class="comment-like">
                                                        <ul>
                                                            <li><i class="fa fa-comments"></i>6条评论</li>
                                                            <li><i class="fa fa-heart"></i>25 赞</li>
                                                        </ul>
                                                    </div> 
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-sm-6 col-xs-12">
                                        <div class="single-blog">
                                            <div class="single-blog-img">
                                                <a href="#">
                                                    <img src="img/blog/2.jpg" alt="blog">
                                                </a>
                                                <div class="blog-date text-center">
                                                    <h2>09 <span>Feb</span></h2>    
                                                </div>
                                            </div>
                                            <div class="single-blog-info mt-25">
                                                <h4><a href="#">Fashion Show With New Trend</a></h4>
                                                <p>But I must explain to you how all this mistaken idea  of denouncing pleasure and praising pain was bornad will give you a complete pain was praising</p>
                                                <div class="button-comments">
                                                    <div class="read-button text-center">
                                                        <a class="read-more text-uppercase" href="#">阅读更多 <i class="fa fa-angle-double-right"></i></a>
                                                    </div>
                                                    <div class="comment-like">
                                                        <ul>
                                                            <li><i class="fa fa-comments"></i>10 条评论</li>
                                                            <li><i class="fa fa-heart"></i>20 赞</li>
                                                        </ul>
                                                    </div> 
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 hidden-sm col-xs-12">
                                        <div class="single-blog-list">
                                            <div class="blog-date mr-25 text-center">
                                                <h2>12 <span>二月</span></h2>    
                                            </div>
                                            <div class="blog-list-info single-blog-info mb-25">
                                                <h4><a href="#">男士新潮流</a></h4>
                                                <p>But I must explain to you how all this mistaken idea  of denouncing pleasure</p>
                                            </div>
                                        </div>
                                        <div class="single-blog-list">
                                            <div class="blog-date mr-25 text-center">
                                                <h2>15 <span>三月</span></h2>    
                                            </div>
                                            <div class="blog-list-info single-blog-info mb-25">
                                                <h4><a href="#">时尚展示</a></h4>
                                                <p>But I must explain to you how all this mistaken idea  of denouncing pleasure</p>
                                            </div>
                                        </div>
                                        <div class="single-blog-list">
                                            <div class="blog-date mr-25 text-center">
                                                <h2>20 <span>四月</span></h2>    
                                            </div>
                                            <div class="blog-list-info single-blog-info mb-25">
                                                <h4><a href="#">少女服装</a></h4>
                                                <p>But I must explain to you how all this mistaken idea  of denouncing pleasure</p>
                                            </div>
                                        </div>
                                        <div class="single-blog-list hidden-md">
                                            <div class="blog-date mr-25 text-center">
                                                <h2>09 <span>五月</span></h2>    
                                            </div>
                                            <div class="blog-list-info single-blog-info mb-25">
                                                <h4><a href="#">裙摆时尚</a></h4>
                                                <p>But I must explain to you how all this mistaken idea  of denouncing pleasure</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div id="tweet" role="tabpanel" class="section-tab-item">
                                    <div class="col-md-4">
                                        <div class="single-twitter mb-10">
                                            <div class="twitter-icon">
                                                <img src="img/icon/twitter.png" alt="">
                                            </div>
                                            <div class="twitter-feed">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tenetur maiores rem dolores. <a>-jan 18, 2016</a></p>
                                            </div>
                                        </div>
                                        <div class="single-twitter mb-10">
                                            <div class="twitter-icon">
                                                <img src="img/icon/twitter.png" alt="">
                                            </div>
                                            <div class="twitter-feed">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tenetur maiores rem dolores. <a>-jan 18, 2016</a></p>
                                            </div>
                                        </div>
                                        <div class="single-twitter">
                                            <div class="twitter-icon">
                                                <img src="img/icon/twitter.png" alt="">
                                            </div>
                                            <div class="twitter-feed">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tenetur maiores rem dolores. <a>-jan 18, 2016</a></p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="single-twitter mb-10">
                                            <div class="twitter-icon">
                                                <img src="img/icon/twitter.png" alt="">
                                            </div>
                                            <div class="twitter-feed">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tenetur maiores rem dolores. <a>-jan 18, 2016</a></p>
                                            </div>
                                        </div>
                                        <div class="single-twitter mb-10">
                                            <div class="twitter-icon">
                                                <img src="img/icon/twitter.png" alt="">
                                            </div>
                                            <div class="twitter-feed">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tenetur maiores rem dolores. <a>-jan 18, 2016</a></p>
                                            </div>
                                        </div>
                                        <div class="single-twitter">
                                            <div class="twitter-icon">
                                                <img src="img/icon/twitter.png" alt="">
                                            </div>
                                            <div class="twitter-feed">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tenetur maiores rem dolores. <a>-jan 18, 2016</a></p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="single-twitter mb-10">
                                            <div class="twitter-icon">
                                                <img src="img/icon/twitter.png" alt="">
                                            </div>
                                            <div class="twitter-feed">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tenetur maiores rem dolores. <a>-jan 18, 2016</a></p>
                                            </div>
                                        </div>
                                        <div class="single-twitter mb-10">
                                            <div class="twitter-icon">
                                                <img src="img/icon/twitter.png" alt="">
                                            </div>
                                            <div class="twitter-feed">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tenetur maiores rem dolores. <a>-jan 18, 2016</a></p>
                                            </div>
                                        </div>
                                        <div class="single-twitter">
                                            <div class="twitter-icon">
                                                <img src="img/icon/twitter.png" alt="">
                                            </div>
                                            <div class="twitter-feed">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tenetur maiores rem dolores. <a>-jan 18, 2016</a></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div id="instagram" role="tabpanel" class="section-tab-item">
                                    <div class="row mb-25">
                                        <div class="col-md-4">
                                            <div class="single-instagram">
                                                <a href="#">
                                                    <img src="img/blog/1.jpg" alt="blog">
                                                </a>    
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="single-instagram">
                                                <a href="#">
                                                    <img src="img/blog/2.jpg" alt="blog">
                                                </a>    
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="single-instagram">
                                                <a href="#">
                                                    <img src="img/blog/1.jpg" alt="blog">
                                                </a>  
                                            </div>
                                        </div>    
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="single-instagram">
                                                <a href="#">
                                                    <img src="img/blog/2.jpg" alt="blog">
                                                </a>    
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="single-instagram">
                                                <a href="#">
                                                    <img src="img/blog/1.jpg" alt="blog">
                                                </a>    
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                        <div class="single-instagram">
                                            <a href="#">
                                                <img src="img/blog/2.jpg" alt="blog">
                                            </a>  
                                        </div>
                                    </div>
                                    </div>
                                </div>    
                            </div>
                        </div>
                    </div>
                </div>    
                <!-- blog area end -->
                <!-- testimonial area start -->
                <div class="testimonial-area pt-100 pb-45">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-5 col-md-4 col-sm-3 col-xs-12">
                                <div class="testimonial-left text-right">
                                    <h2>用户评论</h2>
                                    <p class="hidden-sm">But I must explain to you how all this mistaken idea  of denouncing pleasure and praising pain was bornad</p>
                                </div>
                            </div>
                            <div class="col-lg-7 col-md-8 col-sm-9 col-xs-12">
                                <div class="testi-owl">
                                    <div class="testimonial-right">
                                        <div class="testimonial-img">
                                            <img src="img/testimonial/1.jpg" alt="">
                                        </div>
                                        <div class="testimonial-info">
                                            <h3>Zaculine Jenelia, <span> Head Of Business</span></h3>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing    elit, sed do eiusmod tempor incididunt ut labore et lore magna aliqua. Ut enim ad minim veniam quis</p>
                                        </div>
                                    </div>
                                    <div class="testimonial-right">
                                        <div class="testimonial-img">
                                            <img src="img/testimonial/1.jpg" alt="">
                                        </div>
                                        <div class="testimonial-info">
                                            <h3>Zaculine Jenelia, <span> Head Of Business</span></h3>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing    elit, sed do eiusmod tempor incididunt ut labore et lore magna aliqua. Ut enim ad minim veniam quis</p>
                                            <a href="#" class="section-button mt-30">查看更多</a>
                                        </div>
                                    </div>
                                    <div class="testimonial-right">
                                        <div class="testimonial-img">
                                            <img src="img/testimonial/1.jpg" alt="">
                                        </div>
                                        <div class="testimonial-info">
                                            <h3>Zaculine Jenelia, <span> Head Of Business</span></h3>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing    elit, sed do eiusmod tempor incididunt ut labore et lore magna aliqua. Ut enim ad minim veniam quis</p>
                                            <a href="#" class="section-button mt-30">查看更多</a>
                                        </div>
                                    </div>
                                    <div class="testimonial-right">
                                        <div class="testimonial-img">
                                            <img src="img/testimonial/1.jpg" alt="">
                                        </div>
                                        <div class="testimonial-info">
                                            <h3>Zaculine Jenelia, <span> Head Of Business</span></h3>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing    elit, sed do eiusmod tempor incididunt ut labore et lore magna aliqua. Ut enim ad minim veniam quis</p>
                                            <a href="#" class="section-button mt-30">查看更多</a>
                                        </div>
                                    </div>
                                </div>    
                            </div>
                        </div>
                    </div>
                </div>
                <!-- testimonial area end -->
                <!-- client area start -->
                <!--<div class="client-area ptb-90">
                    <div class="container">
                        <div class="row">
                            <div class="client-owl">
                                <div class="col-xs-12">
                                    <div class="single-client">
                                        <div class="single-client-img plr-40">
                                            <a href="#"><img src="img/client/1.png" alt=""></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12">
                                    <div class="single-client">
                                        <div class="single-client-img plr-40">
                                            <a href="#"><img src="img/client/2.png" alt=""></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12">
                                    <div class="single-client">
                                        <div class="single-client-img plr-40">
                                            <a href="#"><img src="img/client/3.png" alt=""></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12">
                                    <div class="single-client">
                                        <div class="single-client-img plr-40">
                                            <a href="#"><img src="img/client/4.png" alt=""></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12">
                                    <div class="single-client">
                                        <div class="single-client-img plr-40">
                                            <a href="#"><img src="img/client/5.png" alt=""></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12">
                                    <div class="single-client">
                                        <div class="single-client-img plr-40">
                                            <a href="#"><img src="img/client/1.png" alt=""></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12">
                                    <div class="single-client">
                                        <div class="single-client-img plr-40">
                                            <a href="#"><img src="img/client/2.png" alt=""></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12">
                                    <div class="single-client">
                                        <div class="single-client-img plr-40">
                                            <a href="#"><img src="img/client/3.png" alt=""></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12">
                                    <div class="single-client">
                                        <div class="single-client-img plr-40">
                                            <a href="#"><img src="img/client/4.png" alt=""></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12">
                                    <div class="single-client">
                                        <div class="single-client-img plr-40">
                                            <a href="#"><img src="img/client/5.png" alt=""></a>
                                        </div>
                                    </div>
                                </div>
                            </div>    
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="client-button text-center pt-35">
                                    <a href='#' class='section-button'>查看更多</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>-->
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
                                                <img src="img/icon/5.png" alt="">
                                            </div>
                                        </div>    
                                        <div class="single-service-info">
                                            <h4 class="text-uppercase">免运费</h4>
                                            <p>免费提供所有产品</p>
                                        </div> 
                                    </div>
                                </div>
                            </div> 
                            <div class="col-md-3 col-sm-4 col-xs-12">   
                                <div class="single-service text-center">
                                    <div class="single-service-content ptb-40">
                                        <div class="single-service-icon-wrapper">
                                            <div class="single-service-icon">
                                                <img src="img/icon/7.png" alt="">
                                            </div>
                                        </div>    
                                        <div class="single-service-info">
                                            <h4 class="text-uppercase">在线订购</h4>
                                            <p>010-88888-100</p>
                                        </div>
                                    </div>    
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-4 col-xs-12">    
                                <div class="single-service text-center">
                                    <div class="single-service-content ptb-40">
                                        <div class="single-service-icon-wrapper">
                                            <div class="single-service-icon">
                                                <img src="img/icon/9.png" alt="">
                                            </div>
                                        </div>    
                                        <div class="single-service-info">
                                            <h4 class="text-uppercase">退款</h4>
                                            <p>退款保证</p>
                                        </div>
                                    </div>    
                                </div>
                            </div>
                            <div class="col-md-3 hidden-sm col-xs-12">    
                                <div class="single-service text-center">
                                    <div class="single-service-content ptb-40">
                                        <div class="single-service-icon-wrapper">
                                            <div class="single-service-icon">
                                                <img src="img/icon/10.png" alt="">
                                            </div>
                                        </div>    
                                        <div class="single-service-info">
                                            <h4 class="text-uppercase">礼品券</h4>
                                            <p>惊喜礼品券</p>
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
                            <div class="col-md-4 col-sm-12 col-xs-12">
                                <div class="touch-left">
                                    <div class="touch-logo mb-35">
                                        <a href="index.html"><!--<img src="img/logo/2.png" alt="shofixe">--></a>
                                    </div>
                                    <p>热烈欢迎浏览我们的网站，我们致以诚挚的谢意</p>
                                    <p>欢迎将我们的网站推荐给更多朋友</p>
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
                            <div class="col-md-8 col-sm-12 col-xs-12">
                                <div class="touch-right">
                                    <h2 class="text-uppercase">与我联系</h2>
                                    <form id="contact-form-two" action="mail.php" method="post">
                                        <input type="text" placeholder="在这输入您的名字..." name="name">
                                        <input type="text" placeholder="在这输入电阻邮件地址..." name="email">
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
                                        <p>Copyright &copy; 2018.Company name All rights reserved.<a target="_blank" href="http://www.taobao.com/">网页</a></p>
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
        
        <!-- QUICKVIEW PRODUCT -->
        <div id="quickview-wrapper">
            <!-- Modal -->
            <div class="modal fade" id="productModal" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        </div>
                        <div class="modal-body">
                            <div class="modal-product">
                                <div class="product-images">
                                    <div class="main-image images">
                                        <img alt="" src="img/product/static2.jpg">
                                    </div>
                                </div><!-- .product-images -->

                                <div class="product-info">
                                    <h1>Diam quis cursus</h1>
                                    <div class="price-box">
                                        <p class="price"><span class="special-price"><span class="amount">$132.00</span></span></p>
                                    </div>
                                    <a href="shop.html" class="see-all">See all features</a>
                                    <div class="quick-add-to-cart">
                                        <form method="post" class="cart">
                                            <div class="numbers-row">
                                                <input type="number" id="french-hens" value="3">
                                            </div>
                                            <button class="single-add-to-cart-button" type="submit">Add to cart</button>
                                        </form>
                                    </div>
                                    <div class="quick-desc">
                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam fringilla augue nec est tristique auctor. Donec non est at libero vulputate rutrum.
                                    </div>
                                    <div class="social-sharing">
                                        <div class="widget widget_socialsharing_widget">
                                            <h3 class="widget-title-modal">Share this product</h3>
                                            <ul class="social-icons">
                                                <li><a target="_blank" title="Facebook" href="#" class="facebook social-icon"><i class="fa fa-facebook"></i></a></li>
                                                <li><a target="_blank" title="Twitter" href="#" class="twitter social-icon"><i class="fa fa-twitter"></i></a></li>
                                                <li><a target="_blank" title="Pinterest" href="#" class="pinterest social-icon"><i class="fa fa-pinterest"></i></a></li>
                                                <li><a target="_blank" title="Google +" href="#" class="gplus social-icon"><i class="fa fa-google-plus"></i></a></li>
                                                <li><a target="_blank" title="LinkedIn" href="#" class="linkedin social-icon"><i class="fa fa-linkedin"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div><!-- .product-info -->
                            </div><!-- .modal-product -->
                        </div><!-- .modal-body -->
                    </div><!-- .modal-content -->
                </div><!-- .modal-dialog -->
            </div>
            <!-- END Modal -->
        </div>
        <!-- END QUICKVIEW PRODUCT -->
        
       	<!-- jquery
		============================================ -->		
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

