package com.hds.entity;

/**
 * ��Ʒ��ʵ����
 * @author ��
 *
 */
public class ShoppingGood {
	private Integer good_id;//��Ʒid
	private String good_name;//��Ʒ����
	private Integer store_id;//��������id
	private String store_name;//����������
	public Integer getGood_id() {
		return good_id;
	}
	public void setGood_id(Integer good_id) {
		this.good_id = good_id;
	}
	public String getGood_name() {
		return good_name;
	}
	public void setGood_name(String good_name) {
		this.good_name = good_name;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	

}
