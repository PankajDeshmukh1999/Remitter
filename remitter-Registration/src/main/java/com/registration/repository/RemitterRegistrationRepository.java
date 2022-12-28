package com.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registration.entity.RemitterRegistration;

@Repository
public interface RemitterRegistrationRepository extends JpaRepository<RemitterRegistration, Integer> {
	public RemitterRegistration findByaccountNumber(int accountNumber);
	
//	public RemitterRegistration updateByaccountBalanceByaccountNumber (int accountNumber, int accountBalance);
}
