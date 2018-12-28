package com.hds.entity;

/**
 * 商品的销量实体类
 * @author 离
 *
 */
public class GoodSale {
	//private Integer sale_id;//销量id
	private Integer sale_num;//商品销量
	//private Integer store_id;//商品所属店铺
	private Integer good_id;//销量所属商品
	
	public Integer getSale_num() {
		return sale_num;
	}
	public void setSale_num(Integer sale_num) {
		this.sale_num = sale_num;
	}
	
	public Integer getGood_id() {
		return good_id;
	}
	public void setGood_id(Integer good_id) {
		this.good_id = good_id;
	}
	

}
