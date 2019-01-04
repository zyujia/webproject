package com.oracle.entity;

import java.util.Date;
import java.util.List;

public class Goods {
	private Integer id;
	private String name;
	private Integer num;
	private Double price;
	private Type type;
	private String image;
	private Date creatdate;
	private String sn;
	
	private List<Images> listImages;
	
	public List<Images> getListImages() {
		return listImages;
	}
	public void setListImages(List<Images> listImages) {
		this.listImages = listImages;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getCreatdate() {
		return creatdate;
	}
	public void setCreatdate(Date creatdate) {
		this.creatdate = creatdate;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public Goods(Integer id, String name, Integer num, Double price, Type type,
			String image, Date creatdate, String sn) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
		this.price = price;
		this.type = type;
		this.image = image;
		this.creatdate = creatdate;
		this.sn = sn;
	}
	public Goods() {
		super();
	}

	
}
