package com.example.assesment3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Employee {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	@NotBlank(message = "Name is mandatory")
	private String employeeName;

	@NotBlank
	private int salary;
	@Email
	private String email;
	@NotBlank
	private String contact;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
//	public Employee(int employeeId, String employeeName, int salary, String email, String contact) {
//		super();
//		this.employeeId = employeeId;
//		this.employeeName = employeeName;
//		this.salary = salary;
//		this.email = email;
//		this.contact = contact;
//	}

	public Employee() {
		super();
	}

	public Employee(int employeeId, @NotBlank(message = "Name not blank") String employeeName, @NotEmpty int salary,
			@NotBlank String email, @NotBlank String contact) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
		this.email = email;
		this.contact = contact;
	}

}
