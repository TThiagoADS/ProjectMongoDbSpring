package com.tthiago.ads.workshopmongo.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long timestramp;
	private Integer status;
	private String error;;
	private String message;
	private String msg;
	
	public StandardError() {
		
	}

	public StandardError(Long timestramp, Integer status, String error, String message, String msg) {
		super();
		this.timestramp = timestramp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.msg = msg;
	}

	public Long getTimestramp() {
		return timestramp;
	}

	public void setTimestramp(Long timestramp) {
		this.timestramp = timestramp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
