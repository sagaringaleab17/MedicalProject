package com.jsp.medicworld.exception;

public class UserNotFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resourcename;
	private String feildName;
	private Object feildValue;
	
	
	
	
	public UserNotFoundException(String resourcename, String feildName, Object feildValue) {
		super("User not found................");
		this.resourcename = resourcename;
		this.feildName = feildName;
		this.feildValue = feildValue;
	}
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

	
}
