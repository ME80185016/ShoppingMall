package com.hds.entity;

/**
 * ��������ʵ����
 * @author ��
 *
 */
public class ShoppingOrderline {
	//private Integer orderline_id;//��������id
	private Integer order_id;//��������
	private Integer address_id;//����������ĵ�ַ
	private Integer good_id;//�������������Ʒ
	private String order_state;//����״̬
	private Integer good_num;//�������Ʒ����
	private Integer good_price;//�������Ʒ�۸�
	private String image_route;//�������ƷͼƬ
	private String address_name;//�û���ַ��
	private String good_name;//��Ʒ��
	
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
