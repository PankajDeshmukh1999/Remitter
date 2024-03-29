package com.Beneficiary.Registration.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Beneficiary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Bid;
	@NotBlank(message = "name not blank")
	private String name;
	private int accountNumber;
	@NotBlank(message = "transferLimit not blank")
	private String transferLimit;
	@NotBlank(message = "ifscCode not blank")
	private String ifscCode;
	@NotBlank(message = "email not blank")
	private String email;
	@NotBlank(message = "address not blank")
	private String address;
	@NotBlank(message = "accountStatus not blank")
	private String accountStatus;

	private double amount = 0.0;

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

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Beneficiary(int bid, String name, int accountNumber, String transferLimit, String ifscCode, String email,
			String address, String accountStatus, double amount) {
		super();
		Bid = bid;
		this.name = name;
		this.accountNumber = accountNumber;
		this.transferLimit = transferLimit;
		this.ifscCode = ifscCode;
		this.email = email;
		this.address = address;
		this.accountStatus = accountStatus;
		this.amount = amount;
	}

	public Beneficiary() {
		super();
	}

	@Override
	public String toString() {
		return "Beneficiary [Bid=" + Bid + ", name=" + name + ", accountNumber=" + accountNumber + ", transferLimit="
				+ transferLimit + ", ifscCode=" + ifscCode + ", email=" + email + ", address=" + address
				+ ", accountStatus=" + accountStatus + ", amount=" + amount + "]";
	}

}
