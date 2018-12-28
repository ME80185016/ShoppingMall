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
 * 此接口用于普通用户进行的操作，包括注册、登录、购物、加入购物车、退款等等
 * @author 离
 *
 */
public interface UserMapper {
	//普通用户注册，角色类型为2
	public void insertUser(ShoppingRole role) throws Exception;
	//根据用户名在shopping_role表中查询用户
	public ShoppingRole queryUserByName(String role_name)throws Exception;
	//根据手机号在shopping_role表中查询用户
	public ShoppingRole queryUserByTel(String role_tel)throws Exception;
	//用户浏览商品，查找全部商品
	public List<ShoppingGood> queryGoods(int page)throws Exception;
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
	//查找全部角色名
	public List<String> queryRoleNames()throws Exception;
	//查找商品数量用于分页
	public int queryGoodCount()throws Exception;
	//用户购买商品，向订单表shopping_order里添加数据
	public void insertOrder(ShoppingOrder order) throws Exception;
	//取得当前添加的订单id
	public int selectOrderIdCurrval()throws Exception;
	//用户购买商品，向订单详情表Shopping_orderline表里添加数据
	public void insertOrderline(ShoppingOrderline orderline)throws Exception;
	//更改商品余量，当用户加入购物车或购买后商品余量-用户购买数量，当店铺进货后商品余量进行相应更改
	public void updateGoodMargin(@Param("good_id")int good_id,@Param("margin_num")int margin_num);
	//更改商品销量，当用户加入购物车或购买后商品销量+用户购买数量
	public void updateGoodSale(@Param("good_id")int good_id,@Param("sale_num")int sale_num);
	//用户添加收藏商品
	public void insertCollectGood(CollectGood collectgood)throws Exception;
	//根据用户id查询其购物车
	public List<ShoppingOrder> queryShoppingCarByUserId(@Param("user_id") int user_id)throws Exception;
	//根据用户id查询其订单
	public List<ShoppingOrder> queryOrderByUserId(@Param("user_id")int user_id)throws Exception;
	//根据用户id查询其代发货订单
	public List<ShoppingOrder> queryWaitDeliverGoodByUserId(@Param("user_id") int user_id)throws Exception;
	//根据用户id查询其代收货订单
	public List<ShoppingOrder> queryWaitReceiptGoodByUserId(@Param("user_id") int user_id)throws Exception;
	//根据用户id查询其代评价订单
	public List<ShoppingOrder> queryWaitAssessGoodByUserId(@Param("user_id") int user_id)throws Exception;
	//根据用户id查询其代退款订单
	public List<ShoppingOrder> queryWaitBackMoneyByUserId(@Param("user_id") int user_id)throws Exception;
	//根据用户id查询其已退款订单
	public List<ShoppingOrder> queryBackMoneyByUserId(@Param("user_id") int user_id)throws Exception;
	//根据用户id查询其已完成订单
	public List<ShoppingOrder> queryOverOrderByUserId(@Param("user_id") int user_id)throws Exception;
	//根据用户id查询其收藏商品
	public List<CollectGood> queryCollectGoodByUserId(@Param("user_id") int user_id)throws Exception;
	//用户或店铺添加地址
	public void insertUserAddress(RoleAddress address)throws Exception;
	//根据地址id查询地址
	public RoleAddress queryAddressById(@Param("address_id")int address_id)throws Exception;
	//根据用户id查询地址
	public List<RoleAddress> queryAddressByUserId(@Param("user_id")int user_id)throws Exception;
	//用户删除自己的账号信息
	public void deleteUserById(int user_id)throws Exception;
	//用户更新自己账号信息
	public void updateUserById(ShoppingRole role)throws Exception;
	//用户更新自己地址信息
	public void updateAddressById(RoleAddress address)throws Exception;
	//用户删除自己的某个收藏商品
	public void deleteCollectGoodById(@Param("collect_id")int collect_id)throws Exception;
	//用户添加收藏店铺
	public void insertCollectStore(CollectStore collectstore)throws Exception;
	//根据用户id查询其收藏店铺
	public List<CollectStore> queryCollectStoreByUserId(@Param("user_id") int user_id)throws Exception;
	//根据角色id查询角色对象
	public ShoppingRole queryRoleById(@Param("role_id")int role_id)throws Exception;
	//用户删除自己的某个收藏店铺
	public void deleteCollectStoreById(@Param("collect_id")int collect_id)throws Exception;
	//用户删除自己的某个地址
	public void deleteAddressById(@Param("address_id")int address_id)throws Exception;
	//用户删除自己的订单详情
	public void deleteOrderlineById(@Param("order_id")int order_id)throws Exception;
	//用户删除自己的订单详情对应的订单
	public void deleteOrderById(@Param("order_id")int order_id)throws Exception;
	//用户评价商品
	public void insertGoodAssess(GoodAssess assess)throws Exception;
	//根据用户id查询其评价的商品
	public List<GoodAssess> queryGoodAssessByUserId(@Param("user_id") int user_id)throws Exception;
	//根据商品id查询其评价
	public List<GoodAssess> queryGoodAssessByGoodId(@Param("good_id") int good_id)throws Exception;
	//用户删除自己的某个评价
	public void deleteGoodAssessById(@Param("assess_id")int assess_id)throws Exception;
	//根据订单id查询订单
	public ShoppingOrder queryOrderById(@Param("order_id")int order_id)throws Exception;
	//根据订单id查询订单详情
	public ShoppingOrderline queryOrderlineById(@Param("order_id")int order_id) throws Exception;
	//根据订单id更新订单信息
	public void updateOrderById(ShoppingOrder order)throws Exception;
	//根据订单id更新订单详情信息
	public void updateOrderlineById(ShoppingOrderline orderline)throws Exception;
	//根据商品名查询商品
	public List<ShoppingGood> queryGoodByName(@Param("good_name")String good_name)throws Exception;
	//用户浏览店铺，查询全部店铺
	public List<ShoppingRole> queryStores(int page)throws Exception;
	//根据店铺id查询店铺信息
	public StoreInfo queryStoreInfoById(int store_id)throws Exception;
	//查找店铺数量用于分页
	public int queryStoreCount()throws Exception;
	//根据店铺id查询地址
	public List<RoleAddress> queryAddressByStoreId(@Param("store_id")int store_id)throws Exception;
	//浏览某一家店铺的商品
	public List<ShoppingGood> queryStoreGoods(@Param("store_id")int store_id)throws Exception;
	//查询当前用户最新的一张订单，即用户当前要买的这个订单
	public ShoppingOrder queryCurrvalOrder(@Param("user_id") int user_id)throws Exception;
	//根据订单id将订单状态置为待评价，即确认收货
	public void updateOrderStateReceiptGood(@Param("order_id")int order_id)throws Exception;
	//根据订单id将订单详情状态置为待评价，即确认收货
	public void updateOrderlineStateReceiptGood(@Param("order_id")int order_id)throws Exception;
	
	
	
}
