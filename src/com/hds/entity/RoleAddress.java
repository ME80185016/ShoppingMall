package com.hds.entity;

/**
 * ��ɫ��ַ��ʵ����
 * @author ��
 *
 */
public class RoleAddress {
	private Integer address_id;//��ַid
	private String address_name;//��ַ����
	private String address_code;//��������
	private String linkman_name;//�û���ʵ����
	private String linkman_tel;//�û���ʵ�绰������������ϵ����
	private Integer user_id;//�����û�
	private Integer store_id;//��������
	public Integer getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}
	public String getAddress_name() {
		return address_name;
	}
	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}
	public String getAddress_code() {
		return address_code;
	}
	public void setAddress_code(String address_code) {
		this.address_code = address_code;
	}
	
	public String getLinkman_name() {
		return linkman_name;
	}
	public void setLinkman_name(String linkman_name) {
		this.linkman_name = linkman_name;
	}
	public String getLinkman_tel() {
		return linkman_tel;
	}
	public void setLinkman_tel(String linkman_tel) {
		this.linkman_tel = linkman_tel;
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
	

}
