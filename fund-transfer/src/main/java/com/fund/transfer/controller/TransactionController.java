package com.fund.transfer.controller;



import java.sql.Date;


import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fund.transfer.entity.Beneficiary;
import com.fund.transfer.entity.RemitterRegistration;
import com.fund.transfer.entity.Transaction;
import com.fund.transfer.exception.TransactionListUnavilable;
import com.fund.transfer.service.TransactionService;

@RestController
@CrossOrigin(origins = "*")
public class TransactionController {

	@Autowired
	private TransactionService service;
	
	@Autowired
	RestTemplate rest;
	
	@PostMapping("/transactions/transaction")
	public Transaction fundTransfer(@RequestBody Transaction transaction) throws TransactionListUnavilable {
		transaction.setTransactionId(Math.abs(new Random().nextLong()));
		transaction.setResponceCode(000);
		
		Beneficiary beneficiary = rest.getForObject("http://localhost:9988/Beneficiary/accountNumber/"+transaction.getBeneficiaryAaccountNumber(), Beneficiary.class);
		
		System.out.println(beneficiary.getAmount());
		RemitterRegistration registration =rest.getForObject("http://localhost:8899/registration/"+transaction.getRemitterAccountNumber(), RemitterRegistration.class);

		
		if(transaction.getAmount()>0) {
			
			MultiValueMap<String, Double> body = new LinkedMultiValueMap<String, Double>();  
			body.add("amount", transaction.getAmount());
			HttpEntity<?> httpEntity = new HttpEntity<Object>(body);
			rest.exchange("http://localhost:9988/Beneficiary/updateBy/"+beneficiary.getAccountNumber(),HttpMethod.PUT,httpEntity,Boolean.class);
			
			//
			MultiValueMap<String, Double> body1 = new LinkedMultiValueMap<String, Double>();  
			body1.add("accountBalance", transaction.getAmount());
			HttpEntity<?> httpEntity1 = new HttpEntity<Object>(body1);
			rest.exchange("http://localhost:8899/registration/update/"+registration.getAccountNumber(),HttpMethod.PUT,httpEntity1,Boolean.class);
			
			transaction.setResponceCode(111);
			
			System.out.println(transaction);
			System.out.println("transaction successfull");
			return service.saveTransaction(transaction);
		}else {
		System.out.println("transaction unsuccessfull");
		return null;
		}
	}
	
	@GetMapping("transaction/{startDate}/{endDate}")
	public List<Transaction> findData(@PathVariable("startDate") Date startDate,@PathVariable("endDate") Date endDate){
		return service.betweenDates(startDate, endDate);
	}
	
	@GetMapping("/transaction/getList")
	public List<Transaction> getAllList() throws TransactionListUnavilable{
		return service.getAllTransaction();
	}
	
}
