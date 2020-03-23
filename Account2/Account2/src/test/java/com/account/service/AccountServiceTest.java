package com.account.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.account.entities.Account;
import com.account.entities.AccountType;
import com.account.entities.Customer;
import com.account.formbean.CreateAccCus;
import com.account.formbean.Response;
import com.account.repo.AccountRepo;
import com.account.repo.CustomerRepo;
import com.account.service.Impl.AccountServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountServiceTest {
	
	@Mock
	AccountRepo accRepo;
	CustomerRepo cusRepo;
	
	@Mock
	AccountService accSer;
	
	@InjectMocks
	AccountServiceImpl accSerImpl;
	
	Account acc=new Account();
	AccountType ac=null;
	CreateAccCus cus=null;
	Response res=null;
	Customer cs=null;
	
	
	@Before
	public void before() {
		
	}
	
	@Test
	public void addAccountTest() {
		acc.setAccountNumber(1L);
		acc.setAccount(ac.current);
		acc.setBalance(100.0);
		acc.setIsfc("HS098");
		acc.setStatus(true);
		acc.setCustomer(cs);
		cs=new Customer();
		cs.setName("vasu");
		cs.setEmail("vasu@gmail.com");
		cs.setCustomerId(1L);
		cs.setAddress("Delhi");
		cs.setIsEligible(true);	
		acc.setCustomer(cs);
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
		
	Mockito.when(accRepo.findById(1L)).thenReturn(Optional.of(acc));
	Mockito.when(cusRepo.findById(1L)).thenReturn(Optional.of(cs));
	Mockito.when(accRepo.save(acc)).thenReturn(acc);
	Mockito.when(cusRepo.save(cs)).thenReturn(cs);
		String response=accSerImpl.addAcccount(cus);
		assertEquals("account added", response);
	}


}
