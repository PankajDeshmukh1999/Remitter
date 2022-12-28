package com.registration.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "beneficiary")
public class Beneficiary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Bid;
//	@NotEmpty
	private String name;
//	@NotEmpty
	private String accountNumber;
//	@NotEmpty
	private String transferLimit;
//	@NotEmpty
	private String ifscCode;
//	@NotEmpty
	private String email;
//	@NotEmpty
	private String address;
//	@NotEmpty
	private String accountStatus;
	
	@ManyToOne
	@JsonIgnoreProperties
	private RemitterRegistration registration;
	
	public Beneficiary(int bid, String name, String accountNumber, String transferLimit, String ifscCode, String email,
			String address, String accountStatus, RemitterRegistration registration) {
		super();
		Bid = bid;
		this.name = name;
		this.accountNumber = accountNumber;
		this.transferLimit = transferLimit;
		this.ifscCode = ifscCode;
		this.email = email;
		this.address = address;
		this.accountStatus = accountStatus;
		this.registration = registration;
	}
	public RemitterRegistration getRegistration() {
		return registration;
	}
	public void setRegistration(RemitterRegistration registration) {
		this.registration = registration;
	}
	public int getBid() {
		return Bid;
	}
	public void setBid(int bid) {
		Bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getTransferLimit() {
		return transferLimit;
	}
	public void setTransferLimit(String transferLimit) {
		this.transferLimit = transferLimit;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public Beneficiary() {
	}
	
	
}
