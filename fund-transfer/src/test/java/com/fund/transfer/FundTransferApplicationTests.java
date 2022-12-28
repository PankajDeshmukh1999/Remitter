package com.fund.transfer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fund.transfer.entity.Transaction;
import com.fund.transfer.repository.TransactionRepository;

@SpringBootTest
class FundTransferApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private TransactionRepository repository;
	
	private Transaction transaction;
	
	@Test
	public void getAllTransactionTest() {
		List l = repository.findAll();
		assertThat(l).size().isGreaterThan(0);
	}
	

}
