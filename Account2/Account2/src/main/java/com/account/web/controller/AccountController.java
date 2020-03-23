package com.account.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.Exception.AccountNotFoundException;
import com.account.entities.Account;
import com.account.formbean.CreateAccCus;
import com.account.formbean.Depo;
import com.account.formbean.Transfer;
import com.account.formbean.UpdateAcc;
import com.account.service.AccountService;

import net.bytebuddy.implementation.bytecode.Throw;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService as;

	
	@PostMapping(value="/add")
	public ResponseEntity<String>addAccount(@RequestBody CreateAccCus create)throws AccountNotFoundException{
		String message=as.addAcccount(create);
		return new ResponseEntity<String>(message,HttpStatus.OK);
		
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<Account>update(@RequestBody UpdateAcc update){
		Account acc=as.updateAccount(update);
		return new ResponseEntity<Account>(acc,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value="/delete/{accountNumber}")
	public ResponseEntity<Void>delete(@PathVariable(name="accountNumber") Long accountNumber){
		as.delete(accountNumber);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@GetMapping(value="allacc")
	public List<Account>getAllAccount(){
		return as.getAllAccount();
	}
	
	@GetMapping(path="account/{isfc}")
	public ResponseEntity<List<Account>>getAccByIsfc(@PathVariable(name="isfc")String isfc){
		List<Account>acc=as.showAllAccounts(isfc);
		return new ResponseEntity<List<Account>>(acc,HttpStatus.OK);
	}
	
	@GetMapping(path="account/{accountNumber}")
	public ResponseEntity<Account>getAccByAccNum(@PathVariable(name="accountNumber")Long accountNumber){
		Account acc=as.getAccountByAccNum(accountNumber);
		return new ResponseEntity<Account>(acc,HttpStatus.OK);
	}
	
	
	@PutMapping(value="transfer")
	public ResponseEntity<Void>transfer(@RequestBody Transfer transfer){
		as.fundTransfer(transfer.getFromAccount(), transfer.getToAccount(), transfer.getAmount());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping(value="withdraw")
	public ResponseEntity<Void>withdraw(@RequestBody Depo depo){
		as.withdraw(depo.getAccountNumber(), depo.getAmount());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping(value="deposit")
	public ResponseEntity<Void>deposit(@RequestBody Depo depo){
		as.deposit(depo.getAccountNumber(), depo.getAmount());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
