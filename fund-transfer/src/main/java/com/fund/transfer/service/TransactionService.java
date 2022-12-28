package com.fund.transfer.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fund.transfer.config.ApplicationConstants;
import com.fund.transfer.entity.Beneficiary;
import com.fund.transfer.entity.RemitterRegistration;
import com.fund.transfer.entity.Transaction;
import com.fund.transfer.exception.TransferLimitInvalid;
import com.fund.transfer.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository repository;
	
	@Autowired
	RestTemplate restTemplate;
	
	//save transactions
	public Transaction saveTransaction(Transaction transactionDetails) {
		return repository.save(transactionDetails);
	}
	
	//beneficiary by account number
	public Beneficiary getBeneficiaryByAccountNumber(int BeneficiaryAaccountNumber) {
		Beneficiary beneficiary = new Beneficiary();
		return restTemplate.getForObject("http://localhost:9988/Beneficiary/accountNumber/"+beneficiary.getAccountNumber(),Beneficiary.class);
	}
	
	//remitter by account number
	public RemitterRegistration getRemitterByAccountNumber(int remitterAccountNumber) {
		RemitterRegistration registration = new RemitterRegistration();
		return 	restTemplate.getForObject("http://localhost:8899/registration/"+registration.getAccountNumber(),RemitterRegistration.class);
	}
	
	
	public List<Transaction> betweenDates(Date startDate,Date endDate){
		return repository.findByTransactionDateBetween(startDate, endDate);
	}
	
}
