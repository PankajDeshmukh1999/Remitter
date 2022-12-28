package com.fund.transfer.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;


@Entity
public class Transaction {
	
	@Id
	private Long transactionId;
	private int remitterAccountNumber; 
	private int beneficiaryAaccountNumber; 
	private double amount;
	private String narration;
//	private int remitterAccountBalance; 
//	private int beneficiaryAccountBalance; 
	private int responceCode;
	
//	@CreatedDate
	@CreationTimestamp
	private Date transactionDate;
	@UpdateTimestamp()
	private Date insertDate;
	@UpdateTimestamp()
	private Date updateDate;
	
	public Transaction() {
		super();
	}

	public Transaction(Long transactionId, int remitterAccountNumber, int beneficiaryAaccountNumber, double amount,
			String narration, int responceCode, Date transactionDate, Date insertDate, Date updateDate) {
		super();
		this.transactionId = transactionId;
		this.remitterAccountNumber = remitterAccountNumber;
		this.beneficiaryAaccountNumber = beneficiaryAaccountNumber;
		this.amount = amount;
		this.narration = narration;
		this.responceCode = responceCode;
		this.transactionDate = transactionDate;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public int getRemitterAccountNumber() {
		return remitterAccountNumber;
	}

	public void setRemitterAccountNumber(int remitterAccountNumber) {
		this.remitterAccountNumber = remitterAccountNumber;
	}
	
	

	public int getBeneficiaryAaccountNumber() {
		return beneficiaryAaccountNumber;
	}

	public void setBeneficiaryAaccountNumber(int beneficiaryAaccountNumber) {
		this.beneficiaryAaccountNumber = beneficiaryAaccountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

//	public int getRemitterAccountBalance() {
//		return remitterAccountBalance;
//	}
//
//	public void setRemitterAccountBalance(int remitterAccountBalance) {
//		this.remitterAccountBalance = remitterAccountBalance;
//	}
//
//	public int getBeneficiaryAccountBalance() {
//		return beneficiaryAccountBalance;
//	}
//
//	public void setBeneficiaryAccountBalance(int beneficiaryAccountBalance) {
//		this.beneficiaryAccountBalance = beneficiaryAccountBalance;
//	}

	public int getResponceCode() {
		return responceCode;
	}

	public void setResponceCode(int responceCode) {
		this.responceCode = responceCode;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", remitterAccountNumber=" + remitterAccountNumber
				+ ", BeneficiaryAaccountNumber=" + beneficiaryAaccountNumber + ", amount=" + amount + ", narration="
				+ narration + ", responceCode=" + responceCode + ", transactionDate=" + transactionDate
				+ ", insertDate=" + insertDate + ", updateDate=" + updateDate + "]";
	}
	
	

}
