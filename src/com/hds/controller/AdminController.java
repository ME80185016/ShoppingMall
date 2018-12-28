package com.hds.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hds.biz.AdminBiz;
import com.hds.entity.GoodAssess;
import com.hds.entity.GoodImage;
import com.hds.entity.GoodInfo;
import com.hds.entity.GoodMargin;
import com.hds.entity.GoodPrice;
import com.hds.entity.GoodProperties;
import com.hds.entity.GoodSale;
import com.hds.entity.RoleAddress;
import com.hds.entity.ShoppingGood;
import com.hds.entity.ShoppingRole;
import com.hds.entity.StoreInfo;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminBiz adminBiz;
	/**
	 * 管理员登出
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
			model.setViewName("/page/admin/adminPage");
		}
		return model;
	}
	/**
	 * 根据用户名登录，查询数据库此用户名是否存在，然后查询对应的密码是否正确
	 * 
	 * @param role_name
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminLoginByName")
	public String adminLoginByName(String role_name, HttpServletRequest request)
			throws Exception {
		// 根据用户名查询用户
		ShoppingRole userLogin = adminBiz.queryAdminByName(role_name);
		// 获取页面上用户输入的密码
		String pwd = request.getParameter("role_pwd");
		if (userLogin != null) {
			if (userLogin.getRole_pwd().equals(pwd)) {
				request.getSession().setAttribute("currvalRole", userLogin);
				return "/page/admin/adminPage";
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
	@RequestMapping(value = "/adminLoginByTel")
	public String adminLoginByTel(String role_tel, HttpServletRequest request)
			throws Exception {
		// 根据手机号查询用户
		ShoppingRole userLogin = adminBiz.queryAdminByTel(role_tel);
		// 获取页面上用户输入的密码
		String pwd = request.getParameter("role_pwd");
		if (userLogin != null) {
			if (userLogin.getRole_pwd().equals(pwd)) {
				request.getSession().setAttribute("currvalRole", userLogin);
				return "/page/admin/adminPage";
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
	 * 根据角色id删除角色
	 * @param role_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteRoleById")
	public ModelAndView deleteRoleById(int role_id)throws Exception{
		ModelAndView model=new ModelAndView();
		//删除角色
		adminBiz.deleteRoleById(role_id);
		//跳转页面
		JOptionPane.showMessageDialog(null, "已删除");
		model.setViewName("/page/admin/adminPage");
		return model;
		
	}
	/**
	 * 根据角色id查询角色
	 * @param role_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryRoleById")
	public ModelAndView queryRoleById(int role_id)throws Exception{
		ModelAndView model=new ModelAndView();
		//查询角色
		ShoppingRole queryRoleById = adminBiz.queryRoleById(role_id);
		//将角色信息存入model
		model.addObject("role", queryRoleById);
		//跳转页面
		model.setViewName("/page/admin/lookRole");
		return model;
	}
	/**
	 * 根据角色名查询角色
	 * @param role_name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryRoleByName")
	public ModelAndView queryRoleByName(String role_name)throws Exception{
		ModelAndView model=new ModelAndView();
		//查询角色
		ShoppingRole queryRoleByName = adminBiz.queryRoleByName(role_name);
		//将角色信息存入model
		model.addObject("role", queryRoleByName);
		//跳转页面
		model.setViewName("/page/admin/lookRole");
		return model;
	}
	/**
	 * 根据商品id查询商品
	 * @param good_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryGoodById")
	public ModelAndView queryGoodById(int good_id)throws Exception{
		ModelAndView model=new ModelAndView();
		//查询角色
		ShoppingGood queryGoodById = adminBiz.queryGoodById(good_id);
		//将角色信息存入model
		model.addObject("queryGoodById", queryGoodById);
		//跳转页面
		model.setViewName("/page/admin/lookGood");
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
		//查询商品
		List<ShoppingGood> queryGoodByName = adminBiz.queryGoodByName(good_name);
		//将商品信息存入model
		model.addObject("queryGoods", queryGoodByName);
		//跳转页面
		model.setViewName("/page/admin/queryGood");
		return model;
	}
	/**
	 * 查看商品详情
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
		ShoppingGood queryGoodById = adminBiz.queryGoodById(good_id);
		// 根据商品id查询商品价格封装到GoodPrice对象中
		int queryPriceById = adminBiz.queryPriceById(good_id);
		GoodPrice price = new GoodPrice();
		price.setPrice_num(queryPriceById);
		// 根据商品id查询商品图片路径封装到GoodImage对象中
		String queryImageRouteById = adminBiz.queryImageRouteById(good_id);
		GoodImage image = new GoodImage();
		image.setImage_route(queryImageRouteById);
		// 根据商品id查询商品销量封装到goodSale对象中
		int querySaleById = adminBiz.querySaleById(good_id);
		GoodSale sale = new GoodSale();
		sale.setSale_num(querySaleById);
		// 根据商品id查询商品余量封装到GoodMargin对象中
		int queryMarginById = adminBiz.queryMarginById(good_id);
		GoodMargin margin = new GoodMargin();
		margin.setMargin_num(queryMarginById);
		// 根据商品id查询商品属性
		GoodProperties queryPropertiesById = adminBiz
				.queryPropertiesById(good_id);
		// 根据商品id查询商品评价
		List<GoodAssess> queryAssessById = adminBiz.queryAssessById(good_id);
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
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/admin/lookGoodLine");

		return model;
	}
	/**
	 * 管理员根据商品id删除商品
	 * @param good_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteGoodInfo")
	public ModelAndView deleteGoodInfo(int good_id)throws Exception{
		ModelAndView model=new ModelAndView();
		//删除商品相关信息
		adminBiz.deleteGoodById(good_id);
		adminBiz.deletePriceById(good_id);
		adminBiz.deleteImageRoute(good_id);
		adminBiz.deleteAssessById(good_id);
		adminBiz.deleteMarginById(good_id);
		adminBiz.deletePropertiesById(good_id);
		adminBiz.deleteSaleById(good_id);
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/admin/adminPage");
		return model;
	}
	/**
	 * 管理员更改店铺状态
	 * @param store_id
	 * @param store_state
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateStoreState")
	public ModelAndView updateStoreState(int store_id,String store_state)throws Exception{
		ModelAndView model=new ModelAndView();
		//管理员更改店铺状态
		adminBiz.updateStoreStateById(store_id, store_state);
		switch (store_state) {
		case "0":
			JOptionPane.showMessageDialog(null, "成功，店铺状态为已关停");
			break;
		case "1":
			JOptionPane.showMessageDialog(null, "成功，店铺状态为营业中");
			break;
		case "2":
			JOptionPane.showMessageDialog(null, "成功，店铺状态为已打烊");
			break;
		default:
			break;
		}
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/admin/adminPage");
		return model;
	}
	/**
	 * 管理员拒绝开店
	 * @param role_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/refuseOpenStore")
	public ModelAndView refuseOpenStore(int role_id)throws Exception{
		ModelAndView model=new ModelAndView();
		//删除店铺-角色表
		adminBiz.deleteRoleById(role_id);
		//删除店铺-信息表
		adminBiz.deleteStoreInfoById(role_id);
		//跳转页面
		JOptionPane.showMessageDialog(null, "已拒绝开店");
		model.setViewName("/page/admin/adminPage");
		return model;
		
	}
	/**
	 * 管理员浏览商品
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/adminLookGood")
	public ModelAndView adminLookGood(HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		// 查询出第一页所有商品
		List<ShoppingGood> queryGoods = adminBiz.queryGoods();
		// 创建集合存储商品信息
		List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();
		for (ShoppingGood good : queryGoods) {
			GoodInfo goodinfo = new GoodInfo();
			// 根据商品id查询商品价格封装到GoodPrice对象中
			// System.out.println(good.getGood_id());
			int queryPriceById = adminBiz.queryPriceById(good.getGood_id());
			GoodPrice price = new GoodPrice();
			price.setPrice_num(queryPriceById);
			// 根据商品id查询商品图片路径封装到GoodImage对象中
			String queryImageRouteById = adminBiz.queryImageRouteById(good
					.getGood_id());
			GoodImage image = new GoodImage();
			image.setImage_route(queryImageRouteById);
			// 根据商品id查询商品销量封装到goodSale对象中
			int querySaleById = adminBiz.querySaleById(good.getGood_id());
			GoodSale sale = new GoodSale();
			sale.setSale_num(querySaleById);
			// 根据商品id查询商品余量封装到GoodMargin对象中
			int queryMarginById = adminBiz.queryMarginById(good.getGood_id());
			GoodMargin margin = new GoodMargin();
			margin.setMargin_num(queryMarginById);
			// 根据商品id查询商品属性
			GoodProperties queryPropertiesById = adminBiz
					.queryPropertiesById(good.getGood_id());
			// 根据商品id查询商品评价
			List<GoodAssess> queryAssessById = adminBiz.queryAssessById(good
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
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/admin/lookGood");
		return model;
	}
	/**
	 * 管理员浏览店铺
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/adminLookStore")
	public ModelAndView adminLookStore(HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		// 查询出所有店铺
		List<ShoppingRole> queryStores = adminBiz.queryStores();
		// 创建集合存储店铺信息
		List<StoreInfo> storeInfos = new ArrayList<StoreInfo>();
		for (ShoppingRole store : queryStores) {
			// 根据店铺id查询店铺信息
			StoreInfo storeInfo = adminBiz.queryStoreInfoById(store.getRole_id());
			// 将goodinfo对象存放如集合中
			storeInfos.add(storeInfo);
		}
		
		// 将查出的数据存入session中
		request.getSession().setAttribute("storeinfos", storeInfos);
		// 页面定位到lookGood.jsp页面
		model.setViewName("/page/admin/lookStore");
		return model;
	}
	/**
	 * 根据店铺id查询店铺详细信息并且查看其商品
	 * @param store_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/adminLookStoreLine")
	public ModelAndView adminLookStoreLine(Integer store_id,HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		//根据店铺id查询shoppingRole表中信息
		ShoppingRole queryStoreById = adminBiz.queryRoleById(store_id);
		// 根据店铺id查询店铺信息
		StoreInfo storeInfo = adminBiz.queryStoreInfoById(store_id);
		//根据店铺id查询地址
		List<RoleAddress> queryAddressByStoreId = adminBiz.queryAddressByStoreId(store_id);
		//根据店铺id查询其商品
		List<ShoppingGood> queryGoods = adminBiz.queryStoreGoods(store_id);
		// 创建集合存储商品信息
		List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();
		for (ShoppingGood good : queryGoods) {
			GoodInfo goodinfo = new GoodInfo();
			// 根据商品id查询商品价格封装到GoodPrice对象中
			int queryPriceById = adminBiz.queryPriceById(good.getGood_id());
			GoodPrice price = new GoodPrice();
			price.setPrice_num(queryPriceById);
			// 根据商品id查询商品图片路径封装到GoodImage对象中
			String queryImageRouteById = adminBiz.queryImageRouteById(good
					.getGood_id());
			GoodImage image = new GoodImage();
			image.setImage_route(queryImageRouteById);
			// 根据商品id查询商品销量封装到goodSale对象中
			int querySaleById = adminBiz.querySaleById(good.getGood_id());
			GoodSale sale = new GoodSale();
			sale.setSale_num(querySaleById);
			// 根据商品id查询商品余量封装到GoodMargin对象中
			int queryMarginById = adminBiz.queryMarginById(good.getGood_id());
			GoodMargin margin = new GoodMargin();
			margin.setMargin_num(queryMarginById);
			// 根据商品id查询商品属性
			GoodProperties queryPropertiesById = adminBiz
					.queryPropertiesById(good.getGood_id());
			// 根据商品id查询商品评价
			List<GoodAssess> queryAssessById = adminBiz.queryAssessById(good
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
		model.setViewName("/page/admin/lookStoreLine");
		return model;
	}
	/**
	 * 管理员查看申请开店的店铺信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/lookApplyStore")
	public ModelAndView lookApplyStore()throws Exception{
		ModelAndView model=new ModelAndView();
		List<StoreInfo> queryApplyStoreInfo = adminBiz.queryApplyStoreInfo();
		model.addObject("storeinfos", queryApplyStoreInfo);
		model.setViewName("/page/admin/lookStore");
		return model;
	}
	

}
