package com.registration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.registration.entity.RemitterRegistration;
import com.registration.repository.RemitterRegistrationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class RemitterRegistrationApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RemitterRegistrationRepository repository;
	
	@Test
	public void getAllRemitterTest() {
		List l = repository.findAll();
		assertThat(l).size().isGreaterThan(0);
	}
	
	@Test
	public void findByIdTest() {
		RemitterRegistration u = repository.findByaccountNumber(4536);
		assertEquals("Shubham", u.getFirstName());
	}
	
//	@Test
//	public void saveRemitterTest() {
//		RemitterRegistration r = new RemitterRegistration(11, "uday", "jadhav", 2233, 70000.0, "pune", "uday@g.com");
//		 repository.save(r);
//		 assertThat(r.getAccountNumber()).isEqualTo(2233);
//	}
	
}
