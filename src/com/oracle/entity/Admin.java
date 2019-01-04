package com.oracle.entity;

public class Admin {
	private Integer id;
	private String userName;
	private String loginName;
	private String pwd;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Admin(Integer id, String userName, String loginName, String pwd) {
		super();
		this.id = id;
		this.userName = userName;
		this.loginName = loginName;
		this.pwd = pwd;
	}
	public Admin() {
		super();
	}
	

}
