package com.hds.entity;
/**
 * �ղ���Ʒ��ʵ����
 * @author ��
 *
 */
public class CollectGood {
	private Integer collect_id;//�ղ�id
	private Integer user_id;//���ղ��������û�
	private Integer good_id;//���û����ղص���Ʒ
	private Integer store_id;//����Ʒ�����ĵ���
	private String good_name;//�ղص���Ʒ��
	private String image_route;//�ղص���ƷͼƬ
	public Integer getCollect_id() {
		return collect_id;
	}
	public void setCollect_id(Integer collect_id) {
		this.collect_id = collect_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getGood_id() {
		return good_id;
	}
	public void setGood_id(Integer good_id) {
		this.good_id = good_id;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public String getGood_name() {
		return good_name;
	}
	public void setGood_name(String good_name) {
		this.good_name = good_name;
	}
	public String getImage_route() {
		return image_route;
	}
	public void setImage_route(String image_route) {
		this.image_route = image_route;
	}
	
	

}
