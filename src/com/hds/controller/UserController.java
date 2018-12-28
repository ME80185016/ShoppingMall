package com.hds.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hds.biz.UserBiz;
import com.hds.entity.CollectGood;
import com.hds.entity.CollectStore;
import com.hds.entity.GoodAssess;
import com.hds.entity.GoodImage;
import com.hds.entity.GoodInfo;
import com.hds.entity.GoodMargin;
import com.hds.entity.GoodPrice;
import com.hds.entity.GoodProperties;
import com.hds.entity.GoodSale;
import com.hds.entity.PaySaPi;
import com.hds.entity.RoleAddress;
import com.hds.entity.ShoppingGood;
import com.hds.entity.ShoppingOrder;
import com.hds.entity.ShoppingOrderline;
import com.hds.entity.ShoppingRole;
import com.hds.entity.StoreInfo;
import com.hds.payutil.PayUtil;
import com.hds.payutil.PaysTest;
import com.hds.util.sms.RandomTest;
import com.hds.util.sms.SMSTest;
import com.hds.util.sms.UserRegisterFilter;

/**
 * userController,该类包含普通用户的一些操作，如注册，登录，购物...
 * 
 * @author 离
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	private static int page = 1;
	private static int pageCount = 0;
	private static int storePage=1;
	private static int storePageCount=0;
	private int yzmNumber = RandomTest.getNum();// 调用工具类方法产生四位随机数
	@Autowired
	private UserBiz userbiz;
	/**
	 * 用户登出
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/loginOut")
	public ModelAndView loginOut(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		int showConfirmDialog = JOptionPane.showConfirmDialog(null,
				"确定退出系统？", "确定", JOptionPane.YES_NO_OPTION);
		if (showConfirmDialog == 0) {
			request.getSession().removeAttribute("currvalRole");
			model.setViewName("/page/roleLogin");
		}else {
			model.setViewName("/page/user/userPage");
		}
		return model;
	}
	
	
	
	/**
	 * 普通用户注册方法，成功后定向到成功页面
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userRegist")
	public ModelAndView userRegist(ShoppingRole role,HttpServletRequest request) throws Exception {
		// UserRegisterFilter filter =new UserRegisterFilter();
		ModelAndView model = new ModelAndView();
		boolean userNameRepeat = UserRegisterFilter.userNameRepeat(role
				.getRole_name());
		String role_yzm=request.getParameter("role_yzm");
		String yzm = String.valueOf(yzmNumber);
		if (userNameRepeat) {
			JOptionPane.showMessageDialog(null, "用户名重复，请重新输入!");
			model.setViewName("/page/user/userRegister");
		} else {
			int showConfirmDialog = JOptionPane.showConfirmDialog(null,
					"用户名可用，是否确定使用？", "用户名确定", JOptionPane.YES_NO_OPTION);
			if (showConfirmDialog == 0) {
				if(role_yzm.equals(yzm)){
					userbiz.userRegist(role);
					JOptionPane.showMessageDialog(null, "注册成功，请登录!");
					model.setViewName("/page/roleLogin");
				}else {
					JOptionPane.showMessageDialog(null, "验证码输入不正确，请重新输入!");
					model.setViewName("/page/user/userRegister");
				}
				
			} else {
				model.setViewName("/page/user/userRegister");
			}
		}

		return model;

	}

	/**
	 * 通过用户输入的手机号调用短信接口获取验证码
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws Exception
	 */
	@RequestMapping(value = "/getyzm")
	public void getYzm(HttpServletRequest request,HttpServletResponse response,String rolename,String roletel) throws UnsupportedEncodingException{
		byte[] b=rolename.getBytes("ISO-8859-1");//用tomcat的格式（iso-8859-1）方式去读。
		String name=new String(b,"utf-8");//采用utf-8去接string
		System.out.println("用户名:"+name+"，电话"+roletel+",系统验证码："+yzmNumber);
		try {
			int sendSMS = SMSTest.sendSMS(yzmNumber, name, roletel);// 调用工具类的方法向手机号发送短信
			String data=Integer.toString(sendSMS);
			response.setContentType("application/text; charset=UTF-8");
			response.getWriter().write(data);
			System.out.println("返回数据："+data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new RuntimeException("IO异常");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new RuntimeException("服务器繁忙，发送验证码失败");
		}

	}

	/**
	 * 根据用户名登录，查询数据库此用户名是否存在，然后查询对应的密码是否正确
	 * 
	 * @param role_name
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userLoginByName")
	public String userLoginByName(String role_name, HttpServletRequest request)
			throws Exception {
		// 根据用户名查询用户
		ShoppingRole userLogin = userbiz.userLoginByName(role_name);
		// 获取页面上用户输入的密码
		String pwd = request.getParameter("role_pwd");
		if (userLogin != null) {
			if (userLogin.getRole_pwd().equals(pwd)) {
				List<RoleAddress> queryAddressByUserId = userbiz
						.queryAddressByUserId(userLogin.getRole_id());
				request.getSession().setAttribute("currvalRole", userLogin);
				request.getSession().setAttribute("userAddresses",
						queryAddressByUserId);
				return "/page/user/userPage";
			} else {
				JOptionPane.showMessageDialog(null,"密码错误，请重新输入!");
				return "/page/roleLogin";
			}
		} else {
			JOptionPane.showMessageDialog(null,"用户名不存在，请重新输入!");
			return "/page/roleLogin";
		}

	}

	/**
	 * 根据手机号登录，根据手机号查询数据库是否存在该用户，然后判断密码是否正确
	 * 
	 * @param role_tel
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userLoginByTel")
	public String userLoginByTel(String role_tel, HttpServletRequest request)
			throws Exception {
		// 根据手机号查询用户
		ShoppingRole userLogin = userbiz.userLoginByTel(role_tel);
		// 获取页面上用户输入的密码
		String pwd = request.getParameter("role_pwd");
		if (userLogin != null) {
			if (userLogin.getRole_pwd().equals(pwd)) {
				List<RoleAddress> queryAddressByUserId = userbiz
						.queryAddressByUserId(userLogin.getRole_id());
				request.getSession().setAttribute("currvalRole", userLogin);
				request.getSession().setAttribute("userAddresses",
						queryAddressByUserId);
				return "/page/user/userPage";
			} else {
				JOptionPane.showMessageDialog(null,"密码错误，请重新输入!");
				return "/page/roleLogin";
			}
		} else {
			JOptionPane.showMessageDialog(null,"手机号不存在，请重新输入!");
			return "/page/roleLogin";
		}

	}

	/**
	 * 用户浏览商品
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookGood")
	public ModelAndView userLookGood(HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		// 查询商品数量
		int goodCount = userbiz.queryGoodCount();
		// System.out.println("goodcount:"+goodCount);
		double pagenum = (double) goodCount / 4;
		// System.out.println("pagenum"+pagenum);
		// 调用math类的向上取整函数进行分页
		pageCount = (int) Math.ceil(pagenum);
		// 查询出第一页所有商品
		List<ShoppingGood> queryGoods = userbiz.queryGoods(page);
		// 创建集合存储商品信息
		List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();

		for (ShoppingGood good : queryGoods) {
			GoodInfo goodinfo = new GoodInfo();
			// 根据商品id查询商品价格封装到GoodPrice对象中
			// System.out.println(good.getGood_id());
			int queryPriceById = userbiz.queryPriceById(good.getGood_id());
			GoodPrice price = new GoodPrice();
			price.setPrice_num(queryPriceById);
			// 根据商品id查询商品图片路径封装到GoodImage对象中
			String queryImageRouteById = userbiz.queryImageRouteById(good
					.getGood_id());
			GoodImage image = new GoodImage();
			image.setImage_route(queryImageRouteById);
			// 根据商品id查询商品销量封装到goodSale对象中
			int querySaleById = userbiz.querySaleById(good.getGood_id());
			GoodSale sale = new GoodSale();
			sale.setSale_num(querySaleById);
			// 根据商品id查询商品余量封装到GoodMargin对象中
			int queryMarginById = userbiz.queryMarginById(good.getGood_id());
			GoodMargin margin = new GoodMargin();
			margin.setMargin_num(queryMarginById);
			// 根据商品id查询商品属性
			GoodProperties queryPropertiesById = userbiz
					.queryPropertiesById(good.getGood_id());
			// 根据商品id查询商品评价
			List<GoodAssess> queryAssessById = userbiz.queryAssessById(good
					.getGood_id());
			// 把ShoppingGood对象封装进GoodInfo中
			goodinfo.setGood(good);
			// 把GoodPrice对象封装进GoodInfo中
			goodinfo.setGoodPrice(price);
			// 把GoodImage对象封装进GoodInfo中
			goodinfo.setGoodImage(image);
			// 把GoodSale对象封装进GoodInfo中
			goodinfo.setGoodSale(sale);
			// 把GoodMargin对象封装进GoodInfo中
			goodinfo.setGoodMargin(margin);
			// 把GoodProperties对象封装进GoodInfo中
			goodinfo.setGoodProperties(queryPropertiesById);
			// 把GoodAssess对象封装进GoodInfo中
			goodinfo.setGoodAssesses(queryAssessById);
			// 将goodinfo对象存放如集合中
			goodInfos.add(goodinfo);
		}

		// 将查询出的商品集合存入modelAndView中
		// model.addObject("goodinfos", goodInfos);
		// 将查出的数据存入session中
		request.getSession().setAttribute("goodinfos", goodInfos);
		request.getSession().setAttribute("pageCount", pageCount);
		request.getSession().setAttribute("page", page);
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/user/lookGood");
		return model;
	}

	/**
	 * 用户点击下一页查看下一页的商品
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookGoodNext")
	public ModelAndView userLookGoodNext(HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		page += 1;
		if (page <= 0) {
			page = 1;
		} else {
			System.out.println(page);
			// 查询出第一页所有商品
			List<ShoppingGood> queryGoods = userbiz.queryGoods(page);
			// 创建集合存储商品信息
			List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();

			for (ShoppingGood good : queryGoods) {
				GoodInfo goodinfo = new GoodInfo();
				// 根据商品id查询商品价格封装到GoodPrice对象中
				// System.out.println(good.getGood_id());
				int queryPriceById = userbiz.queryPriceById(good.getGood_id());
				GoodPrice price = new GoodPrice();
				price.setPrice_num(queryPriceById);
				// 根据商品id查询商品图片路径封装到GoodImage对象中
				String queryImageRouteById = userbiz.queryImageRouteById(good
						.getGood_id());
				GoodImage image = new GoodImage();
				image.setImage_route(queryImageRouteById);
				// 根据商品id查询商品销量封装到goodSale对象中
				int querySaleById = userbiz.querySaleById(good.getGood_id());
				GoodSale sale = new GoodSale();
				sale.setSale_num(querySaleById);
				// 根据商品id查询商品余量封装到GoodMargin对象中
				int queryMarginById = userbiz
						.queryMarginById(good.getGood_id());
				GoodMargin margin = new GoodMargin();
				margin.setMargin_num(queryMarginById);
				// 根据商品id查询商品属性
				GoodProperties queryPropertiesById = userbiz
						.queryPropertiesById(good.getGood_id());
				// 根据商品id查询商品评价
				List<GoodAssess> queryAssessById = userbiz.queryAssessById(good
						.getGood_id());
				// 把ShoppingGood对象封装进GoodInfo中
				goodinfo.setGood(good);
				// 把GoodPrice对象封装进GoodInfo中
				goodinfo.setGoodPrice(price);
				// 把GoodImage对象封装进GoodInfo中
				goodinfo.setGoodImage(image);
				// 把GoodSale对象封装进GoodInfo中
				goodinfo.setGoodSale(sale);
				// 把GoodMargin对象封装进GoodInfo中
				goodinfo.setGoodMargin(margin);
				// 把GoodProperties对象封装进GoodInfo中
				goodinfo.setGoodProperties(queryPropertiesById);
				// 把GoodAssess对象封装进GoodInfo中
				goodinfo.setGoodAssesses(queryAssessById);
				// 将goodinfo对象存放如集合中
				goodInfos.add(goodinfo);
			}

			// 将查询出的商品集合存入modelAndView中
			// model.addObject("goodinfos", goodInfos);
			// 将查出的数据存入session中
			request.getSession().setAttribute("goodinfos", goodInfos);
			request.getSession().setAttribute("page", page);
		}
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/user/lookGood");
		return model;
	}

	/**
	 * 用户点击上一页查看上一页的商品
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookGoodBack")
	public ModelAndView userLookGoodBack(HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		page -= 1;
		if (page <= 0) {
			page = 1;
		} else {
			// 查询出第一页所有商品
			List<ShoppingGood> queryGoods = userbiz.queryGoods(page);
			// 创建集合存储商品信息
			List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();
			/*
			 * //创建集合存储商品价格 List<Integer> queryPrices=null; //创建集合存储商品图片路径
			 * List<String> queryImages=null; //创建集合存储商品销量 List<Integer>
			 * querySales=null; //创建集合存储商品余量 List<Integer> queryMargins=null;
			 * //创建集合存储商品属性 List<GoodProperties> queryProperties=null;
			 * //创建集合存储商品评价 List<GoodAssess> queryAssesses=null;
			 */
			for (ShoppingGood good : queryGoods) {
				GoodInfo goodinfo = new GoodInfo();
				// 根据商品id查询商品价格封装到GoodPrice对象中
				// System.out.println(good.getGood_id());
				int queryPriceById = userbiz.queryPriceById(good.getGood_id());
				GoodPrice price = new GoodPrice();
				price.setPrice_num(queryPriceById);
				// 根据商品id查询商品图片路径封装到GoodImage对象中
				String queryImageRouteById = userbiz.queryImageRouteById(good
						.getGood_id());
				GoodImage image = new GoodImage();
				image.setImage_route(queryImageRouteById);
				// 根据商品id查询商品销量封装到goodSale对象中
				int querySaleById = userbiz.querySaleById(good.getGood_id());
				GoodSale sale = new GoodSale();
				sale.setSale_num(querySaleById);
				// 根据商品id查询商品余量封装到GoodMargin对象中
				int queryMarginById = userbiz
						.queryMarginById(good.getGood_id());
				GoodMargin margin = new GoodMargin();
				margin.setMargin_num(queryMarginById);
				// 根据商品id查询商品属性
				GoodProperties queryPropertiesById = userbiz
						.queryPropertiesById(good.getGood_id());
				// 根据商品id查询商品评价
				List<GoodAssess> queryAssessById = userbiz.queryAssessById(good
						.getGood_id());
				// 把ShoppingGood对象封装进GoodInfo中
				goodinfo.setGood(good);
				// 把GoodPrice对象封装进GoodInfo中
				goodinfo.setGoodPrice(price);
				// 把GoodImage对象封装进GoodInfo中
				goodinfo.setGoodImage(image);
				// 把GoodSale对象封装进GoodInfo中
				goodinfo.setGoodSale(sale);
				// 把GoodMargin对象封装进GoodInfo中
				goodinfo.setGoodMargin(margin);
				// 把GoodProperties对象封装进GoodInfo中
				goodinfo.setGoodProperties(queryPropertiesById);
				// 把GoodAssess对象封装进GoodInfo中
				goodinfo.setGoodAssesses(queryAssessById);
				// 将goodinfo对象存放如集合中
				goodInfos.add(goodinfo);
			}

			// 将查询出的商品集合存入modelAndView中
			// model.addObject("goodinfos", goodInfos);
			// 将查出的数据存入session中
			request.getSession().setAttribute("goodinfos", goodInfos);
			request.getSession().setAttribute("page", page);
		}
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/user/lookGood");
		return model;
	}

	/**
	 * 当用户输入页数时向指定页数跳转
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookGoodJump")
	public ModelAndView userLookGoodJump(Integer jumpPage,
			HttpServletRequest request) throws Exception {
		ModelAndView model = new ModelAndView();
		// 判断用户输入的页数
		/*
		 * if(jumpPage<=0){
		 * 
		 * }
		 */
		page=jumpPage;
		List<ShoppingGood> queryGoods = userbiz.queryGoods(page);
		// 创建集合存储商品信息
		List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();
		/*
		 * //创建集合存储商品价格 List<Integer> queryPrices=null; //创建集合存储商品图片路径
		 * List<String> queryImages=null; //创建集合存储商品销量 List<Integer>
		 * querySales=null; //创建集合存储商品余量 List<Integer> queryMargins=null;
		 * //创建集合存储商品属性 List<GoodProperties> queryProperties=null; //创建集合存储商品评价
		 * List<GoodAssess> queryAssesses=null;
		 */
		for (ShoppingGood good : queryGoods) {
			GoodInfo goodinfo = new GoodInfo();
			// 根据商品id查询商品价格封装到GoodPrice对象中
			// System.out.println(good.getGood_id());
			int queryPriceById = userbiz.queryPriceById(good.getGood_id());
			GoodPrice price = new GoodPrice();
			price.setPrice_num(queryPriceById);
			// 根据商品id查询商品图片路径封装到GoodImage对象中
			String queryImageRouteById = userbiz.queryImageRouteById(good
					.getGood_id());
			GoodImage image = new GoodImage();
			image.setImage_route(queryImageRouteById);
			// 根据商品id查询商品销量封装到goodSale对象中
			int querySaleById = userbiz.querySaleById(good.getGood_id());
			GoodSale sale = new GoodSale();
			sale.setSale_num(querySaleById);
			// 根据商品id查询商品余量封装到GoodMargin对象中
			int queryMarginById = userbiz.queryMarginById(good.getGood_id());
			GoodMargin margin = new GoodMargin();
			margin.setMargin_num(queryMarginById);
			// 根据商品id查询商品属性
			GoodProperties queryPropertiesById = userbiz
					.queryPropertiesById(good.getGood_id());
			// 根据商品id查询商品评价
			List<GoodAssess> queryAssessById = userbiz.queryAssessById(good
					.getGood_id());
			// 把ShoppingGood对象封装进GoodInfo中
			goodinfo.setGood(good);
			// 把GoodPrice对象封装进GoodInfo中
			goodinfo.setGoodPrice(price);
			// 把GoodImage对象封装进GoodInfo中
			goodinfo.setGoodImage(image);
			// 把GoodSale对象封装进GoodInfo中
			goodinfo.setGoodSale(sale);
			// 把GoodMargin对象封装进GoodInfo中
			goodinfo.setGoodMargin(margin);
			// 把GoodProperties对象封装进GoodInfo中
			goodinfo.setGoodProperties(queryPropertiesById);
			// 把GoodAssess对象封装进GoodInfo中
			goodinfo.setGoodAssesses(queryAssessById);
			// 将goodinfo对象存放如集合中
			goodInfos.add(goodinfo);
		}

		// 将查询出的商品集合存入modelAndView中
		// model.addObject("goodinfos", goodInfos);
		// 将查出的数据存入session中
		request.getSession().setAttribute("goodinfos", goodInfos);
		request.getSession().setAttribute("page", page);
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/user/lookGood");
		return model;
	}

	/**
	 * 用户查看商品详情
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/lookGoodLine")
	public ModelAndView lookGoodLine(int good_id, HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();

		GoodInfo goodinfo = new GoodInfo();
		// 根据商品id查询商品
		ShoppingGood queryGoodById = userbiz.queryGoodById(good_id);
		//根据商品id查询所属店铺详情
		StoreInfo queryStoreInfoById = userbiz.queryStoreInfoById(queryGoodById.getStore_id());
		
		// 根据商品id查询商品价格封装到GoodPrice对象中
		int queryPriceById = userbiz.queryPriceById(good_id);
		GoodPrice price = new GoodPrice();
		price.setPrice_num(queryPriceById);
		// 根据商品id查询商品图片路径封装到GoodImage对象中
		String queryImageRouteById = userbiz.queryImageRouteById(good_id);
		GoodImage image = new GoodImage();
		image.setImage_route(queryImageRouteById);
		// 根据商品id查询商品销量封装到goodSale对象中
		int querySaleById = userbiz.querySaleById(good_id);
		GoodSale sale = new GoodSale();
		sale.setSale_num(querySaleById);
		// 根据商品id查询商品余量封装到GoodMargin对象中
		int queryMarginById = userbiz.queryMarginById(good_id);
		GoodMargin margin = new GoodMargin();
		margin.setMargin_num(queryMarginById);
		// 根据商品id查询商品属性
		GoodProperties queryPropertiesById = userbiz
				.queryPropertiesById(good_id);
		// 根据商品id查询商品评价
		List<GoodAssess> queryAssessById = userbiz.queryAssessById(good_id);
		// 把ShoppingGood对象封装进GoodInfo中
		goodinfo.setGood(queryGoodById);
		// 把GoodPrice对象封装进GoodInfo中
		goodinfo.setGoodPrice(price);
		// 把GoodImage对象封装进GoodInfo中
		goodinfo.setGoodImage(image);
		// 把GoodSale对象封装进GoodInfo中
		goodinfo.setGoodSale(sale);
		// 把GoodMargin对象封装进GoodInfo中
		goodinfo.setGoodMargin(margin);
		// 把GoodProperties对象封装进GoodInfo中
		goodinfo.setGoodProperties(queryPropertiesById);
		// 把GoodAssess对象封装进GoodInfo中
		goodinfo.setGoodAssesses(queryAssessById);
		// 将查询出的商品集合存入session中
		// model.addObject("goodinfo", goodinfo);
		request.getSession().setAttribute("goodinfo", goodinfo);
		request.getSession().setAttribute("storeInfo", queryStoreInfoById);
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/user/lookGoodLine");

		return model;
	}

	/**
	 * 用户购买商品，向订单表shopping_order添加数据,向订单详情表添加数据
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userBuyGoods")
	public ModelAndView userBuyGoods(Integer address_id, String payType,
			Integer good_id, Integer goodnum, HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		/*
		 * System.out.println("地址id="+address_id);
		 * System.out.println("商品id="+good_id);
		 * System.out.println("支付方式="+payType);
		 */
		// 创建ModelAndView对象
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
			if(loginUser.getRole_type().equals("1")){
				// 页面跳转
				JOptionPane.showMessageDialog(null, "您当前角色为店铺，请切换用户登录");
				model.setViewName("/page/roleLogin");	
			}else if (loginUser.getRole_type().equals("0")) {
				// 页面跳转
				JOptionPane.showMessageDialog(null, "您当前角色为管理员，请切换用户登录");
				model.setViewName("/page/roleLogin");
			}else {
		// 创建ShoppingOrder对象
		ShoppingOrder order = new ShoppingOrder();
		// 向订单表中添加当前用户id和用户名
		order.setUser_id(loginUser.getRole_id());
		order.setUser_name(loginUser.getRole_name());
		// 根据商品id获取当前商品对象以获取商品所属店铺id
		ShoppingGood queryGoodById = userbiz.queryGoodById(good_id);
		// 向订单表中添加商品所属店铺id和店铺名
		order.setStore_id(queryGoodById.getStore_id());
		order.setStore_name(queryGoodById.getStore_name());
		// 根据商品id获取商品价格
		int queryPriceById = userbiz.queryPriceById(good_id);
		// 向订单表中添加订单金额
		order.setOrder_money(queryPriceById * goodnum);
		// 获取当前系统时间，并将其格式化为字符串存入订单中
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd号HH:mm:ss");
		String formatDate = sdf.format(date);
		order.setOrder_time(formatDate);
		// 添加订单状态，默认为0，先将其设为0，后续检测到用户付款成功后，将其改为1，并将商品销量+1
		order.setOrder_state("0");
		// 添加支付方式
		order.setPay_type(payType);
		// 根据商品id获取商品余量
		int queryMarginById = userbiz.queryMarginById(good_id);
		// 将订单插入到订单表中
		userbiz.insertOrder(order);
		// 获取当前订单id
		int OrderIdCurrval = userbiz.selectOrderIdCurrval();
		// 创建一个shoppingOrderline对象
		ShoppingOrderline orderline = new ShoppingOrderline();
		// 将订单id赋给订单详情对象
		orderline.setOrder_id(OrderIdCurrval);
		// 将地址id赋给订单详情对象
		orderline.setAddress_id(address_id);
		// 将商品id赋给订单详情对象
		orderline.setGood_id(good_id);
		// 将order_state赋给订单详情对象，默认为0，后续检测到用户付款成功后，将其改为1，并将商品销量+1
		orderline.setOrder_state("0");
		// 将购买商品数量赋给订单详情对象
		orderline.setGood_num(goodnum);
		// 将商品的单价赋给订单详情对象
		orderline.setGood_price(queryPriceById);
		// 根据商品id获取商品图片路径
		String queryImageRouteById = userbiz.queryImageRouteById(good_id);
		// 将商品图片路径赋给订单详情对象
		orderline.setImage_route(queryImageRouteById);
		// 根据地址id获取地址名
		RoleAddress queryAddressById = userbiz.queryAddressById(address_id);
		// 将地址名赋给订单详情对象
		orderline.setAddress_name(queryAddressById.getAddress_name());
		//将商品名加入订单详情表
		orderline.setGood_name(queryGoodById.getGood_name());
		// 将订单详情加入详情表
		userbiz.insertOrderline(orderline);
		// 将商品余量-购买数量
		userbiz.updateGoodMargin(good_id, queryMarginById - goodnum);
		//查询刚添加的这条订单信息
		ShoppingOrder queryCurrvalOrder = userbiz.queryCurrvalOrder(loginUser.getRole_id());
		//查询刚添加的这条订单详情信息
		ShoppingOrderline queryCurravlOrderline = userbiz.queryOrderlineById(queryCurrvalOrder.getOrder_id());

		//如果是支付宝支付或微信支付则调用支付接口
		if(payType.equals("1")||payType.equals("2")){
		int payTypeInt = Integer.parseInt(payType);
		//String priceValueOf = String.valueOf((float)queryPriceById*goodnum);
		String sendPays = PaysTest.sendPays(OrderIdCurrval,loginUser.getRole_id(),queryGoodById.getGood_name(),payTypeInt,(double)queryPriceById*goodnum/100);
		//String sendPays = PaysTest.sendPays(queryCurrvalOrder.getOrder_id(),loginUser.getRole_id(),"goodname",payTypeInt,(double)queryPriceById*goodnum);
		//System.out.println("controller订单id="+queryCurrvalOrder.getOrder_id()+",商品名="+"goodname"+",支付类型:"+payType+",角色id:"+loginUser.getRole_id()+",支付金额="+(double)queryPriceById*goodnum/100);

		// 页面跳转
		/*response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sendPays);
		response.sendRedirect("/page/user/userPays.jsp");*/
		session.setAttribute("payResult", sendPays);
		model.setViewName("/page/user/payResult");
		//如果是货到付款方式则不调用支付接口
		}else if(payType.equals("3")){
			session.setAttribute("currvalOrder",queryCurrvalOrder);
			//session.setAttribute("curravlOrderline", queryCurravlOrderline);
			int querySaleById = userbiz.querySaleById(queryCurravlOrderline.getGood_id());
			queryCurrvalOrder.setOrder_state("1");
			queryCurravlOrderline.setOrder_state("1");
			userbiz.updateOrderById(queryCurrvalOrder);
			userbiz.updateOrderlineById(queryCurravlOrderline);
			userbiz.updateGoodSale(queryCurravlOrderline.getGood_id(), querySaleById+1);
			model.setViewName("/page/pays/paySuccess");
		}
		
			}
		}
		return model;

	}
	/**
	 * 支付通知
	 * @param request
	 * @param response
	 * @param paySaPi
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	@RequestMapping("/notifyPay")
	public void notifyPay(HttpServletRequest request, HttpServletResponse response, PaySaPi paySaPi) throws Exception {
		
		// 保证密钥一致性
		if (PayUtil.checkPayKey(paySaPi)) {
			ShoppingOrder queryOrderById = userbiz.queryOrderById(Integer.parseInt(paySaPi.getOrderid()));
			ShoppingOrderline queryOrderlineById = userbiz.queryOrderlineById(Integer.parseInt(paySaPi.getOrderid()));
			int querySaleById = userbiz.querySaleById(queryOrderlineById.getGood_id());
			queryOrderById.setOrder_state("1");
			queryOrderlineById.setOrder_state("1");
			userbiz.updateOrderById(queryOrderById);
			userbiz.updateOrderlineById(queryOrderlineById);
			userbiz.updateGoodSale(queryOrderlineById.getGood_id(), querySaleById+1);
			System.out.println("回调通知完成");
		} 
	}
	/**
	 * 支付回调
	 * @param request
	 * @param response
	 * @param orderid
	 * @return
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	@RequestMapping("/returnPay")
	public ModelAndView returnPay(HttpServletRequest request, HttpServletResponse response,String orderid) throws Exception {
		System.out.println("return");
		boolean paySuccess = false;
		ShoppingOrder queryOrderById = userbiz.queryOrderById(Integer.parseInt(orderid));
		if (queryOrderById.getOrder_state().equals("1")) {
			paySuccess=true;
		}else {
			paySuccess=false;
		}
		ModelAndView view = new ModelAndView();
		// 根据订单号查找相应的记录:根据结果跳转到不同的页面
		if (paySuccess) {
			JOptionPane.showMessageDialog(null, "支付成功");
			request.getSession().setAttribute("currvalOrder", queryOrderById);
			view.setViewName("/page/pays/paySuccess");
		} else {
			JOptionPane.showMessageDialog(null, "秘钥不一致，付款失败");
			view.setViewName("/page/pays/payFail");
		}
		return view;
	}
	
	
	
	/**
	 * 用户根据订单id查看订单详情
	 * @param order_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/lookOrderLine")
	public ModelAndView lookOrderLine(int order_id,HttpServletRequest request)throws Exception{
		//System.out.println("查看定单详情");
		ModelAndView model=new ModelAndView();
		//查看订单详情
		ShoppingOrderline queryOrderlineById = userbiz.queryOrderlineById(order_id);
		//存入对象
		request.getSession().setAttribute("lookOrderLine", queryOrderlineById);
		model.setViewName("/page/user/lookOrderLine");
		return model;
	}

	/**
	 * 用户将商品加入购物车
	 * 
	 * @param good_id
	 * @param goodnum
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userAddShoppingCar")
	public ModelAndView userAddShoppingCar(Integer good_id, Integer goodnum,
			HttpServletRequest request) throws Exception {
		// 创建ModelAndView对象
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginUser = (ShoppingRole) session.getAttribute("currvalRole");
		if(loginUser==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
			if(loginUser.getRole_type().equals("1")){
				// 页面跳转
				JOptionPane.showMessageDialog(null, "您当前角色为店铺，请切换用户登录");
				model.setViewName("/page/roleLogin");	
			}else if (loginUser.getRole_type().equals("0")) {
				// 页面跳转
				JOptionPane.showMessageDialog(null, "您当前角色为管理员，请切换用户登录");
				model.setViewName("/page/roleLogin");
			}else {
				
		// 创建ShoppingOrder对象
		ShoppingOrder order = new ShoppingOrder();
		// 向订单表中添加当前用户id和用户名
		order.setUser_id(loginUser.getRole_id());
		order.setUser_name(loginUser.getRole_name());
		// 根据商品id获取当前商品对象以获取商品所属店铺id
		ShoppingGood queryGoodById = userbiz.queryGoodById(good_id);
		// 向订单表中添加商品所属店铺id和店铺名
		order.setStore_id(queryGoodById.getStore_id());
		order.setStore_name(queryGoodById.getStore_name());
		// 根据商品id获取商品价格
		int queryPriceById = userbiz.queryPriceById(good_id);
		// 向订单表中添加订单金额
		order.setOrder_money(queryPriceById * goodnum);
		// 获取当前系统时间，并将其格式化为字符串存入订单中
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd号HH:mm:ss");
		String formatDate = sdf.format(date);
		order.setOrder_time(formatDate);
		// 添加订单状态，默认为0，先将其设为0，后续检测到用户付款成功后，将其改为1，并将商品销量+1
		order.setOrder_state("0");
		// 添加支付方式
		//order.setPay_type("");
		// 根据商品id获取商品余量
		int queryMarginById = userbiz.queryMarginById(good_id);
		// 将订单插入到订单表中
		userbiz.insertOrder(order);
		// 获取当前订单id
		int OrderIdCurrval = userbiz.selectOrderIdCurrval();
		// 创建一个shoppingOrderline对象
		ShoppingOrderline orderline = new ShoppingOrderline();
		// 将订单id赋给订单详情对象
		orderline.setOrder_id(OrderIdCurrval);
		// 将地址id赋给订单详情对象
		//orderline.setAddress_id(null);
		// 将商品id赋给订单详情对象
		orderline.setGood_id(good_id);
		// 将order_state赋给订单详情对象，默认为0，后续检测到用户付款成功后，将其改为1，并将商品销量+1
		orderline.setOrder_state("0");
		// 将购买商品数量赋给订单详情对象
		orderline.setGood_num(goodnum);
		// 将商品的单价赋给订单详情对象
		orderline.setGood_price(queryPriceById);
		// 根据商品id获取商品图片路径
		String queryImageRouteById = userbiz.queryImageRouteById(good_id);
		// 将商品图片路径赋给订单详情对象
		orderline.setImage_route(queryImageRouteById);
		//将商品名赋给订单详情对象
		orderline.setGood_name(queryGoodById.getGood_name());
		// 将地址名赋给订单详情对象
		//orderline.setAddress_name(null);
		// 将订单详情加入详情表
		userbiz.insertOrderline(orderline);
		// 将商品余量-购买数量
		userbiz.updateGoodMargin(good_id, queryMarginById - goodnum);
		// 页面跳转
		JOptionPane.showMessageDialog(null, "加入购物车成功");
		model.setViewName("/page/user/lookGood");
			}
		}
		return model;

	}
	/**
	 * 用户结算订单
	 * @param order_id
	 * @param address_id
	 * @param pay_type
	 * @param address_name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/accountShoppingCar")
	public ModelAndView accountShoppingCar(int order_id,int address_id,String pay_type,String address_name,String good_name,int good_price,int good_num,HttpServletRequest request) throws Exception{
		ModelAndView model=new ModelAndView();
		HttpSession session = request.getSession();
		ShoppingRole loginUser =(ShoppingRole) session.getAttribute("currvalRole");
		//根据订单id查询订单
		ShoppingOrder queryOrderById = userbiz.queryOrderById(order_id);
		//将页面传过来的支付方式添加到订单中
		queryOrderById.setPay_type(pay_type);
		//格式化当前时间
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd号HH:mm:ss");
		String formatTime = sdf.format(date);
		//将当前时间插入当前order对象中
		queryOrderById.setOrder_time(formatTime);
		//检测到付款成功后，将状态置为1
		//queryOrderById.setOrder_state("1");
		//根据订单id查询订单详情
		ShoppingOrderline queryOrderlineById = userbiz.queryOrderlineById(order_id);
		//将页面上传过来的地址id和地址内容插入订单详情表
		queryOrderlineById.setAddress_id(address_id);
		queryOrderlineById.setAddress_name(address_name);
		//检测到付款成功后，将状态置为1
		//queryOrderlineById.setOrder_state("1");
		//更新订单表
		userbiz.updateOrderById(queryOrderById);
		//更新订单详情表
		userbiz.updateOrderlineById(queryOrderlineById);
		if(pay_type.equals("1")||pay_type.equals("2")){
			int payTypeInt = Integer.parseInt(pay_type);
			String sendPays = PaysTest.sendPays(order_id,loginUser.getRole_id(),good_name,payTypeInt,(double)(good_price*good_num)/100);
			//System.out.println("orderid:"+order_id+",orderuid:"+loginUser.getRole_id()+",goodsname:"+good_name+",paytype:"+payTypeInt+",price:"+(double)(good_price*good_num)/100);
			session.setAttribute("payResult", sendPays);
			//如果是货到付款方式则不调用支付接口
			}else if(pay_type.equals("3")){
				session.setAttribute("currvalOrder",queryOrderById);
				session.setAttribute("curravlOrderline", queryOrderlineById);
			}
			model.setViewName("/page/user/payResult");
			
			return model;
	}
	/**
	 * 用户发起退单申请
	 * @param order_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/backOrder")
	public ModelAndView backOrder(int order_id)throws Exception{
		ModelAndView model=new ModelAndView();
		//根据订单id查询订单
		ShoppingOrder queryOrderById = userbiz.queryOrderById(order_id);
		//格式化当前时间
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd号HH:mm:ss");
		String formatTime = sdf.format(date);
		//将当前时间插入当前order对象中
		queryOrderById.setOrder_time(formatTime);
		//将订单状态置为4，待退款状态，等待店铺同意
		queryOrderById.setOrder_state("4");
		//根据订单id查询订单详情对象
		ShoppingOrderline queryOrderlineById = userbiz.queryOrderlineById(order_id);
		//将订单状态置为4，待退款状态，等待店铺同意
		queryOrderlineById.setOrder_state("4");
		//更新订单表
		userbiz.updateOrderById(queryOrderById);
		//更新订单详情表
		userbiz.updateOrderlineById(queryOrderlineById);
		// 页面跳转
		JOptionPane.showMessageDialog(null, "已发起退单申请，请等待店铺处理");
		model.setViewName("/page/user/lookOrder");
		return model;
	}

	/**
	 * 用户收藏某件商品
	 * 
	 * @param good_id
	 * @param goodnum
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userAddCollectGood")
	public ModelAndView userAddCollectGood(Integer good_id,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 创建ModelAndView对象
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
			if(loginUser.getRole_type().equals("1")){
				// 页面跳转
				JOptionPane.showMessageDialog(null, "您当前角色为店铺，请切换用户登录");
				model.setViewName("/page/roleLogin");	
			}else if (loginUser.getRole_type().equals("0")) {
				// 页面跳转
				JOptionPane.showMessageDialog(null, "您当前角色为管理员，请切换用户登录");
				model.setViewName("/page/roleLogin");
			}else {
				boolean collectRepeat=false;
		List<CollectGood> queryCollectGoodByUserId = userbiz.queryCollectGoodByUserId(loginUser.getRole_id());
		for(CollectGood collectGood:queryCollectGoodByUserId){
			if(good_id==collectGood.getGood_id()){
				// 页面跳转
				collectRepeat=true;
				break;
			}
		}
		if(!collectRepeat){
			
		// 创建CollectGood对象
		CollectGood collectGood = new CollectGood();
		// 向收藏表中添加商品id
		collectGood.setGood_id(good_id);
		// 向订单表中添加当前用户id
		collectGood.setUser_id(loginUser.getRole_id());
		// 根据商品id获取当前商品对象以获取商品所属店铺id
		ShoppingGood queryGoodById = userbiz.queryGoodById(good_id);
		// 向收藏商品表中添加商品所属店铺id
		collectGood.setStore_id(queryGoodById.getStore_id());
		// 将商品名字插入到收藏对象中
		collectGood.setGood_name(queryGoodById.getGood_name());
		// 根据商品id查询图片路径
		String queryImageRouteById = userbiz.queryImageRouteById(good_id);
		// 将图片路径插入收藏对象中
		collectGood.setImage_route(queryImageRouteById);
		// 向收藏表中添加数据
		userbiz.insertCollectGood(collectGood);
		// 页面跳转
		JOptionPane.showMessageDialog(null, "收藏成功");
		model.setViewName("/page/user/lookGoodLine");
		}else {
			JOptionPane.showMessageDialog(null, "此商品已收藏");
			model.setViewName("/page/user/lookGood");
		}
			}
		}
		
		return model;
	}

	/**
	 * 用户查询自己的订单
	 * 
	 * @param good_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookOrder")
	public ModelAndView userLookOrder(HttpServletRequest request)
			throws Exception {
		// 创建ModelAndView对象
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
		// 查询当前用户的所有订单信息，返回一个集合
		List<ShoppingOrder> orders = userbiz.queryOrderByUserId(loginUser
				.getRole_id());

		// 页面跳转
		model.addObject("shoppingOrders", orders);
		model.setViewName("/page/user/lookOrder");
		}
		return model;

	}

	/**
	 * 用户查看自己的购物车
	 * 
	 * @param good_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookShoppingCar")
	public ModelAndView userLookShoppingCar(HttpServletRequest request)
			throws Exception {
		// 创建ModelAndView对象
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
		// 查询当前用户的所有订单信息，返回一个数组
		List<ShoppingOrder> orders = userbiz.queryShoppingCarByUserId(loginUser
				.getRole_id());
		// 页面跳转
		model.addObject("shoppingCars", orders);
		model.setViewName("/page/user/lookShoppingCar");
		}
		return model;

	}
	/**
	 * 用户查看自己的代发货
	 * 
	 * @param good_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookWaitDeliver")
	public ModelAndView userLookWaitDeliver(HttpServletRequest request)
			throws Exception {
		// 创建ModelAndView对象
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
		// 查询当前用户的所有订单信息，返回一个数组
		List<ShoppingOrder> orders = userbiz.queryWaitDeliverGoodByUserId(loginUser
				.getRole_id());
		// 页面跳转
		model.addObject("waitDeliverGoods", orders);
		model.setViewName("/page/user/lookWaitDeliverGood");
		}
		return model;

	}
	/**
	 * 用户查看自己的待收货
	 * 
	 * @param good_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookWaitReceipt")
	public ModelAndView userLookWaitReceipt(HttpServletRequest request)
			throws Exception {
		// 创建ModelAndView对象
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
		// 查询当前用户的所有订单信息，返回一个数组
		List<ShoppingOrder> orders = userbiz.queryWaitReceiptGoodByUserId(loginUser
				.getRole_id());
		// 页面跳转
		model.addObject("waitReceiptGoods", orders);
		model.setViewName("/page/user/lookWaitReceiptGood");
		}
		return model;

	}
	/**
	 * 用户查看自己的待评价
	 * 
	 * @param good_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookWaitAssess")
	public ModelAndView userLookWaitAssess(HttpServletRequest request)
			throws Exception {
		// 创建ModelAndView对象
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
		// 查询当前用户的所有订单信息，返回一个数组
		List<ShoppingOrder> orders = userbiz.queryWaitAssessGoodByUserId(loginUser
				.getRole_id());
		// 页面跳转
		model.addObject("waitAssessGoods", orders);
		model.setViewName("/page/user/lookWaitAssessGood");
		}
		return model;

	}
	/**
	 * 用户查看自己的待退款
	 * 
	 * @param good_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookWaitBackMoney")
	public ModelAndView userLookWaitBackMoney(HttpServletRequest request)
			throws Exception {
		// 创建ModelAndView对象
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
		// 查询当前用户的所有订单信息，返回一个数组
		List<ShoppingOrder> orders = userbiz.queryWaitBackMoneyByUserId(loginUser
				.getRole_id());
		// 页面跳转
		model.addObject("waitBackMoneys", orders);
		model.setViewName("/page/user/lookWaitBackMoney");
		}
		return model;

	}
	/**
	 * 用户查看自己的已退款
	 * 
	 * @param good_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookBackMoney")
	public ModelAndView userLookBackMoney(HttpServletRequest request)
			throws Exception {
		// 创建ModelAndView对象
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
		// 查询当前用户的所有订单信息，返回一个数组
		List<ShoppingOrder> orders = userbiz.queryBackMoneyByUserId(loginUser
				.getRole_id());
		// 页面跳转
		model.addObject("BackMoneys", orders);
		model.setViewName("/page/user/lookBackMoney");
		}
		return model;

	}
	/**
	 * 用户查看自己的已完成
	 * 
	 * @param good_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookOverOrder")
	public ModelAndView userLookOverOrder(HttpServletRequest request)
			throws Exception {
		// 创建ModelAndView对象
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
		// 查询当前用户的所有订单信息，返回一个数组
		List<ShoppingOrder> orders = userbiz.queryOverOrderByUserId(loginUser
				.getRole_id());
		// 页面跳转
		model.addObject("overOrders", orders);
		model.setViewName("/page/user/lookOverOrder");
		}
		return model;

	}

	/**
	 * 用户查看自己的收藏
	 * 
	 * @param good_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookCollectGood")
	public ModelAndView userLookCollectGood(HttpServletRequest request)
			throws Exception {
		// 创建ModelAndView对象
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
		// 查询当前用户的所有订单信息，返回一个数组
		List<CollectGood> collectGoods = userbiz
				.queryCollectGoodByUserId(loginUser.getRole_id());
		// 页面跳转
		model.addObject("collectGoods", collectGoods);
		model.setViewName("/page/user/lookCollectGood");
		}
		return model;

	}

	/**
	 * 用户添加地址
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addUserAddress")
	public ModelAndView addUserAddress(RoleAddress address,
			HttpServletRequest request) throws Exception {
		// 创建ModelAndView对象
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
		// 将当前用户id存入roleAddress对象中
		address.setUser_id(loginUser.getRole_id());
		// 将roleAddress对象插表
		userbiz.insertUserAddress(address);
		// 跳转页面
		JOptionPane.showMessageDialog(null, "地址已添加");
		model.setViewName("/page/user/userPage");
		}
		return model;
	}

	/**
	 * 用户删除自己账号信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser(HttpServletRequest request) throws Exception {
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
			int showConfirmDialog = JOptionPane.showConfirmDialog(null,
					"确定注销自身账号吗", "提示", JOptionPane.YES_NO_OPTION);
			if (showConfirmDialog == 0) {
				// 删除自己账号信息
				userbiz.deleteUserById(loginUser.getRole_id());
				JOptionPane.showMessageDialog(null, "账号已注销");
				// 跳转页面
				model.setViewName("/page/roleLogin");
			} else {
				model.setViewName("/page/user/userPage");
			}
		
		}
		return model;
	}

	/**
	 * 更新用户信息
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateUserInfo")
	public ModelAndView updateUser(ShoppingRole role) throws Exception {
		ModelAndView model = new ModelAndView();
		userbiz.updateUserById(role);
		JOptionPane.showMessageDialog(null, "信息已更新");
		model.setViewName("/page/user/userPage");
		return model;

	}

	/**
	 * 更新地址信息
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateAddressInfo")
	public ModelAndView updateUser(RoleAddress address) throws Exception {
		ModelAndView model = new ModelAndView();
		userbiz.updateAddressById(address);
		JOptionPane.showMessageDialog(null, "信息已更新");
		model.setViewName("/page/user/userPage");
		return model;

	}

	/**
	 * 删除某件收藏商品
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteCollectGood")
	public ModelAndView deleteCollectGood(int collect_id) throws Exception {
		ModelAndView model = new ModelAndView();
		userbiz.deleteCollectGoodById(collect_id);
		JOptionPane.showMessageDialog(null, "收藏已删除");
		model.setViewName("/page/user/userPage");
		return model;

	}

	/**
	 * 用户收藏某家店铺
	 * 
	 * @param store_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userAddCollectStore")
	public ModelAndView userAddCollectStore(Integer store_id,
			HttpServletRequest request) throws Exception {
		// 创建ModelAndView对象
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
			boolean collectRepeat=false;
			List<CollectStore> queryCollectStoreByUserId = userbiz.queryCollectStoreByUserId(loginUser.getRole_id());
			for(CollectStore collectStore:queryCollectStoreByUserId){
				if(store_id==collectStore.getStore_id()){
					collectRepeat=true;
					break;
				}
			}
			if(!collectRepeat){
			
		// 创建CollectStore对象
		CollectStore collectStore = new CollectStore();
		// 向收藏表中添加店铺id
		collectStore.setStore_id(store_id);
		// 向收藏表中添加当前用户id
		collectStore.setUser_id(loginUser.getRole_id());
		// 根据店铺id查询店铺对象
		ShoppingRole queryStoreById = userbiz.queryRoleById(store_id);
		// 向收藏表中添加店铺名
		collectStore.setStore_name(queryStoreById.getRole_name());
		// 向收藏表中添加数据
		userbiz.insertCollectStore(collectStore);
		// 页面跳转
		JOptionPane.showMessageDialog(null, "收藏成功");
		model.setViewName("/page/user/lookStore");
			}else {
				JOptionPane.showMessageDialog(null, "此店铺已收藏");
				model.setViewName("/page/user/lookStore");
			}
		}
		return model;
	}

	/**
	 * 用户查看自己的收藏店铺
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookCollectStore")
	public ModelAndView userLookCollectStore(HttpServletRequest request)
			throws Exception {
		// 创建ModelAndView对象
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
		// 查询当前用户的所有收藏店铺信息，返回一个数组
		List<CollectStore> collectStores = userbiz
				.queryCollectStoreByUserId(loginUser.getRole_id());
		// 页面跳转
		model.addObject("collectStores", collectStores);
		model.setViewName("/page/user/lookCollectStore");
		}
		return model;

	}

	/**
	 * 删除某件收藏店铺
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteCollectStore")
	public ModelAndView deleteCollectStore(int collect_id) throws Exception {
		ModelAndView model = new ModelAndView();
		userbiz.deleteCollectStoreById(collect_id);
		JOptionPane.showMessageDialog(null, "收藏已删除");
		model.setViewName("/page/user/userPage");
		return model;

	}

	/**
	 * 删除某个地址
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteAddressById")
	public ModelAndView deleteAddressById(int address_id) throws Exception {
		ModelAndView model = new ModelAndView();
		userbiz.deleteAddressById(address_id);
		JOptionPane.showMessageDialog(null, "地址已删除");
		model.setViewName("/page/user/userPage");
		return model;

	}

	/**
	 * 删除某张订单及其详情
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteOrderById")
	public ModelAndView deleteOrderById(int order_id) throws Exception {
		ModelAndView model = new ModelAndView();
		userbiz.deleteOrderAndLineById(order_id);
		JOptionPane.showMessageDialog(null, "定单已删除");
		model.setViewName("/page/user/userPage");
		return model;

	}

	/**
	 * 用户评价某件商品
	 * 
	 * @param store_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userAssessGood")
	public ModelAndView userAssessGood(String assess_content, Integer good_id,Integer order_id,
			HttpServletRequest request) throws Exception {
		// 创建ModelAndView对象
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
		ShoppingOrder queryOrderById = userbiz.queryOrderById(order_id);
		ShoppingOrderline queryOrderlineById = userbiz.queryOrderlineById(order_id);
		queryOrderById.setOrder_state("Y");
		queryOrderlineById.setOrder_state("Y");
		// 创建goodAssess对象
		GoodAssess assess = new GoodAssess();
		//
		assess.setUser_id(loginUser.getRole_id());
		// 向评价表中添加商品id
		assess.setGood_id(good_id);
		// 向评价表中添加当前评价内容
		assess.setAssess_content(assess_content);
		// 获取当前系统时间，并将其格式化为字符串存入订单中
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd号HH:mm:ss");
		String formatDate = sdf.format(date);
		// 向评价表中添加时间
		assess.setAssess_time(formatDate);
		// 根据商品id查询商品对象
		ShoppingGood queryGoodById = userbiz.queryGoodById(good_id);
		// 向评价表中添加商品名
		assess.setGood_name(queryGoodById.getGood_name());
		// 根据商品id查询图片路径
		String queryImageRouteById = userbiz.queryImageRouteById(good_id);
		// 向评价表中添加图片路径
		assess.setImage_route(queryImageRouteById);
		//向评价表中添加用户名
		assess.setUser_name(loginUser.getRole_name());
		// 向收藏表中添加数据
		userbiz.insertGoodAssess(assess);
		//更新订单及详情状态
		userbiz.updateOrderById(queryOrderById);
		userbiz.updateOrderlineById(queryOrderlineById);
		// 页面跳转
		JOptionPane.showMessageDialog(null, "评价成功");
		model.setViewName("/page/user/lookWaitAssessGood");
		}
		
		return model;

	}
	/**
	 * 用户取消退款申请
	 * @param order_id
	 * @throws Exception
	 */
	@RequestMapping("/userNotBackMoney")
	public void userNotBackMoney(int order_id)throws Exception{
		ShoppingOrder queryOrderById = userbiz.queryOrderById(order_id);
		ShoppingOrderline queryOrderlineById = userbiz.queryOrderlineById(order_id);
		queryOrderById.setOrder_state("2");
		queryOrderlineById.setOrder_state("2");
		userbiz.updateOrderById(queryOrderById);
		userbiz.updateOrderlineById(queryOrderlineById);
		JOptionPane.showMessageDialog(null, "退款申请已取消");
		
	}

	/**
	 * 用户查看自己的评价商品
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookGoodAssess")
	public ModelAndView userLookGoodAssess(HttpServletRequest request)
			throws Exception {
		// 创建ModelAndView对象
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
		// 查询当前用户的所有收藏店铺信息，返回一个数组
		List<GoodAssess> goodAssesses = userbiz
				.queryGoodAssessByUserId(loginUser.getRole_id());
		// 页面跳转
		model.addObject("goodAssesses", goodAssesses);
		model.setViewName("/page/user/lookAssessGood");
		}
		return model;

	}

	/**
	 * 删除某个评价
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteAssessById")
	public ModelAndView deleteAssessById(int assess_id) throws Exception {
		ModelAndView model = new ModelAndView();
		userbiz.deleteGoodAssessById(assess_id);
		JOptionPane.showMessageDialog(null, "评价已删除");
		model.setViewName("/page/user/userPage");
		return model;

	}
	/**
	 * 根据商品名查询商品
	 * @param good_name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryGoodByName")
	public ModelAndView queryGoodByName(String good_name)throws Exception{
		ModelAndView model=new ModelAndView();
		//根据商品名模糊查询商品
		System.out.println(good_name);
		List<ShoppingGood> queryGoodByName = userbiz.queryGoodByName(good_name);
		model.addObject("queryGoods", queryGoodByName);
		model.setViewName("/page/user/queryGood");
		return model;
	}
	/**
	 * 用户浏览店铺
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookStore")
	public ModelAndView userLookStore(HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		// 查询店铺数量
		int storeCount = userbiz.queryStoreCount();
		// System.out.println("goodcount:"+goodCount);
		double pagenum = (double) storeCount / 4;
		// System.out.println("pagenum"+pagenum);
		// 调用math类的向上取整函数进行分页
		storePageCount = (int) Math.ceil(pagenum);
		// 查询出第一页所有店铺
		List<ShoppingRole> queryStores = userbiz.queryStores(storePage);
		// 创建集合存储店铺信息
		List<StoreInfo> storeInfos = new ArrayList<StoreInfo>();
		for (ShoppingRole store : queryStores) {
			// 根据店铺id查询店铺信息
			StoreInfo storeInfo = userbiz.queryStoreInfoById(store.getRole_id());
			// 将goodinfo对象存放如集合中
			storeInfos.add(storeInfo);
		}
		// 将查询出的商品集合存入modelAndView中
		// model.addObject("goodinfos", goodInfos);
		// 将查出的数据存入session中
		request.getSession().setAttribute("storeinfos", storeInfos);
		request.getSession().setAttribute("storePageCount", storePageCount);
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/user/lookStore");
		return model;
	}
	/**
	 * 用户点击上一页查询上一页店铺
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookStoreBack")
	public ModelAndView userLookStoreBack(HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		storePage -= 1;
		if (storePage <= 0) {
			storePage = 1;
		} else {
		// 查询店铺数量
		int storeCount = userbiz.queryStoreCount();
		// System.out.println("goodcount:"+goodCount);
		double pagenum = (double) storeCount / 4;
		// System.out.println("pagenum"+pagenum);
		// 调用math类的向上取整函数进行分页
		storePageCount = (int) Math.ceil(pagenum);
		// 查询出第一页所有店铺
		List<ShoppingRole> queryStores = userbiz.queryStores(storePage);
		// 创建集合存储店铺信息
		List<StoreInfo> storeInfos = new ArrayList<StoreInfo>();

		for (ShoppingRole store : queryStores) {
			// 根据店铺id查询店铺信息
			StoreInfo storeInfo = userbiz.queryStoreInfoById(store.getRole_id());
			// 将goodinfo对象存放如集合中
			storeInfos.add(storeInfo);
		}

		// 将查询出的商品集合存入modelAndView中
		// model.addObject("goodinfos", goodInfos);
		// 将查出的数据存入session中
		request.getSession().setAttribute("storeinfos", storeInfos);
		request.getSession().setAttribute("storePageCount", storePageCount);
		}
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/user/lookStore");
		return model;
	}
	/**
	 * 用户点击下一页查询下一页店铺
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookStoreNext")
	public ModelAndView userLookStoreNext(HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		storePage += 1;
		if (storePage <= 0) {
			storePage = 1;
		} else {
		// 查询店铺数量
		int storeCount = userbiz.queryStoreCount();
		// System.out.println("goodcount:"+goodCount);
		double pagenum = (double) storeCount / 4;
		// System.out.println("pagenum"+pagenum);
		// 调用math类的向上取整函数进行分页
		storePageCount = (int) Math.ceil(pagenum);
		// 查询出第一页所有店铺
		List<ShoppingRole> queryStores = userbiz.queryStores(storePage);
		// 创建集合存储店铺信息
		List<StoreInfo> storeInfos = new ArrayList<StoreInfo>();

		for (ShoppingRole store : queryStores) {
			// 根据店铺id查询店铺信息
			StoreInfo storeInfo = userbiz.queryStoreInfoById(store.getRole_id());
			// 将goodinfo对象存放如集合中
			storeInfos.add(storeInfo);
		}

		// 将查询出的商品集合存入modelAndView中
		// model.addObject("goodinfos", goodInfos);
		// 将查出的数据存入session中
		request.getSession().setAttribute("storeinfos", storeInfos);
		request.getSession().setAttribute("storePageCount", storePageCount);
		}
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/user/lookStore");
		return model;
	}
	/**
	 * 用户输入页数向固定页数跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookStoreJump")
	public ModelAndView userLookStoreJump(Integer jumpPage,HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		storePage=jumpPage;
		// 查询店铺数量
		int storeCount = userbiz.queryStoreCount();
		// System.out.println("goodcount:"+goodCount);
		double pagenum = (double) storeCount / 4;
		// System.out.println("pagenum"+pagenum);
		// 调用math类的向上取整函数进行分页
		storePageCount = (int) Math.ceil(pagenum);
		// 查询出第一页所有店铺
		List<ShoppingRole> queryStores = userbiz.queryStores(storePage);
		// 创建集合存储店铺信息
		List<StoreInfo> storeInfos = new ArrayList<StoreInfo>();

		for (ShoppingRole store : queryStores) {
			// 根据店铺id查询店铺信息
			StoreInfo storeInfo = userbiz.queryStoreInfoById(store.getRole_id());
			// 将goodinfo对象存放如集合中
			storeInfos.add(storeInfo);
		}

		// 将查询出的商品集合存入modelAndView中
		// model.addObject("goodinfos", goodInfos);
		// 将查出的数据存入session中
		request.getSession().setAttribute("storeinfos", storeInfos);
		request.getSession().setAttribute("storePageCount", storePageCount);
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/user/lookStore");
		return model;
	}
	/**
	 * 根据店铺id查询店铺详细信息并且查看其商品
	 * @param store_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userLookStoreLine")
	public ModelAndView userLookStoreLine(Integer store_id,HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		//根据store_id查询shoppingRole表中信息
		ShoppingRole queryStoreById = userbiz.queryRoleById(store_id);
		// 根据店铺id查询店铺信息
		StoreInfo storeInfo = userbiz.queryStoreInfoById(store_id);
		//根据店铺id查询地址
		List<RoleAddress> queryAddressByStoreId = userbiz.queryAddressByStoreId(store_id);
		//根据店铺id查询其商品
		List<ShoppingGood> queryGoods = userbiz.queryStoreGoods(store_id);
		// 创建集合存储商品信息
		List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();
		for (ShoppingGood good : queryGoods) {
			GoodInfo goodinfo = new GoodInfo();
			// 根据商品id查询商品价格封装到GoodPrice对象中
			int queryPriceById = userbiz.queryPriceById(good.getGood_id());
			GoodPrice price = new GoodPrice();
			price.setPrice_num(queryPriceById);
			// 根据商品id查询商品图片路径封装到GoodImage对象中
			String queryImageRouteById = userbiz.queryImageRouteById(good
					.getGood_id());
			GoodImage image = new GoodImage();
			image.setImage_route(queryImageRouteById);
			// 根据商品id查询商品销量封装到goodSale对象中
			int querySaleById = userbiz.querySaleById(good.getGood_id());
			GoodSale sale = new GoodSale();
			sale.setSale_num(querySaleById);
			// 根据商品id查询商品余量封装到GoodMargin对象中
			int queryMarginById = userbiz.queryMarginById(good.getGood_id());
			GoodMargin margin = new GoodMargin();
			margin.setMargin_num(queryMarginById);
			// 根据商品id查询商品属性
			GoodProperties queryPropertiesById = userbiz
					.queryPropertiesById(good.getGood_id());
			// 根据商品id查询商品评价
			List<GoodAssess> queryAssessById = userbiz.queryAssessById(good
					.getGood_id());
			// 把ShoppingGood对象封装进GoodInfo中
			goodinfo.setGood(good);
			// 把GoodPrice对象封装进GoodInfo中
			goodinfo.setGoodPrice(price);
			// 把GoodImage对象封装进GoodInfo中
			goodinfo.setGoodImage(image);
			// 把GoodSale对象封装进GoodInfo中
			goodinfo.setGoodSale(sale);
			// 把GoodMargin对象封装进GoodInfo中
			goodinfo.setGoodMargin(margin);
			// 把GoodProperties对象封装进GoodInfo中
			goodinfo.setGoodProperties(queryPropertiesById);
			// 把GoodAssess对象封装进GoodInfo中
			goodinfo.setGoodAssesses(queryAssessById);
			// 将goodinfo对象存放如集合中
			goodInfos.add(goodinfo);
		}
		model.addObject("store", queryStoreById);
		model.addObject("storeinfo", storeInfo);
		model.addObject("storeAddresses", queryAddressByStoreId);
		model.addObject("goodinfos", goodInfos);
		model.setViewName("/page/user/lookStoreLine");
		return model;
	}
	/**
	 * 用户确认收货
	 * @param order_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userReceiptGood")
	public ModelAndView userReceiptGood(int order_id)throws Exception{
		ModelAndView model=new ModelAndView();
		userbiz.updateOrderStateReceiptGood(order_id);
		userbiz.updateOrderlineStateReceiptGood(order_id);
		JOptionPane.showMessageDialog(null, "已确认收货");
		model.setViewName("/page/user/lookWaitReceiptGood");
		return model;
	}
	
}
