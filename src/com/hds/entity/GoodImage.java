package com.hds.entity;

/**
 * ��ƷͼƬ��ʵ����
 * @author ��
 *
 */
public class GoodImage {
	private Integer image_id;//ͼƬ��id
	private String image_route;//��ƷͼƬ��·��
	//private Integer store_id;//��Ʒ�����ĵ���
	private Integer good_id;//ͼƬ��������Ʒ
	
	
	public Integer getImage_id() {
		return image_id;
	}
	public void setImage_id(Integer image_id) {
		this.image_id = image_id;
	}
	public String getImage_route() {
		return image_route;
	}
	public void setImage_route(String image_route) {
		this.image_route = image_route;
	}
	
	public Integer getGood_id() {
		return good_id;
	}
	public void setGood_id(Integer good_id) {
		this.good_id = good_id;
	}
	

}
