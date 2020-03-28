package com.tuppl.institute.exception;

public class ServiceException  extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ServiceException(String code) {
		this.code=code;
	}

}
