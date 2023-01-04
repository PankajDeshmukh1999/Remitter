package com.example.assesment3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.assesment3.controller.EmployeeController;
import com.example.assesment3.entity.Employee;
import com.example.assesment3.repository.EmployeeRepository;
import com.example.assesment3.service.EmployeeService;

@SpringBootTest
class Assesment3ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private EmployeeController controller;
	
	@Test
	public void testAll() {
		List l = controller.getAllEmployee();
		assertThat(l).size().isGreaterThan(0);
	}
	
	@Test
	public void findByIdTest() {
		Employee e = repository.findEmployeeByEmployeeId(1);
		assertEquals(15000, e.getSalary());
	}

}
