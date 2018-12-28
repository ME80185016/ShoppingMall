package com.hds.entity;

/**
 * 订单的实体类
 * @author 离
 *
 */
public class ShoppingOrder {
	private Integer order_id;//订单id
	private Integer user_id;//订单所属的用户
	//private Integer good_id;//已删表
	private Integer store_id;//订单所属的店铺
	private Integer order_money;//订单总金额
	private String order_time;//订单的创建时间
	private String order_state;//订单状态
	private String user_name;//订单所属的用户名，店铺方订单展示
	private String store_name;//订单所属的店铺名，用户方订单展示
	private String pay_type;//订单支付方式
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	} 
	public Integer getOrder_money() {
		return order_money;
	}
	public void setOrder_money(Integer order_money) {
		this.order_money = order_money;
	}
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String order_time) {
		this. order_time = order_time;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	
}
