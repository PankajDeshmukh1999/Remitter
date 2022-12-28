package com.Beneficiary.Registration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Beneficiary.Registration.entity.Beneficiary;
import com.Beneficiary.Registration.repository.BeneficiaryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class BeneficiaryRegistrationApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	private BeneficiaryRepository repository;
	
	private Beneficiary beneficiary;
	
	@Test
	public void getBeneficiaryTest() {
		List list = repository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void BeneficiaryByAccountNumberTest() {
		beneficiary= repository.findByaccountNumber(1111);
		assertEquals("abc", beneficiary.getName());
	}
	
//	@Test
//	public void saveBeneficiary() {
//		beneficiary = new Beneficiary(300, "Akash", 9098, "40000", "hdfc1234", "akash@g.com", "Latur", "Active", 0);
//		repository.save(beneficiary);
//		assertThat(beneficiary.getAccountNumber()).isEqualTo(9098);
//	}
}
