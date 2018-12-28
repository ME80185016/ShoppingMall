package com.hds.controller;

import java.io.IOException;
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

import com.hds.biz.StoreBiz;
import com.hds.entity.GoodAssess;
import com.hds.entity.GoodImage;
import com.hds.entity.GoodInfo;
import com.hds.entity.GoodMargin;
import com.hds.entity.GoodPrice;
import com.hds.entity.GoodProperties;
import com.hds.entity.GoodSale;
import com.hds.entity.RoleAddress;
import com.hds.entity.ShoppingGood;
import com.hds.entity.ShoppingOrder;
import com.hds.entity.ShoppingOrderline;
import com.hds.entity.ShoppingRole;
import com.hds.entity.StoreInfo;
import com.hds.util.sms.RandomTest;
import com.hds.util.sms.SMSTest;
import com.hds.util.sms.UserRegisterFilter;

/**
 * storeController,该类包含店铺的一些操作，如注册，登录，商品上架与下架...
 * 
 * @author 离
 *
 */
@Controller
@RequestMapping("/store")
public class StoreController {
	@Autowired
	private StoreBiz storebiz;
	private int yzmNumber = RandomTest.getNum();// 调用工具类方法产生四位随机数
	private static int page = 1;
	private static int pageCount = 0;

	/**
	 * 店铺登出
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
			model.setViewName("/page/store/storePage");
		}
		return model;
	}
	/**
	 * 店铺注册方法，注册完等待管理员审核
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/storeRegist")
	public ModelAndView userRegist(ShoppingRole role, StoreInfo storeInfo,HttpServletRequest request)
			throws Exception {
		String role_yzm=request.getParameter("role_yzm");
		String yzm=String.valueOf(yzmNumber);
		//创建modelAndView对象
		ModelAndView model = new ModelAndView();
		//验证店铺名是否重复
		boolean userNameRepeat = UserRegisterFilter.userNameRepeat(role.getRole_name());
		if(userNameRepeat){
			JOptionPane.showMessageDialog(null,"店铺名重复，请重新输入!");
			model.setViewName("/page/store/storeRegist");
		}else {
			int showConfirmDialog = JOptionPane.showConfirmDialog(null, "店铺名可用，是否确定使用？", "店铺名确定", JOptionPane.YES_NO_OPTION);
			if(showConfirmDialog==0){
				if(role_yzm.equals(yzm)){
					storebiz.storeRegist(role);
					//获取新注册店铺的id
					int selectStoreIdCurrval = storebiz.selectStoreIdCurrval();
					//为店铺信息添加属性
					storeInfo.setStore_id(selectStoreIdCurrval);
					//从角色表中取出角色名作为店铺信息表里的店铺名
					storeInfo.setStore_name(role.getRole_name());
					//将店铺信息插入到store_info表中
					storebiz.addStoreInfo(storeInfo);
					JOptionPane.showMessageDialog(null,"注册成功，请登录!");
					model.setViewName("/page/roleLogin");
				}else {
					JOptionPane.showMessageDialog(null,"验证码不正确，请重新输入!");
					model.setViewName("/page/store/storeRegist");
				}
				
			}else {
				model.setViewName("/page/store/storeRegist");
			}
		
	  }
		
		return model;

	}

	/**
	 * 通过用户输入的手机号调用短信接口获取验证码
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getyzm")
	public void getYzm(HttpServletRequest request,HttpServletResponse response,String rolename,String roletel) throws Exception {
		System.out.println("用户名:"+rolename+"电话"+roletel);
		try {
			int sendSMS = SMSTest.sendSMS(yzmNumber, rolename, roletel);// 调用工具类的方法向手机号发送短信
			String data=Integer.toString(sendSMS);
			response.setContentType("application/text; charset=utf-8");
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
	 * 店铺根据店铺名登录
	 * 
	 * @param role_name
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/storeLoginByName")
	public String storeLoginByName(String role_name, HttpServletRequest request)
			throws Exception {
		ShoppingRole storeLoginByName = storebiz.storeLoginByName(role_name);
		String role_pwd = request.getParameter("role_pwd");
		if (storeLoginByName != null) {
			if (storeLoginByName.getRole_pwd().equals(role_pwd)) {
				request.getSession().setAttribute("currvalRole", storeLoginByName);
				return "/page/store/storePage";
			} else {
				JOptionPane.showMessageDialog(null,"密码错误，请重新输入!");
				return "/page/roleLogin";
			}
		} else {
			JOptionPane.showMessageDialog(null,"店铺名不存在，请重新输入!");
			return "/page/roleLogin";
		}

	}

	/**
	 * 根据店铺注册手机号登录
	 * 
	 * @param role_tel
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/storeLoginByTel")
	public String storeLoginByTel(String role_tel, HttpServletRequest request)
			throws Exception {
		ShoppingRole storeLoginByTel = storebiz.storeLoginByTel(role_tel);
		String role_pwd = request.getParameter("role_pwd");
		if (storeLoginByTel != null) {
			if (storeLoginByTel.getRole_pwd().equals(role_pwd)) {
				request.getSession().setAttribute("currvalRole", storeLoginByTel);
				return "/page/store/storePage";
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
	 * 店铺上架商品
	 * 
	 * @param good
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "addGood")
	public ModelAndView addGood(GoodInfo goodInfo, HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		// 为商品添加所属的店铺，当前操作的店铺id
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
		goodInfo.getGood().setStore_id(currvalRole.getRole_id());
		goodInfo.getGood().setStore_name(currvalRole.getRole_name());
		storebiz.addGood(goodInfo.getGood());
		int goodIdCurrval = storebiz.selectGoodIdCurrval();
		GoodMargin margin = new GoodMargin();
		// 为商品余量信息添加所属的商品id
		margin.setGood_id(goodIdCurrval);
		margin.setMargin_num(100);
		GoodSale sale = new GoodSale();
		// 为商品销量信息添加所属的商品id
		sale.setGood_id(goodIdCurrval);
		sale.setSale_num(0);
		// 取出存放在页面上name为imageRoute的input标签的值
		String imageRoute = request.getParameter("imageRoute");
		//创建goodImage对象
		GoodImage image=new GoodImage();
		image.setImage_route(imageRoute);
		image.setGood_id(goodIdCurrval);
		goodInfo.setGoodImage(image);
		goodInfo.setGoodMargin(margin);
		goodInfo.getGoodPrice().setGood_id(goodIdCurrval);
		goodInfo.getGoodProperties().setGood_id(goodIdCurrval);
		goodInfo.setGoodSale(sale);
		// 将商品信息添表
		storebiz.addGoodInfo(goodInfo);
		System.out.println(storebiz.selectGoodIdCurrval());
		JOptionPane.showMessageDialog(null, "商品已上架");
		model.setViewName("/page/store/storePage");
		}
		return model;

	}
	/**
	 * 店铺删除自己信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteStore")
	public ModelAndView deleteStore(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		int showConfirmDialog = JOptionPane.showConfirmDialog(null, "确定注销账户？", "删除提示", JOptionPane.YES_NO_OPTION);
		if(showConfirmDialog==0){
			// 为商品添加所属的店铺，当前操作的店铺id
			ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
			//删除自己账号信息
			storebiz.deleteStoreById(currvalRole.getRole_id());
			//跳转页面
			model.setViewName("/index");
		}else {
			model.setViewName("/page/store/lookStoreInfo");
		}
		
		return model;
	}
	/**
	 * 店铺登录后查询自己详细信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/lookStoreInfo")
	public ModelAndView lookStoreInfo(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		// 获取当前登录的店铺
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		//根据店铺id查询店铺信息
		StoreInfo queryStoreInfoById = storebiz.queryStoreInfoById(currvalRole.getRole_id());
		//根据店铺id查询地址
		List<RoleAddress> queryAddressByStoreId = storebiz.queryAddressByStoreId(currvalRole.getRole_id());
		//添加当前店铺信息到session中
		request.getSession().setAttribute("currvalRole", currvalRole);
		request.getSession().setAttribute("currvalRoleInfo", queryStoreInfoById);
		request.getSession().setAttribute("storeAddresses", queryAddressByStoreId);
		//跳转页面
		model.setViewName("/page/store/lookStoreInfo");
		}else {
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * 更新店铺信息
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateStoreInfo")
	public ModelAndView updateStoreInfo(ShoppingRole role,StoreInfo storeInfo) throws Exception {
		ModelAndView model = new ModelAndView();
		storebiz.updateStoreById(role);
		storebiz.updateStoreInfoById(storeInfo);
		
		model.setViewName("/page/user/updateSuccess");
		return model;

	}
	/**
	 * 店铺浏览自家商品
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookGood")
	public ModelAndView storeLookGood(HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		// 获取当前登录的店铺
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		// 查询商品数量
		int goodCount = storebiz.queryGoodCount(currvalRole.getRole_id());
		// System.out.println("goodcount:"+goodCount);
		double pagenum = (double) goodCount / 4;
		// System.out.println("pagenum"+pagenum);
		// 调用math类的向上取整函数进行分页
		pageCount = (int) Math.ceil(pagenum);
		// 查询出第一页所有商品
		List<ShoppingGood> queryGoods = storebiz.queryStoreGoods(currvalRole.getRole_id(),page);
		// 创建集合存储商品信息
		List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();

		for (ShoppingGood good : queryGoods) {
			GoodInfo goodinfo = new GoodInfo();
			// 根据商品id查询商品价格封装到GoodPrice对象中
			// System.out.println(good.getGood_id());
			int queryPriceById = storebiz.queryPriceById(good.getGood_id());
			GoodPrice price = new GoodPrice();
			price.setPrice_num(queryPriceById);
			// 根据商品id查询商品图片路径封装到GoodImage对象中
			String queryImageRouteById = storebiz.queryImageRouteById(good
					.getGood_id());
			GoodImage image = new GoodImage();
			image.setImage_route(queryImageRouteById);
			// 根据商品id查询商品销量封装到goodSale对象中
			int querySaleById = storebiz.querySaleById(good.getGood_id());
			GoodSale sale = new GoodSale();
			sale.setSale_num(querySaleById);
			// 根据商品id查询商品余量封装到GoodMargin对象中
			int queryMarginById = storebiz.queryMarginById(good.getGood_id());
			GoodMargin margin = new GoodMargin();
			margin.setMargin_num(queryMarginById);
			// 根据商品id查询商品属性
			GoodProperties queryPropertiesById = storebiz
					.queryPropertiesById(good.getGood_id());
			// 根据商品id查询商品评价
			List<GoodAssess> queryAssessById = storebiz.queryAssessById(good
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
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/store/storeLookGood");
		}else {
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * 店铺浏览自家商品下一页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookGoodNext")
	public ModelAndView storeLookGoodNext(HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		page+=1;
		
		// 获取当前登录的店铺
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
			if(page>pageCount||page==pageCount){
				page=pageCount;
		// 查询商品数量
		int goodCount = storebiz.queryGoodCount(currvalRole.getRole_id());
		// System.out.println("goodcount:"+goodCount);
		double pagenum = (double) goodCount / 4;
		// System.out.println("pagenum"+pagenum);
		// 调用math类的向上取整函数进行分页
		pageCount = (int) Math.ceil(pagenum);
		// 查询出下一页所有商品
		List<ShoppingGood> queryGoods = storebiz.queryStoreGoods(currvalRole.getRole_id(),page);
		// 创建集合存储商品信息
		List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();

		for (ShoppingGood good : queryGoods) {
			GoodInfo goodinfo = new GoodInfo();
			// 根据商品id查询商品价格封装到GoodPrice对象中
			// System.out.println(good.getGood_id());
			int queryPriceById = storebiz.queryPriceById(good.getGood_id());
			GoodPrice price = new GoodPrice();
			price.setPrice_num(queryPriceById);
			// 根据商品id查询商品图片路径封装到GoodImage对象中
			String queryImageRouteById = storebiz.queryImageRouteById(good
					.getGood_id());
			GoodImage image = new GoodImage();
			image.setImage_route(queryImageRouteById);
			// 根据商品id查询商品销量封装到goodSale对象中
			int querySaleById = storebiz.querySaleById(good.getGood_id());
			GoodSale sale = new GoodSale();
			sale.setSale_num(querySaleById);
			// 根据商品id查询商品余量封装到GoodMargin对象中
			int queryMarginById = storebiz.queryMarginById(good.getGood_id());
			GoodMargin margin = new GoodMargin();
			margin.setMargin_num(queryMarginById);
			// 根据商品id查询商品属性
			GoodProperties queryPropertiesById = storebiz
					.queryPropertiesById(good.getGood_id());
			// 根据商品id查询商品评价
			List<GoodAssess> queryAssessById = storebiz.queryAssessById(good
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
		// 将查出的数据存入session中
		request.getSession().setAttribute("goodinfos", goodInfos);
		request.getSession().setAttribute("pageCount", pageCount);
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/store/storeLookGood");
			}
		}else {
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * 店铺浏览自家商品上一页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookGoodBack")
	public ModelAndView storeLookGoodBack(HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		page-=1;
		// 获取当前登录的店铺
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
			if(page<=1){
				page=1;
		// 查询商品数量
		int goodCount = storebiz.queryGoodCount(currvalRole.getRole_id());
		// System.out.println("goodcount:"+goodCount);
		double pagenum = (double) goodCount / 4;
		// System.out.println("pagenum"+pagenum);
		// 调用math类的向上取整函数进行分页
		pageCount = (int) Math.ceil(pagenum);
		// 查询出上一页所有商品
		List<ShoppingGood> queryGoods = storebiz.queryStoreGoods(currvalRole.getRole_id(),page);
		// 创建集合存储商品信息
		List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();

		for (ShoppingGood good : queryGoods) {
			GoodInfo goodinfo = new GoodInfo();
			// 根据商品id查询商品价格封装到GoodPrice对象中
			// System.out.println(good.getGood_id());
			int queryPriceById = storebiz.queryPriceById(good.getGood_id());
			GoodPrice price = new GoodPrice();
			price.setPrice_num(queryPriceById);
			// 根据商品id查询商品图片路径封装到GoodImage对象中
			String queryImageRouteById = storebiz.queryImageRouteById(good
					.getGood_id());
			GoodImage image = new GoodImage();
			image.setImage_route(queryImageRouteById);
			// 根据商品id查询商品销量封装到goodSale对象中
			int querySaleById = storebiz.querySaleById(good.getGood_id());
			GoodSale sale = new GoodSale();
			sale.setSale_num(querySaleById);
			// 根据商品id查询商品余量封装到GoodMargin对象中
			int queryMarginById = storebiz.queryMarginById(good.getGood_id());
			GoodMargin margin = new GoodMargin();
			margin.setMargin_num(queryMarginById);
			// 根据商品id查询商品属性
			GoodProperties queryPropertiesById = storebiz
					.queryPropertiesById(good.getGood_id());
			// 根据商品id查询商品评价
			List<GoodAssess> queryAssessById = storebiz.queryAssessById(good
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
		// 将查出的数据存入session中
		request.getSession().setAttribute("goodinfos", goodInfos);
		request.getSession().setAttribute("pageCount", pageCount);
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/store/storeLookGood");
			}
		}else {
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * 店铺浏览自家商品指定页数商品
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookGoodJump")
	public ModelAndView storeLookGoodJump(HttpServletRequest request,int jumpPage)
			throws Exception {
		ModelAndView model = new ModelAndView();
		// 获取当前登录的店铺
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
			if(jumpPage>=pageCount){
				page=pageCount;
			}else if(jumpPage<=1){
				jumpPage=1;
			}
		// 查询商品数量
		int goodCount = storebiz.queryGoodCount(currvalRole.getRole_id());
		// System.out.println("goodcount:"+goodCount);
		double pagenum = (double) goodCount / 4;
		// System.out.println("pagenum"+pagenum);
		// 调用math类的向上取整函数进行分页
		pageCount = (int) Math.ceil(pagenum);
		// 查询出指定页数的商品
		List<ShoppingGood> queryGoods = storebiz.queryStoreGoods(currvalRole.getRole_id(),jumpPage);
		// 创建集合存储商品信息
		List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();

		for (ShoppingGood good : queryGoods) {
			GoodInfo goodinfo = new GoodInfo();
			// 根据商品id查询商品价格封装到GoodPrice对象中
			// System.out.println(good.getGood_id());
			int queryPriceById = storebiz.queryPriceById(good.getGood_id());
			GoodPrice price = new GoodPrice();
			price.setPrice_num(queryPriceById);
			// 根据商品id查询商品图片路径封装到GoodImage对象中
			String queryImageRouteById = storebiz.queryImageRouteById(good
					.getGood_id());
			GoodImage image = new GoodImage();
			image.setImage_route(queryImageRouteById);
			// 根据商品id查询商品销量封装到goodSale对象中
			int querySaleById = storebiz.querySaleById(good.getGood_id());
			GoodSale sale = new GoodSale();
			sale.setSale_num(querySaleById);
			// 根据商品id查询商品余量封装到GoodMargin对象中
			int queryMarginById = storebiz.queryMarginById(good.getGood_id());
			GoodMargin margin = new GoodMargin();
			margin.setMargin_num(queryMarginById);
			// 根据商品id查询商品属性
			GoodProperties queryPropertiesById = storebiz
					.queryPropertiesById(good.getGood_id());
			// 根据商品id查询商品评价
			List<GoodAssess> queryAssessById = storebiz.queryAssessById(good
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
		// 将查出的数据存入session中
		request.getSession().setAttribute("goodinfos", goodInfos);
		request.getSession().setAttribute("pageCount", pageCount);
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/store/storeLookGood");
			
		}else {
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * 店铺根据商品id删除商品
	 * @param good_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteGoodInfo")
	public ModelAndView deleteGoodInfo(int good_id)throws Exception{
		ModelAndView model=new ModelAndView();
		//删除商品相关信息
		storebiz.deleteGoodById(good_id);
		storebiz.deletePriceById(good_id);
		storebiz.deleteImageRoute(good_id);
		storebiz.deleteAssessById(good_id);
		storebiz.deleteMarginById(good_id);
		storebiz.deletePropertiesById(good_id);
		storebiz.deleteSaleById(good_id);
		JOptionPane.showMessageDialog(null, "商品已下架");
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/store/storeLookGood");
		return model;
	}
	/**
	 * 店铺更新自家商品信息
	 * @param goodInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateGoodInfo")
	public ModelAndView updateGoodInfo(GoodInfo goodInfo)throws Exception{
		//System.out.println("good_name:"+goodInfo.getGood().getGood_name());
		//System.out.println("good_total:"+goodInfo.getGoodProperties().getGood_total());
		ModelAndView model=new ModelAndView();
		storebiz.updateGoodInfo(goodInfo);
		//跳转页面
		JOptionPane.showMessageDialog(null, "商品信息已更新");
		model.setViewName("/page/store/storeLookGood");
		return model;
	}
	/**
	 * 店铺查看其全部订单
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookOrder")
	public ModelAndView StoreLookOrder(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		// 获取当前登录的店铺
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		//查询自家店铺用户已付款店铺未发货的订单
		List<ShoppingOrder> queryOrderByStoreId = storebiz.queryOrderByStoreId(currvalRole.getRole_id());
		//存入数据
		model.addObject("storeLookOrders", queryOrderByStoreId);
		//跳转页面
		model.setViewName("/page/store/lookOrder");
		}else {
			JOptionPane.showMessageDialog(null,"请先登录!");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * 店铺查看待发货订单
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookWaitDeliver")
	public ModelAndView storeLookWaitDeliver(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		// 获取当前登录的店铺
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		//查询自家店铺用户已付款店铺未发货的订单
		List<ShoppingOrder> queryOrderByStoreId = storebiz.queryWaitDeliverGoodByStoreId(currvalRole.getRole_id());
		//存入数据
		model.addObject("storeLookWaitDeliver", queryOrderByStoreId);
		//跳转页面
		model.setViewName("/page/store/storeLookWaitDeliver");
		}else {
			JOptionPane.showMessageDialog(null,"请先登录!");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * 店铺查看待收货订单
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookWaitReceipt")
	public ModelAndView storeLookWaitReceipt(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		// 获取当前登录的店铺
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		//查询自家店铺用户已付款店铺未发货的订单
		List<ShoppingOrder> queryReceiptOrderByStoreId = storebiz.queryWaitReceiptGoodByStoreId(currvalRole.getRole_id());
		//存入数据
		model.addObject("storeLookWaitReceipt", queryReceiptOrderByStoreId);
		//跳转页面
		model.setViewName("/page/store/storeLookWaitReceipt");
		}else {
			JOptionPane.showMessageDialog(null,"请先登录!");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * 店铺查看待评价订单
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookWaitAssess")
	public ModelAndView storeLookWaitAssess(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		// 获取当前登录的店铺
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		//查询自家店铺待评价的订单
		List<ShoppingOrder> queryAssessOrderByStoreId = storebiz.queryWaitAssessGoodByStoreId(currvalRole.getRole_id());
		//存入数据
		model.addObject("storeLookWaitAssess", queryAssessOrderByStoreId);
		//跳转页面
		model.setViewName("/page/store/storeLookWaitAssess");
		}else {
			JOptionPane.showMessageDialog(null,"请先登录!");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * 店铺查看待退款订单
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookWaitBackMoney")
	public ModelAndView storeLookWaitBackMoney(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		// 获取当前登录的店铺
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		//查询自家店铺待评价的订单
		List<ShoppingOrder> queryWaitBackMoney = storebiz.queryWaitBackMoneyByStoreId(currvalRole.getRole_id());
		//存入数据
		model.addObject("storeLookWaitBackMoney", queryWaitBackMoney);
		//跳转页面
		model.setViewName("/page/store/storeLookWaitBackMoney");
		}else {
			JOptionPane.showMessageDialog(null,"请先登录!");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * 店铺查看已退款订单
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookBackMoney")
	public ModelAndView storeLookBackMoney(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		// 获取当前登录的店铺
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		//查询自家店铺待评价的订单
		List<ShoppingOrder> queryBackMoney = storebiz.queryBackMoneyByStoreId(currvalRole.getRole_id());
		//存入数据
		model.addObject("storeLookBackMoney", queryBackMoney);
		//跳转页面
		model.setViewName("/page/store/storeLookBackMoney");
		}else {
			JOptionPane.showMessageDialog(null,"请先登录!");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * 店铺查看已完成订单
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookOverOrder")
	public ModelAndView storeLookOverOrder(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		// 获取当前登录的店铺
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		//查询自家店铺待评价的订单
		List<ShoppingOrder> queryOverOrder = storebiz.queryOverOrderByStoreId(currvalRole.getRole_id());
		//存入数据
		model.addObject("storeLookOverOrder", queryOverOrder);
		//跳转页面
		model.setViewName("/page/store/storeLookOverOrder");
		}else {
			JOptionPane.showMessageDialog(null,"请先登录!");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * 店铺发货，更改订单状态
	 * @param order_id
	 * @param order_state
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeAcceptOrder")
	public ModelAndView storeAcceptOrder(int order_id)throws Exception{
		ModelAndView model=new ModelAndView();
		ShoppingOrder queryOrderById = storebiz.queryOrderById(order_id);
		ShoppingOrderline queryOrderlineById = storebiz.queryOrderlineById(order_id);
		queryOrderById.setOrder_state("2");
		queryOrderlineById.setOrder_state("2");
		storebiz.updateOrderById(queryOrderById);
		storebiz.updateOrderlineById(queryOrderlineById);
		//跳转页面
		JOptionPane.showMessageDialog(null,"商品已发货");
		model.setViewName("/page/store/storePage");
		return model;
	}

	/**
	 * 店铺退款，更改订单状态
	 * @param order_id
	 * @param order_state
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeBackOrder")
	public ModelAndView storeBackOrder(int order_id)throws Exception{
		ModelAndView model=new ModelAndView();
		//调用支付接口，将用户的钱退还给用户
		
		ShoppingOrder queryOrderById = storebiz.queryOrderById(order_id);
		ShoppingOrderline queryOrderlineById = storebiz.queryOrderlineById(order_id);
		queryOrderById.setOrder_state("5");
		queryOrderlineById.setOrder_state("5");
		//将订单状态更新为已退款
		storebiz.updateOrderById(queryOrderById);
		storebiz.updateOrderlineById(queryOrderlineById);
		//跳转页面
		JOptionPane.showMessageDialog(null,"已退款");
		model.setViewName("/page/store/storePage");
		return model;
	}
	/**
	 * 店铺更改自己状态，营业或打烊
	 * @param store_state
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateStoreState")
	public ModelAndView updateStoreState(String store_state,HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		// 获取当前登录的店铺
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		storebiz.updateStoreStateById(currvalRole.getRole_id(), store_state);
		//跳转页面
		JOptionPane.showMessageDialog(null,"成功，正在营业中");
		model.setViewName("/page/store/storePage");
		return model;
	}
	/**
	 * 店铺删除地址信息
	 * @param address_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteStoreAddress")
	public ModelAndView deleteStoreAddress(int address_id)throws Exception{
		ModelAndView model=new ModelAndView();
		storebiz.deleteAddressById(address_id);
		// 页面定位到lookGood.jsp页面
		JOptionPane.showMessageDialog(null,"地址已删除");
		model.setViewName("/page/store/deleteSuccess");
		return model;
	}
	/**
	 * 店铺根据商品名模糊查询
	 * @param good_name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryGoodByName")
	public ModelAndView queryGoodByName(String good_name,HttpServletRequest request)throws Exception{
		//System.out.println(good_name);
		ModelAndView model=new ModelAndView();
		// 获取当前登录的店铺
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		//根据店铺id和商品名查询商品
		List<ShoppingGood> queryGoodByName = storebiz.queryGoodByName(good_name, currvalRole.getRole_id());
		//添加当前店铺信息到session中
		request.getSession().setAttribute("queryGoods", queryGoodByName);
		//跳转页面
		model.setViewName("/page/store/queryGood");
		return model;
	}
	/**
	 * 根据商品id查询商品详情
	 * @param good_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("lookGoodline")
	public ModelAndView queryGoodlineById(int good_id)throws Exception{
		ModelAndView model=new ModelAndView();
		GoodInfo goodinfo = new GoodInfo();
		//根据商品id查询商品
		ShoppingGood good = storebiz.queryGoodById(good_id);
		// 根据商品id查询商品价格封装到GoodPrice对象中
		int queryPriceById = storebiz.queryPriceById(good_id);
		GoodPrice price = new GoodPrice();
		price.setPrice_num(queryPriceById);
		// 根据商品id查询商品图片路径封装到GoodImage对象中
		String queryImageRouteById = storebiz.queryImageRouteById(good_id);
		GoodImage image = new GoodImage();
		image.setImage_route(queryImageRouteById);
		// 根据商品id查询商品销量封装到goodSale对象中
		int querySaleById = storebiz.querySaleById(good_id);
		GoodSale sale = new GoodSale();
		sale.setSale_num(querySaleById);
		// 根据商品id查询商品余量封装到GoodMargin对象中
		int queryMarginById = storebiz.queryMarginById(good_id);
		GoodMargin margin = new GoodMargin();
		margin.setMargin_num(queryMarginById);
		// 根据商品id查询商品属性
		GoodProperties queryPropertiesById = storebiz
				.queryPropertiesById(good_id);
		// 根据商品id查询商品评价
		List<GoodAssess> queryAssessById = storebiz.queryAssessById(good_id);
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
		//跳转页面
		model.addObject("goodinfo", goodinfo);
		model.setViewName("/page/store/storeLookGoodLine");
		return model;
		
	}
	/**
	 * 查看月度报表数据
	 * @param start_date
	 * @param end_date
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("storeLookReportData")
	public ModelAndView StoreLookReportData(String start_date,String end_date,HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		int totalMoney=0;
		//创建一个集合存放满足条件的数据
		List<ShoppingOrder> orderList=new ArrayList<ShoppingOrder>();
		// 获取当前登录的店铺
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		//查询自家店铺用户已付款店铺未发货的订单
		List<ShoppingOrder> queryOrderByStoreId = storebiz.queryStoreReport(currvalRole.getRole_id());
		//创建时间格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd号HH:mm:ss");
		//将开始和结束格式化为时间
		Date start = sdf.parse(start_date);
		Date end = sdf.parse(end_date);
		//遍历装有订单数据的集合，若满足时间条件则加入满足条件的数组之中
		for(ShoppingOrder order:queryOrderByStoreId){
			Date orderTime = sdf.parse(order.getOrder_time());
			if(orderTime.after(start)&&orderTime.before(end)){
				totalMoney+=order.getOrder_money();
				orderList.add(order);
			}
		}
		//跳转页面
		model.addObject("reportData",orderList);
		model.addObject("totalMoney", totalMoney);
		model.setViewName("/page/store/lookReportData");
		}else {
			JOptionPane.showMessageDialog(null,"请先登录!");
			model.setViewName("/page/roleLogin");
		}
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
		storebiz.deleteOrderAndLineById(order_id);
		JOptionPane.showMessageDialog(null, "定单已删除");
		model.setViewName("/page/store/storePage");
		return model;
	}
	/**
	 * 店铺根据订单id查看订单详情
	 * @param order_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/lookOrderLine")
	public ModelAndView lookOrderLine(int order_id,HttpServletRequest request)throws Exception{
		//System.out.println("查看定单详情");
		ModelAndView model=new ModelAndView();
		//查看订单详情
		ShoppingOrderline queryOrderlineById = storebiz.queryOrderlineById(order_id);
		//存入对象
		request.getSession().setAttribute("lookOrderLine", queryOrderlineById);
		model.setViewName("/page/store/lookOrderLine");
		return model;
	}
	/**
	 * 店铺添加地址
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addStoreAddress")
	public ModelAndView addStoreAddress(RoleAddress address,
			HttpServletRequest request) throws Exception {
		// 创建ModelAndView对象
		ModelAndView model = new ModelAndView();
		// 获取当前用户的session
		HttpSession session = request.getSession();
		// 获取当前登录的对象
		ShoppingRole loginRole = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginRole==null){
			// 页面跳转
			JOptionPane.showMessageDialog(null, "请先登录");
			model.setViewName("/page/roleLogin");
		}else {
		// 将当前用户id存入roleAddress对象中
		address.setUser_id(loginRole.getRole_id());
		// 将roleAddress对象插表
		storebiz.insertStoreAddress(address);
		// 跳转页面
		JOptionPane.showMessageDialog(null, "地址已添加");
		model.setViewName("/page/store/storePage");
		}
		return model;
	}
}
