package com.hds.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hds.biz.UserBiz;
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
import com.hds.mapper.UserMapper;
/**
 * 普通用户业务逻辑层
 * @author 离
 *
 */
@Service
public class UserBizImpl implements UserBiz {
	@Autowired
	private UserMapper usermapper;

	@Override
	public void userRegist(ShoppingRole role) throws Exception {
		// TODO Auto-generated method stub
		usermapper.insertUser(role);

	}

	@Override
	public ShoppingRole userLoginByName(String role_name) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryUserByName(role_name);
		 
	}

	@Override
	public ShoppingRole userLoginByTel(String role_tel) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryUserByTel(role_tel);
	}

	@Override
	public List<ShoppingGood> queryGoods(int page) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryGoods(page);
	}
	
	@Override
	public ShoppingGood queryGoodById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryGoodById(good_id);
	}

	@Override
	public int queryPriceById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryPriceById(good_id);
	}

	@Override
	public String queryImageRouteById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryImageRouteById(good_id);
	}

	@Override
	public int querySaleById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.querySaleById(good_id);
	}

	@Override
	public int queryMarginById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryMarginById(good_id);
	}

	@Override
	public GoodProperties queryPropertiesById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryPropertiesById(good_id);
	}

	@Override
	public List<GoodAssess> queryAssessById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryAssessById(good_id);
	}

	@Override
	public int queryGoodCount() throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryGoodCount();
	}

	@Override
	public void insertOrder(ShoppingOrder order) throws Exception {
		// TODO Auto-generated method stub
		usermapper.insertOrder(order);
	}
	
	@Override
	public void insertOrderline(ShoppingOrderline orderline) throws Exception {
		// TODO Auto-generated method stub
		usermapper.insertOrderline(orderline);
	}

	@Override
	public void updateGoodMargin(int good_id, int margin_num) {
		// TODO Auto-generated method stub
		usermapper.updateGoodMargin(good_id, margin_num);
		
	}

	@Override
	public void updateGoodSale(int good_id, int sale_num) {
		// TODO Auto-generated method stub
		usermapper.updateGoodSale(good_id, sale_num);
		
	}

	@Override
	public void insertCollectGood(CollectGood collectgood) throws Exception {
		// TODO Auto-generated method stub
		usermapper.insertCollectGood(collectgood);
		
	}

	@Override
	public List<ShoppingOrder> queryOrderByUserId(int user_id) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryOrderByUserId(user_id);
	}

	@Override
	public List<ShoppingOrder> queryShoppingCarByUserId(int user_id)
			throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryShoppingCarByUserId(user_id);
	}

	@Override
	public List<CollectGood> queryCollectGoodByUserId(int user_id)
			throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryCollectGoodByUserId(user_id);
	}

	@Override
	public int selectOrderIdCurrval() throws Exception {
		// TODO Auto-generated method stub
		return usermapper.selectOrderIdCurrval();
	}

	@Override
	public RoleAddress queryAddressById(int address_id) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryAddressById(address_id);
	}

	@Override
	public void insertUserAddress(RoleAddress address) throws Exception {
		// TODO Auto-generated method stub
		usermapper.insertUserAddress(address);
	}

	@Override
	public List<RoleAddress> queryAddressByUserId(int user_id) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryAddressByUserId(user_id);
	}

	@Override
	public void deleteUserById(int user_id) throws Exception {
		// TODO Auto-generated method stub
		usermapper.deleteUserById(user_id);
	}

	@Override
	public void updateUserById(ShoppingRole role) throws Exception {
		// TODO Auto-generated method stub
		usermapper.updateUserById(role);
		
	}

	@Override
	public void updateAddressById(RoleAddress address) throws Exception {
		// TODO Auto-generated method stub
		usermapper.updateAddressById(address);
	}

	@Override
	public void deleteCollectGoodById(int collect_id) throws Exception {
		// TODO Auto-generated method stub
		usermapper.deleteCollectGoodById(collect_id);
	}

	@Override
	public void insertCollectStore(CollectStore collectStore) throws Exception {
		// TODO Auto-generated method stub
		usermapper.insertCollectStore(collectStore);
		
	}

	@Override
	public List<CollectStore> queryCollectStoreByUserId(int user_id)
			throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryCollectStoreByUserId(user_id);
	}

	@Override
	public ShoppingRole queryRoleById(int role_id) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryRoleById(role_id);
	}

	@Override
	public void deleteCollectStoreById(int collect_id) throws Exception {
		// TODO Auto-generated method stub
		usermapper.deleteCollectStoreById(collect_id);
	}

	@Override
	public void deleteAddressById(int address_id) throws Exception {
		// TODO Auto-generated method stub
		usermapper.deleteAddressById(address_id);
	}

	@Override
	public void deleteOrderAndLineById(int order_id) throws Exception {
		// TODO Auto-generated method stub
		usermapper.deleteOrderById(order_id);
		usermapper.deleteOrderlineById(order_id);
	}

	@Override
	public void insertGoodAssess(GoodAssess assess) throws Exception {
		// TODO Auto-generated method stub
		usermapper.insertGoodAssess(assess);
	}

	@Override
	public List<GoodAssess> queryGoodAssessByUserId(int user_id)
			throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryGoodAssessByUserId(user_id);
	}

	@Override
	public List<GoodAssess> queryGoodAssessByGoodId(int good_id)
			throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryGoodAssessByGoodId(good_id);
	}

	@Override
	public void deleteGoodAssessById(int assess_id) throws Exception {
		// TODO Auto-generated method stub
		usermapper.deleteGoodAssessById(assess_id);
	}

	@Override
	public ShoppingOrder queryOrderById(int order_id) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryOrderById(order_id);
	}

	@Override
	public ShoppingOrderline queryOrderlineById(int order_id) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryOrderlineById(order_id);
	}

	@Override
	public void updateOrderById(ShoppingOrder order) throws Exception {
		// TODO Auto-generated method stub
		usermapper.updateOrderById(order);
	}

	@Override
	public void updateOrderlineById(ShoppingOrderline orderline)
			throws Exception {
		// TODO Auto-generated method stub
		usermapper.updateOrderlineById(orderline);
	}

	@Override
	public List<ShoppingGood> queryGoodByName(String good_name)
			throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryGoodByName(good_name);
	}

	@Override
	public List<ShoppingRole> queryStores(int page) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryStores(page);
	}

	@Override
	public StoreInfo queryStoreInfoById(int store_id) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryStoreInfoById(store_id);
	}

	@Override
	public int queryStoreCount() throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryStoreCount();
	}

	@Override
	public List<RoleAddress> queryAddressByStoreId(int store_id)
			throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryAddressByStoreId(store_id);
	}

	@Override
	public List<ShoppingGood> queryStoreGoods(int store_id) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryStoreGoods(store_id);
	}

	@Override
	public ShoppingOrder queryCurrvalOrder(int user_id) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryCurrvalOrder(user_id);
	}

	@Override
	public List<ShoppingOrder> queryWaitDeliverGoodByUserId(int user_id)
			throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryWaitDeliverGoodByUserId(user_id);
	}

	@Override
	public List<ShoppingOrder> queryWaitReceiptGoodByUserId(int user_id)
			throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryWaitReceiptGoodByUserId(user_id);
	}

	@Override
	public List<ShoppingOrder> queryWaitAssessGoodByUserId(int user_id)
			throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryWaitAssessGoodByUserId(user_id);
	}

	@Override
	public List<ShoppingOrder> queryWaitBackMoneyByUserId(int user_id)
			throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryWaitBackMoneyByUserId(user_id);
	}

	@Override
	public List<ShoppingOrder> queryBackMoneyByUserId(int user_id)
			throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryBackMoneyByUserId(user_id);
	}

	@Override
	public void updateOrderStateReceiptGood(int order_id) throws Exception {
		// TODO Auto-generated method stub
		usermapper.updateOrderStateReceiptGood(order_id);
	}

	@Override
	public void updateOrderlineStateReceiptGood(int order_id) throws Exception {
		// TODO Auto-generated method stub
		usermapper.updateOrderlineStateReceiptGood(order_id);
	}

	@Override
	public List<ShoppingOrder> queryOverOrderByUserId(int user_id)
			throws Exception {
		// TODO Auto-generated method stub
		return usermapper.queryOverOrderByUserId(user_id);
	}


}
