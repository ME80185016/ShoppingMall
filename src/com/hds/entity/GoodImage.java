package com.hds.entity;

/**
 * 商品图片的实体类
 * @author 离
 *
 */
public class GoodImage {
	private Integer image_id;//图片的id
	private String image_route;//商品图片的路径
	//private Integer store_id;//商品所属的店铺
	private Integer good_id;//图片所属的商品
	
	
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
