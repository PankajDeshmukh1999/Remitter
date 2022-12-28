package com.Beneficiary.Registration.controller;

import java.util.List;

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

import com.Beneficiary.Registration.entity.Beneficiary;
import com.Beneficiary.Registration.service.BeneficiaryService;

@RestController
@CrossOrigin(origins = "*")
public class BeneficiaryController {

	@Autowired
	private BeneficiaryService service;
	
	@PostMapping("/Beneficiary/Beneficiary")
	public Beneficiary saveBeneficiary(@RequestBody Beneficiary beneficiary) {
		return service.saveBeneficiary(beneficiary);
	}
	
	@GetMapping("/Beneficiary/{id}")
	public Beneficiary getById(@PathVariable("id") int bid) {
		return service.getById(bid);
	}
	
	@GetMapping("/Beneficiary/getList")
	public List<Beneficiary >getAllList(){
		return service.getAllData();
	}
	
	@GetMapping("/Beneficiary/accountNumber/{accountNumber}")
	public Beneficiary getByAccountNumber(@PathVariable("accountNumber") int accountNumber) {
		return service.searchByAccountNumber(accountNumber);
	}
	
	@PutMapping("/Beneficiary/update/{accountNumber}")
	public ResponseEntity<String> updateByAccountNumber(@PathVariable("accountNumber")int accountNumber, @RequestBody Beneficiary beneficiary ) throws Exception{
		service.updateByAccountNumber(accountNumber, beneficiary);
		return ResponseEntity.ok("Data updated");
	}
	
	//
	@PutMapping("/Beneficiary/updateBy/{accountNumber}")
	public ResponseEntity<Boolean> updateAmount(@PathVariable int accountNumber,@RequestParam double amount ){
		
		boolean creadit =service.updateAmountByAccountNumber(accountNumber, amount);
		return ResponseEntity.status(HttpStatus.OK).body(creadit);
	}
	
	
}
