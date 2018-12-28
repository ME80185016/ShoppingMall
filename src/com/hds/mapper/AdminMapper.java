package com.hds.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hds.entity.GoodAssess;
import com.hds.entity.GoodProperties;
import com.hds.entity.RoleAddress;
import com.hds.entity.ShoppingGood;
import com.hds.entity.ShoppingRole;
import com.hds.entity.StoreInfo;

public interface AdminMapper {
	//�����û�����shopping_role���в�ѯ�û�
	public ShoppingRole queryAdminByName(String role_name)throws Exception;
	
	//�����ֻ�����shopping_role���в�ѯ�û�
	public ShoppingRole queryAdminByTel(String role_tel)throws Exception;
	
	// ���ݽ�ɫid��ѯ��ɫ
	public ShoppingRole queryRoleById(@Param("role_id") int role_id)
			throws Exception;
	
	// ���ݽ�ɫ����ѯ��ɫ
	public ShoppingRole queryRoleByName(@Param("role_name") String role_name)
			throws Exception;

	// ����Ա���ݽ�ɫidɾ����ɫ���û��͹���Ա��ɾ���Լ����˺���Ϣ
	public void deleteRoleById(int role_id) throws Exception;
	
	// ����Ա�����Ʒ������ȫ����Ʒ
	public List<ShoppingGood> queryGoods() throws Exception;
	
	// ������Ʒid������Ʒ
	public ShoppingGood queryGoodById(int good_id) throws Exception;

	// ������Ʒid������Ʒ�۸�
	public int queryPriceById(int good_id) throws Exception;

	// ������Ʒid������ƷͼƬ·��
	public String queryImageRouteById(int good_id) throws Exception;

	// ������Ʒid������Ʒ����
	public int querySaleById(int good_id) throws Exception;

	// ������Ʒid������Ʒ����
	public int queryMarginById(int good_id) throws Exception;

	// ������Ʒid������Ʒ����
	public GoodProperties queryPropertiesById(int good_id) throws Exception;

	// ������Ʒid������Ʒ����
	public List<GoodAssess> queryAssessById(int good_id) throws Exception;

	// ������Ʒ��������Ʒ
	public List<ShoppingGood> queryGoodByName(String good_name) throws Exception;

	// ����Ա�¼���Ʒ������Ʒid
	public void deleteGoodById(@Param("good_id") int good_id) throws Exception;

	// ����Ա������Ʒidɾ���۸�
	public void deletePriceById(@Param("good_id") int good_id) throws Exception;

	// ����Ա������Ʒidɾ��ͼƬ
	public void deleteImageRoute(@Param("good_id") int good_id)
			throws Exception;

	// ������Ʒidɾ����Ʒ����
	public void deleteSaleById(@Param("good_id") int good_id) throws Exception;

	// ������Ʒidɾ����Ʒ����
	public void deleteMarginById(@Param("good_id") int good_id)
			throws Exception;

	// ������Ʒidɾ����Ʒ����
	public void deletePropertiesById(@Param("good_id") int good_id)
			throws Exception;

	// ������Ʒidɾ����Ʒ����
	public void deleteAssessById(@Param("good_id") int good_id)
			throws Exception;

	// ����Ա���ĵ���״̬
	public void updateStoreStateById(@Param("store_id") int store_id,
			@Param("store_state") String store_state) throws Exception;

	// ����Ա���ݵ���idɾ��������Ϣ���ܾ�����
	public void deleteStoreInfoById(int store_id) throws Exception;
	
	//�û�������̣���ѯȫ������
	public List<ShoppingRole> queryStores()throws Exception;
	
	//���ݵ���id��ѯ������Ϣ
	public StoreInfo queryStoreInfoById(int store_id)throws Exception;
	
	//���ݵ���id��ѯ��ַ
	public List<RoleAddress> queryAddressByStoreId(@Param("store_id")int store_id)throws Exception;
	
	//���ĳһ�ҵ��̵���Ʒ
	public List<ShoppingGood> queryStoreGoods(@Param("store_id")int store_id)throws Exception;

	//�鿴���뿪��ĵ�����Ϣ
	public List<StoreInfo> queryApplyStoreInfo()throws Exception;
	
	
	
	
}
