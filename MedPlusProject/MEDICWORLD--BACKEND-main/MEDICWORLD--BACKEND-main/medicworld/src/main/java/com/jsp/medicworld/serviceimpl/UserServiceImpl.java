package com.jsp.medicworld.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.medicworld.dao.UserDao;
import com.jsp.medicworld.entity.User;
import com.jsp.medicworld.service.UserService;


@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserDao repo;
	
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		if(user.getPassword().equals(user.getConfirm_password()))
		{
			return repo.save(user);
		}
		else
		{
			return null;
		}
	}

	@Override
	public User forgot(User user, int id) {
		// TODO Auto-generated method stub
		if(repo.existsById(id))
		{
			if(user.getPassword().equals(user.getConfirm_password()))
			{
				return repo.save(user);
			}
		}
		return null;
	}
	
	@Override
	public String getmail(String usermail) {
		// TODO Auto-generated method stub
		String s=repo.getusermail(usermail);
		if(s!=null)
		{
			return s;
		}
		else
		{
			return null;
		}
	}


	@Override
	public User updateusingemail(User user, String email) {
		// TODO Auto-generated method stub
		String s=repo.getusermail(email);
		if(s!=null)
		{
			if(user.getPassword().equals(user.getConfirm_password()))
			{
				return repo.save(user);
			}
		}
		return null;
		
	}

	
	@Override
	public List<User> getall() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User getObject(String usermail) {
		// TODO Auto-generated method stub
		return repo.getusermaill(usermail);
	}
	
	@Override
	public String changePwdService(String email, String password, String confirm) {

		Optional<User> optionalUser = repo.findByemail(email);
		if (optionalUser.isPresent()) 
		{
			if (password.equals(confirm)) 
			{
				String valid = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,20}$";
				if (password.matches(valid)) {
					User user = optionalUser.get();
					user.setPassword(password);
					repo.save(user);
					return "Password reset successful";
				} 
				

		}
	
		}
		return null;
		}}
		
