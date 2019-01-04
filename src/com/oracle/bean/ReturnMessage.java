package com.oracle.bean;

public class ReturnMessage<T> {
	private Integer code;
	private String message;
	private T t;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public ReturnMessage(Integer code, String message, T t) {
		super();
		this.code = code;
		this.message = message;
		this.t = t;
	}
	public ReturnMessage() {
		super();
	}
	
}
