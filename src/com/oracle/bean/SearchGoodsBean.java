package com.oracle.bean;

public class SearchGoodsBean {
	private String name;
	private String sn;
	private Integer minNum;
	private Integer maxNum;
	private Double minPrice;
	private Double maxPrice;
	private Integer type;
	
	private Integer pageSize;
	private Integer currentPage;
	
	private Integer offSet;
	private Integer length;
	
	
	
	public Integer getOffSet() {
		return offSet;
	}
	public void setOffSet(Integer offSet) {
		this.offSet = offSet;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public Integer getMinNum() {
		return minNum;
	}
	public void setMinNum(Integer minNum) {
		this.minNum = minNum;
	}
	public Integer getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public SearchGoodsBean(String name, String sn, Integer minNum,
			Integer maxNum, Double minPrice, Double maxPrice, Integer type) {
		super();
		this.name = name;
		this.sn = sn;
		this.minNum = minNum;
		this.maxNum = maxNum;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.type = type;
	}
	public SearchGoodsBean() {
		super();
	}
	

}
