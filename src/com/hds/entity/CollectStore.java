package com.hds.entity;

/**
 * �ղص��̵�ʵ����
 * @author ��
 *
 */
public class CollectStore {
	private Integer collect_id;//�ղ�id
	private Integer user_id;//�ղ��������û�
	private Integer store_id;//�û��ղصĵ���
	private String store_name;//�û��ղصĵ�������
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
