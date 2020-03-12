package com.account;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.account.entities.Account;
import com.account.entities.AccountType;
import com.account.entities.Customer;
import com.account.repository.AccountRepository;
import com.account.repository.CustomerRepository;
import com.account.service.AccountService;
import com.account.service.CustomerService;


//@EnableTransactionManagement
@SpringBootApplication
public class BankApplication implements CommandLineRunner {
	

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CustomerService customerService;

	@Override
	public void run(String... args) throws Exception {

		/*Customer customer = new Customer("Raj", "raj@gmail.com", "Ecity", "Bangalore", "Karnataka", "986534282", true);
		customerService.CreateCustomer(customer);*/

		Account account = new Account("HG0078", 800.0, true, AccountType.savings);
		accountService.createAccount(account);

	}

}
