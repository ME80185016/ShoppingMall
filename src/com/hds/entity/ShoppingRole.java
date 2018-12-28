package com.hds.entity;

/**
 * 角色实体类
 * @author 离
 *
 */
public class ShoppingRole {
	private Integer role_id;//角色id
	private String role_name;//角色名称
	private String role_pwd;//角色密码
	private String role_type;//角色类型，普通用户2，店铺1，管理员0
	private String role_head;//角色头像，有默认头像
	private String role_tel;//角色注册电话，需要接收验证码
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_pwd() {
		return role_pwd;
	}
	public void setRole_pwd(String role_pwd) {
		this.role_pwd = role_pwd;
	}
	public String getRole_type() {
		return role_type;
	}
	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}
	public String getRole_head() {
		return role_head;
	}
	public void setRole_head(String role_head) {
		this.role_head = role_head;
	}
	public String getRole_tel() {
		return role_tel;
	}
	public void setRole_tel(String role_tel) {
		this.role_tel = role_tel;
	}
	
	

}
