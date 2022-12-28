package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.model.User;
import com.login.service.RegistrationService;
import com.registration.exception.InvalidLogin;
@RestController
@CrossOrigin(origins = "*")
public class RegistrationController {

	@Autowired
	private RegistrationService service;
	
	@PostMapping("/register/user")
	public User registerUser(@RequestBody User user) {
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;
	}
	
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmail = user.getUsername();
		String tempacc = user.getPassword();
		User u =  null;
		if(tempEmail !=null && tempacc !=null) {
			u = service.fetchUserByUsernameAndPassword(tempEmail, tempacc);
		}
		if(u == null) {
			throw new InvalidLogin("Bad credentials");
		}
		return u;
	}
}
