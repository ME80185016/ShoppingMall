package com.hds.entity;

/**
 * ��Ʒ����ʵ����
 * @author ��
 *
 */
public class GoodAssess {
	private Integer assess_id;//����id
	private Integer user_id;//�������������û�
	private Integer good_id;//���۵����ļ���Ʒ
	//private Integer store_id;//��Ʒ�����ĵ���
	private String assess_content;//�û����۵�����
	private String assess_time;//���۵�ʱ��
	private String good_name;//���۵���Ʒ��
	private String image_route;//���۵���ƷͼƬ
	private String user_name;//�����˵��û���
	public Integer getAssess_id() {
		return assess_id;
	}
	public void setAssess_id(Integer assess_id) {
		this.assess_id = assess_id;
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
	
	public String getAssess_content() {
		return assess_content;
	}
	public void setAssess_content(String assess_content) {
		this.assess_content = assess_content;
	}
	public String getAssess_time() {
		return assess_time;
	}
	public void setAssess_time(String assess_time) {
		this.assess_time = assess_time;
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
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	

}
