package com.hds.entity;

/**
 * ��Ʒ���Ե�ʵ����
 * @author ��
 *
 */
public class GoodProperties {
	//private Integer pro_id;//����id
	private String color_name;//��Ʒ��ɫ
	private String size_name;//��Ʒ�ͺŴ�С
	private String good_men;//��Ʒ����װ����Ůװ����������
	private String good_age;//��Ʒ��������Ⱥ
	private String good_topOrDown;//��Ʒ�����»�������
	private String good_season;//��Ʒ�ʺϵļ���
	private String good_type;//��Ʒ�����ͣ����������������޷�...
	private Integer good_total;//��Ʒ��������
	//private Integer store_id;//��Ʒ�����ĵ���
	private Integer good_id;//������������Ʒ
	
	public String getColor_name() {
		return color_name;
	}
	public void setColor_name(String color_name) {
		this.color_name = color_name;
	}
	public String getSize_name() {
		return size_name;
	}
	public void setSize_name(String size_name) {
		this.size_name = size_name;
	}
	public String getGood_men() {
		return good_men;
	}
	public void setGood_men(String good_men) {
		this.good_men = good_men;
	}
	public String getGood_age() {
		return good_age;
	}
	public void setGood_age(String good_age) {
		this.good_age = good_age;
	}
	public String getGood_topOrDown() {
		return good_topOrDown;
	}
	public void setGood_topOrDown(String good_topOrDown) {
		this.good_topOrDown = good_topOrDown;
	}
	public String getGood_season() {
		return good_season;
	}
	public void setGood_season(String good_season) {
		this.good_season = good_season;
	}
	public String getGood_type() {
		return good_type;
	}
	public void setGood_type(String good_type) {
		this.good_type = good_type;
	}
	public Integer getGood_total() {
		return good_total;
	}
	public void setGood_total(Integer good_total) {
		this.good_total = good_total;
	}
	
	public Integer getGood_id() {
		return good_id;
	}
	public void setGood_id(Integer good_id) {
		this.good_id = good_id;
	}
	@Override
	public String toString() {
		return "GoodProperties [color_name=" + color_name + ", size_name="
				+ size_name + ", good_men=" + good_men + ", good_age="
				+ good_age + ", good_topOrDown=" + good_topOrDown
				+ ", good_season=" + good_season + ", good_type=" + good_type
				+ ", good_total=" + good_total + ", good_id=" + good_id + "]";
	}
	

}
