package com.hds.entity;

/**
 * ������ʵ����
 * @author ��
 *
 */
public class ShoppingOrder {
	private Integer order_id;//����id
	private Integer user_id;//�����������û�
	//private Integer good_id;//��ɾ��
	private Integer store_id;//���������ĵ���
	private Integer order_money;//�����ܽ��
	private String order_time;//�����Ĵ���ʱ��
	private String order_state;//����״̬
	private String user_name;//�����������û��������̷�����չʾ
	private String store_name;//���������ĵ��������û�������չʾ
	private String pay_type;//����֧����ʽ
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
