package com.hds.entity;

import java.util.List;

public class GoodInfo {
	private ShoppingGood good; 
	private GoodImage goodImage;
	private GoodMargin goodMargin;
	private GoodPrice goodPrice;
	private GoodProperties goodProperties;
	private GoodSale goodSale;
	private List<GoodAssess> goodAssesses;
	public ShoppingGood getGood() {
		return good;
	}
	public void setGood(ShoppingGood good) {
		this.good = good;
	}
	public GoodImage getGoodImage() {
		return goodImage;
	}
	public void setGoodImage(GoodImage goodImage) {
		this.goodImage = goodImage;
	}
	public GoodMargin getGoodMargin() {
		return goodMargin;
	}
	public void setGoodMargin(GoodMargin goodMargin) {
		this.goodMargin = goodMargin;
	}
	public GoodPrice getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(GoodPrice goodPrice) {
		this.goodPrice = goodPrice;
	}
	public GoodProperties getGoodProperties() {
		return goodProperties;
	}
	public void setGoodProperties(GoodProperties goodProperties) {
		this.goodProperties = goodProperties;
	}
	public GoodSale getGoodSale() {
		return goodSale;
	}
	public void setGoodSale(GoodSale goodSale) {
		this.goodSale = goodSale;
	}
	public List<GoodAssess> getGoodAssesses() {
		return goodAssesses;
	}
	public void setGoodAssesses(List<GoodAssess> goodAssesses) {
		this.goodAssesses = goodAssesses;
	}
	
	
	
}
