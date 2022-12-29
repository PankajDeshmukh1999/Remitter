package com.registration.controller;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.registration.entity.Beneficiary;
import com.registration.entity.RemitterRegistration;
import com.registration.exception.InvalidLogin;
import com.registration.exception.RemitterNotFound;
import com.registration.service.RemitterRegistrationService;

@RestController
@CrossOrigin(origins = "*")
public class RemitterRegistrationController {
	
	@Autowired
	private RemitterRegistrationService  service;
	
	@PostMapping("/registration/registration")
	public RemitterRegistration saveRemitter(@RequestBody RemitterRegistration registration) {
		return service.saveRemiter(registration);
	}
	
	@GetMapping("/registration/{accountNumber}")
	public RemitterRegistration findByAccountNumber(@PathVariable("accountNumber") int accountNumber) throws AccountNotFoundException {
		return service.findByaccountNumber(accountNumber);
	}
	
	@GetMapping("/registration/getAllRemitter")
	public List<RemitterRegistration> getAllData(){
		return service.getAllRemitter();
	}
	
	//update
	@PutMapping("/registration/update/{accountNumber}")//
	public ResponseEntity<Boolean>  saveUpdate(@PathVariable int accountNumber,
											   @RequestParam double accountBalance ) throws AccountNotFoundException {
		boolean update = false;
		update = service.updateRecords(accountNumber, accountBalance);
		return ResponseEntity.status(HttpStatus.OK).body(update);
	}
	
	//Get beneficiary details by id
	@GetMapping("/remitter/beneficiary/{id}")
	public Beneficiary getBeneficiaryDetails(@PathVariable("id") int id) {
		return service.getBeneficiaryDetails(id);
	}
	
}
