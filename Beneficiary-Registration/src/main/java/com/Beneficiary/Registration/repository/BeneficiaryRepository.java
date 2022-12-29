package com.Beneficiary.Registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Beneficiary.Registration.entity.Beneficiary;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer>{
	public Beneficiary  findByaccountNumber(int accountNumber);

	
}
