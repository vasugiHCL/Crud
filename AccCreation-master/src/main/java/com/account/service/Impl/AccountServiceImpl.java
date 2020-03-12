package com.account.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.account.entities.Account;

import com.account.repository.AccountRepository;
import com.account.service.AccountService;


@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;

	
	@Override
	public List<Account> getAllAccounts() {
		return (List<Account>) accountRepository.findAll();
	}


	@Override
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}


	@Override
	public Account updateAccount(Account account) {
		
		return accountRepository.save(account);
	}


	@Override
	public void deleteAccountNumber(Long accountNumber) {
		accountRepository.deleteById(accountNumber);
		
	}


	@Override
	public Account getAccountByAccNum(Long accountNumber) {
		Account account=accountRepository.findByAccountNumber(accountNumber);
		return account;
	}


	@Override
	public List<Account> showAllAccounts(String isfc) {
		List<Account> account=accountRepository.findByIsfc(isfc);
		return account;
	}

	

}
