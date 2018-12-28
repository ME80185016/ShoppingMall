package com.hds.entity;

/**
 * 商品评价实体类
 * @author 离
 *
 */
public class GoodAssess {
	private Integer assess_id;//评价id
	private Integer user_id;//该评价所属的用户
	private Integer good_id;//评价的是哪件商品
	//private Integer store_id;//商品所属的店铺
	private String assess_content;//用户评价的内容
	private String assess_time;//评价的时间
	private String good_name;//评价的商品名
	private String image_route;//评价的商品图片
	private String user_name;//评价人的用户名
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
