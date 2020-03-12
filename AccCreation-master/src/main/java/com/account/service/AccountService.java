package com.account.service;

import java.util.List;

import com.account.entities.Account;
import com.account.entities.Customer;

public interface AccountService {
	Account createAccount(Account account);
	Account updateAccount(Account account);
	public void deleteAccountNumber(Long accountNumber);
	public List<Account> getAllAccounts();
	public List<Account>showAllAccounts(String isfc);
	Account getAccountByAccNum(Long accountNumber);
	

 
}
