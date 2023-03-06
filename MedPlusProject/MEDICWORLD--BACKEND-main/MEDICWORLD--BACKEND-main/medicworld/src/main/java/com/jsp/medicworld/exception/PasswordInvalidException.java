package com.jsp.medicworld.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PasswordInvalidException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resourcename;
	private String feildName;
	private Object feildValue;
	
	
	public String getResourcename() {
		return resourcename;
	}
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	public String getFeildName() {
		return feildName;
	}
	public void setFeildName(String feildName) {
		this.feildName = feildName;
	}
	public Object getFeildValue() {
		return feildValue;
	}
	public void setFeildValue(Object feildValue) {
		this.feildValue = feildValue;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public PasswordInvalidException(String resourcename, String feildName, Object feildValue) {
		super("Password Missmatched.............:-)");
		this.resourcename = resourcename;
		this.feildName = feildName;
		this.feildValue = feildValue;
	}
	
	
	
	

}
