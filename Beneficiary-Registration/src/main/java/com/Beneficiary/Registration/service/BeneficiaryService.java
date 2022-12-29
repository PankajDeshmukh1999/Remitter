package com.Beneficiary.Registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Beneficiary.Registration.entity.Beneficiary;
import com.Beneficiary.Registration.repository.BeneficiaryRepository;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Service
public class BeneficiaryService {
	@Autowired
	private BeneficiaryRepository repository;

	public Beneficiary saveBeneficiary(Beneficiary beneficiary) {
		return repository.save(beneficiary);
	}

	public Beneficiary getById(int bid) {
		return repository.findById(bid).get();
	}

	public Beneficiary searchByAccountNumber(int accountNumber) {
		return repository.findByaccountNumber(accountNumber);
	}

	public List<Beneficiary> getAllData() {
		return repository.findAll();
	}

	public void updateByAccountNumber(int accountNumber, Beneficiary beneficiary) throws Exception {
		if (repository.findByaccountNumber(accountNumber).getAccountNumber() == accountNumber) {
			beneficiary.setBid(repository.findByaccountNumber(accountNumber).getBid());
			repository.save(beneficiary);
		} else {
			throw new Exception("Account number not found with " + accountNumber);
		}

	}
	
	public int deleteById(int id) {
		if(repository.existsById(id)) {
		 repository.deleteById(id);
		 return 1;
		}
		else {
			return 0;
		}
	}
	
	//
	public String updateBeneficiary(int id,Beneficiary beneficiary) {
		if(repository.existsById(id)) {
			beneficiary.setBid(id);
			 repository.save(beneficiary);
			 return "Record update";
		}else {
			repository.save(beneficiary);
			return "Id not exist";
		}
		
	}
	
	public Optional<Beneficiary> findById(int id) {
		return repository.findById(id);
	}
	
	// update account balance
	@JsonDeserialize()
	public Boolean updateAmountByAccountNumber(int accountNumber, double amount) {
		Beneficiary beneficiary = searchByAccountNumber(accountNumber);
		if (!beneficiary.equals(null)) {
			double balance = beneficiary.getAmount();
			beneficiary.setAmount(amount + balance);
			repository.save(beneficiary);
			return true;
		}
		return false;
	}

}
