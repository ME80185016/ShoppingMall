package com.hds.biz;
/**
 * ҵ���߼���ӿڣ����ڵ��̹��ܵ��߼�ʵ��
 */
import java.util.List;

import com.hds.entity.GoodAssess;
import com.hds.entity.GoodInfo;
import com.hds.entity.GoodProperties;
import com.hds.entity.RoleAddress;
import com.hds.entity.ShoppingGood;
import com.hds.entity.ShoppingOrder;
import com.hds.entity.ShoppingOrderline;
import com.hds.entity.ShoppingRole;
import com.hds.entity.StoreInfo;

public interface StoreBiz {
	//����ע�ᣬ��ɫ����Ϊ1
	public void storeRegist(ShoppingRole role) throws Exception;
	//Ϊע��ĵ��������Ϣ
	public void addStoreInfo(StoreInfo storeInfo)throws Exception;
	//ȡ����ע��ĵ��̵�id
	public int selectStoreIdCurrval()throws Exception;
	//����ʹ�õ�������¼
	public ShoppingRole storeLoginByName(String role_name)throws Exception;
	//����ʹ��ע���ֻ��ŵ�¼
	public ShoppingRole storeLoginByTel(String role_tel)throws Exception;
	//�����ϼ���Ʒ
	public void addGood(ShoppingGood good)throws Exception;
	//ȡ�õ�ǰ��ӵ���Ʒ��id
	public int selectGoodIdCurrval()throws Exception;
	//Ϊ�ϼܵ���Ʒ�����Ϣ
	public void addGoodInfo(GoodInfo goodInfo)throws Exception;
	//���̿�ɾ���Լ����˺���Ϣ
	public void deleteStoreById(int store_id)throws Exception;
	//���ݵ���id��ѯ������ϸ��Ϣ
	public StoreInfo queryStoreInfoById(int store_id)throws Exception;
	//���ݵ���id��ѯ��ַ
	public List<RoleAddress> queryAddressByStoreId(int store_id)throws Exception;
	//���̸����Լ��˺���Ϣ
	public void updateStoreById(ShoppingRole role)throws Exception;
	//���̸����Լ���ϸ��Ϣ
	public void updateStoreInfoById(StoreInfo storeInfo)throws Exception;
	//���̸����Լ���ַ��Ϣ
	public void updateAddressById(RoleAddress address)throws Exception;
	//��������Լ���Ʒ
	public List<ShoppingGood> queryStoreGoods(int store_id,int page)throws Exception;
	//������Ʒid������Ʒ
	public ShoppingGood queryGoodById(int good_id) throws Exception;
	//������Ʒid������Ʒ�۸�
	public int queryPriceById(int good_id)throws Exception;
	//������Ʒid������ƷͼƬ·��
	public String queryImageRouteById(int good_id)throws Exception;
	//������Ʒid������Ʒ����
	public int querySaleById(int good_id)throws Exception;
	//������Ʒid������Ʒ����
	public int queryMarginById(int good_id)throws Exception;
	//������Ʒid������Ʒ����
	public GoodProperties queryPropertiesById(int good_id)throws Exception;
	//������Ʒid������Ʒ����
	public List<GoodAssess> queryAssessById(int good_id)throws Exception;
	//���ҵ�����Ʒ�������ڷ�ҳ
	public int queryGoodCount(int store_id)throws Exception;
	//�����¼���Ʒ������Ʒid
	public void deleteGoodById(int good_id)throws Exception;
	//���̸�����Ʒidɾ���۸�
	public void deletePriceById(int good_id)throws Exception;
	//���̸�����Ʒidɾ��ͼƬ
	public void deleteImageRoute(int good_id)throws Exception;
	//������Ʒidɾ����Ʒ����
	public void deleteSaleById(int good_id)throws Exception;
	//������Ʒidɾ����Ʒ����
	public void deleteMarginById(int good_id)throws Exception;
	//������Ʒidɾ����Ʒ����
	public void deletePropertiesById(int good_id)throws Exception;
	//������Ʒidɾ����Ʒ����
	public void deleteAssessById(int good_id)throws Exception;
	//���̸�����Ʒ��Ϣ
	public void updateGoodInfo(GoodInfo goodInfo)throws Exception;
	//���ݵ���id��ѯ�䶩��
	public List<ShoppingOrder> queryOrderByStoreId(int store_id)throws Exception;
	//���ݵ���id��ѯ��δ��������
	public List<ShoppingOrder> queryWaitDeliverGoodByStoreId(int store_id)throws Exception;
	//���ݵ���id��ѯ����ջ�����
	public List<ShoppingOrder> queryWaitReceiptGoodByStoreId(int store_id)throws Exception;
	//���ݵ���id��ѯ������۶���
	public List<ShoppingOrder> queryWaitAssessGoodByStoreId(int store_id)throws Exception;
	//���ݵ���id��ѯ����˿��
	public List<ShoppingOrder> queryWaitBackMoneyByStoreId(int store_id)throws Exception;
	//���ݵ���id��ѯ�����˿��
	public List<ShoppingOrder> queryBackMoneyByStoreId(int store_id)throws Exception;
	//���ݵ���id��ѯ������ɶ���
	public List<ShoppingOrder> queryOverOrderByStoreId(int store_id)throws Exception;
	//���ݶ���id���Ķ���״̬
	public void updateOrderStateById(int order_id)throws Exception;
	//���ݶ���id�˵�
	public void updateOrderStateBackOrder(int order_id)throws Exception;
	//���ݵ���id���ĵ���״̬,Ӫҵ�����
	public void updateStoreStateById(int store_id,String store_state)throws Exception;
	//���ݵ�ַidɾ����ַ
	public void deleteAddressById(int address_id)throws Exception;
	//������Ʒ��ģ����ѯ��Ʒ
	public List<ShoppingGood> queryGoodByName(String good_name,int store_id)throws Exception;
	//�û�ɾ���Լ��Ķ�������Ͷ���
	public void deleteOrderAndLineById(int order_id)throws Exception;
	//���ݶ���id��ѯ����
	public ShoppingOrder queryOrderById(int order_id)throws Exception;
	//���ݶ���id��ѯ��������
	public ShoppingOrderline queryOrderlineById(int order_id) throws Exception;
	//���ݶ���id���¶�����Ϣ
	public void updateOrderById(ShoppingOrder order)throws Exception;
	//���ݶ���id���¶���������Ϣ
	public void updateOrderlineById(ShoppingOrderline orderline)throws Exception;
	//�û��������ӵ�ַ
	public void insertStoreAddress(RoleAddress address)throws Exception;
	//�û��鿴��������
	public List<ShoppingOrder> queryStoreReport(int store_id)throws Exception;
	
	
	
	
	
	
	
	

}
