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
 * 此接口用于店铺进行的操作，包括注册、登录、商品上架、下架、店铺营业和打烊等等
 * @author 离
 *
 */
public interface StoreMapper {
	//将店铺信息插入shopping_role表中，角色为1
	public void insertStoreToShoppingRole(ShoppingRole role) throws Exception;
	//将店铺信息插入store_info表
	public void insertStoreToStoreInfo(StoreInfo store)throws Exception;
	//取得当前店铺的id
	public int selectStoreIdCurrval()throws Exception;
	//根据店铺名查询店铺登录信息
	public ShoppingRole queryStoreByName(String role_name)throws Exception;
	//根据店铺注册手机号查询店铺登录信息
	public ShoppingRole queryStoreByTel(String role_tel) throws Exception;
	//根据店铺登录表中的id在store_info中查询店铺详细信息
	public StoreInfo queryStoreById(int id)throws Exception;
	//店铺上架商品插入shopping_good表(上架商品将店家上架的商品名称给予这家店铺的这件商品)
	public void insertGoodToShoppingGood(ShoppingGood good)throws Exception;
	//店铺上架商品插入good_price表(上架商品将店家上架的商品价格给予这家店铺的这件商品)
	public void insertGoodToGoodPrice(GoodPrice price)throws Exception;
	//店铺上架商品插入good_image表(上架商品将店家上架的商品的图片路径给予这家店铺的这件商品)
	public void insertGoodToGoodImage(GoodImage image)throws Exception;
	//店铺上架商品插入good_sale表(上架商品将默认销量0给予这个店铺的这件商品)
	public void insertGoodToGoodSale(GoodSale sale)throws Exception;
	//店铺上架商品插入good_margin表(上架商品将店家上架的商品数量给予这家店铺的这件商品)
	public void insertGoodToGoodMargin(GoodMargin margin)throws Exception;
	//店铺上架商品插入good_properties表(上架商品将店家上架的商品属性给予这家店铺的这件商品)
	public void insertGoodToGoodProperties(GoodProperties properties)throws Exception;
	//取得当前商品的id
	public int selectGoodIdCurrval()throws Exception;
	//店铺可删除自己的账号信息
	public void deleteStoreById(int store_id)throws Exception;
	//根据店铺id查询店铺详细信息
	public StoreInfo queryStoreInfoById(int store_id)throws Exception;
	//根据店铺id查询地址
	public List<RoleAddress> queryAddressByStoreId(@Param("store_id")int store_id)throws Exception;
	//店铺更新自己账号信息
	public void updateStoreById(ShoppingRole role)throws Exception;
	//店铺更新自己详细信息
	public void updateStoreInfoById(StoreInfo storeInfo)throws Exception;
	//店铺更新自己地址信息
	public void updateAddressById(RoleAddress address)throws Exception;
	//店铺浏览自家商品
	public List<ShoppingGood> queryStoreGoods(@Param("store_id")int store_id,@Param("page")int page)throws Exception;
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
	public int queryGoodCount(@Param("store_id")int store_id)throws Exception;
	//店铺下架商品根据商品id
	public void deleteGoodById(@Param("good_id") int good_id)throws Exception;
	//店铺根据商品id删除价格
	public void deletePriceById(@Param("good_id") int good_id)throws Exception;
	//店铺根据商品id删除图片
	public void deleteImageRouteById(@Param("good_id") int good_id)throws Exception;
	//根据商品id删除商品销量
	public void deleteSaleById(@Param("good_id") int good_id)throws Exception;
	//根据商品id删除商品余量
	public void deleteMarginById(@Param("good_id")int good_id)throws Exception;
	//根据商品id删除商品属性
	public void deletePropertiesById(@Param("good_id")int good_id)throws Exception;
	//根据商品id删除商品评价
	public void deleteAssessById(@Param("good_id")int good_id)throws Exception;
	//店铺更新商品信息
	public void updateShoppingGood(ShoppingGood good)throws Exception;
	//店铺更新价格信息
	public void updateGoodPrice(GoodPrice price)throws Exception;
	//店铺更新图片信息
	public void updateGoodImage(GoodImage image)throws Exception;
	//店铺更新商品余量
	public void updateGoodMargin(GoodMargin margin)throws Exception;
	//店铺更新商品属性
	public void updateGoodProperties(GoodProperties properties)throws Exception;
	//根据订单id更改订单状态,接单
	public void updateOrderStateById(@Param("order_id") int order_id)throws Exception;
	//根据订单id退单
	public void updateOrderStateBackOrder(@Param("order_id") int order_id)throws Exception;
	//根据订单id删除订单
	//public void deleteOrderById(@Param("order_id") int order_id)throws Exception;
	//根据店铺id更改店铺状态,营业或打烊
	public void updateStoreStateById(@Param("store_id") int store_id,@Param("store_state") String store_state)throws Exception;
	//根据地址id删除地址
	public void deleteAddressById(@Param("address_id") int address_id)throws Exception;
	//根据商品名查询商品
	public List<ShoppingGood> queryGoodByName(@Param("good_name")String good_name,@Param("store_id")int store_id)throws Exception;
	//根据店铺id查询其订单
	public List<ShoppingOrder> queryOrderByStoreId(@Param("store_id")int store_id)throws Exception;
	//根据店铺id查询其代发货订单
	public List<ShoppingOrder> queryWaitDeliverGoodByStoreId(@Param("store_id") int store_id)throws Exception;
	//根据店铺id查询其代收货订单
	public List<ShoppingOrder> queryWaitReceiptGoodByStoreId(@Param("store_id") int store_id)throws Exception;
	//根据店铺id查询其代评价订单
	public List<ShoppingOrder> queryWaitAssessGoodByStoreId(@Param("store_id") int store_id)throws Exception;
	//根据店铺id查询其代退款订单
	public List<ShoppingOrder> queryWaitBackMoneyByStoreId(@Param("store_id") int store_id)throws Exception;
	//根据店铺id查询其已退款订单
	public List<ShoppingOrder> queryBackMoneyByStoreId(@Param("store_id") int store_id)throws Exception;
	//根据店铺id查询其已完成订单
	public List<ShoppingOrder> queryOverOrderByStoreId(@Param("store_id") int store_id)throws Exception;
	//店铺删除自己的订单详情
	public void deleteOrderlineById(@Param("order_id")int order_id)throws Exception;
	//店铺删除自己的订单详情对应的订单
	public void deleteOrderById(@Param("order_id")int order_id)throws Exception;
	//根据订单id查询订单
	public ShoppingOrder queryOrderById(@Param("order_id")int order_id)throws Exception;
	//根据订单id查询订单详情
	public ShoppingOrderline queryOrderlineById(@Param("order_id")int order_id) throws Exception;
	//根据订单id更新订单信息
	public void updateOrderById(ShoppingOrder order)throws Exception;
	//根据订单id更新订单详情信息
	public void updateOrderlineById(ShoppingOrderline orderline)throws Exception;
	//用户或店铺添加地址
	public void insertStoreAddress(RoleAddress address)throws Exception;
	//用户查看报表数据
	public List<ShoppingOrder> queryStoreReport(@Param("store_id")int store_id)throws Exception;
}
