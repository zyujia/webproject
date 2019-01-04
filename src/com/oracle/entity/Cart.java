package com.oracle.entity;

public class Cart {
	private Integer id;
	private String image;
	private String name;
	private Double price;
	private Integer num;
	private Goods goods;
	private User user;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Cart(Integer id, String image, String name, Double price,
			Integer num, Goods goods, User user) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
		this.price = price;
		this.num = num;
		this.goods = goods;
		this.user = user;
	}
	public Cart() {
		super();
	}
	
}
