package com.hds.biz;
import java.util.List;

import com.hds.entity.CollectGood;
import com.hds.entity.CollectStore;
import com.hds.entity.GoodAssess;
import com.hds.entity.GoodProperties;
import com.hds.entity.RoleAddress;
import com.hds.entity.ShoppingGood;
import com.hds.entity.ShoppingOrder;
import com.hds.entity.ShoppingOrderline;
/**
 * ҵ���߼���ӿڣ�������ͨ�û��߼�ʵ��
 */
import com.hds.entity.ShoppingRole;
import com.hds.entity.StoreInfo;

public interface UserBiz {
	//��ͨ�û�ע�ᣬ��ɫ����Ϊ2
	public void userRegist(ShoppingRole role) throws Exception;
	//��ͨ�û�ʹ���û�����¼
	public ShoppingRole userLoginByName(String role_name)throws Exception;
	//��ͨ�û�ʹ���ֻ��ŵ�¼
	public ShoppingRole userLoginByTel(String role_tel)throws Exception;
	//�û������Ʒ������������Ʒ
	public List<ShoppingGood> queryGoods(int page)throws Exception;
	//������Ʒid������Ʒ
	public ShoppingGood queryGoodById(int good_id)throws Exception;
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
	//������Ʒ�������ڷ�ҳ
	public int queryGoodCount()throws Exception;
	//�û�������Ʒ���򶩵���shopping_order���������
	public void insertOrder(ShoppingOrder order) throws Exception;
	//ȡ�õ�ǰ��ӵĶ���id
	public int selectOrderIdCurrval()throws Exception;
	//�û�������Ʒ���򶩵���������������
	public void insertOrderline(ShoppingOrderline orderline) throws Exception;
	//������Ʒ���������û����빺�ﳵ�������Ʒ����-1�������̽�������Ʒ����������Ӧ����
	public void updateGoodMargin(int good_id,int margin_num);
	//������Ʒ���������û����빺�ﳵ�������Ʒ����+1
	public void updateGoodSale(int good_id,int sale_num);
	//�û�����ղ���Ʒ
	public void insertCollectGood(CollectGood collectgood)throws Exception;
	//�����û�id��ѯ�䶩��
	public List<ShoppingOrder> queryOrderByUserId(int user_id)throws Exception;
	//�����û�id��ѯ�乺�ﳵ
	public List<ShoppingOrder> queryShoppingCarByUserId(int user_id)throws Exception;
	//�����û�id��ѯ�����������
	public List<ShoppingOrder> queryWaitDeliverGoodByUserId(int user_id)throws Exception;
	//�����û�id��ѯ����ջ�����
	public List<ShoppingOrder> queryWaitReceiptGoodByUserId(int user_id)throws Exception;
	//�����û�id��ѯ������۶���
	public List<ShoppingOrder> queryWaitAssessGoodByUserId(int user_id)throws Exception;
	//�����û�id��ѯ����˿��
	public List<ShoppingOrder> queryWaitBackMoneyByUserId(int user_id)throws Exception;
	//�����û�id��ѯ�����˿��
	public List<ShoppingOrder> queryBackMoneyByUserId(int user_id)throws Exception;
	//�����û�id��ѯ������ɶ���
	public List<ShoppingOrder> queryOverOrderByUserId(int user_id)throws Exception;
	//�����û�id��ѯ���ղ���Ʒ
	public List<CollectGood> queryCollectGoodByUserId(int user_id)throws Exception;
	//�û��������ӵ�ַ
	public void insertUserAddress(RoleAddress address)throws Exception;
	//���ݵ�ַid��ѯ��ַ
	public RoleAddress queryAddressById(int address_id)throws Exception;
	//�����û�id��ѯ��ַ
	public List<RoleAddress> queryAddressByUserId(int user_id)throws Exception;
	//�û���ɾ���Լ����˺���Ϣ
	public void deleteUserById(int user_id)throws Exception;
	//�û������Լ��˺���Ϣ
	public void updateUserById(ShoppingRole role)throws Exception;
	//�û������Լ���ַ��Ϣ
	public void updateAddressById(RoleAddress address)throws Exception;
	//�û�ɾ���Լ���ĳ���ղ���Ʒ
	public void deleteCollectGoodById(int collect_id)throws Exception;
	//�û�����ղص���
	public void insertCollectStore(CollectStore collectStore)throws Exception;
	//�����û�id��ѯ���ղص���
	public List<CollectStore> queryCollectStoreByUserId(int user_id)throws Exception;	
	//���ݽ�ɫid��ѯ��ɫ����
	public ShoppingRole queryRoleById(int role_id)throws Exception;
	//�û�ɾ���Լ���ĳ���ղص���
	public void deleteCollectStoreById(int collect_id)throws Exception;
	//�û�ɾ���Լ���ĳ����ַ
	public void deleteAddressById(int address_id)throws Exception;
	//�û�ɾ���Լ��Ķ�������Ͷ���
	public void deleteOrderAndLineById(int order_id)throws Exception;
	//�û�������Ʒ
	public void insertGoodAssess(GoodAssess assess)throws Exception;
	//�����û�id��ѯ�����۵���Ʒ
	public List<GoodAssess> queryGoodAssessByUserId(int user_id)throws Exception;
	//������Ʒid��ѯ������
	public List<GoodAssess> queryGoodAssessByGoodId(int good_id)throws Exception;
	//�û�ɾ���Լ���ĳ������
	public void deleteGoodAssessById(int assess_id)throws Exception;
	//���ݶ���id��ѯ����
	public ShoppingOrder queryOrderById(int order_id)throws Exception;
	//���ݶ���id��ѯ��������
	public ShoppingOrderline queryOrderlineById(int order_id) throws Exception;
	//���ݶ���id���¶�����Ϣ
	public void updateOrderById(ShoppingOrder order)throws Exception;
	//���ݶ���id���¶���������Ϣ
	public void updateOrderlineById(ShoppingOrderline orderline)throws Exception;
	//������Ʒ����ѯ��Ʒ
	public List<ShoppingGood> queryGoodByName(String good_name)throws Exception;
	//�û�������̣���ѯȫ������
	public List<ShoppingRole> queryStores(int page)throws Exception;
	//���ݵ���id��ѯ������Ϣ
	public StoreInfo queryStoreInfoById(int store_id)throws Exception;
	//���ҵ����������ڷ�ҳ
	public int queryStoreCount()throws Exception;
	//���ݵ���id��ѯ��ַ
	public List<RoleAddress> queryAddressByStoreId(int store_id)throws Exception;
	//���ĳһ�ҵ��̵���Ʒ
	public List<ShoppingGood> queryStoreGoods(int store_id)throws Exception;
	//��ѯ��ǰ�û����µ�һ�Ŷ��������û���ǰҪ����������
	public ShoppingOrder queryCurrvalOrder(int user_id)throws Exception;
	//���ݶ���id������״̬��Ϊ�����ۣ���ȷ���ջ�
	public void updateOrderStateReceiptGood(int order_id)throws Exception;
	//���ݶ���id����������״̬��Ϊ�����ۣ���ȷ���ջ�
	public void updateOrderlineStateReceiptGood(int order_id)throws Exception;
	
	
}
