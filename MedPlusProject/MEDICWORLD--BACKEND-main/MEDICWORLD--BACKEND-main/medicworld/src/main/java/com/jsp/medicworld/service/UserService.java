package com.jsp.medicworld.service;

import java.util.List;

import com.jsp.medicworld.entity.User;

public interface UserService {
	public User save(User user);
	public User forgot(User user,int id);
	public String getmail(String usermail);
	public User updateusingemail(User user, String email);
	public List<User> getall();
	public User getObject(String usermail);
	
	
	
	public String changePwdService(String email, String password,String confirm);
	
}
