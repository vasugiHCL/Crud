package com.account.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.account.entities.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>{
	
	List<Account> findByIsfc(String isfc);

}
