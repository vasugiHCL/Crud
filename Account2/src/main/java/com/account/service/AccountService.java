package com.account.service;

import java.util.List;

import com.account.Exception.AmountLimitExceededException;
import com.account.Exception.InsufficientAmount;
import com.account.entities.Account;
import com.account.formbean.CreateAccCus;
import com.account.formbean.UpdateAcc;


public interface AccountService {
	
	
	public void addAcccount(CreateAccCus createAccCus);
	public Account updateAccount(UpdateAcc update);
	public void delete(Long accountNumber);
	
	public List<Account>getAllAccount();
	public List<Account>showAllAccounts(String isfc);
	Account getAccountByAccNum(Long accountNumber);
	
	
	
	public void fundTransfer(Long fromAccountNumber,Long toAccountNumber, double amount)
			throws AmountLimitExceededException;
	public void withdraw(Long accountNumber,double amount)throws InsufficientAmount;
	public void deposit(Long accountNumber,double amount);
	
	
	
	

}
