package com.hds.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hds.entity.GoodAssess;
import com.hds.entity.GoodImage;
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
/**
 * �˽ӿ����ڵ��̽��еĲ���������ע�ᡢ��¼����Ʒ�ϼܡ��¼ܡ�����Ӫҵ�ʹ��ȵȵ�
 * @author ��
 *
 */
public interface StoreMapper {
	//��������Ϣ����shopping_role���У���ɫΪ1
	public void insertStoreToShoppingRole(ShoppingRole role) throws Exception;
	//��������Ϣ����store_info��
	public void insertStoreToStoreInfo(StoreInfo store)throws Exception;
	//ȡ�õ�ǰ���̵�id
	public int selectStoreIdCurrval()throws Exception;
	//���ݵ�������ѯ���̵�¼��Ϣ
	public ShoppingRole queryStoreByName(String role_name)throws Exception;
	//���ݵ���ע���ֻ��Ų�ѯ���̵�¼��Ϣ
	public ShoppingRole queryStoreByTel(String role_tel) throws Exception;
	//���ݵ��̵�¼���е�id��store_info�в�ѯ������ϸ��Ϣ
	public StoreInfo queryStoreById(int id)throws Exception;
	//�����ϼ���Ʒ����shopping_good��(�ϼ���Ʒ������ϼܵ���Ʒ���Ƹ�����ҵ��̵������Ʒ)
	public void insertGoodToShoppingGood(ShoppingGood good)throws Exception;
	//�����ϼ���Ʒ����good_price��(�ϼ���Ʒ������ϼܵ���Ʒ�۸������ҵ��̵������Ʒ)
	public void insertGoodToGoodPrice(GoodPrice price)throws Exception;
	//�����ϼ���Ʒ����good_image��(�ϼ���Ʒ������ϼܵ���Ʒ��ͼƬ·��������ҵ��̵������Ʒ)
	public void insertGoodToGoodImage(GoodImage image)throws Exception;
	//�����ϼ���Ʒ����good_sale��(�ϼ���Ʒ��Ĭ������0����������̵������Ʒ)
	public void insertGoodToGoodSale(GoodSale sale)throws Exception;
	//�����ϼ���Ʒ����good_margin��(�ϼ���Ʒ������ϼܵ���Ʒ����������ҵ��̵������Ʒ)
	public void insertGoodToGoodMargin(GoodMargin margin)throws Exception;
	//�����ϼ���Ʒ����good_properties��(�ϼ���Ʒ������ϼܵ���Ʒ���Ը�����ҵ��̵������Ʒ)
	public void insertGoodToGoodProperties(GoodProperties properties)throws Exception;
	//ȡ�õ�ǰ��Ʒ��id
	public int selectGoodIdCurrval()throws Exception;
	//���̿�ɾ���Լ����˺���Ϣ
	public void deleteStoreById(int store_id)throws Exception;
	//���ݵ���id��ѯ������ϸ��Ϣ
	public StoreInfo queryStoreInfoById(int store_id)throws Exception;
	//���ݵ���id��ѯ��ַ
	public List<RoleAddress> queryAddressByStoreId(@Param("store_id")int store_id)throws Exception;
	//���̸����Լ��˺���Ϣ
	public void updateStoreById(ShoppingRole role)throws Exception;
	//���̸����Լ���ϸ��Ϣ
	public void updateStoreInfoById(StoreInfo storeInfo)throws Exception;
	//���̸����Լ���ַ��Ϣ
	public void updateAddressById(RoleAddress address)throws Exception;
	//��������Լ���Ʒ
	public List<ShoppingGood> queryStoreGoods(@Param("store_id")int store_id,@Param("page")int page)throws Exception;
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
	public int queryGoodCount(@Param("store_id")int store_id)throws Exception;
	//�����¼���Ʒ������Ʒid
	public void deleteGoodById(@Param("good_id") int good_id)throws Exception;
	//���̸�����Ʒidɾ���۸�
	public void deletePriceById(@Param("good_id") int good_id)throws Exception;
	//���̸�����Ʒidɾ��ͼƬ
	public void deleteImageRouteById(@Param("good_id") int good_id)throws Exception;
	//������Ʒidɾ����Ʒ����
	public void deleteSaleById(@Param("good_id") int good_id)throws Exception;
	//������Ʒidɾ����Ʒ����
	public void deleteMarginById(@Param("good_id")int good_id)throws Exception;
	//������Ʒidɾ����Ʒ����
	public void deletePropertiesById(@Param("good_id")int good_id)throws Exception;
	//������Ʒidɾ����Ʒ����
	public void deleteAssessById(@Param("good_id")int good_id)throws Exception;
	//���̸�����Ʒ��Ϣ
	public void updateShoppingGood(ShoppingGood good)throws Exception;
	//���̸��¼۸���Ϣ
	public void updateGoodPrice(GoodPrice price)throws Exception;
	//���̸���ͼƬ��Ϣ
	public void updateGoodImage(GoodImage image)throws Exception;
	//���̸�����Ʒ����
	public void updateGoodMargin(GoodMargin margin)throws Exception;
	//���̸�����Ʒ����
	public void updateGoodProperties(GoodProperties properties)throws Exception;
	//���ݶ���id���Ķ���״̬,�ӵ�
	public void updateOrderStateById(@Param("order_id") int order_id)throws Exception;
	//���ݶ���id�˵�
	public void updateOrderStateBackOrder(@Param("order_id") int order_id)throws Exception;
	//���ݶ���idɾ������
	//public void deleteOrderById(@Param("order_id") int order_id)throws Exception;
	//���ݵ���id���ĵ���״̬,Ӫҵ�����
	public void updateStoreStateById(@Param("store_id") int store_id,@Param("store_state") String store_state)throws Exception;
	//���ݵ�ַidɾ����ַ
	public void deleteAddressById(@Param("address_id") int address_id)throws Exception;
	//������Ʒ����ѯ��Ʒ
	public List<ShoppingGood> queryGoodByName(@Param("good_name")String good_name,@Param("store_id")int store_id)throws Exception;
	//���ݵ���id��ѯ�䶩��
	public List<ShoppingOrder> queryOrderByStoreId(@Param("store_id")int store_id)throws Exception;
	//���ݵ���id��ѯ�����������
	public List<ShoppingOrder> queryWaitDeliverGoodByStoreId(@Param("store_id") int store_id)throws Exception;
	//���ݵ���id��ѯ����ջ�����
	public List<ShoppingOrder> queryWaitReceiptGoodByStoreId(@Param("store_id") int store_id)throws Exception;
	//���ݵ���id��ѯ������۶���
	public List<ShoppingOrder> queryWaitAssessGoodByStoreId(@Param("store_id") int store_id)throws Exception;
	//���ݵ���id��ѯ����˿��
	public List<ShoppingOrder> queryWaitBackMoneyByStoreId(@Param("store_id") int store_id)throws Exception;
	//���ݵ���id��ѯ�����˿��
	public List<ShoppingOrder> queryBackMoneyByStoreId(@Param("store_id") int store_id)throws Exception;
	//���ݵ���id��ѯ������ɶ���
	public List<ShoppingOrder> queryOverOrderByStoreId(@Param("store_id") int store_id)throws Exception;
	//����ɾ���Լ��Ķ�������
	public void deleteOrderlineById(@Param("order_id")int order_id)throws Exception;
	//����ɾ���Լ��Ķ��������Ӧ�Ķ���
	public void deleteOrderById(@Param("order_id")int order_id)throws Exception;
	//���ݶ���id��ѯ����
	public ShoppingOrder queryOrderById(@Param("order_id")int order_id)throws Exception;
	//���ݶ���id��ѯ��������
	public ShoppingOrderline queryOrderlineById(@Param("order_id")int order_id) throws Exception;
	//���ݶ���id���¶�����Ϣ
	public void updateOrderById(ShoppingOrder order)throws Exception;
	//���ݶ���id���¶���������Ϣ
	public void updateOrderlineById(ShoppingOrderline orderline)throws Exception;
	//�û��������ӵ�ַ
	public void insertStoreAddress(RoleAddress address)throws Exception;
	//�û��鿴��������
	public List<ShoppingOrder> queryStoreReport(@Param("store_id")int store_id)throws Exception;
}
