package com.hds.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hds.entity.CollectGood;
import com.hds.entity.CollectStore;
import com.hds.entity.GoodAssess;
import com.hds.entity.GoodProperties;
import com.hds.entity.RoleAddress;
import com.hds.entity.ShoppingGood;
import com.hds.entity.ShoppingOrder;
import com.hds.entity.ShoppingOrderline;
import com.hds.entity.ShoppingRole;
import com.hds.entity.StoreInfo;
/**
 * �˽ӿ�������ͨ�û����еĲ���������ע�ᡢ��¼��������빺�ﳵ���˿�ȵ�
 * @author ��
 *
 */
public interface UserMapper {
	//��ͨ�û�ע�ᣬ��ɫ����Ϊ2
	public void insertUser(ShoppingRole role) throws Exception;
	//�����û�����shopping_role���в�ѯ�û�
	public ShoppingRole queryUserByName(String role_name)throws Exception;
	//�����ֻ�����shopping_role���в�ѯ�û�
	public ShoppingRole queryUserByTel(String role_tel)throws Exception;
	//�û������Ʒ������ȫ����Ʒ
	public List<ShoppingGood> queryGoods(int page)throws Exception;
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
	//����ȫ����ɫ��
	public List<String> queryRoleNames()throws Exception;
	//������Ʒ�������ڷ�ҳ
	public int queryGoodCount()throws Exception;
	//�û�������Ʒ���򶩵���shopping_order���������
	public void insertOrder(ShoppingOrder order) throws Exception;
	//ȡ�õ�ǰ��ӵĶ���id
	public int selectOrderIdCurrval()throws Exception;
	//�û�������Ʒ���򶩵������Shopping_orderline�����������
	public void insertOrderline(ShoppingOrderline orderline)throws Exception;
	//������Ʒ���������û����빺�ﳵ�������Ʒ����-�û����������������̽�������Ʒ����������Ӧ����
	public void updateGoodMargin(@Param("good_id")int good_id,@Param("margin_num")int margin_num);
	//������Ʒ���������û����빺�ﳵ�������Ʒ����+�û���������
	public void updateGoodSale(@Param("good_id")int good_id,@Param("sale_num")int sale_num);
	//�û�����ղ���Ʒ
	public void insertCollectGood(CollectGood collectgood)throws Exception;
	//�����û�id��ѯ�乺�ﳵ
	public List<ShoppingOrder> queryShoppingCarByUserId(@Param("user_id") int user_id)throws Exception;
	//�����û�id��ѯ�䶩��
	public List<ShoppingOrder> queryOrderByUserId(@Param("user_id")int user_id)throws Exception;
	//�����û�id��ѯ�����������
	public List<ShoppingOrder> queryWaitDeliverGoodByUserId(@Param("user_id") int user_id)throws Exception;
	//�����û�id��ѯ����ջ�����
	public List<ShoppingOrder> queryWaitReceiptGoodByUserId(@Param("user_id") int user_id)throws Exception;
	//�����û�id��ѯ������۶���
	public List<ShoppingOrder> queryWaitAssessGoodByUserId(@Param("user_id") int user_id)throws Exception;
	//�����û�id��ѯ����˿��
	public List<ShoppingOrder> queryWaitBackMoneyByUserId(@Param("user_id") int user_id)throws Exception;
	//�����û�id��ѯ�����˿��
	public List<ShoppingOrder> queryBackMoneyByUserId(@Param("user_id") int user_id)throws Exception;
	//�����û�id��ѯ������ɶ���
	public List<ShoppingOrder> queryOverOrderByUserId(@Param("user_id") int user_id)throws Exception;
	//�����û�id��ѯ���ղ���Ʒ
	public List<CollectGood> queryCollectGoodByUserId(@Param("user_id") int user_id)throws Exception;
	//�û��������ӵ�ַ
	public void insertUserAddress(RoleAddress address)throws Exception;
	//���ݵ�ַid��ѯ��ַ
	public RoleAddress queryAddressById(@Param("address_id")int address_id)throws Exception;
	//�����û�id��ѯ��ַ
	public List<RoleAddress> queryAddressByUserId(@Param("user_id")int user_id)throws Exception;
	//�û�ɾ���Լ����˺���Ϣ
	public void deleteUserById(int user_id)throws Exception;
	//�û������Լ��˺���Ϣ
	public void updateUserById(ShoppingRole role)throws Exception;
	//�û������Լ���ַ��Ϣ
	public void updateAddressById(RoleAddress address)throws Exception;
	//�û�ɾ���Լ���ĳ���ղ���Ʒ
	public void deleteCollectGoodById(@Param("collect_id")int collect_id)throws Exception;
	//�û�����ղص���
	public void insertCollectStore(CollectStore collectstore)throws Exception;
	//�����û�id��ѯ���ղص���
	public List<CollectStore> queryCollectStoreByUserId(@Param("user_id") int user_id)throws Exception;
	//���ݽ�ɫid��ѯ��ɫ����
	public ShoppingRole queryRoleById(@Param("role_id")int role_id)throws Exception;
	//�û�ɾ���Լ���ĳ���ղص���
	public void deleteCollectStoreById(@Param("collect_id")int collect_id)throws Exception;
	//�û�ɾ���Լ���ĳ����ַ
	public void deleteAddressById(@Param("address_id")int address_id)throws Exception;
	//�û�ɾ���Լ��Ķ�������
	public void deleteOrderlineById(@Param("order_id")int order_id)throws Exception;
	//�û�ɾ���Լ��Ķ��������Ӧ�Ķ���
	public void deleteOrderById(@Param("order_id")int order_id)throws Exception;
	//�û�������Ʒ
	public void insertGoodAssess(GoodAssess assess)throws Exception;
	//�����û�id��ѯ�����۵���Ʒ
	public List<GoodAssess> queryGoodAssessByUserId(@Param("user_id") int user_id)throws Exception;
	//������Ʒid��ѯ������
	public List<GoodAssess> queryGoodAssessByGoodId(@Param("good_id") int good_id)throws Exception;
	//�û�ɾ���Լ���ĳ������
	public void deleteGoodAssessById(@Param("assess_id")int assess_id)throws Exception;
	//���ݶ���id��ѯ����
	public ShoppingOrder queryOrderById(@Param("order_id")int order_id)throws Exception;
	//���ݶ���id��ѯ��������
	public ShoppingOrderline queryOrderlineById(@Param("order_id")int order_id) throws Exception;
	//���ݶ���id���¶�����Ϣ
	public void updateOrderById(ShoppingOrder order)throws Exception;
	//���ݶ���id���¶���������Ϣ
	public void updateOrderlineById(ShoppingOrderline orderline)throws Exception;
	//������Ʒ����ѯ��Ʒ
	public List<ShoppingGood> queryGoodByName(@Param("good_name")String good_name)throws Exception;
	//�û�������̣���ѯȫ������
	public List<ShoppingRole> queryStores(int page)throws Exception;
	//���ݵ���id��ѯ������Ϣ
	public StoreInfo queryStoreInfoById(int store_id)throws Exception;
	//���ҵ����������ڷ�ҳ
	public int queryStoreCount()throws Exception;
	//���ݵ���id��ѯ��ַ
	public List<RoleAddress> queryAddressByStoreId(@Param("store_id")int store_id)throws Exception;
	//���ĳһ�ҵ��̵���Ʒ
	public List<ShoppingGood> queryStoreGoods(@Param("store_id")int store_id)throws Exception;
	//��ѯ��ǰ�û����µ�һ�Ŷ��������û���ǰҪ����������
	public ShoppingOrder queryCurrvalOrder(@Param("user_id") int user_id)throws Exception;
	//���ݶ���id������״̬��Ϊ�����ۣ���ȷ���ջ�
	public void updateOrderStateReceiptGood(@Param("order_id")int order_id)throws Exception;
	//���ݶ���id����������״̬��Ϊ�����ۣ���ȷ���ջ�
	public void updateOrderlineStateReceiptGood(@Param("order_id")int order_id)throws Exception;
	
	
	
}
