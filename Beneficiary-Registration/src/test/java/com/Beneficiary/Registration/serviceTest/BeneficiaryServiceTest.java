package com.Beneficiary.Registration.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Beneficiary.Registration.entity.Beneficiary;
import com.Beneficiary.Registration.repository.BeneficiaryRepository;
import com.Beneficiary.Registration.service.BeneficiaryService;

@ExtendWith(MockitoExtension.class)
public class BeneficiaryServiceTest {

	@InjectMocks
	private BeneficiaryService service;
	
	@Mock
	private BeneficiaryRepository repository;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void createBeneficiary() {
		Beneficiary beneficiary = new Beneficiary(300, "Akash", 9098, "40000", "hdfc1234", "akash@g.com", "Latur", "Active", 0);
		Mockito.when(repository.save(beneficiary)).thenReturn(beneficiary);
		Beneficiary rg = service.saveBeneficiary(beneficiary);
		assertEquals(beneficiary, rg);
	}
	
	@Test
	public void readAllBeneficiaryTest() {
		Beneficiary beneficiary = new Beneficiary(300, "Akash", 9098, "40000", "hdfc1234", "akash@g.com", "Latur", "Active", 0);
		List<Beneficiary> list = new ArrayList<>();
		list.add(beneficiary);
		Mockito.when(repository.findAll()).thenReturn(list);
		List<Beneficiary> actual =  service.getAllData();
		assertEquals(list, actual);
		assertEquals(list.size(), actual.size());
		assertEquals(list.get(0), actual.get(0));
	}
	
	@Test
	void getByIdTest() {
		Beneficiary beneficiary = new Beneficiary(300, "Akash", 9098, "40000", "hdfc1234", "akash@g.com", "Latur", "Active", 0);
		Optional<Beneficiary> list = Optional.of(beneficiary);
		Mockito.when(repository.findById(31)).thenReturn(list);
		Optional<Beneficiary> actual= service.findById(31);
		Beneficiary actualBeneficiary = actual.get();
		assertEquals(beneficiary.getBid(), actualBeneficiary.getBid());
		assertEquals(beneficiary.getName(), actualBeneficiary.getName());
		assertEquals(beneficiary.getAccountNumber(), actualBeneficiary.getAccountNumber());
	}
	
}
