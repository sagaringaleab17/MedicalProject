package com.jsp.medicworld.exception;

public class TaskFailedException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public TaskFailedException(String resourcename, String feildName, Object feildValue) {
		super("Task Failed...............");
		this.resourcename = resourcename;
		this.feildName = feildName;
		this.feildValue = feildValue;
	}
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
	
	

}
