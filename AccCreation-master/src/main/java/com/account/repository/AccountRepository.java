package com.account.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.account.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{
	
	Account findByAccountNumber(Long accountNumber);
	List<Account> findByIsfc(String isfc);
	
	
}
