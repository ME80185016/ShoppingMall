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
 * 业务逻辑层接口，用于普通用户逻辑实现
 */
import com.hds.entity.ShoppingRole;
import com.hds.entity.StoreInfo;

public interface UserBiz {
	//普通用户注册，角色类型为2
	public void userRegist(ShoppingRole role) throws Exception;
	//普通用户使用用户名登录
	public ShoppingRole userLoginByName(String role_name)throws Exception;
	//普通用户使用手机号登录
	public ShoppingRole userLoginByTel(String role_tel)throws Exception;
	//用户浏览商品，查找所有商品
	public List<ShoppingGood> queryGoods(int page)throws Exception;
	//根据商品id查找商品
	public ShoppingGood queryGoodById(int good_id)throws Exception;
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
	//查找商品数量用于分页
	public int queryGoodCount()throws Exception;
	//用户购买商品，向订单表shopping_order里添加数据
	public void insertOrder(ShoppingOrder order) throws Exception;
	//取得当前添加的订单id
	public int selectOrderIdCurrval()throws Exception;
	//用户购买商品，向订单详情表里添加数据
	public void insertOrderline(ShoppingOrderline orderline) throws Exception;
	//更改商品余量，当用户加入购物车或购买后商品余量-1，当店铺进货后商品余量进行相应更改
	public void updateGoodMargin(int good_id,int margin_num);
	//更改商品销量，当用户加入购物车或购买后商品销量+1
	public void updateGoodSale(int good_id,int sale_num);
	//用户添加收藏商品
	public void insertCollectGood(CollectGood collectgood)throws Exception;
	//根据用户id查询其订单
	public List<ShoppingOrder> queryOrderByUserId(int user_id)throws Exception;
	//根据用户id查询其购物车
	public List<ShoppingOrder> queryShoppingCarByUserId(int user_id)throws Exception;
	//根据用户id查询其代发货订单
	public List<ShoppingOrder> queryWaitDeliverGoodByUserId(int user_id)throws Exception;
	//根据用户id查询其代收货订单
	public List<ShoppingOrder> queryWaitReceiptGoodByUserId(int user_id)throws Exception;
	//根据用户id查询其代评价订单
	public List<ShoppingOrder> queryWaitAssessGoodByUserId(int user_id)throws Exception;
	//根据用户id查询其代退款订单
	public List<ShoppingOrder> queryWaitBackMoneyByUserId(int user_id)throws Exception;
	//根据用户id查询其已退款订单
	public List<ShoppingOrder> queryBackMoneyByUserId(int user_id)throws Exception;
	//根据用户id查询其已完成订单
	public List<ShoppingOrder> queryOverOrderByUserId(int user_id)throws Exception;
	//根据用户id查询其收藏商品
	public List<CollectGood> queryCollectGoodByUserId(int user_id)throws Exception;
	//用户或店铺添加地址
	public void insertUserAddress(RoleAddress address)throws Exception;
	//根据地址id查询地址
	public RoleAddress queryAddressById(int address_id)throws Exception;
	//根据用户id查询地址
	public List<RoleAddress> queryAddressByUserId(int user_id)throws Exception;
	//用户可删除自己的账号信息
	public void deleteUserById(int user_id)throws Exception;
	//用户更新自己账号信息
	public void updateUserById(ShoppingRole role)throws Exception;
	//用户更新自己地址信息
	public void updateAddressById(RoleAddress address)throws Exception;
	//用户删除自己的某个收藏商品
	public void deleteCollectGoodById(int collect_id)throws Exception;
	//用户添加收藏店铺
	public void insertCollectStore(CollectStore collectStore)throws Exception;
	//根据用户id查询其收藏店铺
	public List<CollectStore> queryCollectStoreByUserId(int user_id)throws Exception;	
	//根据角色id查询角色对象
	public ShoppingRole queryRoleById(int role_id)throws Exception;
	//用户删除自己的某个收藏店铺
	public void deleteCollectStoreById(int collect_id)throws Exception;
	//用户删除自己的某个地址
	public void deleteAddressById(int address_id)throws Exception;
	//用户删除自己的订单详情和订单
	public void deleteOrderAndLineById(int order_id)throws Exception;
	//用户评价商品
	public void insertGoodAssess(GoodAssess assess)throws Exception;
	//根据用户id查询其评价的商品
	public List<GoodAssess> queryGoodAssessByUserId(int user_id)throws Exception;
	//根据商品id查询其评价
	public List<GoodAssess> queryGoodAssessByGoodId(int good_id)throws Exception;
	//用户删除自己的某个评价
	public void deleteGoodAssessById(int assess_id)throws Exception;
	//根据订单id查询订单
	public ShoppingOrder queryOrderById(int order_id)throws Exception;
	//根据订单id查询订单详情
	public ShoppingOrderline queryOrderlineById(int order_id) throws Exception;
	//根据订单id更新订单信息
	public void updateOrderById(ShoppingOrder order)throws Exception;
	//根据订单id更新订单详情信息
	public void updateOrderlineById(ShoppingOrderline orderline)throws Exception;
	//根据商品名查询商品
	public List<ShoppingGood> queryGoodByName(String good_name)throws Exception;
	//用户浏览店铺，查询全部店铺
	public List<ShoppingRole> queryStores(int page)throws Exception;
	//根据店铺id查询店铺信息
	public StoreInfo queryStoreInfoById(int store_id)throws Exception;
	//查找店铺数量用于分页
	public int queryStoreCount()throws Exception;
	//根据店铺id查询地址
	public List<RoleAddress> queryAddressByStoreId(int store_id)throws Exception;
	//浏览某一家店铺的商品
	public List<ShoppingGood> queryStoreGoods(int store_id)throws Exception;
	//查询当前用户最新的一张订单，即用户当前要买的这个订单
	public ShoppingOrder queryCurrvalOrder(int user_id)throws Exception;
	//根据订单id将订单状态置为待评价，即确认收货
	public void updateOrderStateReceiptGood(int order_id)throws Exception;
	//根据订单id将订单详情状态置为待评价，即确认收货
	public void updateOrderlineStateReceiptGood(int order_id)throws Exception;
	
	
}
