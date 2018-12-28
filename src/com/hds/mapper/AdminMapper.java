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
	//根据用户名在shopping_role表中查询用户
	public ShoppingRole queryAdminByName(String role_name)throws Exception;
	
	//根据手机号在shopping_role表中查询用户
	public ShoppingRole queryAdminByTel(String role_tel)throws Exception;
	
	// 根据角色id查询角色
	public ShoppingRole queryRoleById(@Param("role_id") int role_id)
			throws Exception;
	
	// 根据角色名查询角色
	public ShoppingRole queryRoleByName(@Param("role_name") String role_name)
			throws Exception;

	// 管理员根据角色id删除角色，用户和管理员可删除自己的账号信息
	public void deleteRoleById(int role_id) throws Exception;
	
	// 管理员浏览商品，查找全部商品
	public List<ShoppingGood> queryGoods() throws Exception;
	
	// 根据商品id查找商品
	public ShoppingGood queryGoodById(int good_id) throws Exception;

	// 根据商品id查找商品价格
	public int queryPriceById(int good_id) throws Exception;

	// 根据商品id查找商品图片路径
	public String queryImageRouteById(int good_id) throws Exception;

	// 根据商品id查找商品销量
	public int querySaleById(int good_id) throws Exception;

	// 根据商品id查找商品余量
	public int queryMarginById(int good_id) throws Exception;

	// 根据商品id查找商品属性
	public GoodProperties queryPropertiesById(int good_id) throws Exception;

	// 根据商品id查找商品评价
	public List<GoodAssess> queryAssessById(int good_id) throws Exception;

	// 根据商品名查找商品
	public List<ShoppingGood> queryGoodByName(String good_name) throws Exception;

	// 管理员下架商品根据商品id
	public void deleteGoodById(@Param("good_id") int good_id) throws Exception;

	// 管理员根据商品id删除价格
	public void deletePriceById(@Param("good_id") int good_id) throws Exception;

	// 管理员根据商品id删除图片
	public void deleteImageRoute(@Param("good_id") int good_id)
			throws Exception;

	// 根据商品id删除商品销量
	public void deleteSaleById(@Param("good_id") int good_id) throws Exception;

	// 根据商品id删除商品余量
	public void deleteMarginById(@Param("good_id") int good_id)
			throws Exception;

	// 根据商品id删除商品属性
	public void deletePropertiesById(@Param("good_id") int good_id)
			throws Exception;

	// 根据商品id删除商品评价
	public void deleteAssessById(@Param("good_id") int good_id)
			throws Exception;

	// 管理员更改店铺状态
	public void updateStoreStateById(@Param("store_id") int store_id,
			@Param("store_state") String store_state) throws Exception;

	// 管理员根据店铺id删除店铺信息，拒绝开店
	public void deleteStoreInfoById(int store_id) throws Exception;
	
	//用户浏览店铺，查询全部店铺
	public List<ShoppingRole> queryStores()throws Exception;
	
	//根据店铺id查询店铺信息
	public StoreInfo queryStoreInfoById(int store_id)throws Exception;
	
	//根据店铺id查询地址
	public List<RoleAddress> queryAddressByStoreId(@Param("store_id")int store_id)throws Exception;
	
	//浏览某一家店铺的商品
	public List<ShoppingGood> queryStoreGoods(@Param("store_id")int store_id)throws Exception;

	//查看申请开店的店铺信息
	public List<StoreInfo> queryApplyStoreInfo()throws Exception;
	
	
	
	
}
