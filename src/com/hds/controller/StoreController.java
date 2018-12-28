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
 * storeController,����������̵�һЩ��������ע�ᣬ��¼����Ʒ�ϼ����¼�...
 * 
 * @author ��
 *
 */
@Controller
@RequestMapping("/store")
public class StoreController {
	@Autowired
	private StoreBiz storebiz;
	private int yzmNumber = RandomTest.getNum();// ���ù����෽��������λ�����
	private static int page = 1;
	private static int pageCount = 0;

	/**
	 * ���̵ǳ�
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
			model.setViewName("/page/store/storePage");
		}
		return model;
	}
	/**
	 * ����ע�᷽����ע����ȴ�����Ա���
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
		//����modelAndView����
		ModelAndView model = new ModelAndView();
		//��֤�������Ƿ��ظ�
		boolean userNameRepeat = UserRegisterFilter.userNameRepeat(role.getRole_name());
		if(userNameRepeat){
			JOptionPane.showMessageDialog(null,"�������ظ�������������!");
			model.setViewName("/page/store/storeRegist");
		}else {
			int showConfirmDialog = JOptionPane.showConfirmDialog(null, "���������ã��Ƿ�ȷ��ʹ�ã�", "������ȷ��", JOptionPane.YES_NO_OPTION);
			if(showConfirmDialog==0){
				if(role_yzm.equals(yzm)){
					storebiz.storeRegist(role);
					//��ȡ��ע����̵�id
					int selectStoreIdCurrval = storebiz.selectStoreIdCurrval();
					//Ϊ������Ϣ�������
					storeInfo.setStore_id(selectStoreIdCurrval);
					//�ӽ�ɫ����ȡ����ɫ����Ϊ������Ϣ����ĵ�����
					storeInfo.setStore_name(role.getRole_name());
					//��������Ϣ���뵽store_info����
					storebiz.addStoreInfo(storeInfo);
					JOptionPane.showMessageDialog(null,"ע��ɹ������¼!");
					model.setViewName("/page/roleLogin");
				}else {
					JOptionPane.showMessageDialog(null,"��֤�벻��ȷ������������!");
					model.setViewName("/page/store/storeRegist");
				}
				
			}else {
				model.setViewName("/page/store/storeRegist");
			}
		
	  }
		
		return model;

	}

	/**
	 * ͨ���û�������ֻ��ŵ��ö��Žӿڻ�ȡ��֤��
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getyzm")
	public void getYzm(HttpServletRequest request,HttpServletResponse response,String rolename,String roletel) throws Exception {
		System.out.println("�û���:"+rolename+"�绰"+roletel);
		try {
			int sendSMS = SMSTest.sendSMS(yzmNumber, rolename, roletel);// ���ù�����ķ������ֻ��ŷ��Ͷ���
			String data=Integer.toString(sendSMS);
			response.setContentType("application/text; charset=utf-8");
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
	 * ���̸��ݵ�������¼
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
				JOptionPane.showMessageDialog(null,"�����������������!");
				return "/page/roleLogin";
			}
		} else {
			JOptionPane.showMessageDialog(null,"�����������ڣ�����������!");
			return "/page/roleLogin";
		}

	}

	/**
	 * ���ݵ���ע���ֻ��ŵ�¼
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
				JOptionPane.showMessageDialog(null,"�����������������!");
				return "/page/roleLogin";
			}
		} else {
			JOptionPane.showMessageDialog(null,"�ֻ��Ų����ڣ�����������!");
			return "/page/roleLogin";
		}

	}

	/**
	 * �����ϼ���Ʒ
	 * 
	 * @param good
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "addGood")
	public ModelAndView addGood(GoodInfo goodInfo, HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		// Ϊ��Ʒ��������ĵ��̣���ǰ�����ĵ���id
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
		goodInfo.getGood().setStore_id(currvalRole.getRole_id());
		goodInfo.getGood().setStore_name(currvalRole.getRole_name());
		storebiz.addGood(goodInfo.getGood());
		int goodIdCurrval = storebiz.selectGoodIdCurrval();
		GoodMargin margin = new GoodMargin();
		// Ϊ��Ʒ������Ϣ�����������Ʒid
		margin.setGood_id(goodIdCurrval);
		margin.setMargin_num(100);
		GoodSale sale = new GoodSale();
		// Ϊ��Ʒ������Ϣ�����������Ʒid
		sale.setGood_id(goodIdCurrval);
		sale.setSale_num(0);
		// ȡ�������ҳ����nameΪimageRoute��input��ǩ��ֵ
		String imageRoute = request.getParameter("imageRoute");
		//����goodImage����
		GoodImage image=new GoodImage();
		image.setImage_route(imageRoute);
		image.setGood_id(goodIdCurrval);
		goodInfo.setGoodImage(image);
		goodInfo.setGoodMargin(margin);
		goodInfo.getGoodPrice().setGood_id(goodIdCurrval);
		goodInfo.getGoodProperties().setGood_id(goodIdCurrval);
		goodInfo.setGoodSale(sale);
		// ����Ʒ��Ϣ���
		storebiz.addGoodInfo(goodInfo);
		System.out.println(storebiz.selectGoodIdCurrval());
		JOptionPane.showMessageDialog(null, "��Ʒ���ϼ�");
		model.setViewName("/page/store/storePage");
		}
		return model;

	}
	/**
	 * ����ɾ���Լ���Ϣ
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteStore")
	public ModelAndView deleteStore(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		int showConfirmDialog = JOptionPane.showConfirmDialog(null, "ȷ��ע���˻���", "ɾ����ʾ", JOptionPane.YES_NO_OPTION);
		if(showConfirmDialog==0){
			// Ϊ��Ʒ��������ĵ��̣���ǰ�����ĵ���id
			ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
			//ɾ���Լ��˺���Ϣ
			storebiz.deleteStoreById(currvalRole.getRole_id());
			//��תҳ��
			model.setViewName("/index");
		}else {
			model.setViewName("/page/store/lookStoreInfo");
		}
		
		return model;
	}
	/**
	 * ���̵�¼���ѯ�Լ���ϸ��Ϣ
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/lookStoreInfo")
	public ModelAndView lookStoreInfo(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		// ��ȡ��ǰ��¼�ĵ���
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		//���ݵ���id��ѯ������Ϣ
		StoreInfo queryStoreInfoById = storebiz.queryStoreInfoById(currvalRole.getRole_id());
		//���ݵ���id��ѯ��ַ
		List<RoleAddress> queryAddressByStoreId = storebiz.queryAddressByStoreId(currvalRole.getRole_id());
		//��ӵ�ǰ������Ϣ��session��
		request.getSession().setAttribute("currvalRole", currvalRole);
		request.getSession().setAttribute("currvalRoleInfo", queryStoreInfoById);
		request.getSession().setAttribute("storeAddresses", queryAddressByStoreId);
		//��תҳ��
		model.setViewName("/page/store/lookStoreInfo");
		}else {
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * ���µ�����Ϣ
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
	 * ��������Լ���Ʒ
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookGood")
	public ModelAndView storeLookGood(HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ��¼�ĵ���
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		// ��ѯ��Ʒ����
		int goodCount = storebiz.queryGoodCount(currvalRole.getRole_id());
		// System.out.println("goodcount:"+goodCount);
		double pagenum = (double) goodCount / 4;
		// System.out.println("pagenum"+pagenum);
		// ����math�������ȡ���������з�ҳ
		pageCount = (int) Math.ceil(pagenum);
		// ��ѯ����һҳ������Ʒ
		List<ShoppingGood> queryGoods = storebiz.queryStoreGoods(currvalRole.getRole_id(),page);
		// �������ϴ洢��Ʒ��Ϣ
		List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();

		for (ShoppingGood good : queryGoods) {
			GoodInfo goodinfo = new GoodInfo();
			// ������Ʒid��ѯ��Ʒ�۸��װ��GoodPrice������
			// System.out.println(good.getGood_id());
			int queryPriceById = storebiz.queryPriceById(good.getGood_id());
			GoodPrice price = new GoodPrice();
			price.setPrice_num(queryPriceById);
			// ������Ʒid��ѯ��ƷͼƬ·����װ��GoodImage������
			String queryImageRouteById = storebiz.queryImageRouteById(good
					.getGood_id());
			GoodImage image = new GoodImage();
			image.setImage_route(queryImageRouteById);
			// ������Ʒid��ѯ��Ʒ������װ��goodSale������
			int querySaleById = storebiz.querySaleById(good.getGood_id());
			GoodSale sale = new GoodSale();
			sale.setSale_num(querySaleById);
			// ������Ʒid��ѯ��Ʒ������װ��GoodMargin������
			int queryMarginById = storebiz.queryMarginById(good.getGood_id());
			GoodMargin margin = new GoodMargin();
			margin.setMargin_num(queryMarginById);
			// ������Ʒid��ѯ��Ʒ����
			GoodProperties queryPropertiesById = storebiz
					.queryPropertiesById(good.getGood_id());
			// ������Ʒid��ѯ��Ʒ����
			List<GoodAssess> queryAssessById = storebiz.queryAssessById(good
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
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/store/storeLookGood");
		}else {
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * ��������Լ���Ʒ��һҳ
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookGoodNext")
	public ModelAndView storeLookGoodNext(HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		page+=1;
		
		// ��ȡ��ǰ��¼�ĵ���
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
			if(page>pageCount||page==pageCount){
				page=pageCount;
		// ��ѯ��Ʒ����
		int goodCount = storebiz.queryGoodCount(currvalRole.getRole_id());
		// System.out.println("goodcount:"+goodCount);
		double pagenum = (double) goodCount / 4;
		// System.out.println("pagenum"+pagenum);
		// ����math�������ȡ���������з�ҳ
		pageCount = (int) Math.ceil(pagenum);
		// ��ѯ����һҳ������Ʒ
		List<ShoppingGood> queryGoods = storebiz.queryStoreGoods(currvalRole.getRole_id(),page);
		// �������ϴ洢��Ʒ��Ϣ
		List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();

		for (ShoppingGood good : queryGoods) {
			GoodInfo goodinfo = new GoodInfo();
			// ������Ʒid��ѯ��Ʒ�۸��װ��GoodPrice������
			// System.out.println(good.getGood_id());
			int queryPriceById = storebiz.queryPriceById(good.getGood_id());
			GoodPrice price = new GoodPrice();
			price.setPrice_num(queryPriceById);
			// ������Ʒid��ѯ��ƷͼƬ·����װ��GoodImage������
			String queryImageRouteById = storebiz.queryImageRouteById(good
					.getGood_id());
			GoodImage image = new GoodImage();
			image.setImage_route(queryImageRouteById);
			// ������Ʒid��ѯ��Ʒ������װ��goodSale������
			int querySaleById = storebiz.querySaleById(good.getGood_id());
			GoodSale sale = new GoodSale();
			sale.setSale_num(querySaleById);
			// ������Ʒid��ѯ��Ʒ������װ��GoodMargin������
			int queryMarginById = storebiz.queryMarginById(good.getGood_id());
			GoodMargin margin = new GoodMargin();
			margin.setMargin_num(queryMarginById);
			// ������Ʒid��ѯ��Ʒ����
			GoodProperties queryPropertiesById = storebiz
					.queryPropertiesById(good.getGood_id());
			// ������Ʒid��ѯ��Ʒ����
			List<GoodAssess> queryAssessById = storebiz.queryAssessById(good
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
		// ����������ݴ���session��
		request.getSession().setAttribute("goodinfos", goodInfos);
		request.getSession().setAttribute("pageCount", pageCount);
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/store/storeLookGood");
			}
		}else {
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * ��������Լ���Ʒ��һҳ
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookGoodBack")
	public ModelAndView storeLookGoodBack(HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		page-=1;
		// ��ȡ��ǰ��¼�ĵ���
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
			if(page<=1){
				page=1;
		// ��ѯ��Ʒ����
		int goodCount = storebiz.queryGoodCount(currvalRole.getRole_id());
		// System.out.println("goodcount:"+goodCount);
		double pagenum = (double) goodCount / 4;
		// System.out.println("pagenum"+pagenum);
		// ����math�������ȡ���������з�ҳ
		pageCount = (int) Math.ceil(pagenum);
		// ��ѯ����һҳ������Ʒ
		List<ShoppingGood> queryGoods = storebiz.queryStoreGoods(currvalRole.getRole_id(),page);
		// �������ϴ洢��Ʒ��Ϣ
		List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();

		for (ShoppingGood good : queryGoods) {
			GoodInfo goodinfo = new GoodInfo();
			// ������Ʒid��ѯ��Ʒ�۸��װ��GoodPrice������
			// System.out.println(good.getGood_id());
			int queryPriceById = storebiz.queryPriceById(good.getGood_id());
			GoodPrice price = new GoodPrice();
			price.setPrice_num(queryPriceById);
			// ������Ʒid��ѯ��ƷͼƬ·����װ��GoodImage������
			String queryImageRouteById = storebiz.queryImageRouteById(good
					.getGood_id());
			GoodImage image = new GoodImage();
			image.setImage_route(queryImageRouteById);
			// ������Ʒid��ѯ��Ʒ������װ��goodSale������
			int querySaleById = storebiz.querySaleById(good.getGood_id());
			GoodSale sale = new GoodSale();
			sale.setSale_num(querySaleById);
			// ������Ʒid��ѯ��Ʒ������װ��GoodMargin������
			int queryMarginById = storebiz.queryMarginById(good.getGood_id());
			GoodMargin margin = new GoodMargin();
			margin.setMargin_num(queryMarginById);
			// ������Ʒid��ѯ��Ʒ����
			GoodProperties queryPropertiesById = storebiz
					.queryPropertiesById(good.getGood_id());
			// ������Ʒid��ѯ��Ʒ����
			List<GoodAssess> queryAssessById = storebiz.queryAssessById(good
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
		// ����������ݴ���session��
		request.getSession().setAttribute("goodinfos", goodInfos);
		request.getSession().setAttribute("pageCount", pageCount);
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/store/storeLookGood");
			}
		}else {
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * ��������Լ���Ʒָ��ҳ����Ʒ
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookGoodJump")
	public ModelAndView storeLookGoodJump(HttpServletRequest request,int jumpPage)
			throws Exception {
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ��¼�ĵ���
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
			if(jumpPage>=pageCount){
				page=pageCount;
			}else if(jumpPage<=1){
				jumpPage=1;
			}
		// ��ѯ��Ʒ����
		int goodCount = storebiz.queryGoodCount(currvalRole.getRole_id());
		// System.out.println("goodcount:"+goodCount);
		double pagenum = (double) goodCount / 4;
		// System.out.println("pagenum"+pagenum);
		// ����math�������ȡ���������з�ҳ
		pageCount = (int) Math.ceil(pagenum);
		// ��ѯ��ָ��ҳ������Ʒ
		List<ShoppingGood> queryGoods = storebiz.queryStoreGoods(currvalRole.getRole_id(),jumpPage);
		// �������ϴ洢��Ʒ��Ϣ
		List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();

		for (ShoppingGood good : queryGoods) {
			GoodInfo goodinfo = new GoodInfo();
			// ������Ʒid��ѯ��Ʒ�۸��װ��GoodPrice������
			// System.out.println(good.getGood_id());
			int queryPriceById = storebiz.queryPriceById(good.getGood_id());
			GoodPrice price = new GoodPrice();
			price.setPrice_num(queryPriceById);
			// ������Ʒid��ѯ��ƷͼƬ·����װ��GoodImage������
			String queryImageRouteById = storebiz.queryImageRouteById(good
					.getGood_id());
			GoodImage image = new GoodImage();
			image.setImage_route(queryImageRouteById);
			// ������Ʒid��ѯ��Ʒ������װ��goodSale������
			int querySaleById = storebiz.querySaleById(good.getGood_id());
			GoodSale sale = new GoodSale();
			sale.setSale_num(querySaleById);
			// ������Ʒid��ѯ��Ʒ������װ��GoodMargin������
			int queryMarginById = storebiz.queryMarginById(good.getGood_id());
			GoodMargin margin = new GoodMargin();
			margin.setMargin_num(queryMarginById);
			// ������Ʒid��ѯ��Ʒ����
			GoodProperties queryPropertiesById = storebiz
					.queryPropertiesById(good.getGood_id());
			// ������Ʒid��ѯ��Ʒ����
			List<GoodAssess> queryAssessById = storebiz.queryAssessById(good
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
		// ����������ݴ���session��
		request.getSession().setAttribute("goodinfos", goodInfos);
		request.getSession().setAttribute("pageCount", pageCount);
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/store/storeLookGood");
			
		}else {
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * ���̸�����Ʒidɾ����Ʒ
	 * @param good_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteGoodInfo")
	public ModelAndView deleteGoodInfo(int good_id)throws Exception{
		ModelAndView model=new ModelAndView();
		//ɾ����Ʒ�����Ϣ
		storebiz.deleteGoodById(good_id);
		storebiz.deletePriceById(good_id);
		storebiz.deleteImageRoute(good_id);
		storebiz.deleteAssessById(good_id);
		storebiz.deleteMarginById(good_id);
		storebiz.deletePropertiesById(good_id);
		storebiz.deleteSaleById(good_id);
		JOptionPane.showMessageDialog(null, "��Ʒ���¼�");
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/store/storeLookGood");
		return model;
	}
	/**
	 * ���̸����Լ���Ʒ��Ϣ
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
		//��תҳ��
		JOptionPane.showMessageDialog(null, "��Ʒ��Ϣ�Ѹ���");
		model.setViewName("/page/store/storeLookGood");
		return model;
	}
	/**
	 * ���̲鿴��ȫ������
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookOrder")
	public ModelAndView StoreLookOrder(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		// ��ȡ��ǰ��¼�ĵ���
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		//��ѯ�Լҵ����û��Ѹ������δ�����Ķ���
		List<ShoppingOrder> queryOrderByStoreId = storebiz.queryOrderByStoreId(currvalRole.getRole_id());
		//��������
		model.addObject("storeLookOrders", queryOrderByStoreId);
		//��תҳ��
		model.setViewName("/page/store/lookOrder");
		}else {
			JOptionPane.showMessageDialog(null,"���ȵ�¼!");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * ���̲鿴����������
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookWaitDeliver")
	public ModelAndView storeLookWaitDeliver(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		// ��ȡ��ǰ��¼�ĵ���
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		//��ѯ�Լҵ����û��Ѹ������δ�����Ķ���
		List<ShoppingOrder> queryOrderByStoreId = storebiz.queryWaitDeliverGoodByStoreId(currvalRole.getRole_id());
		//��������
		model.addObject("storeLookWaitDeliver", queryOrderByStoreId);
		//��תҳ��
		model.setViewName("/page/store/storeLookWaitDeliver");
		}else {
			JOptionPane.showMessageDialog(null,"���ȵ�¼!");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * ���̲鿴���ջ�����
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookWaitReceipt")
	public ModelAndView storeLookWaitReceipt(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		// ��ȡ��ǰ��¼�ĵ���
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		//��ѯ�Լҵ����û��Ѹ������δ�����Ķ���
		List<ShoppingOrder> queryReceiptOrderByStoreId = storebiz.queryWaitReceiptGoodByStoreId(currvalRole.getRole_id());
		//��������
		model.addObject("storeLookWaitReceipt", queryReceiptOrderByStoreId);
		//��תҳ��
		model.setViewName("/page/store/storeLookWaitReceipt");
		}else {
			JOptionPane.showMessageDialog(null,"���ȵ�¼!");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * ���̲鿴�����۶���
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookWaitAssess")
	public ModelAndView storeLookWaitAssess(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		// ��ȡ��ǰ��¼�ĵ���
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		//��ѯ�Լҵ��̴����۵Ķ���
		List<ShoppingOrder> queryAssessOrderByStoreId = storebiz.queryWaitAssessGoodByStoreId(currvalRole.getRole_id());
		//��������
		model.addObject("storeLookWaitAssess", queryAssessOrderByStoreId);
		//��תҳ��
		model.setViewName("/page/store/storeLookWaitAssess");
		}else {
			JOptionPane.showMessageDialog(null,"���ȵ�¼!");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * ���̲鿴���˿��
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookWaitBackMoney")
	public ModelAndView storeLookWaitBackMoney(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		// ��ȡ��ǰ��¼�ĵ���
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		//��ѯ�Լҵ��̴����۵Ķ���
		List<ShoppingOrder> queryWaitBackMoney = storebiz.queryWaitBackMoneyByStoreId(currvalRole.getRole_id());
		//��������
		model.addObject("storeLookWaitBackMoney", queryWaitBackMoney);
		//��תҳ��
		model.setViewName("/page/store/storeLookWaitBackMoney");
		}else {
			JOptionPane.showMessageDialog(null,"���ȵ�¼!");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * ���̲鿴���˿��
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookBackMoney")
	public ModelAndView storeLookBackMoney(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		// ��ȡ��ǰ��¼�ĵ���
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		//��ѯ�Լҵ��̴����۵Ķ���
		List<ShoppingOrder> queryBackMoney = storebiz.queryBackMoneyByStoreId(currvalRole.getRole_id());
		//��������
		model.addObject("storeLookBackMoney", queryBackMoney);
		//��תҳ��
		model.setViewName("/page/store/storeLookBackMoney");
		}else {
			JOptionPane.showMessageDialog(null,"���ȵ�¼!");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * ���̲鿴����ɶ���
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeLookOverOrder")
	public ModelAndView storeLookOverOrder(HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		// ��ȡ��ǰ��¼�ĵ���
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		//��ѯ�Լҵ��̴����۵Ķ���
		List<ShoppingOrder> queryOverOrder = storebiz.queryOverOrderByStoreId(currvalRole.getRole_id());
		//��������
		model.addObject("storeLookOverOrder", queryOverOrder);
		//��תҳ��
		model.setViewName("/page/store/storeLookOverOrder");
		}else {
			JOptionPane.showMessageDialog(null,"���ȵ�¼!");
			model.setViewName("/page/roleLogin");
		}
		return model;
	}
	/**
	 * ���̷��������Ķ���״̬
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
		//��תҳ��
		JOptionPane.showMessageDialog(null,"��Ʒ�ѷ���");
		model.setViewName("/page/store/storePage");
		return model;
	}

	/**
	 * �����˿���Ķ���״̬
	 * @param order_id
	 * @param order_state
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeBackOrder")
	public ModelAndView storeBackOrder(int order_id)throws Exception{
		ModelAndView model=new ModelAndView();
		//����֧���ӿڣ����û���Ǯ�˻����û�
		
		ShoppingOrder queryOrderById = storebiz.queryOrderById(order_id);
		ShoppingOrderline queryOrderlineById = storebiz.queryOrderlineById(order_id);
		queryOrderById.setOrder_state("5");
		queryOrderlineById.setOrder_state("5");
		//������״̬����Ϊ���˿�
		storebiz.updateOrderById(queryOrderById);
		storebiz.updateOrderlineById(queryOrderlineById);
		//��תҳ��
		JOptionPane.showMessageDialog(null,"���˿�");
		model.setViewName("/page/store/storePage");
		return model;
	}
	/**
	 * ���̸����Լ�״̬��Ӫҵ�����
	 * @param store_state
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateStoreState")
	public ModelAndView updateStoreState(String store_state,HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		// ��ȡ��ǰ��¼�ĵ���
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		storebiz.updateStoreStateById(currvalRole.getRole_id(), store_state);
		//��תҳ��
		JOptionPane.showMessageDialog(null,"�ɹ�������Ӫҵ��");
		model.setViewName("/page/store/storePage");
		return model;
	}
	/**
	 * ����ɾ����ַ��Ϣ
	 * @param address_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteStoreAddress")
	public ModelAndView deleteStoreAddress(int address_id)throws Exception{
		ModelAndView model=new ModelAndView();
		storebiz.deleteAddressById(address_id);
		// ҳ�涨λ��lookGood.jspҳ��
		JOptionPane.showMessageDialog(null,"��ַ��ɾ��");
		model.setViewName("/page/store/deleteSuccess");
		return model;
	}
	/**
	 * ���̸�����Ʒ��ģ����ѯ
	 * @param good_name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryGoodByName")
	public ModelAndView queryGoodByName(String good_name,HttpServletRequest request)throws Exception{
		//System.out.println(good_name);
		ModelAndView model=new ModelAndView();
		// ��ȡ��ǰ��¼�ĵ���
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		//���ݵ���id����Ʒ����ѯ��Ʒ
		List<ShoppingGood> queryGoodByName = storebiz.queryGoodByName(good_name, currvalRole.getRole_id());
		//��ӵ�ǰ������Ϣ��session��
		request.getSession().setAttribute("queryGoods", queryGoodByName);
		//��תҳ��
		model.setViewName("/page/store/queryGood");
		return model;
	}
	/**
	 * ������Ʒid��ѯ��Ʒ����
	 * @param good_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("lookGoodline")
	public ModelAndView queryGoodlineById(int good_id)throws Exception{
		ModelAndView model=new ModelAndView();
		GoodInfo goodinfo = new GoodInfo();
		//������Ʒid��ѯ��Ʒ
		ShoppingGood good = storebiz.queryGoodById(good_id);
		// ������Ʒid��ѯ��Ʒ�۸��װ��GoodPrice������
		int queryPriceById = storebiz.queryPriceById(good_id);
		GoodPrice price = new GoodPrice();
		price.setPrice_num(queryPriceById);
		// ������Ʒid��ѯ��ƷͼƬ·����װ��GoodImage������
		String queryImageRouteById = storebiz.queryImageRouteById(good_id);
		GoodImage image = new GoodImage();
		image.setImage_route(queryImageRouteById);
		// ������Ʒid��ѯ��Ʒ������װ��goodSale������
		int querySaleById = storebiz.querySaleById(good_id);
		GoodSale sale = new GoodSale();
		sale.setSale_num(querySaleById);
		// ������Ʒid��ѯ��Ʒ������װ��GoodMargin������
		int queryMarginById = storebiz.queryMarginById(good_id);
		GoodMargin margin = new GoodMargin();
		margin.setMargin_num(queryMarginById);
		// ������Ʒid��ѯ��Ʒ����
		GoodProperties queryPropertiesById = storebiz
				.queryPropertiesById(good_id);
		// ������Ʒid��ѯ��Ʒ����
		List<GoodAssess> queryAssessById = storebiz.queryAssessById(good_id);
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
		//��תҳ��
		model.addObject("goodinfo", goodinfo);
		model.setViewName("/page/store/storeLookGoodLine");
		return model;
		
	}
	/**
	 * �鿴�¶ȱ�������
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
		//����һ�����ϴ����������������
		List<ShoppingOrder> orderList=new ArrayList<ShoppingOrder>();
		// ��ȡ��ǰ��¼�ĵ���
		ShoppingRole currvalRole =(ShoppingRole) request.getSession().getAttribute("currvalRole");
		if(currvalRole!=null){
		//��ѯ�Լҵ����û��Ѹ������δ�����Ķ���
		List<ShoppingOrder> queryOrderByStoreId = storebiz.queryStoreReport(currvalRole.getRole_id());
		//����ʱ���ʽ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��HH:mm:ss");
		//����ʼ�ͽ�����ʽ��Ϊʱ��
		Date start = sdf.parse(start_date);
		Date end = sdf.parse(end_date);
		//����װ�ж������ݵļ��ϣ�������ʱ�������������������������֮��
		for(ShoppingOrder order:queryOrderByStoreId){
			Date orderTime = sdf.parse(order.getOrder_time());
			if(orderTime.after(start)&&orderTime.before(end)){
				totalMoney+=order.getOrder_money();
				orderList.add(order);
			}
		}
		//��תҳ��
		model.addObject("reportData",orderList);
		model.addObject("totalMoney", totalMoney);
		model.setViewName("/page/store/lookReportData");
		}else {
			JOptionPane.showMessageDialog(null,"���ȵ�¼!");
			model.setViewName("/page/roleLogin");
		}
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
		storebiz.deleteOrderAndLineById(order_id);
		JOptionPane.showMessageDialog(null, "������ɾ��");
		model.setViewName("/page/store/storePage");
		return model;
	}
	/**
	 * ���̸��ݶ���id�鿴��������
	 * @param order_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/lookOrderLine")
	public ModelAndView lookOrderLine(int order_id,HttpServletRequest request)throws Exception{
		//System.out.println("�鿴��������");
		ModelAndView model=new ModelAndView();
		//�鿴��������
		ShoppingOrderline queryOrderlineById = storebiz.queryOrderlineById(order_id);
		//�������
		request.getSession().setAttribute("lookOrderLine", queryOrderlineById);
		model.setViewName("/page/store/lookOrderLine");
		return model;
	}
	/**
	 * ������ӵ�ַ
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addStoreAddress")
	public ModelAndView addStoreAddress(RoleAddress address,
			HttpServletRequest request) throws Exception {
		// ����ModelAndView����
		ModelAndView model = new ModelAndView();
		// ��ȡ��ǰ�û���session
		HttpSession session = request.getSession();
		// ��ȡ��ǰ��¼�Ķ���
		ShoppingRole loginRole = (ShoppingRole) session
				.getAttribute("currvalRole");
		if(loginRole==null){
			// ҳ����ת
			JOptionPane.showMessageDialog(null, "���ȵ�¼");
			model.setViewName("/page/roleLogin");
		}else {
		// ����ǰ�û�id����roleAddress������
		address.setUser_id(loginRole.getRole_id());
		// ��roleAddress������
		storebiz.insertStoreAddress(address);
		// ��תҳ��
		JOptionPane.showMessageDialog(null, "��ַ�����");
		model.setViewName("/page/store/storePage");
		}
		return model;
	}
}
