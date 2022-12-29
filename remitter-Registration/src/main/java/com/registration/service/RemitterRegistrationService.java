package com.registration.service;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestTemplate;

import com.registration.entity.Beneficiary;
import com.registration.entity.RemitterRegistration;
import com.registration.exception.RemitterNotFound;
import com.registration.repository.RemitterRegistrationRepository;

@Service
public class RemitterRegistrationService {

	@Autowired
	private RemitterRegistrationRepository repository;
	
	@Autowired
	RestTemplate restTemplate;
	
	private RemitterRegistration registration;
	
	public RemitterRegistration saveRemiter(RemitterRegistration registration) {
		return repository.save(registration);
	}
	
	//find by account number
	@ExceptionHandler(AccountNotFoundException.class)
	public RemitterRegistration findByaccountNumber(int accountNumber) throws AccountNotFoundException {
		RemitterRegistration registration = repository.findByaccountNumber(accountNumber);
		if(registration.getAccountNumber()==accountNumber) {
			return registration;
		}
		else {
			throw new AccountNotFoundException("Account number not found");
		}
		
	}
	
	//update record by account number
	public Boolean updateRecords(int accountNumber, double accountBalance) throws AccountNotFoundException {

		RemitterRegistration registration = findByaccountNumber(accountNumber);
		if(registration.getAccountBalance()>accountBalance) {
			registration.setAccountBalance(registration.getAccountBalance()-accountBalance);
			repository.save(registration);
			return true;
		}
		return false;
	}
	
	public Beneficiary getBeneficiaryDetails(int id) {
		Beneficiary beneficiary = restTemplate.getForObject("http://localhost:9988/Beneficiary/"+id, Beneficiary.class);
		return beneficiary;
	}
	
	@ExceptionHandler(RemitterNotFound.class)
	public List<RemitterRegistration> getAllRemitter(){
		return repository.findAll();
	}
}
