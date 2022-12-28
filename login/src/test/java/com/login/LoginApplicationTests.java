package com.login;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.login.controller.RegistrationController;
import com.login.model.User;
import com.login.repository.RegistrationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class LoginApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	 private RegistrationRepository repository;
	
	@Autowired
	private RegistrationController controller;
	
	@Test
	public void getAllDataTest() {
		List l = repository.findAll();
		assertThat(l).size().isGreaterThan(0);
	}
	
	@Test
	public void findByIdTest() {
		User u = repository.findById(37).get();
		assertEquals("deepak", u.getUsername());
	}
	

}
