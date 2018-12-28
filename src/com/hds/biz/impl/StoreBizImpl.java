package com.hds.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hds.biz.StoreBiz;
import com.hds.entity.GoodAssess;
import com.hds.entity.GoodInfo;
import com.hds.entity.GoodProperties;
import com.hds.entity.RoleAddress;
import com.hds.entity.ShoppingGood;
import com.hds.entity.ShoppingOrder;
import com.hds.entity.ShoppingOrderline;
import com.hds.entity.ShoppingRole;
import com.hds.entity.StoreInfo;
import com.hds.mapper.StoreMapper;
/**
 * 店铺业务逻辑层
 * @author 离
 *
 */
@Service
public class StoreBizImpl implements StoreBiz {
	@Autowired
	private StoreMapper storemapper;
	/**
	 * 店铺注册
	 */
	@Override
	public void storeRegist(ShoppingRole role) throws Exception {
		// TODO Auto-generated method stub
		storemapper.insertStoreToShoppingRole(role);//调用mapper接口方法将店铺登录信息插入shopping_role表

	}
	/**
	 * 为注册的店铺添加信息
	 */
	@Override
	public void addStoreInfo(StoreInfo storeInfo) throws Exception {
		// TODO Auto-generated method stub
		storemapper.insertStoreToStoreInfo(storeInfo);//调用mapper接口方法将店铺注册其他信息插入表store_info
		
	}
	/**
	 * 店铺根据店铺名登录
	 */
	@Override
	public ShoppingRole storeLoginByName(String role_name) throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryStoreByName(role_name);
	}
	/**
	 * 店铺根据手机号登录
	 */
	@Override
	public ShoppingRole storeLoginByTel(String role_tel) throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryStoreByTel(role_tel);
	}
	/**
	 * 店铺上架商品
	 */
	@Override
	public void addGood(ShoppingGood good) throws Exception {
		// TODO Auto-generated method stub
		storemapper.insertGoodToShoppingGood(good);
		
	}
	
	@Override
	public void addGoodInfo(GoodInfo goodInfo) throws Exception {
		// TODO Auto-generated method stub
		storemapper.insertGoodToGoodImage(goodInfo.getGoodImage());
		storemapper.insertGoodToGoodMargin(goodInfo.getGoodMargin());
		storemapper.insertGoodToGoodPrice(goodInfo.getGoodPrice());
		storemapper.insertGoodToGoodProperties(goodInfo.getGoodProperties());
		storemapper.insertGoodToGoodSale(goodInfo.getGoodSale());
		
		
	}
	/**
	 * 取得当前添加的商品的id
	 */
	@Override
	public int selectGoodIdCurrval() throws Exception {
		// TODO Auto-generated method stub
		return storemapper.selectGoodIdCurrval();
	}
	/**
	 * 取得新注册的店铺的id
	 */
	@Override
	public int selectStoreIdCurrval() throws Exception {
		// TODO Auto-generated method stub
		return storemapper.selectStoreIdCurrval();
	}
	@Override
	public void deleteStoreById(int store_id) throws Exception {
		// TODO Auto-generated method stub
		storemapper.deleteStoreById(store_id);
	}
	@Override
	public StoreInfo queryStoreInfoById(int store_id) throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryStoreInfoById(store_id);
	}
	@Override
	public void updateStoreById(ShoppingRole role) throws Exception {
		// TODO Auto-generated method stub
		storemapper.updateStoreById(role);
		
	}
	@Override
	public void updateStoreInfoById(StoreInfo storeInfo) throws Exception {
		// TODO Auto-generated method stub
		storemapper.updateStoreInfoById(storeInfo);
	}
	@Override
	public void updateAddressById(RoleAddress address) throws Exception {
		// TODO Auto-generated method stub
		storemapper.updateAddressById(address);
	}
	@Override
	public List<RoleAddress> queryAddressByStoreId(int store_id)
			throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryAddressByStoreId(store_id);
	}
	@Override
	public List<ShoppingGood> queryStoreGoods(int store_id,int page) throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryStoreGoods(store_id,page);
	}
	@Override
	public ShoppingGood queryGoodById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryGoodById(good_id);
	}
	@Override
	public int queryPriceById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryPriceById(good_id);
	}
	@Override
	public String queryImageRouteById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryImageRouteById(good_id);
	}
	@Override
	public int querySaleById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return storemapper.querySaleById(good_id);
	}
	@Override
	public int queryMarginById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryMarginById(good_id);
	}
	@Override
	public GoodProperties queryPropertiesById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryPropertiesById(good_id);
	}
	@Override
	public List<GoodAssess> queryAssessById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryAssessById(good_id);
	}
	@Override
	public int queryGoodCount(int store_id) throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryGoodCount(store_id);
	}
	@Override
	public void deleteGoodById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		storemapper.deleteGoodById(good_id);
	}
	@Override
	public void deletePriceById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		storemapper.deletePriceById(good_id);
	}
	@Override
	public void deleteImageRoute(int good_id) throws Exception {
		// TODO Auto-generated method stub
		storemapper.deleteImageRouteById(good_id);
	}
	@Override
	public void deleteSaleById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		storemapper.deleteSaleById(good_id);
	}
	@Override
	public void deleteMarginById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		storemapper.deleteMarginById(good_id);
	}
	@Override
	public void deletePropertiesById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		storemapper.deletePropertiesById(good_id);
	}
	@Override
	public void deleteAssessById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		storemapper.deleteAssessById(good_id);
	}
	@Override
	public void updateGoodInfo(GoodInfo goodInfo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(goodInfo.getGoodProperties().toString());
		storemapper.updateGoodProperties(goodInfo.getGoodProperties());
		storemapper.updateShoppingGood(goodInfo.getGood());
		storemapper.updateGoodPrice(goodInfo.getGoodPrice());
		storemapper.updateGoodImage(goodInfo.getGoodImage());
		storemapper.updateGoodMargin(goodInfo.getGoodMargin());
	}
	
	@Override
	public List<ShoppingOrder> queryWaitDeliverGoodByStoreId(int store_id)
			throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryWaitDeliverGoodByStoreId(store_id);
	}
	@Override
	public void updateOrderStateById(int order_id)
			throws Exception {
		// TODO Auto-generated method stub
		storemapper.updateOrderStateById(order_id);
	}
	@Override
	public void updateOrderStateBackOrder(int order_id) throws Exception {
		// TODO Auto-generated method stub
		storemapper.updateOrderStateBackOrder(order_id);
	}
	@Override
	public void updateStoreStateById(int store_id, String store_state)
			throws Exception {
		// TODO Auto-generated method stub
		storemapper.updateStoreStateById(store_id, store_state);
	}
	@Override
	public void deleteAddressById(int address_id) throws Exception {
		// TODO Auto-generated method stub
		storemapper.deleteAddressById(address_id);
	}
	@Override
	public List<ShoppingGood> queryGoodByName(String good_name,int store_id)
			throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryGoodByName(good_name,store_id);
	}
	@Override
	public List<ShoppingOrder> queryOrderByStoreId(int store_id)
			throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryOrderByStoreId(store_id);
	}
	@Override
	public List<ShoppingOrder> queryWaitReceiptGoodByStoreId(int store_id)
			throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryWaitReceiptGoodByStoreId(store_id);
	}
	@Override
	public List<ShoppingOrder> queryWaitAssessGoodByStoreId(int store_id)
			throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryWaitAssessGoodByStoreId(store_id);
	}
	@Override
	public List<ShoppingOrder> queryWaitBackMoneyByStoreId(int store_id)
			throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryWaitBackMoneyByStoreId(store_id);
	}
	@Override
	public List<ShoppingOrder> queryBackMoneyByStoreId(int store_id)
			throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryBackMoneyByStoreId(store_id);
	}
	@Override
	public void deleteOrderAndLineById(int order_id) throws Exception {
		// TODO Auto-generated method stub
		storemapper.deleteOrderById(order_id);
		storemapper.deleteOrderlineById(order_id);
	}
	@Override
	public ShoppingOrderline queryOrderlineById(int order_id) throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryOrderlineById(order_id);
	}
	@Override
	public void insertStoreAddress(RoleAddress address) throws Exception {
		// TODO Auto-generated method stub
		storemapper.insertStoreAddress(address);
	}
	@Override
	public List<ShoppingOrder> queryOverOrderByStoreId(int store_id)
			throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryOverOrderByStoreId(store_id);
	}
	@Override
	public ShoppingOrder queryOrderById(int order_id) throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryOrderById(order_id);
	}
	@Override
	public void updateOrderById(ShoppingOrder order) throws Exception {
		// TODO Auto-generated method stub
		storemapper.updateOrderById(order);
	}
	@Override
	public void updateOrderlineById(ShoppingOrderline orderline)
			throws Exception {
		// TODO Auto-generated method stub
		storemapper.updateOrderlineById(orderline);
	}
	@Override
	public List<ShoppingOrder> queryStoreReport(int store_id) throws Exception {
		// TODO Auto-generated method stub
		return storemapper.queryStoreReport(store_id);
	}
	
	
	

}
