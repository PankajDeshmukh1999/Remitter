package com.fund.transfer.repository;

import java.sql.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fund.transfer.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
//	@Query(value = "select * from transaction where transaction_date between:startDate and :endDate", nativeQuery = true)
	List<Transaction> findByTransactionDateBetween(Date startDate,Date endDate);
}
