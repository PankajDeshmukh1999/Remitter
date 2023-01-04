package com.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.login.model.User;
import com.login.repository.RegistrationRepository;
import com.registration.exception.InvalidLogin;

@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	@ExceptionHandler(InvalidLogin.class)
	public User fetchUserByUsernameAndPassword(String username,String password) {
		return repo.findByUsernameAndPassword(username, password);
	}
}

