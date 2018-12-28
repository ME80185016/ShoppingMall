package com.hds.entity;

/**
 * 商品的余量实体类
 * @author 离
 *
 */
public class GoodMargin {
	//private Integer margin_id;//余量id
	private Integer margin_num;//商品余量
	//private Integer store_id;//商品所属的店铺
	private Integer good_id;//余量所属的商品
	
	public Integer getMargin_num() {
		return margin_num;
	}
	public void setMargin_num(Integer margin_num) {
		this.margin_num = margin_num;
	}
	
	public Integer getGood_id() {
		return good_id;
	}
	public void setGood_id(Integer good_id) {
		this.good_id = good_id;
	}
	

}
