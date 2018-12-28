package com.hds.entity;

/**
 * 店铺信息实体类
 * @author 离
 *
 */
public class StoreInfo {
	private Integer store_id;//店铺id
	private String linkman_name;//店铺联系人名
	private String store_state;//店铺状态
	private String store_license;//店铺营业执照照片路径
	private String store_men_image;//店主手持身份证照片路径
	private String store_image;//店铺内部照片路径
	private String store_name;//店铺名称
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	
	public String getLinkman_name() {
		return linkman_name;
	}
	public void setLinkman_name(String linkman_name) {
		this.linkman_name = linkman_name;
	}
	public String getStore_state() {
		return store_state;
	}
	public void setStore_state(String store_state) {
		this.store_state = store_state;
	}
	public String getStore_license() {
		return store_license;
	}
	public void setStore_license(String store_license) {
		this.store_license = store_license;
	}
	public String getStore_men_image() {
		return store_men_image;
	}
	public void setStore_men_image(String store_men_image) {
		this.store_men_image = store_men_image;
	}
	public String getStore_image() {
		return store_image;
	}
	public void setStore_image(String store_image) {
		this.store_image = store_image;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	

}
