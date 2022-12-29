package com.registration.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.registration.entity.RemitterRegistration;
import com.registration.repository.RemitterRegistrationRepository;

@ExtendWith(MockitoExtension.class)
public class RemitterServiceTest {
	
	@InjectMocks
	private RemitterRegistrationService service;
	
	@Mock
	private RemitterRegistrationRepository repository;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	public void createRemitterTest() {
		RemitterRegistration registration = new RemitterRegistration(11, "uday", "jadhav", 2233, 70000.0, "pune", "uday@g.com");
		Mockito.when(repository.save(registration)).thenReturn(registration);
		RemitterRegistration rg = service.saveRemiter(registration);
		assertEquals(registration, rg);
	}
	
	@Test
	public void readAllRemitterTest() {
		RemitterRegistration registration = new RemitterRegistration(11, "Sujit", "gula", 2233, 70000.0, "pune", "sujit@g.com");
		List<RemitterRegistration> list = new ArrayList<>();
		list.add(registration);
		Mockito.when(repository.findAll()).thenReturn(list);
		List<RemitterRegistration> actual =  service.getAllRemitter();
		assertEquals(list, actual);
		assertEquals(list.size(), actual.size());
		assertEquals(list.get(0), actual.get(0));
	}
	
	
}
