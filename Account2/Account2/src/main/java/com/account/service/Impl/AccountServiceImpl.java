package com.account.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.Exception.AccountNotFoundException;
import com.account.Exception.AmountLimitExceededException;
import com.account.Exception.InsufficientAmount;
import com.account.entities.Account;
import com.account.entities.Customer;
import com.account.entities.Transaction;
import com.account.formbean.CreateAccCus;
import com.account.formbean.UpdateAcc;
import com.account.repo.AccountRepo;
import com.account.repo.CustomerRepo;
import com.account.repo.TransactionRepo;
import com.account.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo repo;

	@Autowired
	private CustomerRepo repo1;

	@Autowired
	private TransactionRepo trepo;

	@Override
	public String addAcccount(CreateAccCus createAccCus)throws AccountNotFoundException {
		Account account = new Account(createAccCus.getIsfc(), createAccCus.getBalance(), createAccCus.isStatus(),
				createAccCus.getAccount());
		Customer cus = new Customer(createAccCus.getName(), createAccCus.getAddress(), createAccCus.getContactno(),
				createAccCus.getEmail(), createAccCus.getIsEligible());
		cus.addAccountList(account);
		repo1.save(cus);
		repo1.save(account.getCustomer());
		return "Account added successfully";

	}

	@Override
	public void fundTransfer(Long fromAccountNumber, Long toAccountNumber, double amount)
			throws AmountLimitExceededException {
		if (amount <= 500) {
			Account account = repo.findById(fromAccountNumber).orElseThrow(AccountNotFoundException::new);
			account.setBalance(account.getBalance() - amount);
			repo.save(account);
			Account acc = repo.findById(toAccountNumber).orElseThrow(AccountNotFoundException::new);
			acc.setBalance(acc.getBalance() + amount);
			repo.save(acc);
		} else {
			throw new AmountLimitExceededException();
		}

		Transaction log = new Transaction(fromAccountNumber, toAccountNumber, amount, "transfer");
		trepo.save(log);

	}

	@Override
	public void withdraw(Long accountNumber, double amount) {
		Account acc = repo.findById(accountNumber).orElseThrow(AccountNotFoundException::new);
		if ((acc.getBalance() - amount) >= 100) {
			acc.setBalance(acc.getBalance() - amount);
			repo.save(acc);
		} else {
			throw new InsufficientAmount();
		}

		Transaction log = new Transaction(accountNumber, null, amount, "withdraw");
		trepo.save(log);
	}

	@Override
	public void deposit(Long accountNumber, double amount) {
		Account acc = repo.findById(accountNumber).orElseThrow(AccountNotFoundException::new);
		acc.setBalance(acc.getBalance() + amount);
		repo.save(acc);

		Transaction log = new Transaction(accountNumber, null, amount, "deposit");
		trepo.save(log);
	}

	@Override
	public List<Account> getAllAccount() {
		return repo.findAll();
	}

	@Override
	public Account updateAccount(UpdateAcc update) {
		Account acc = repo.findById(update.getAccountNumber()).orElseThrow(AccountNotFoundException::new);
		acc.setStatus(update.isStatus());
		repo.save(acc);
		return acc;
	}

	@Override
	public void delete(Long accountNumber) {
		Account acc = repo.findById(accountNumber).orElseThrow(AccountNotFoundException::new);
		repo.delete(acc);
	}

	@Override
	public List<Account> showAllAccounts(String isfc) {
		List<Account> acc = repo.findByIsfc(isfc);
		return acc;
	}

	@Override
	public Account getAccountByAccNum(Long accountNumber) {
		Account acc = repo.findById(accountNumber).orElseThrow(AccountNotFoundException::new);
		return acc;
	}

}
