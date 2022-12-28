package com.Beneficiary.Registration.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "registration")
public class RemitterRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
//	@NotEmpty
	private String firstName;
//	@NotEmpty
	private String lastName;
//	@NotEmpty
	private String accountNumber;
//	@NotEmpty
	private String accountBalance;
//	@NotEmpty
	private String address;
//	@NotEmpty
	private String email;
	
//	private Beneficiary beneficiary;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RemitterRegistration(int id, String firstName, String lastName, String accountNumber, String accountBalance,
			String address, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.address = address;
		this.email = email;
	}

	public RemitterRegistration() {
		
	}

}
