package com.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.registration.entity.Beneficiary;
import com.registration.entity.RemitterRegistration;
import com.registration.repository.RemitterRegistrationRepository;

@Service
public class RemitterRegistrationService {

	@Autowired
	private RemitterRegistrationRepository repository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public RemitterRegistration saveRemiter(RemitterRegistration registration) {
		return repository.save(registration);
	}
	
	//find by account number
	public RemitterRegistration findByaccountNumber(int accountNumber) {
		return repository.findByaccountNumber(accountNumber);
	}
	
	//update record by account number
	public Boolean updateRecords(int accountNumber, double accountBalance) {

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
	
}
