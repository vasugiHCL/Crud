package com.account.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.entities.Account;

import com.account.formbean.AccForm;
import com.account.formbean.AccountForm;
import com.account.service.AccountService;

@RestController
@RequestMapping(path = "/acc")
public class AccountController {
	
	@Autowired
	private AccountService as;
	
	@GetMapping(path = "account", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Account> getAllAccount() {
		return as.getAllAccounts();
	}
	
	@PostMapping(path="create")
	public ResponseEntity<Account>createAccount(@RequestBody AccountForm accForm){
		Account account=new Account(accForm.getIsfc(),accForm.getBalance(),accForm.isActive(),accForm.getAccount());
		return new ResponseEntity<Account>(as.createAccount(account), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path="update/{accountNumber}")
	public ResponseEntity<Account>updateAccount(@RequestBody AccForm accoForm,@PathVariable(name="accountNumber")Long accountNumber){
		Account account=as.getAccountByAccNum(accountNumber);
				account.setAccount(accoForm.getAccount());
				account.setBalance(accoForm.getBalance());
				account.setActive(accoForm.isActive());
				System.out.println(account);
		return new ResponseEntity<Account>(as.updateAccount(account),HttpStatus.ACCEPTED);
		
	}
	@DeleteMapping(path="delete/{accountNumber}")
	public ResponseEntity<Void>deleteAccount(@PathVariable(name="accountNumber")Long accountNumber){
		as.deleteAccountNumber(accountNumber);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path="accountByIsfc/{isfc}")
	public ResponseEntity<List<Account>>getAllAccByIsfc(@PathVariable(name="isfc")String isfc){
		List<Account> account=as.showAllAccounts(isfc);
		return new ResponseEntity<List<Account>>(account,HttpStatus.OK);
	}
	@GetMapping(path="accountByAccNum/{accountNumber}")
	public ResponseEntity<Account>getAccByAccNum(@PathVariable(name="accountNumber")Long accountNumber){
		Account account=as.getAccountByAccNum(accountNumber);
		return new ResponseEntity<Account>(account,HttpStatus.OK);
	}
	
	
}
