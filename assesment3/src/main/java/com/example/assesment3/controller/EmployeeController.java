package com.example.assesment3.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.assesment3.entity.Employee;
import com.example.assesment3.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employee/employee")
	public Employee saveEmployee (@Valid @RequestBody Employee employee){
		return service.saveEmployee(employee);
	}
	
	@GetMapping("/employee/list")
	public List<Employee> getAllEmployee(){
		return service.getAllEmployee();
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee getEmpployeeById(@PathVariable("employeeId") int employeeId) {
		return service.findById(employeeId);
	}

}
