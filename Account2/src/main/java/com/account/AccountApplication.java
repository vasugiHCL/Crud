package com.account;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AccountApplication implements CommandLineRunner{
	
	

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		
		/*Account account = new Account("HG0078", 800.0, true, AccountType.savings);
		accountService.createAccount(account);*/
		
		
	}

}
