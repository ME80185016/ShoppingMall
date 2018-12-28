package com.hds.entity;

/**
 *商品价格实体类 
 * @author 离
 *
 */
public class GoodPrice {
	//private Integer price_id;//价格id
	private Integer price_num;//商品价格
	//private Integer store_id;//商品所属的店铺
	private Integer good_id;//价格所属商品
	
	public Integer getPrice_num() {
		return price_num;
	}
	public void setPrice_num(Integer price_num) {
		this.price_num = price_num;
	}
	
	public Integer getGood_id() {
		return good_id;
	}
	public void setGood_id(Integer good_id) {
		this.good_id = good_id;
	}
	

}
