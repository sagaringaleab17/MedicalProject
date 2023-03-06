package com.jsp.medicworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.medicworld.entity.User;
import com.jsp.medicworld.exception.PasswordInvalidException;
import com.jsp.medicworld.exception.AccountNotFoundException;
import com.jsp.medicworld.exception.UserNotFoundException;
import com.jsp.medicworld.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	@Autowired
	private UserService ser;

	
	//http://localhost:save
	@PostMapping("/save")
	public ResponseEntity<User> save(@RequestBody User user) 
	{
		User udb = ser.save(user);
		if (udb != null) {
			return new ResponseEntity<User>(ser.save(user), HttpStatus.CREATED);
		} 
		else 
		{
			throw new PasswordInvalidException(null, null, udb);
		}
		
	}

	
	//http://localhost:8080/forgot/11
	@PutMapping("/forgot/{id}")
	public ResponseEntity<User> forgot(@RequestBody User user, @PathVariable int id) {
		User udb = ser.forgot(user, id);
		if (udb != null) {
			return new ResponseEntity<User>(ser.forgot(user, id), HttpStatus.OK);
		} else {
			throw new UserNotFoundException(null, null, udb);
		}

	}
	
	
	//http://localhost:8080/getbymail/sagar05@gmail.com

	@GetMapping("/getbymail/{email}")
	public ResponseEntity<User> getbymail(@PathVariable String email) 
	{
		User udb = ser.getObject(email);
		if (udb != null)
		{
			return new ResponseEntity<User>(ser.getObject(email), HttpStatus.OK);
		} 
		else 
		{
			throw new UserNotFoundException(null, null, udb);
		}

	
	}

	@GetMapping("/getusermail/{usermail}")
	public String getusermail(@PathVariable String usermail) {
		return ser.getmail(usermail);
	}

	@PutMapping("/forgott/{email}")
	public User updateusingemail(@RequestHeader User user, @PathVariable String email) 
	{
		return ser.updateusingemail(user, email);
	}

	@GetMapping("/getall")
	public List<User> getall() {
		return ser.getall();
	}
	
	@PutMapping("/resetPwswd")
	public ResponseEntity<String> toChangepwd(@RequestHeader String email, @RequestHeader String password,@RequestHeader String confirm)
			 {
		
		String updated =ser.changePwdService(email, password,confirm);
		if (updated=="updated") {
			return ResponseEntity.status(200).body(updated);
		} 
		return  ResponseEntity.status(400).body(updated);
		}

}
