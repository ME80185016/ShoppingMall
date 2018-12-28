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
	 * ����Ա�ǳ�
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
			model.setViewName("/page/admin/adminPage");
		}
		return model;
	}
	/**
	 * �����û�����¼����ѯ���ݿ���û����Ƿ���ڣ�Ȼ���ѯ��Ӧ�������Ƿ���ȷ
	 * 
	 * @param role_name
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminLoginByName")
	public String adminLoginByName(String role_name, HttpServletRequest request)
			throws Exception {
		// �����û�����ѯ�û�
		ShoppingRole userLogin = adminBiz.queryAdminByName(role_name);
		// ��ȡҳ�����û����������
		String pwd = request.getParameter("role_pwd");
		if (userLogin != null) {
			if (userLogin.getRole_pwd().equals(pwd)) {
				request.getSession().setAttribute("currvalRole", userLogin);
				return "/page/admin/adminPage";
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
	@RequestMapping(value = "/adminLoginByTel")
	public String adminLoginByTel(String role_tel, HttpServletRequest request)
			throws Exception {
		// �����ֻ��Ų�ѯ�û�
		ShoppingRole userLogin = adminBiz.queryAdminByTel(role_tel);
		// ��ȡҳ�����û����������
		String pwd = request.getParameter("role_pwd");
		if (userLogin != null) {
			if (userLogin.getRole_pwd().equals(pwd)) {
				request.getSession().setAttribute("currvalRole", userLogin);
				return "/page/admin/adminPage";
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
	 * ���ݽ�ɫidɾ����ɫ
	 * @param role_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteRoleById")
	public ModelAndView deleteRoleById(int role_id)throws Exception{
		ModelAndView model=new ModelAndView();
		//ɾ����ɫ
		adminBiz.deleteRoleById(role_id);
		//��תҳ��
		JOptionPane.showMessageDialog(null, "��ɾ��");
		model.setViewName("/page/admin/adminPage");
		return model;
		
	}
	/**
	 * ���ݽ�ɫid��ѯ��ɫ
	 * @param role_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryRoleById")
	public ModelAndView queryRoleById(int role_id)throws Exception{
		ModelAndView model=new ModelAndView();
		//��ѯ��ɫ
		ShoppingRole queryRoleById = adminBiz.queryRoleById(role_id);
		//����ɫ��Ϣ����model
		model.addObject("role", queryRoleById);
		//��תҳ��
		model.setViewName("/page/admin/lookRole");
		return model;
	}
	/**
	 * ���ݽ�ɫ����ѯ��ɫ
	 * @param role_name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryRoleByName")
	public ModelAndView queryRoleByName(String role_name)throws Exception{
		ModelAndView model=new ModelAndView();
		//��ѯ��ɫ
		ShoppingRole queryRoleByName = adminBiz.queryRoleByName(role_name);
		//����ɫ��Ϣ����model
		model.addObject("role", queryRoleByName);
		//��תҳ��
		model.setViewName("/page/admin/lookRole");
		return model;
	}
	/**
	 * ������Ʒid��ѯ��Ʒ
	 * @param good_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryGoodById")
	public ModelAndView queryGoodById(int good_id)throws Exception{
		ModelAndView model=new ModelAndView();
		//��ѯ��ɫ
		ShoppingGood queryGoodById = adminBiz.queryGoodById(good_id);
		//����ɫ��Ϣ����model
		model.addObject("queryGoodById", queryGoodById);
		//��תҳ��
		model.setViewName("/page/admin/lookGood");
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
		//��ѯ��Ʒ
		List<ShoppingGood> queryGoodByName = adminBiz.queryGoodByName(good_name);
		//����Ʒ��Ϣ����model
		model.addObject("queryGoods", queryGoodByName);
		//��תҳ��
		model.setViewName("/page/admin/queryGood");
		return model;
	}
	/**
	 * �鿴��Ʒ����
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
		ShoppingGood queryGoodById = adminBiz.queryGoodById(good_id);
		// ������Ʒid��ѯ��Ʒ�۸��װ��GoodPrice������
		int queryPriceById = adminBiz.queryPriceById(good_id);
		GoodPrice price = new GoodPrice();
		price.setPrice_num(queryPriceById);
		// ������Ʒid��ѯ��ƷͼƬ·����װ��GoodImage������
		String queryImageRouteById = adminBiz.queryImageRouteById(good_id);
		GoodImage image = new GoodImage();
		image.setImage_route(queryImageRouteById);
		// ������Ʒid��ѯ��Ʒ������װ��goodSale������
		int querySaleById = adminBiz.querySaleById(good_id);
		GoodSale sale = new GoodSale();
		sale.setSale_num(querySaleById);
		// ������Ʒid��ѯ��Ʒ������װ��GoodMargin������
		int queryMarginById = adminBiz.queryMarginById(good_id);
		GoodMargin margin = new GoodMargin();
		margin.setMargin_num(queryMarginById);
		// ������Ʒid��ѯ��Ʒ����
		GoodProperties queryPropertiesById = adminBiz
				.queryPropertiesById(good_id);
		// ������Ʒid��ѯ��Ʒ����
		List<GoodAssess> queryAssessById = adminBiz.queryAssessById(good_id);
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
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/admin/lookGoodLine");

		return model;
	}
	/**
	 * ����Ա������Ʒidɾ����Ʒ
	 * @param good_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteGoodInfo")
	public ModelAndView deleteGoodInfo(int good_id)throws Exception{
		ModelAndView model=new ModelAndView();
		//ɾ����Ʒ�����Ϣ
		adminBiz.deleteGoodById(good_id);
		adminBiz.deletePriceById(good_id);
		adminBiz.deleteImageRoute(good_id);
		adminBiz.deleteAssessById(good_id);
		adminBiz.deleteMarginById(good_id);
		adminBiz.deletePropertiesById(good_id);
		adminBiz.deleteSaleById(good_id);
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/admin/adminPage");
		return model;
	}
	/**
	 * ����Ա���ĵ���״̬
	 * @param store_id
	 * @param store_state
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateStoreState")
	public ModelAndView updateStoreState(int store_id,String store_state)throws Exception{
		ModelAndView model=new ModelAndView();
		//����Ա���ĵ���״̬
		adminBiz.updateStoreStateById(store_id, store_state);
		switch (store_state) {
		case "0":
			JOptionPane.showMessageDialog(null, "�ɹ�������״̬Ϊ�ѹ�ͣ");
			break;
		case "1":
			JOptionPane.showMessageDialog(null, "�ɹ�������״̬ΪӪҵ��");
			break;
		case "2":
			JOptionPane.showMessageDialog(null, "�ɹ�������״̬Ϊ�Ѵ���");
			break;
		default:
			break;
		}
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/admin/adminPage");
		return model;
	}
	/**
	 * ����Ա�ܾ�����
	 * @param role_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/refuseOpenStore")
	public ModelAndView refuseOpenStore(int role_id)throws Exception{
		ModelAndView model=new ModelAndView();
		//ɾ������-��ɫ��
		adminBiz.deleteRoleById(role_id);
		//ɾ������-��Ϣ��
		adminBiz.deleteStoreInfoById(role_id);
		//��תҳ��
		JOptionPane.showMessageDialog(null, "�Ѿܾ�����");
		model.setViewName("/page/admin/adminPage");
		return model;
		
	}
	/**
	 * ����Ա�����Ʒ
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/adminLookGood")
	public ModelAndView adminLookGood(HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		// ��ѯ����һҳ������Ʒ
		List<ShoppingGood> queryGoods = adminBiz.queryGoods();
		// �������ϴ洢��Ʒ��Ϣ
		List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();
		for (ShoppingGood good : queryGoods) {
			GoodInfo goodinfo = new GoodInfo();
			// ������Ʒid��ѯ��Ʒ�۸��װ��GoodPrice������
			// System.out.println(good.getGood_id());
			int queryPriceById = adminBiz.queryPriceById(good.getGood_id());
			GoodPrice price = new GoodPrice();
			price.setPrice_num(queryPriceById);
			// ������Ʒid��ѯ��ƷͼƬ·����װ��GoodImage������
			String queryImageRouteById = adminBiz.queryImageRouteById(good
					.getGood_id());
			GoodImage image = new GoodImage();
			image.setImage_route(queryImageRouteById);
			// ������Ʒid��ѯ��Ʒ������װ��goodSale������
			int querySaleById = adminBiz.querySaleById(good.getGood_id());
			GoodSale sale = new GoodSale();
			sale.setSale_num(querySaleById);
			// ������Ʒid��ѯ��Ʒ������װ��GoodMargin������
			int queryMarginById = adminBiz.queryMarginById(good.getGood_id());
			GoodMargin margin = new GoodMargin();
			margin.setMargin_num(queryMarginById);
			// ������Ʒid��ѯ��Ʒ����
			GoodProperties queryPropertiesById = adminBiz
					.queryPropertiesById(good.getGood_id());
			// ������Ʒid��ѯ��Ʒ����
			List<GoodAssess> queryAssessById = adminBiz.queryAssessById(good
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
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/admin/lookGood");
		return model;
	}
	/**
	 * ����Ա�������
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/adminLookStore")
	public ModelAndView adminLookStore(HttpServletRequest request)
			throws Exception {
		ModelAndView model = new ModelAndView();
		// ��ѯ�����е���
		List<ShoppingRole> queryStores = adminBiz.queryStores();
		// �������ϴ洢������Ϣ
		List<StoreInfo> storeInfos = new ArrayList<StoreInfo>();
		for (ShoppingRole store : queryStores) {
			// ���ݵ���id��ѯ������Ϣ
			StoreInfo storeInfo = adminBiz.queryStoreInfoById(store.getRole_id());
			// ��goodinfo�������缯����
			storeInfos.add(storeInfo);
		}
		
		// ����������ݴ���session��
		request.getSession().setAttribute("storeinfos", storeInfos);
		// ҳ�涨λ��lookGood.jspҳ��
		model.setViewName("/page/admin/lookStore");
		return model;
	}
	/**
	 * ���ݵ���id��ѯ������ϸ��Ϣ���Ҳ鿴����Ʒ
	 * @param store_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/adminLookStoreLine")
	public ModelAndView adminLookStoreLine(Integer store_id,HttpServletRequest request)throws Exception{
		ModelAndView model=new ModelAndView();
		//���ݵ���id��ѯshoppingRole������Ϣ
		ShoppingRole queryStoreById = adminBiz.queryRoleById(store_id);
		// ���ݵ���id��ѯ������Ϣ
		StoreInfo storeInfo = adminBiz.queryStoreInfoById(store_id);
		//���ݵ���id��ѯ��ַ
		List<RoleAddress> queryAddressByStoreId = adminBiz.queryAddressByStoreId(store_id);
		//���ݵ���id��ѯ����Ʒ
		List<ShoppingGood> queryGoods = adminBiz.queryStoreGoods(store_id);
		// �������ϴ洢��Ʒ��Ϣ
		List<GoodInfo> goodInfos = new ArrayList<GoodInfo>();
		for (ShoppingGood good : queryGoods) {
			GoodInfo goodinfo = new GoodInfo();
			// ������Ʒid��ѯ��Ʒ�۸��װ��GoodPrice������
			int queryPriceById = adminBiz.queryPriceById(good.getGood_id());
			GoodPrice price = new GoodPrice();
			price.setPrice_num(queryPriceById);
			// ������Ʒid��ѯ��ƷͼƬ·����װ��GoodImage������
			String queryImageRouteById = adminBiz.queryImageRouteById(good
					.getGood_id());
			GoodImage image = new GoodImage();
			image.setImage_route(queryImageRouteById);
			// ������Ʒid��ѯ��Ʒ������װ��goodSale������
			int querySaleById = adminBiz.querySaleById(good.getGood_id());
			GoodSale sale = new GoodSale();
			sale.setSale_num(querySaleById);
			// ������Ʒid��ѯ��Ʒ������װ��GoodMargin������
			int queryMarginById = adminBiz.queryMarginById(good.getGood_id());
			GoodMargin margin = new GoodMargin();
			margin.setMargin_num(queryMarginById);
			// ������Ʒid��ѯ��Ʒ����
			GoodProperties queryPropertiesById = adminBiz
					.queryPropertiesById(good.getGood_id());
			// ������Ʒid��ѯ��Ʒ����
			List<GoodAssess> queryAssessById = adminBiz.queryAssessById(good
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
		model.setViewName("/page/admin/lookStoreLine");
		return model;
	}
	/**
	 * ����Ա�鿴���뿪��ĵ�����Ϣ
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
