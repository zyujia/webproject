package com.oracle.entity;

public class Images {

	private Integer id;
	private String uuidName;
	private Integer goods;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUuidName() {
		return uuidName;
	}
	public void setUuidName(String uuidName) {
		this.uuidName = uuidName;
	}
	public Integer getGoods() {
		return goods;
	}
	public void setGoods(Integer goods) {
		this.goods = goods;
	}
	public Images(Integer id, String uuidName, Integer goods) {
		super();
		this.id = id;
		this.uuidName = uuidName;
		this.goods = goods;
	}
	public Images() {
		super();
	}
	
	
}
