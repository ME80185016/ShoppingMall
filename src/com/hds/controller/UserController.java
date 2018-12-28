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
 * userController,���������ͨ�û���һЩ��������ע�ᣬ��¼������...
 * 
 * @author ��
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	private static int page = 1;
	private static int pageCount = 0;
	private static int storePage=1;
	private static int storePageCount=0;
	private int yzmNumber = RandomTest.getNum();// ���ù����෽��������λ�����
	@Autowired
	private UserBiz userbiz;
	/**
	 * �û��ǳ�
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/loginOut")
	public ModelAndView loginOut(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		int showConfirmDialog = JOptionPane.showConfirmDialog(null,
				"ȷ���˳�ϵͳ��", "ȷ��", JOptionPane.YES_NO_OPTION);
		if (showConfirmDialog == 0) {
			request.getSession().removeAttribute("currvalRole");
			model.setViewName("/page/roleLogin");
		}else {
			model.setViewName("/page/user/userPage");
		}
		return model;
	}
	
	
	
	/**
	 * ��ͨ�û�ע�᷽�����ɹ����򵽳ɹ�ҳ��
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
			JOptionPane.showMessageDialog(null, "�û����ظ�������������!");
			model.setViewName("/page/user/userRegister");
		} else {
			int showConfirmDialog = JOptionPane.showConfirmDialog(null,
					"�û������ã��Ƿ�ȷ��ʹ�ã�", "�û���ȷ��", JOptionPane.YES_NO_OPTION);
			if (showConfirmDialog == 0) {
				if(role_yzm.equals(yzm)){
					userbiz.userRegist(role);
					JOptionPane.showMessageDialog(null, "ע��ɹ������¼!");
					model.setViewName("/page/roleLogin");
				}else {
					JOptionPane.showMessageDialog(null, "��֤�����벻��ȷ������������!");
					model.setViewName("/page/user/userRegister");
				}
				
			} else {
				model.setViewName("/page/user/userRegister");
			}
		}

		return model;

	}

	/**
	 * ͨ���û�������ֻ��ŵ��ö��Žӿڻ�ȡ��֤��
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws Exception
	 */
	@RequestMapping(value = "/getyzm")
	public void getYzm(HttpServletRequest request,HttpServletResponse response,String rolename,String roletel) throws UnsupportedEncodingException{
		byte[] b=rolename.getBytes("ISO-8859-1");//��tomcat�ĸ�ʽ��iso-8859-1����ʽȥ����
		String name=new String(b,"utf-8");//����utf-8ȥ��string
		System.out.println("�û���:"+name+"���绰"+roletel+",ϵͳ��֤�룺"+yzmNumber);
		try {
			int sendSMS = SMSTest.sendSMS(yzmNumber, name, roletel);// ���ù�����ķ������ֻ��ŷ��Ͷ���
			String data=Integer.toString(sendSMS);
			response.setContentType("application/text; charset=UTF-8");
			response.getWriter().write(data);
			System.out.println("�������ݣ�"+data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new RuntimeException("IO�쳣");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new RuntimeException("��������æ��������֤��ʧ��");
		}

	}

	/**
	 * �����û�����¼����ѯ���ݿ���û����Ƿ���ڣ�Ȼ���ѯ��Ӧ�������Ƿ���ȷ
	 * 
	 * @param role_name
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userLoginByName")
	public String userLoginByName(String role_name, HttpServletRequest request)
			throws Exception {
		// �����û�����ѯ�û�
		ShoppingRole userLogin = userbiz.userLoginByName(role_name);
		// ��ȡҳ�����û����������
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
				JOptionPane.showMessageDialog(null,"�����������������!");
				return "/page/roleLogin";
			}
		} else {
			JOptionPane.showMessageDialog(null,"�û��������ڣ�����������!");
			return "/page/roleLogin";
		}

	}

	/**
	 * �����ֻ��ŵ�¼�������ֻ��Ų�ѯ���ݿ��Ƿ���ڸ��û���Ȼ���ж������Ƿ���ȷ
	 * 
	 * @param role_tel
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userLoginByTel")
	public String userLoginByTel(String role_tel, HttpServletRequest request)
			throws Exception {
		// �����ֻ��Ų�ѯ�û�
		ShoppingRole userLogin = userbiz.userLoginByTel(role_tel);
		// ��ȡҳ�����û����������
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
				JOptionPane.showMessageDialog(null,"�����������������!");
				return "/page/roleLogin";
			}
		} else {
			JOptionPane.showMessageDialog(null,"�ֻ��Ų����ڣ�����������!");
			return "/page/roleLogin";
		}

	}

	/**
	 * �û������Ʒ
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookGood")
	public ModelAndView userLookGood(HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		// ��ѯ��Ʒ����
		int goodCount = userbiz.queryGoodCount();
		// System.out.println("goodcount:"+goodCount);
		double pagenum = (double) goodCount / 4;
		// System.out.println("pagenum"+pagenum);
		// ����math�������ȡ���������з�ҳ
		pageCount = (int) Math.ceil(pagenum);
		// ��ѯ����һҳ������Ʒ
		List<ShoppingGood> queryGoods = userbiz.queryGoods(page);
		// �������ϴ洢��Ʒ��Ϣ
		List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();

		for (ShoppingGood good : queryGoods) {
			GoodInfo goodinfo = new GoodInfo();
			// ������Ʒid��ѯ��Ʒ�۸��װ��GoodPrice������
			// System.out.println(good.getGood_id());
			int queryPriceById = userbiz.queryPriceById(good.getGood_id());
			GoodPrice price = new GoodPrice();
			price.setPrice_num(queryPriceById);
			// ������Ʒid��ѯ��ƷͼƬ·����װ��GoodImage������
			String queryImageRouteById = userbiz.queryImageRouteById(good
					.getGood_id());
			GoodImage image = new GoodImage();
			image.setImage_route(queryImageRouteById);
			// ������Ʒid��ѯ��Ʒ������װ��goodSale������
			int querySaleById = userbiz.querySaleById(good.getGood_id());
			GoodSale sale = new GoodSale();
			sale.setSale_num(querySaleById);
			// ������Ʒid��ѯ��Ʒ������װ��GoodMargin������
			int queryMarginById = userbiz.queryMarginById(good.getGood_id());
			GoodMargin margin = new GoodMargin();
			margin.setMargin_num(queryMarginById);
			// ������Ʒid��ѯ��Ʒ����
			GoodProperties queryPropertiesById = userbiz
					.queryPropertiesById(good.getGood_id());
			// ������Ʒid��ѯ��Ʒ����
			List<GoodAssess> queryAssessById = userbiz.queryAssessById(good
					.getGood_id());
			// ��ShoppingGood�����װ��GoodInfo��
			goodinfo.setGood(good);
			// ��GoodPrice�����װ��GoodInfo��
			goodinfo.setGoodPrice(price);
			// ��GoodImage�����װ��GoodInfo��
			goodinfo.setGoodImage(image);
			// ��GoodSale�����װ��GoodInfo��
			goodinfo.setGoodSale(sale);
			// ��GoodMargin�����װ��GoodInfo��
			goodinfo.setGoodMargin(margin);
			// ��GoodProperties�����װ��GoodInfo��
			goodinfo.setGoodProperties(queryPropertiesById);
			// ��GoodAssess�����װ��GoodInfo��
			goodinfo.setGoodAssesses(queryAssessById);
			// ��goodinfo�������缯����
			goodInfos.add(goodinfo);
		}

		// ����ѯ������Ʒ���ϴ���modelAndView��
		// model.addObject("goodinfos", goodInfos);
		// ����������ݴ���session��
		request.getSession().setAttribute("goodinfos", goodInfos);
		request.getSession().setAttribute("pageCount", pageCount);
		request.getSession().setAttribute("page", page);
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/user/lookGood");
		return model;
	}

	/**
	 * �û������һҳ�鿴��һҳ����Ʒ
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
			// ��ѯ����һҳ������Ʒ
			List<ShoppingGood> queryGoods = userbiz.queryGoods(page);
			// �������ϴ洢��Ʒ��Ϣ
			List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();

			for (ShoppingGood good : queryGoods) {
				GoodInfo goodinfo = new GoodInfo();
				// ������Ʒid��ѯ��Ʒ�۸��װ��GoodPrice������
				// System.out.println(good.getGood_id());
				int queryPriceById = userbiz.queryPriceById(good.getGood_id());
				GoodPrice price = new GoodPrice();
				price.setPrice_num(queryPriceById);
				// ������Ʒid��ѯ��ƷͼƬ·����װ��GoodImage������
				String queryImageRouteById = userbiz.queryImageRouteById(good
						.getGood_id());
				GoodImage image = new GoodImage();
				image.setImage_route(queryImageRouteById);
				// ������Ʒid��ѯ��Ʒ������װ��goodSale������
				int querySaleById = userbiz.querySaleById(good.getGood_id());
				GoodSale sale = new GoodSale();
				sale.setSale_num(querySaleById);
				// ������Ʒid��ѯ��Ʒ������װ��GoodMargin������
				int queryMarginById = userbiz
						.queryMarginById(good.getGood_id());
				GoodMargin margin = new GoodMargin();
				margin.setMargin_num(queryMarginById);
				// ������Ʒid��ѯ��Ʒ����
				GoodProperties queryPropertiesById = userbiz
						.queryPropertiesById(good.getGood_id());
				// ������Ʒid��ѯ��Ʒ����
				List<GoodAssess> queryAssessById = userbiz.queryAssessById(good
						.getGood_id());
				// ��ShoppingGood�����װ��GoodInfo��
				goodinfo.setGood(good);
				// ��GoodPrice�����װ��GoodInfo��
				goodinfo.setGoodPrice(price);
				// ��GoodImage�����װ��GoodInfo��
				goodinfo.setGoodImage(image);
				// ��GoodSale�����װ��GoodInfo��
				goodinfo.setGoodSale(sale);
				// ��GoodMargin�����װ��GoodInfo��
				goodinfo.setGoodMargin(margin);
				// ��GoodProperties�����װ��GoodInfo��
				goodinfo.setGoodProperties(queryPropertiesById);
				// ��GoodAssess�����װ��GoodInfo��
				goodinfo.setGoodAssesses(queryAssessById);
				// ��goodinfo�������缯����
				goodInfos.add(goodinfo);
			}

			// ����ѯ������Ʒ���ϴ���modelAndView��
			// model.addObject("goodinfos", goodInfos);
			// ����������ݴ���session��
			request.getSession().setAttribute("goodinfos", goodInfos);
			request.getSession().setAttribute("page", page);
		}
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/user/lookGood");
		return model;
	}

	/**
	 * �û������һҳ�鿴��һҳ����Ʒ
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
			// ��ѯ����һҳ������Ʒ
			List<ShoppingGood> queryGoods = userbiz.queryGoods(page);
			// �������ϴ洢��Ʒ��Ϣ
			List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();
			/*
			 * //�������ϴ洢��Ʒ�۸� List<Integer> queryPrices=null; //�������ϴ洢��ƷͼƬ·��
			 * List<String> queryImages=null; //�������ϴ洢��Ʒ���� List<Integer>
			 * querySales=null; //�������ϴ洢��Ʒ���� List<Integer> queryMargins=null;
			 * //�������ϴ洢��Ʒ���� List<GoodProperties> queryProperties=null;
			 * //�������ϴ洢��Ʒ���� List<GoodAssess> queryAssesses=null;
			 */
			for (ShoppingGood good : queryGoods) {
				GoodInfo goodinfo = new GoodInfo();
				// ������Ʒid��ѯ��Ʒ�۸��װ��GoodPrice������
				// System.out.println(good.getGood_id());
				int queryPriceById = userbiz.queryPriceById(good.getGood_id());
				GoodPrice price = new GoodPrice();
				price.setPrice_num(queryPriceById);
				// ������Ʒid��ѯ��ƷͼƬ·����װ��GoodImage������
				String queryImageRouteById = userbiz.queryImageRouteById(good
						.getGood_id());
				GoodImage image = new GoodImage();
				image.setImage_route(queryImageRouteById);
				// ������Ʒid��ѯ��Ʒ������װ��goodSale������
				int querySaleById = userbiz.querySaleById(good.getGood_id());
				GoodSale sale = new GoodSale();
				sale.setSale_num(querySaleById);
				// ������Ʒid��ѯ��Ʒ������װ��GoodMargin������
				int queryMarginById = userbiz
						.queryMarginById(good.getGood_id());
				GoodMargin margin = new GoodMargin();
				margin.setMargin_num(queryMarginById);
				// ������Ʒid��ѯ��Ʒ����
				GoodProperties queryPropertiesById = userbiz
						.queryPropertiesById(good.getGood_id());
				// ������Ʒid��ѯ��Ʒ����
				List<GoodAssess> queryAssessById = userbiz.queryAssessById(good
						.getGood_id());
				// ��ShoppingGood�����װ��GoodInfo��
				goodinfo.setGood(good);
				// ��GoodPrice�����װ��GoodInfo��
				goodinfo.setGoodPrice(price);
				// ��GoodImage�����װ��GoodInfo��
				goodinfo.setGoodImage(image);
				// ��GoodSale�����װ��GoodInfo��
				goodinfo.setGoodSale(sale);
				// ��GoodMargin�����װ��GoodInfo��
				goodinfo.setGoodMargin(margin);
				// ��GoodProperties�����װ��GoodInfo��
				goodinfo.setGoodProperties(queryPropertiesById);
				// ��GoodAssess�����װ��GoodInfo��
				goodinfo.setGoodAssesses(queryAssessById);
				// ��goodinfo�������缯����
				goodInfos.add(goodinfo);
			}

			// ����ѯ������Ʒ���ϴ���modelAndView��
			// model.addObject("goodinfos", goodInfos);
			// ����������ݴ���session��
			request.getSession().setAttribute("goodinfos", goodInfos);
			request.getSession().setAttribute("page", page);
		}
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/user/lookGood");
		return model;
	}

	/**
	 * ���û�����ҳ��ʱ��ָ��ҳ����ת
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookGoodJump")
	public ModelAndView userLookGoodJump(Integer jumpPage,
			HttpServletRequest request) throws Exception {
		ModelAndView model = new ModelAndView();
		// �ж��û������ҳ��
		/*
		 * if(jumpPage<=0){
		 * 
		 * }
		 */
		page=jumpPage;
		List<ShoppingGood> queryGoods = userbiz.queryGoods(page);
		// �������ϴ洢��Ʒ��Ϣ
		List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();
		/*
		 * //�������ϴ洢��Ʒ�۸� List<Integer> queryPrices=null; //�������ϴ洢��ƷͼƬ·��
		 * List<String> queryImages=null; //�������ϴ洢��Ʒ���� List<Integer>
		 * querySales=null; //�������ϴ洢��Ʒ���� List<Integer> queryMargins=null;
		 * //�������ϴ洢��Ʒ���� List<GoodProperties> queryProperties=null; //�������ϴ洢��Ʒ����
		 * List<GoodAssess> queryAssesses=null;
		 */
		for (ShoppingGood good : queryGoods) {
			GoodInfo goodinfo = new GoodInfo();
			// ������Ʒid��ѯ��Ʒ�۸��װ��GoodPrice������
			// System.out.println(good.getGood_id());
			int queryPriceById = userbiz.queryPriceById(good.getGood_id());
			GoodPrice price = new GoodPrice();
			price.setPrice_num(queryPriceById);
			// ������Ʒid��ѯ��ƷͼƬ·����װ��GoodImage������
			String queryImageRouteById = userbiz.queryImageRouteById(good
					.getGood_id());
			GoodImage image = new GoodImage();
			image.setImage_route(queryImageRouteById);
			// ������Ʒid��ѯ��Ʒ������װ��goodSale������
			int querySaleById = userbiz.querySaleById(good.getGood_id());
			GoodSale sale = new GoodSale();
			sale.setSale_num(querySaleById);
			// ������Ʒid��ѯ��Ʒ������װ��GoodMargin������
			int queryMarginById = userbiz.queryMarginById(good.getGood_id());
			GoodMargin margin = new GoodMargin();
			margin.setMargin_num(queryMarginById);
			// ������Ʒid��ѯ��Ʒ����
			GoodProperties queryPropertiesById = userbiz
					.queryPropertiesById(good.getGood_id());
			// ������Ʒid��ѯ��Ʒ����
			List<GoodAssess> queryAssessById = userbiz.queryAssessById(good
					.getGood_id());
			// ��ShoppingGood�����װ��GoodInfo��
			goodinfo.setGood(good);
			// ��GoodPrice�����װ��GoodInfo��
			goodinfo.setGoodPrice(price);
			// ��GoodImage�����װ��GoodInfo��
			goodinfo.setGoodImage(image);
			// ��GoodSale�����װ��GoodInfo��
			goodinfo.setGoodSale(sale);
			// ��GoodMargin�����װ��GoodInfo��
			goodinfo.setGoodMargin(margin);
			// ��GoodProperties�����װ��GoodInfo��
			goodinfo.setGoodProperties(queryPropertiesById);
			// ��GoodAssess�����װ��GoodInfo��
			goodinfo.setGoodAssesses(queryAssessById);
			// ��goodinfo�������缯����
			goodInfos.add(goodinfo);
		}

		// ����ѯ������Ʒ���ϴ���modelAndView��
		// model.addObject("goodinfos", goodInfos);
		// ����������ݴ���session��
		request.getSession().setAttribute("goodinfos", goodInfos);
		request.getSession().setAttribute("page", page);
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/user/lookGood");
		return model;
	}

	/**
	 * �û��鿴��Ʒ����
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/lookGoodLine")
	public ModelAndView lookGoodLine(int good_id, HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();

		GoodInfo goodinfo = new GoodInfo();
		// ������Ʒid��ѯ��Ʒ
		ShoppingGood queryGoodById = userbiz.queryGoodById(good_id);
		//������Ʒid��ѯ������������
		StoreInfo queryStoreInfoById = userbiz.queryStoreInfoById(queryGoodById.getStore_id());
		
		// ������Ʒid��ѯ��Ʒ�۸��װ��GoodPrice������
		int queryPriceById = userbiz.queryPriceById(good_id);
		GoodPrice price = new GoodPrice();
		price.setPrice_num(queryPriceById);
		// ������Ʒid��ѯ��ƷͼƬ·����װ��GoodImage������
		String queryImageRouteById = userbiz.queryImageRouteById(good_id);
		GoodImage image = new GoodImage();
		image.setImage_route(queryImageRouteById);
		// ������Ʒid��ѯ��Ʒ������װ��goodSale������
		int querySaleById = userbiz.querySaleById(good_id);
		GoodSale sale = new GoodSale();
		sale.setSale_num(querySaleById);
		// ������Ʒid��ѯ��Ʒ������װ��GoodMargin������
		int queryMarginById = userbiz.queryMarginById(good_id);
		GoodMargin margin = new GoodMargin();
		margin.setMargin_num(queryMarginById);
		// ������Ʒid��ѯ��Ʒ����
		GoodProperties queryPropertiesById = userbiz
				.queryPropertiesById(good_id);
		// ������Ʒid��ѯ��Ʒ����
		List<GoodAssess> queryAssessById = userbiz.queryAssessById(good_id);
		// ��ShoppingGood�����װ��GoodInfo��
		goodinfo.setGood(queryGoodById);
		// ��GoodPrice�����װ��GoodInfo��
		goodinfo.setGoodPrice(price);
		// ��GoodImage�����װ��GoodInfo��
		goodinfo.setGoodImage(image);
		// ��GoodSale�����װ��GoodInfo��
		goodinfo.setGoodSale(sale);
		// ��GoodMargin�����װ��GoodInfo��
		goodinfo.setGoodMargin(margin);
		// ��GoodProperties�����װ��GoodInfo��
		goodinfo.setGoodProperties(queryPropertiesById);
		// ��GoodAssess�����װ��GoodInfo��
		goodinfo.setGoodAssesses(queryAssessById);
		// ����ѯ������Ʒ���ϴ���session��
		// model.addObject("goodinfo", goodinfo);
		request.getSession().setAttribute("goodinfo", goodinfo);
		request.getSession().setAttribute("storeInfo", queryStoreInfoById);
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/user/lookGoodLine");

		return model;
	}

	/**
	 * �û�������Ʒ���򶩵���shopping_order�������,�򶩵�������������
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
		 * System.out.println("��ַid="+address_id);
		 * System.out.println("��Ʒid="+good_id);
		 * System.out.println("֧����ʽ="+payType);
		 */
		// ����ModelAndView����
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
			if(loginUser.getRole_type().equals("1")){
				// ҳ����ת
				JOptionPane.showMessageDialog(null, "����ǰ��ɫΪ���̣����л��û���¼");
				model.setViewName("/page/roleLogin");	
			}else if (loginUser.getRole_type().equals("0")) {
				// ҳ����ת
				JOptionPane.showMessageDialog(null, "����ǰ��ɫΪ����Ա�����л��û���¼");
				model.setViewName("/page/roleLogin");
			}else {
		// ����ShoppingOrder����
		ShoppingOrder order = new ShoppingOrder();
		// �򶩵�������ӵ�ǰ�û�id���û���
		order.setUser_id(loginUser.getRole_id());
		order.setUser_name(loginUser.getRole_name());
		// ������Ʒid��ȡ��ǰ��Ʒ�����Ի�ȡ��Ʒ��������id
		ShoppingGood queryGoodById = userbiz.queryGoodById(good_id);
		// �򶩵����������Ʒ��������id�͵�����
		order.setStore_id(queryGoodById.getStore_id());
		order.setStore_name(queryGoodById.getStore_name());
		// ������Ʒid��ȡ��Ʒ�۸�
		int queryPriceById = userbiz.queryPriceById(good_id);
		// �򶩵�������Ӷ������
		order.setOrder_money(queryPriceById * goodnum);
		// ��ȡ��ǰϵͳʱ�䣬�������ʽ��Ϊ�ַ������붩����
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��HH:mm:ss");
		String formatDate = sdf.format(date);
		order.setOrder_time(formatDate);
		// ��Ӷ���״̬��Ĭ��Ϊ0���Ƚ�����Ϊ0��������⵽�û�����ɹ��󣬽����Ϊ1��������Ʒ����+1
		order.setOrder_state("0");
		// ���֧����ʽ
		order.setPay_type(payType);
		// ������Ʒid��ȡ��Ʒ����
		int queryMarginById = userbiz.queryMarginById(good_id);
		// ���������뵽��������
		userbiz.insertOrder(order);
		// ��ȡ��ǰ����id
		int OrderIdCurrval = userbiz.selectOrderIdCurrval();
		// ����һ��shoppingOrderline����
		ShoppingOrderline orderline = new ShoppingOrderline();
		// ������id���������������
		orderline.setOrder_id(OrderIdCurrval);
		// ����ַid���������������
		orderline.setAddress_id(address_id);
		// ����Ʒid���������������
		orderline.setGood_id(good_id);
		// ��order_state���������������Ĭ��Ϊ0��������⵽�û�����ɹ��󣬽����Ϊ1��������Ʒ����+1
		orderline.setOrder_state("0");
		// ��������Ʒ�������������������
		orderline.setGood_num(goodnum);
		// ����Ʒ�ĵ��۸��������������
		orderline.setGood_price(queryPriceById);
		// ������Ʒid��ȡ��ƷͼƬ·��
		String queryImageRouteById = userbiz.queryImageRouteById(good_id);
		// ����ƷͼƬ·�����������������
		orderline.setImage_route(queryImageRouteById);
		// ���ݵ�ַid��ȡ��ַ��
		RoleAddress queryAddressById = userbiz.queryAddressById(address_id);
		// ����ַ�����������������
		orderline.setAddress_name(queryAddressById.getAddress_name());
		//����Ʒ�����붩�������
		orderline.setGood_name(queryGoodById.getGood_name());
		// ������������������
		userbiz.insertOrderline(orderline);
		// ����Ʒ����-��������
		userbiz.updateGoodMargin(good_id, queryMarginById - goodnum);
		//��ѯ����ӵ�����������Ϣ
		ShoppingOrder queryCurrvalOrder = userbiz.queryCurrvalOrder(loginUser.getRole_id());
		//��ѯ����ӵ���������������Ϣ
		ShoppingOrderline queryCurravlOrderline = userbiz.queryOrderlineById(queryCurrvalOrder.getOrder_id());

		//�����֧����֧����΢��֧�������֧���ӿ�
		if(payType.equals("1")||payType.equals("2")){
		int payTypeInt = Integer.parseInt(payType);
		//String priceValueOf = String.valueOf((float)queryPriceById*goodnum);
		String sendPays = PaysTest.sendPays(OrderIdCurrval,loginUser.getRole_id(),queryGoodById.getGood_name(),payTypeInt,(double)queryPriceById*goodnum/100);
		//String sendPays = PaysTest.sendPays(queryCurrvalOrder.getOrder_id(),loginUser.getRole_id(),"goodname",payTypeInt,(double)queryPriceById*goodnum);
		//System.out.println("controller����id="+queryCurrvalOrder.getOrder_id()+",��Ʒ��="+"goodname"+",֧������:"+payType+",��ɫid:"+loginUser.getRole_id()+",֧�����="+(double)queryPriceById*goodnum/100);

		// ҳ����ת
		/*response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sendPays);
		response.sendRedirect("/page/user/userPays.jsp");*/
		session.setAttribute("payResult", sendPays);
		model.setViewName("/page/user/payResult");
		//����ǻ������ʽ�򲻵���֧���ӿ�
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
	 * ֧��֪ͨ
	 * @param request
	 * @param response
	 * @param paySaPi
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	@RequestMapping("/notifyPay")
	public void notifyPay(HttpServletRequest request, HttpServletResponse response, PaySaPi paySaPi) throws Exception {
		
		// ��֤��Կһ����
		if (PayUtil.checkPayKey(paySaPi)) {
			ShoppingOrder queryOrderById = userbiz.queryOrderById(Integer.parseInt(paySaPi.getOrderid()));
			ShoppingOrderline queryOrderlineById = userbiz.queryOrderlineById(Integer.parseInt(paySaPi.getOrderid()));
			int querySaleById = userbiz.querySaleById(queryOrderlineById.getGood_id());
			queryOrderById.setOrder_state("1");
			queryOrderlineById.setOrder_state("1");
			userbiz.updateOrderById(queryOrderById);
			userbiz.updateOrderlineById(queryOrderlineById);
			userbiz.updateGoodSale(queryOrderlineById.getGood_id(), querySaleById+1);
			System.out.println("�ص�֪ͨ���");
		} 
	}
	/**
	 * ֧���ص�
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
		// ���ݶ����Ų�����Ӧ�ļ�¼:���ݽ����ת����ͬ��ҳ��
		if (paySuccess) {
			JOptionPane.showMessageDialog(null, "֧���ɹ�");
			request.getSession().setAttribute("currvalOrder", queryOrderById);
			view.setViewName("/page/pays/paySuccess");
		} else {
			JOptionPane.showMessageDialog(null, "��Կ��һ�£�����ʧ��");
			view.setViewName("/page/pays/payFail");
		}
		return view;
	}
	
	
	
	/**
	 * �û����ݶ���id�鿴��������
	 * @param order_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/lookOrderLine")
	public ModelAndView lookOrderLine(int order_id,HttpServletRequest request)throws Exception{
		//System.out.println("�鿴��������");
		ModelAndView model=new ModelAndView();
		//�鿴��������
		ShoppingOrderline queryOrderlineById = userbiz.queryOrderlineById(order_id);
		//�������
		request.getSession().setAttribute("lookOrderLine", queryOrderlineById);
		model.setViewName("/page/user/lookOrderLine");
		return model;
	}

	/**
	 * �û�����Ʒ���빺�ﳵ
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
		// ����ModelAndView����
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginUser = (ShoppingRole) session.getAttribute("currvalRole");
		if(loginUser==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
			if(loginUser.getRole_type().equals("1")){
				// ҳ����ת
				JOptionPane.showMessageDialog(null, "����ǰ��ɫΪ���̣����л��û���¼");
				model.setViewName("/page/roleLogin");	
			}else if (loginUser.getRole_type().equals("0")) {
				// ҳ����ת
				JOptionPane.showMessageDialog(null, "����ǰ��ɫΪ����Ա�����л��û���¼");
				model.setViewName("/page/roleLogin");
			}else {
				
		// ����ShoppingOrder����
		ShoppingOrder order = new ShoppingOrder();
		// �򶩵�������ӵ�ǰ�û�id���û���
		order.setUser_id(loginUser.getRole_id());
		order.setUser_name(loginUser.getRole_name());
		// ������Ʒid��ȡ��ǰ��Ʒ�����Ի�ȡ��Ʒ��������id
		ShoppingGood queryGoodById = userbiz.queryGoodById(good_id);
		// �򶩵����������Ʒ��������id�͵�����
		order.setStore_id(queryGoodById.getStore_id());
		order.setStore_name(queryGoodById.getStore_name());
		// ������Ʒid��ȡ��Ʒ�۸�
		int queryPriceById = userbiz.queryPriceById(good_id);
		// �򶩵�������Ӷ������
		order.setOrder_money(queryPriceById * goodnum);
		// ��ȡ��ǰϵͳʱ�䣬�������ʽ��Ϊ�ַ������붩����
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��HH:mm:ss");
		String formatDate = sdf.format(date);
		order.setOrder_time(formatDate);
		// ��Ӷ���״̬��Ĭ��Ϊ0���Ƚ�����Ϊ0��������⵽�û�����ɹ��󣬽����Ϊ1��������Ʒ����+1
		order.setOrder_state("0");
		// ���֧����ʽ
		//order.setPay_type("");
		// ������Ʒid��ȡ��Ʒ����
		int queryMarginById = userbiz.queryMarginById(good_id);
		// ���������뵽��������
		userbiz.insertOrder(order);
		// ��ȡ��ǰ����id
		int OrderIdCurrval = userbiz.selectOrderIdCurrval();
		// ����һ��shoppingOrderline����
		ShoppingOrderline orderline = new ShoppingOrderline();
		// ������id���������������
		orderline.setOrder_id(OrderIdCurrval);
		// ����ַid���������������
		//orderline.setAddress_id(null);
		// ����Ʒid���������������
		orderline.setGood_id(good_id);
		// ��order_state���������������Ĭ��Ϊ0��������⵽�û�����ɹ��󣬽����Ϊ1��������Ʒ����+1
		orderline.setOrder_state("0");
		// ��������Ʒ�������������������
		orderline.setGood_num(goodnum);
		// ����Ʒ�ĵ��۸��������������
		orderline.setGood_price(queryPriceById);
		// ������Ʒid��ȡ��ƷͼƬ·��
		String queryImageRouteById = userbiz.queryImageRouteById(good_id);
		// ����ƷͼƬ·�����������������
		orderline.setImage_route(queryImageRouteById);
		//����Ʒ�����������������
		orderline.setGood_name(queryGoodById.getGood_name());
		// ����ַ�����������������
		//orderline.setAddress_name(null);
		// ������������������
		userbiz.insertOrderline(orderline);
		// ����Ʒ����-��������
		userbiz.updateGoodMargin(good_id, queryMarginById - goodnum);
		// ҳ����ת
		JOptionPane.showMessageDialog(null, "���빺�ﳵ�ɹ�");
		model.setViewName("/page/user/lookGood");
			}
		}
		return model;

	}
	/**
	 * �û����㶩��
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
		//���ݶ���id��ѯ����
		ShoppingOrder queryOrderById = userbiz.queryOrderById(order_id);
		//��ҳ�洫������֧����ʽ��ӵ�������
		queryOrderById.setPay_type(pay_type);
		//��ʽ����ǰʱ��
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM��dd��HH:mm:ss");
		String formatTime = sdf.format(date);
		//����ǰʱ����뵱ǰorder������
		queryOrderById.setOrder_time(formatTime);
		//��⵽����ɹ��󣬽�״̬��Ϊ1
		//queryOrderById.setOrder_state("1");
		//���ݶ���id��ѯ��������
		ShoppingOrderline queryOrderlineById = userbiz.queryOrderlineById(order_id);
		//��ҳ���ϴ������ĵ�ַid�͵�ַ���ݲ��붩�������
		queryOrderlineById.setAddress_id(address_id);
		queryOrderlineById.setAddress_name(address_name);
		//��⵽����ɹ��󣬽�״̬��Ϊ1
		//queryOrderlineById.setOrder_state("1");
		//���¶�����
		userbiz.updateOrderById(queryOrderById);
		//���¶��������
		userbiz.updateOrderlineById(queryOrderlineById);
		if(pay_type.equals("1")||pay_type.equals("2")){
			int payTypeInt = Integer.parseInt(pay_type);
			String sendPays = PaysTest.sendPays(order_id,loginUser.getRole_id(),good_name,payTypeInt,(double)(good_price*good_num)/100);
			//System.out.println("orderid:"+order_id+",orderuid:"+loginUser.getRole_id()+",goodsname:"+good_name+",paytype:"+payTypeInt+",price:"+(double)(good_price*good_num)/100);
			session.setAttribute("payResult", sendPays);
			//����ǻ������ʽ�򲻵���֧���ӿ�
			}else if(pay_type.equals("3")){
				session.setAttribute("currvalOrder",queryOrderById);
				session.setAttribute("curravlOrderline", queryOrderlineById);
			}
			model.setViewName("/page/user/payResult");
			
			return model;
	}
	/**
	 * �û������˵�����
	 * @param order_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/backOrder")
	public ModelAndView backOrder(int order_id)throws Exception{
		ModelAndView model=new ModelAndView();
		//���ݶ���id��ѯ����
		ShoppingOrder queryOrderById = userbiz.queryOrderById(order_id);
		//��ʽ����ǰʱ��
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM��dd��HH:mm:ss");
		String formatTime = sdf.format(date);
		//����ǰʱ����뵱ǰorder������
		queryOrderById.setOrder_time(formatTime);
		//������״̬��Ϊ4�����˿�״̬���ȴ�����ͬ��
		queryOrderById.setOrder_state("4");
		//���ݶ���id��ѯ�����������
		ShoppingOrderline queryOrderlineById = userbiz.queryOrderlineById(order_id);
		//������״̬��Ϊ4�����˿�״̬���ȴ�����ͬ��
		queryOrderlineById.setOrder_state("4");
		//���¶�����
		userbiz.updateOrderById(queryOrderById);
		//���¶��������
		userbiz.updateOrderlineById(queryOrderlineById);
		// ҳ����ת
		JOptionPane.showMessageDialog(null, "�ѷ����˵����룬��ȴ����̴���");
		model.setViewName("/page/user/lookOrder");
		return model;
	}

	/**
	 * �û��ղ�ĳ����Ʒ
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
		// ����ModelAndView����
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
			if(loginUser.getRole_type().equals("1")){
				// ҳ����ת
				JOptionPane.showMessageDialog(null, "����ǰ��ɫΪ���̣����л��û���¼");
				model.setViewName("/page/roleLogin");	
			}else if (loginUser.getRole_type().equals("0")) {
				// ҳ����ת
				JOptionPane.showMessageDialog(null, "����ǰ��ɫΪ����Ա�����л��û���¼");
				model.setViewName("/page/roleLogin");
			}else {
				boolean collectRepeat=false;
		List<CollectGood> queryCollectGoodByUserId = userbiz.queryCollectGoodByUserId(loginUser.getRole_id());
		for(CollectGood collectGood:queryCollectGoodByUserId){
			if(good_id==collectGood.getGood_id()){
				// ҳ����ת
				collectRepeat=true;
				break;
			}
		}
		if(!collectRepeat){
			
		// ����CollectGood����
		CollectGood collectGood = new CollectGood();
		// ���ղر��������Ʒid
		collectGood.setGood_id(good_id);
		// �򶩵�������ӵ�ǰ�û�id
		collectGood.setUser_id(loginUser.getRole_id());
		// ������Ʒid��ȡ��ǰ��Ʒ�����Ի�ȡ��Ʒ��������id
		ShoppingGood queryGoodById = userbiz.queryGoodById(good_id);
		// ���ղ���Ʒ���������Ʒ��������id
		collectGood.setStore_id(queryGoodById.getStore_id());
		// ����Ʒ���ֲ��뵽�ղض�����
		collectGood.setGood_name(queryGoodById.getGood_name());
		// ������Ʒid��ѯͼƬ·��
		String queryImageRouteById = userbiz.queryImageRouteById(good_id);
		// ��ͼƬ·�������ղض�����
		collectGood.setImage_route(queryImageRouteById);
		// ���ղر����������
		userbiz.insertCollectGood(collectGood);
		// ҳ����ת
		JOptionPane.showMessageDialog(null, "�ղسɹ�");
		model.setViewName("/page/user/lookGoodLine");
		}else {
			JOptionPane.showMessageDialog(null, "����Ʒ���ղ�");
			model.setViewName("/page/user/lookGood");
		}
			}
		}
		
		return model;
	}

	/**
	 * �û���ѯ�Լ��Ķ���
	 * 
	 * @param good_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookOrder")
	public ModelAndView userLookOrder(HttpServletRequest request)
			throws Exception {
		// ����ModelAndView����
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
		// ��ѯ��ǰ�û������ж�����Ϣ������һ������
		List<ShoppingOrder> orders = userbiz.queryOrderByUserId(loginUser
				.getRole_id());

		// ҳ����ת
		model.addObject("shoppingOrders", orders);
		model.setViewName("/page/user/lookOrder");
		}
		return model;

	}

	/**
	 * �û��鿴�Լ��Ĺ��ﳵ
	 * 
	 * @param good_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookShoppingCar")
	public ModelAndView userLookShoppingCar(HttpServletRequest request)
			throws Exception {
		// ����ModelAndView����
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
		// ��ѯ��ǰ�û������ж�����Ϣ������һ������
		List<ShoppingOrder> orders = userbiz.queryShoppingCarByUserId(loginUser
				.getRole_id());
		// ҳ����ת
		model.addObject("shoppingCars", orders);
		model.setViewName("/page/user/lookShoppingCar");
		}
		return model;

	}
	/**
	 * �û��鿴�Լ��Ĵ�����
	 * 
	 * @param good_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookWaitDeliver")
	public ModelAndView userLookWaitDeliver(HttpServletRequest request)
			throws Exception {
		// ����ModelAndView����
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
		// ��ѯ��ǰ�û������ж�����Ϣ������һ������
		List<ShoppingOrder> orders = userbiz.queryWaitDeliverGoodByUserId(loginUser
				.getRole_id());
		// ҳ����ת
		model.addObject("waitDeliverGoods", orders);
		model.setViewName("/page/user/lookWaitDeliverGood");
		}
		return model;

	}
	/**
	 * �û��鿴�Լ��Ĵ��ջ�
	 * 
	 * @param good_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookWaitReceipt")
	public ModelAndView userLookWaitReceipt(HttpServletRequest request)
			throws Exception {
		// ����ModelAndView����
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
		// ��ѯ��ǰ�û������ж�����Ϣ������һ������
		List<ShoppingOrder> orders = userbiz.queryWaitReceiptGoodByUserId(loginUser
				.getRole_id());
		// ҳ����ת
		model.addObject("waitReceiptGoods", orders);
		model.setViewName("/page/user/lookWaitReceiptGood");
		}
		return model;

	}
	/**
	 * �û��鿴�Լ��Ĵ�����
	 * 
	 * @param good_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookWaitAssess")
	public ModelAndView userLookWaitAssess(HttpServletRequest request)
			throws Exception {
		// ����ModelAndView����
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
		// ��ѯ��ǰ�û������ж�����Ϣ������һ������
		List<ShoppingOrder> orders = userbiz.queryWaitAssessGoodByUserId(loginUser
				.getRole_id());
		// ҳ����ת
		model.addObject("waitAssessGoods", orders);
		model.setViewName("/page/user/lookWaitAssessGood");
		}
		return model;

	}
	/**
	 * �û��鿴�Լ��Ĵ��˿�
	 * 
	 * @param good_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookWaitBackMoney")
	public ModelAndView userLookWaitBackMoney(HttpServletRequest request)
			throws Exception {
		// ����ModelAndView����
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
		// ��ѯ��ǰ�û������ж�����Ϣ������һ������
		List<ShoppingOrder> orders = userbiz.queryWaitBackMoneyByUserId(loginUser
				.getRole_id());
		// ҳ����ת
		model.addObject("waitBackMoneys", orders);
		model.setViewName("/page/user/lookWaitBackMoney");
		}
		return model;

	}
	/**
	 * �û��鿴�Լ������˿�
	 * 
	 * @param good_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookBackMoney")
	public ModelAndView userLookBackMoney(HttpServletRequest request)
			throws Exception {
		// ����ModelAndView����
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
		// ��ѯ��ǰ�û������ж�����Ϣ������һ������
		List<ShoppingOrder> orders = userbiz.queryBackMoneyByUserId(loginUser
				.getRole_id());
		// ҳ����ת
		model.addObject("BackMoneys", orders);
		model.setViewName("/page/user/lookBackMoney");
		}
		return model;

	}
	/**
	 * �û��鿴�Լ��������
	 * 
	 * @param good_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookOverOrder")
	public ModelAndView userLookOverOrder(HttpServletRequest request)
			throws Exception {
		// ����ModelAndView����
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
		// ��ѯ��ǰ�û������ж�����Ϣ������һ������
		List<ShoppingOrder> orders = userbiz.queryOverOrderByUserId(loginUser
				.getRole_id());
		// ҳ����ת
		model.addObject("overOrders", orders);
		model.setViewName("/page/user/lookOverOrder");
		}
		return model;

	}

	/**
	 * �û��鿴�Լ����ղ�
	 * 
	 * @param good_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookCollectGood")
	public ModelAndView userLookCollectGood(HttpServletRequest request)
			throws Exception {
		// ����ModelAndView����
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
		// ��ѯ��ǰ�û������ж�����Ϣ������һ������
		List<CollectGood> collectGoods = userbiz
				.queryCollectGoodByUserId(loginUser.getRole_id());
		// ҳ����ת
		model.addObject("collectGoods", collectGoods);
		model.setViewName("/page/user/lookCollectGood");
		}
		return model;

	}

	/**
	 * �û���ӵ�ַ
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addUserAddress")
	public ModelAndView addUserAddress(RoleAddress address,
			HttpServletRequest request) throws Exception {
		// ����ModelAndView����
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
		// ����ǰ�û�id����roleAddress������
		address.setUser_id(loginUser.getRole_id());
		// ��roleAddress������
		userbiz.insertUserAddress(address);
		// ��תҳ��
		JOptionPane.showMessageDialog(null, "��ַ�����");
		model.setViewName("/page/user/userPage");
		}
		return model;
	}

	/**
	 * �û�ɾ���Լ��˺���Ϣ
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser(HttpServletRequest request) throws Exception {
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
			int showConfirmDialog = JOptionPane.showConfirmDialog(null,
					"ȷ��ע�������˺���", "��ʾ", JOptionPane.YES_NO_OPTION);
			if (showConfirmDialog == 0) {
				// ɾ���Լ��˺���Ϣ
				userbiz.deleteUserById(loginUser.getRole_id());
				JOptionPane.showMessageDialog(null, "�˺���ע��");
				// ��תҳ��
				model.setViewName("/page/roleLogin");
			} else {
				model.setViewName("/page/user/userPage");
			}
		
		}
		return model;
	}

	/**
	 * �����û���Ϣ
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateUserInfo")
	public ModelAndView updateUser(ShoppingRole role) throws Exception {
		ModelAndView model = new ModelAndView();
		userbiz.updateUserById(role);
		JOptionPane.showMessageDialog(null, "��Ϣ�Ѹ���");
		model.setViewName("/page/user/userPage");
		return model;

	}

	/**
	 * ���µ�ַ��Ϣ
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateAddressInfo")
	public ModelAndView updateUser(RoleAddress address) throws Exception {
		ModelAndView model = new ModelAndView();
		userbiz.updateAddressById(address);
		JOptionPane.showMessageDialog(null, "��Ϣ�Ѹ���");
		model.setViewName("/page/user/userPage");
		return model;

	}

	/**
	 * ɾ��ĳ���ղ���Ʒ
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteCollectGood")
	public ModelAndView deleteCollectGood(int collect_id) throws Exception {
		ModelAndView model = new ModelAndView();
		userbiz.deleteCollectGoodById(collect_id);
		JOptionPane.showMessageDialog(null, "�ղ���ɾ��");
		model.setViewName("/page/user/userPage");
		return model;

	}

	/**
	 * �û��ղ�ĳ�ҵ���
	 * 
	 * @param store_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userAddCollectStore")
	public ModelAndView userAddCollectStore(Integer store_id,
			HttpServletRequest request) throws Exception {
		// ����ModelAndView����
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
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
			
		// ����CollectStore����
		CollectStore collectStore = new CollectStore();
		// ���ղر�����ӵ���id
		collectStore.setStore_id(store_id);
		// ���ղر�����ӵ�ǰ�û�id
		collectStore.setUser_id(loginUser.getRole_id());
		// ���ݵ���id��ѯ���̶���
		ShoppingRole queryStoreById = userbiz.queryRoleById(store_id);
		// ���ղر�����ӵ�����
		collectStore.setStore_name(queryStoreById.getRole_name());
		// ���ղر����������
		userbiz.insertCollectStore(collectStore);
		// ҳ����ת
		JOptionPane.showMessageDialog(null, "�ղسɹ�");
		model.setViewName("/page/user/lookStore");
			}else {
				JOptionPane.showMessageDialog(null, "�˵������ղ�");
				model.setViewName("/page/user/lookStore");
			}
		}
		return model;
	}

	/**
	 * �û��鿴�Լ����ղص���
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookCollectStore")
	public ModelAndView userLookCollectStore(HttpServletRequest request)
			throws Exception {
		// ����ModelAndView����
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
		// ��ѯ��ǰ�û��������ղص�����Ϣ������һ������
		List<CollectStore> collectStores = userbiz
				.queryCollectStoreByUserId(loginUser.getRole_id());
		// ҳ����ת
		model.addObject("collectStores", collectStores);
		model.setViewName("/page/user/lookCollectStore");
		}
		return model;

	}

	/**
	 * ɾ��ĳ���ղص���
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteCollectStore")
	public ModelAndView deleteCollectStore(int collect_id) throws Exception {
		ModelAndView model = new ModelAndView();
		userbiz.deleteCollectStoreById(collect_id);
		JOptionPane.showMessageDialog(null, "�ղ���ɾ��");
		model.setViewName("/page/user/userPage");
		return model;

	}

	/**
	 * ɾ��ĳ����ַ
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteAddressById")
	public ModelAndView deleteAddressById(int address_id) throws Exception {
		ModelAndView model = new ModelAndView();
		userbiz.deleteAddressById(address_id);
		JOptionPane.showMessageDialog(null, "��ַ��ɾ��");
		model.setViewName("/page/user/userPage");
		return model;

	}

	/**
	 * ɾ��ĳ�Ŷ�����������
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteOrderById")
	public ModelAndView deleteOrderById(int order_id) throws Exception {
		ModelAndView model = new ModelAndView();
		userbiz.deleteOrderAndLineById(order_id);
		JOptionPane.showMessageDialog(null, "������ɾ��");
		model.setViewName("/page/user/userPage");
		return model;

	}

	/**
	 * �û�����ĳ����Ʒ
	 * 
	 * @param store_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userAssessGood")
	public ModelAndView userAssessGood(String assess_content, Integer good_id,Integer order_id,
			HttpServletRequest request) throws Exception {
		// ����ModelAndView����
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
		ShoppingOrder queryOrderById = userbiz.queryOrderById(order_id);
		ShoppingOrderline queryOrderlineById = userbiz.queryOrderlineById(order_id);
		queryOrderById.setOrder_state("Y");
		queryOrderlineById.setOrder_state("Y");
		// ����goodAssess����
		GoodAssess assess = new GoodAssess();
		//
		assess.setUser_id(loginUser.getRole_id());
		// �����۱��������Ʒid
		assess.setGood_id(good_id);
		// �����۱�����ӵ�ǰ��������
		assess.setAssess_content(assess_content);
		// ��ȡ��ǰϵͳʱ�䣬�������ʽ��Ϊ�ַ������붩����
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��HH:mm:ss");
		String formatDate = sdf.format(date);
		// �����۱������ʱ��
		assess.setAssess_time(formatDate);
		// ������Ʒid��ѯ��Ʒ����
		ShoppingGood queryGoodById = userbiz.queryGoodById(good_id);
		// �����۱��������Ʒ��
		assess.setGood_name(queryGoodById.getGood_name());
		// ������Ʒid��ѯͼƬ·��
		String queryImageRouteById = userbiz.queryImageRouteById(good_id);
		// �����۱������ͼƬ·��
		assess.setImage_route(queryImageRouteById);
		//�����۱�������û���
		assess.setUser_name(loginUser.getRole_name());
		// ���ղر����������
		userbiz.insertGoodAssess(assess);
		//���¶���������״̬
		userbiz.updateOrderById(queryOrderById);
		userbiz.updateOrderlineById(queryOrderlineById);
		// ҳ����ת
		JOptionPane.showMessageDialog(null, "���۳ɹ�");
		model.setViewName("/page/user/lookWaitAssessGood");
		}
		
		return model;

	}
	/**
	 * �û�ȡ���˿�����
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
		JOptionPane.showMessageDialog(null, "�˿�������ȡ��");
		
	}

	/**
	 * �û��鿴�Լ���������Ʒ
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookGoodAssess")
	public ModelAndView userLookGoodAssess(HttpServletRequest request)
			throws Exception {
		// ����ModelAndView����
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginUser = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginUser==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
		// ��ѯ��ǰ�û��������ղص�����Ϣ������һ������
		List<GoodAssess> goodAssesses = userbiz
				.queryGoodAssessByUserId(loginUser.getRole_id());
		// ҳ����ת
		model.addObject("goodAssesses", goodAssesses);
		model.setViewName("/page/user/lookAssessGood");
		}
		return model;

	}

	/**
	 * ɾ��ĳ������
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteAssessById")
	public ModelAndView deleteAssessById(int assess_id) throws Exception {
		ModelAndView model = new ModelAndView();
		userbiz.deleteGoodAssessById(assess_id);
		JOptionPane.showMessageDialog(null, "������ɾ��");
		model.setViewName("/page/user/userPage");
		return model;

	}
	/**
	 * ������Ʒ����ѯ��Ʒ
	 * @param good_name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryGoodByName")
	public ModelAndView queryGoodByName(String good_name)throws Exception{
		ModelAndView model=new ModelAndView();
		//������Ʒ��ģ����ѯ��Ʒ
		System.out.println(good_name);
		List<ShoppingGood> queryGoodByName = userbiz.queryGoodByName(good_name);
		model.addObject("queryGoods", queryGoodByName);
		model.setViewName("/page/user/queryGood");
		return model;
	}
	/**
	 * �û��������
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookStore")
	public ModelAndView userLookStore(HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		// ��ѯ��������
		int storeCount = userbiz.queryStoreCount();
		// System.out.println("goodcount:"+goodCount);
		double pagenum = (double) storeCount / 4;
		// System.out.println("pagenum"+pagenum);
		// ����math�������ȡ���������з�ҳ
		storePageCount = (int) Math.ceil(pagenum);
		// ��ѯ����һҳ���е���
		List<ShoppingRole> queryStores = userbiz.queryStores(storePage);
		// �������ϴ洢������Ϣ
		List<StoreInfo> storeInfos = new ArrayList<StoreInfo>();
		for (ShoppingRole store : queryStores) {
			// ���ݵ���id��ѯ������Ϣ
			StoreInfo storeInfo = userbiz.queryStoreInfoById(store.getRole_id());
			// ��goodinfo�������缯����
			storeInfos.add(storeInfo);
		}
		// ����ѯ������Ʒ���ϴ���modelAndView��
		// model.addObject("goodinfos", goodInfos);
		// ����������ݴ���session��
		request.getSession().setAttribute("storeinfos", storeInfos);
		request.getSession().setAttribute("storePageCount", storePageCount);
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/user/lookStore");
		return model;
	}
	/**
	 * �û������һҳ��ѯ��һҳ����
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
		// ��ѯ��������
		int storeCount = userbiz.queryStoreCount();
		// System.out.println("goodcount:"+goodCount);
		double pagenum = (double) storeCount / 4;
		// System.out.println("pagenum"+pagenum);
		// ����math�������ȡ���������з�ҳ
		storePageCount = (int) Math.ceil(pagenum);
		// ��ѯ����һҳ���е���
		List<ShoppingRole> queryStores = userbiz.queryStores(storePage);
		// �������ϴ洢������Ϣ
		List<StoreInfo> storeInfos = new ArrayList<StoreInfo>();

		for (ShoppingRole store : queryStores) {
			// ���ݵ���id��ѯ������Ϣ
			StoreInfo storeInfo = userbiz.queryStoreInfoById(store.getRole_id());
			// ��goodinfo�������缯����
			storeInfos.add(storeInfo);
		}

		// ����ѯ������Ʒ���ϴ���modelAndView��
		// model.addObject("goodinfos", goodInfos);
		// ����������ݴ���session��
		request.getSession().setAttribute("storeinfos", storeInfos);
		request.getSession().setAttribute("storePageCount", storePageCount);
		}
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/user/lookStore");
		return model;
	}
	/**
	 * �û������һҳ��ѯ��һҳ����
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
		// ��ѯ��������
		int storeCount = userbiz.queryStoreCount();
		// System.out.println("goodcount:"+goodCount);
		double pagenum = (double) storeCount / 4;
		// System.out.println("pagenum"+pagenum);
		// ����math�������ȡ���������з�ҳ
		storePageCount = (int) Math.ceil(pagenum);
		// ��ѯ����һҳ���е���
		List<ShoppingRole> queryStores = userbiz.queryStores(storePage);
		// �������ϴ洢������Ϣ
		List<StoreInfo> storeInfos = new ArrayList<StoreInfo>();

		for (ShoppingRole store : queryStores) {
			// ���ݵ���id��ѯ������Ϣ
			StoreInfo storeInfo = userbiz.queryStoreInfoById(store.getRole_id());
			// ��goodinfo�������缯����
			storeInfos.add(storeInfo);
		}

		// ����ѯ������Ʒ���ϴ���modelAndView��
		// model.addObject("goodinfos", goodInfos);
		// ����������ݴ���session��
		request.getSession().setAttribute("storeinfos", storeInfos);
		request.getSession().setAttribute("storePageCount", storePageCount);
		}
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/user/lookStore");
		return model;
	}
	/**
	 * �û�����ҳ����̶�ҳ����ת
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLookStoreJump")
	public ModelAndView userLookStoreJump(Integer jumpPage,HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		storePage=jumpPage;
		// ��ѯ��������
		int storeCount = userbiz.queryStoreCount();
		// System.out.println("goodcount:"+goodCount);
		double pagenum = (double) storeCount / 4;
		// System.out.println("pagenum"+pagenum);
		// ����math�������ȡ���������з�ҳ
		storePageCount = (int) Math.ceil(pagenum);
		// ��ѯ����һҳ���е���
		List<ShoppingRole> queryStores = userbiz.queryStores(storePage);
		// �������ϴ洢������Ϣ
		List<StoreInfo> storeInfos = new ArrayList<StoreInfo>();

		for (ShoppingRole store : queryStores) {
			// ���ݵ���id��ѯ������Ϣ
			StoreInfo storeInfo = userbiz.queryStoreInfoById(store.getRole_id());
			// ��goodinfo�������缯����
			storeInfos.add(storeInfo);
		}

		// ����ѯ������Ʒ���ϴ���modelAndView��
		// model.addObject("goodinfos", goodInfos);
		// ����������ݴ���session��
		request.getSession().setAttribute("storeinfos", storeInfos);
		request.getSession().setAttribute("storePageCount", storePageCount);
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/user/lookStore");
		return model;
	}
	/**
	 * ���ݵ���id��ѯ������ϸ��Ϣ���Ҳ鿴����Ʒ
	 * @param store_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userLookStoreLine")
	public ModelAndView userLookStoreLine(Integer store_id,HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		//����store_id��ѯshoppingRole������Ϣ
		ShoppingRole queryStoreById = userbiz.queryRoleById(store_id);
		// ���ݵ���id��ѯ������Ϣ
		StoreInfo storeInfo = userbiz.queryStoreInfoById(store_id);
		//���ݵ���id��ѯ��ַ
		List<RoleAddress> queryAddressByStoreId = userbiz.queryAddressByStoreId(store_id);
		//���ݵ���id��ѯ����Ʒ
		List<ShoppingGood> queryGoods = userbiz.queryStoreGoods(store_id);
		// �������ϴ洢��Ʒ��Ϣ
		List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();
		for (ShoppingGood good : queryGoods) {
			GoodInfo goodinfo = new GoodInfo();
			// ������Ʒid��ѯ��Ʒ�۸��װ��GoodPrice������
			int queryPriceById = userbiz.queryPriceById(good.getGood_id());
			GoodPrice price = new GoodPrice();
			price.setPrice_num(queryPriceById);
			// ������Ʒid��ѯ��ƷͼƬ·����װ��GoodImage������
			String queryImageRouteById = userbiz.queryImageRouteById(good
					.getGood_id());
			GoodImage image = new GoodImage();
			image.setImage_route(queryImageRouteById);
			// ������Ʒid��ѯ��Ʒ������װ��goodSale������
			int querySaleById = userbiz.querySaleById(good.getGood_id());
			GoodSale sale = new GoodSale();
			sale.setSale_num(querySaleById);
			// ������Ʒid��ѯ��Ʒ������װ��GoodMargin������
			int queryMarginById = userbiz.queryMarginById(good.getGood_id());
			GoodMargin margin = new GoodMargin();
			margin.setMargin_num(queryMarginById);
			// ������Ʒid��ѯ��Ʒ����
			GoodProperties queryPropertiesById = userbiz
					.queryPropertiesById(good.getGood_id());
			// ������Ʒid��ѯ��Ʒ����
			List<GoodAssess> queryAssessById = userbiz.queryAssessById(good
					.getGood_id());
			// ��ShoppingGood�����װ��GoodInfo��
			goodinfo.setGood(good);
			// ��GoodPrice�����װ��GoodInfo��
			goodinfo.setGoodPrice(price);
			// ��GoodImage�����װ��GoodInfo��
			goodinfo.setGoodImage(image);
			// ��GoodSale�����װ��GoodInfo��
			goodinfo.setGoodSale(sale);
			// ��GoodMargin�����װ��GoodInfo��
			goodinfo.setGoodMargin(margin);
			// ��GoodProperties�����װ��GoodInfo��
			goodinfo.setGoodProperties(queryPropertiesById);
			// ��GoodAssess�����װ��GoodInfo��
			goodinfo.setGoodAssesses(queryAssessById);
			// ��goodinfo�������缯����
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
	 * �û�ȷ���ջ�
	 * @param order_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userReceiptGood")
	public ModelAndView userReceiptGood(int order_id)throws Exception{
		ModelAndView model=new ModelAndView();
		userbiz.updateOrderStateReceiptGood(order_id);
		userbiz.updateOrderlineStateReceiptGood(order_id);
		JOptionPane.showMessageDialog(null, "��ȷ���ջ�");
		model.setViewName("/page/user/lookWaitReceiptGood");
		return model;
	}
	
}
