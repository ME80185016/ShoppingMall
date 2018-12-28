package com.hds.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hds.biz.AdminBiz;
import com.hds.entity.GoodAssess;
import com.hds.entity.GoodProperties;
import com.hds.entity.RoleAddress;
import com.hds.entity.ShoppingGood;
import com.hds.entity.ShoppingRole;
import com.hds.entity.StoreInfo;
import com.hds.mapper.AdminMapper;
/**
 * 管理员业务逻辑层
 * @author 离
 *
 */
@Service
public class AdminBizImpl implements AdminBiz {
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public void deleteRoleById(int role_id) throws Exception {
		// TODO Auto-generated method stub
		adminMapper.deleteRoleById(role_id);

	}

	@Override
	public ShoppingRole queryRoleById(int role_id) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.queryRoleById(role_id);
	}

	@Override
	public ShoppingRole queryRoleByName(String role_name) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.queryRoleByName(role_name);
	}

	@Override
	public ShoppingGood queryGoodById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.queryGoodById(good_id);
	}

	@Override
	public int queryPriceById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.queryPriceById(good_id);
	}

	@Override
	public String queryImageRouteById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.queryImageRouteById(good_id);
	}

	@Override
	public int querySaleById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.querySaleById(good_id);
	}

	@Override
	public int queryMarginById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.queryMarginById(good_id);
	}

	@Override
	public GoodProperties queryPropertiesById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.queryPropertiesById(good_id);
	}

	@Override
	public List<GoodAssess> queryAssessById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.queryAssessById(good_id);
	}

	@Override
	public List<ShoppingGood> queryGoodByName(String good_name) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.queryGoodByName(good_name);
	}

	@Override
	public void deleteGoodById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		adminMapper.deleteGoodById(good_id);
	}

	@Override
	public void deletePriceById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		adminMapper.deletePriceById(good_id);
	}

	@Override
	public void deleteImageRoute(int good_id) throws Exception {
		// TODO Auto-generated method stub
		adminMapper.deleteImageRoute(good_id);
	}

	@Override
	public void deleteSaleById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		adminMapper.deleteSaleById(good_id);
	}

	@Override
	public void deleteMarginById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		adminMapper.deleteMarginById(good_id);
	}

	@Override
	public void deletePropertiesById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		adminMapper.deletePropertiesById(good_id);
	}

	@Override
	public void deleteAssessById(int good_id) throws Exception {
		// TODO Auto-generated method stub
		adminMapper.deleteAssessById(good_id);
	}

	@Override
	public void updateStoreStateById(int store_id, String store_state)
			throws Exception {
		// TODO Auto-generated method stub
		adminMapper.updateStoreStateById(store_id, store_state);
	}

	@Override
	public void deleteStoreInfoById(int store_id) throws Exception {
		// TODO Auto-generated method stub
		adminMapper.deleteStoreInfoById(store_id);
	}

	@Override
	public List<ShoppingGood> queryGoods() throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.queryGoods();
	}

	@Override
	public List<ShoppingRole> queryStores() throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.queryStores();
	}

	@Override
	public StoreInfo queryStoreInfoById(int store_id) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.queryStoreInfoById(store_id);
	}

	@Override
	public List<RoleAddress> queryAddressByStoreId(int store_id)
			throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.queryAddressByStoreId(store_id);
	}

	@Override
	public List<ShoppingGood> queryStoreGoods(int store_id) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.queryStoreGoods(store_id);
	}

	@Override
	public List<StoreInfo> queryApplyStoreInfo() throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.queryApplyStoreInfo();
	}

	@Override
	public ShoppingRole queryAdminByName(String role_name) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.queryAdminByName(role_name);
	}

	@Override
	public ShoppingRole queryAdminByTel(String role_tel) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.queryAdminByTel(role_tel);
	}

}
