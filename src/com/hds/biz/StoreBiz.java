package com.hds.biz;
/**
 * 业务逻辑层接口，用于店铺功能的逻辑实现
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
	//店铺注册，角色类型为1
	public void storeRegist(ShoppingRole role) throws Exception;
	//为注册的店铺添加信息
	public void addStoreInfo(StoreInfo storeInfo)throws Exception;
	//取得新注册的店铺的id
	public int selectStoreIdCurrval()throws Exception;
	//店铺使用店铺名登录
	public ShoppingRole storeLoginByName(String role_name)throws Exception;
	//店铺使用注册手机号登录
	public ShoppingRole storeLoginByTel(String role_tel)throws Exception;
	//店铺上架商品
	public void addGood(ShoppingGood good)throws Exception;
	//取得当前添加的商品的id
	public int selectGoodIdCurrval()throws Exception;
	//为上架的商品添加信息
	public void addGoodInfo(GoodInfo goodInfo)throws Exception;
	//店铺可删除自己的账号信息
	public void deleteStoreById(int store_id)throws Exception;
	//根据店铺id查询店铺详细信息
	public StoreInfo queryStoreInfoById(int store_id)throws Exception;
	//根据店铺id查询地址
	public List<RoleAddress> queryAddressByStoreId(int store_id)throws Exception;
	//店铺更新自己账号信息
	public void updateStoreById(ShoppingRole role)throws Exception;
	//店铺更新自己详细信息
	public void updateStoreInfoById(StoreInfo storeInfo)throws Exception;
	//店铺更新自己地址信息
	public void updateAddressById(RoleAddress address)throws Exception;
	//店铺浏览自家商品
	public List<ShoppingGood> queryStoreGoods(int store_id,int page)throws Exception;
	//根据商品id查找商品
	public ShoppingGood queryGoodById(int good_id) throws Exception;
	//根据商品id查找商品价格
	public int queryPriceById(int good_id)throws Exception;
	//根据商品id查找商品图片路径
	public String queryImageRouteById(int good_id)throws Exception;
	//根据商品id查找商品销量
	public int querySaleById(int good_id)throws Exception;
	//根据商品id查找商品余量
	public int queryMarginById(int good_id)throws Exception;
	//根据商品id查找商品属性
	public GoodProperties queryPropertiesById(int good_id)throws Exception;
	//根据商品id查找商品评价
	public List<GoodAssess> queryAssessById(int good_id)throws Exception;
	//查找店铺商品数量用于分页
	public int queryGoodCount(int store_id)throws Exception;
	//店铺下架商品根据商品id
	public void deleteGoodById(int good_id)throws Exception;
	//店铺根据商品id删除价格
	public void deletePriceById(int good_id)throws Exception;
	//店铺根据商品id删除图片
	public void deleteImageRoute(int good_id)throws Exception;
	//根据商品id删除商品销量
	public void deleteSaleById(int good_id)throws Exception;
	//根据商品id删除商品余量
	public void deleteMarginById(int good_id)throws Exception;
	//根据商品id删除商品属性
	public void deletePropertiesById(int good_id)throws Exception;
	//根据商品id删除商品评价
	public void deleteAssessById(int good_id)throws Exception;
	//店铺更新商品信息
	public void updateGoodInfo(GoodInfo goodInfo)throws Exception;
	//根据店铺id查询其订单
	public List<ShoppingOrder> queryOrderByStoreId(int store_id)throws Exception;
	//根据店铺id查询其未发货订单
	public List<ShoppingOrder> queryWaitDeliverGoodByStoreId(int store_id)throws Exception;
	//根据店铺id查询其代收货订单
	public List<ShoppingOrder> queryWaitReceiptGoodByStoreId(int store_id)throws Exception;
	//根据店铺id查询其代评价订单
	public List<ShoppingOrder> queryWaitAssessGoodByStoreId(int store_id)throws Exception;
	//根据店铺id查询其代退款订单
	public List<ShoppingOrder> queryWaitBackMoneyByStoreId(int store_id)throws Exception;
	//根据店铺id查询其已退款订单
	public List<ShoppingOrder> queryBackMoneyByStoreId(int store_id)throws Exception;
	//根据店铺id查询其已完成订单
	public List<ShoppingOrder> queryOverOrderByStoreId(int store_id)throws Exception;
	//根据订单id更改订单状态
	public void updateOrderStateById(int order_id)throws Exception;
	//根据订单id退单
	public void updateOrderStateBackOrder(int order_id)throws Exception;
	//根据店铺id更改店铺状态,营业或打烊
	public void updateStoreStateById(int store_id,String store_state)throws Exception;
	//根据地址id删除地址
	public void deleteAddressById(int address_id)throws Exception;
	//根据商品名模糊查询商品
	public List<ShoppingGood> queryGoodByName(String good_name,int store_id)throws Exception;
	//用户删除自己的订单详情和订单
	public void deleteOrderAndLineById(int order_id)throws Exception;
	//根据订单id查询订单
	public ShoppingOrder queryOrderById(int order_id)throws Exception;
	//根据订单id查询订单详情
	public ShoppingOrderline queryOrderlineById(int order_id) throws Exception;
	//根据订单id更新订单信息
	public void updateOrderById(ShoppingOrder order)throws Exception;
	//根据订单id更新订单详情信息
	public void updateOrderlineById(ShoppingOrderline orderline)throws Exception;
	//用户或店铺添加地址
	public void insertStoreAddress(RoleAddress address)throws Exception;
	//用户查看报表数据
	public List<ShoppingOrder> queryStoreReport(int store_id)throws Exception;
	
	
	
	
	
	
	
	

}
