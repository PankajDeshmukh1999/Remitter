package com.example.assesment3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assesment3.entity.Employee;
import com.example.assesment3.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public List<Employee> getAllEmployee(){
		return repository.findAll();
	}
	
	public Employee findById(int id) {
		return repository.findEmployeeByEmployeeId(id);
	}

}
