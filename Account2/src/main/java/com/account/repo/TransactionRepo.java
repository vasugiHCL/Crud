package com.account.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.account.entities.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long>{

}
