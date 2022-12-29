package com.fund.transfer.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

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

import com.fund.transfer.entity.Transaction;
import com.fund.transfer.exception.TransactionListUnavilable;
import com.fund.transfer.repository.TransactionRepository;
import com.fund.transfer.service.TransactionService;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {
	
	@InjectMocks
	private TransactionService service;

	@Mock
	private TransactionRepository repository;
	
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
	void getAllTransactionTest() throws TransactionListUnavilable {
		List<Transaction> list = repository.findAll();
		Mockito.when(repository.findAll()).thenReturn(list);
		List<Transaction> actual =  service.getAllTransaction();
		assertEquals(list, actual);
		assertEquals(list.size(), actual.size());
	}
}
