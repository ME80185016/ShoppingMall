package com.hds.entity;

/**
 * 订单详情实体类
 * @author 离
 *
 */
public class ShoppingOrderline {
	//private Integer orderline_id;//订单详情id
	private Integer order_id;//所属订单
	private Integer address_id;//订单详情里的地址
	private Integer good_id;//订单详情里的商品
	private String order_state;//订单状态
	private Integer good_num;//购买的商品数量
	private Integer good_price;//购买的商品价格
	private String image_route;//购买的商品图片
	private String address_name;//用户地址名
	private String good_name;//商品名
	
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}
	public Integer getGood_id() {
		return good_id;
	}
	public void setGood_id(Integer good_id) {
		this.good_id = good_id;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public Integer getGood_num() {
		return good_num;
	}
	public void setGood_num(Integer good_num) {
		this.good_num = good_num;
	}
	public Integer getGood_price() {
		return good_price;
	}
	public void setGood_price(Integer good_price) {
		this.good_price = good_price;
	}
	public String getImage_route() {
		return image_route;
	}
	public void setImage_route(String image_route) {
		this.image_route = image_route;
	}
	public String getAddress_name() {
		return address_name;
	}
	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}
	public String getGood_name() {
		return good_name;
	}
	public void setGood_name(String good_name) {
		this.good_name = good_name;
	}
	

}
