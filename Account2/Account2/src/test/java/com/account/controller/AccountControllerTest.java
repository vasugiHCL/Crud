package com.account.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.account.Exception.AccountNotFoundException;
import com.account.entities.Account;
import com.account.entities.AccountType;
import com.account.entities.Customer;
import com.account.formbean.CreateAccCus;
import com.account.formbean.Response;
import com.account.formbean.UpdateAcc;
import com.account.service.AccountService;
import com.account.web.controller.AccountController;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {
	
	@Mock
	AccountService accountService;
	
	@InjectMocks
	AccountController accountController;
	
	
	CreateAccCus cus=null;
	Account acc=null;
	AccountType ac=null;
	Customer cs=null;
	Response res=null;
	UpdateAcc up=null;
	
	@Before
	public void before() {
		/*cs=new Customer();
		cs.setName("vasu");
		cs.setEmail("vasu@gmail.com");
		cs.setCustomerId(1L);
		cs.setAddress("Delhi");
		cs.setIsEligible(true);	
		acc=new Account();
		acc.setAccount(ac.current);
		acc.setAccountNumber(1L);
		acc.setBalance(100.0);
		acc.setIsfc("HS098");
		acc.setStatus(true);
		acc.setCustomer(cs);*/
		cus=new CreateAccCus();
		cus.setAccount(ac.current);
		cus.setAddress("Delhi");
		cus.setBalance(100.0);
		cus.setContactno("763280983");
		cus.setEmail("test@gmail.com");
		cus.setIsEligible(true);
		cus.setIsfc("HS0098");
		cus.setName("test");
		cus.setStatus(true);
		res=new Response();
		res.setMessage("added successfully");
		res.setStatusCode(200);
			
	}
	
	@Test
	public void addAccountTest() {
		String message="account added successfully";
		Mockito.when(accountService.addAcccount(cus)).thenReturn(message);
		ResponseEntity<String> response=accountController.addAccount(cus);
		assertEquals(message, response.getBody());
		
	}
	
	
	
}


