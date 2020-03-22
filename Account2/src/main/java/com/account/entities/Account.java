package com.account.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
	
	public class Account {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long accountNumber;
		private String isfc;
		private double balance;
		private boolean status;
		private AccountType account;
		
		@JsonIgnore
		@ManyToOne
		private Customer customer;
		

		public boolean isStatus() {
			return status;
		}


		public void setStatus(boolean status) {
			this.status = status;
		}


		public Customer getCustomer() {
			return customer;
		}


		public void setCustomer(Customer customer) {
			this.customer = customer;
		}


		public Long getAccountNumber() {
			return accountNumber;
		}
		

		public void setAccountNumber(Long accountNumber) {
			this.accountNumber = accountNumber;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		public AccountType getAccount() {
			return account;
		}

		public void setAccount(AccountType account) {
			this.account = account;
		}

		public String getIsfc() {
			return isfc;
		}

		public void setIsfc(String isfc) {
			this.isfc = isfc;
		}


		public Account(String isfc, double balance, boolean status, AccountType account) {
			this.isfc = isfc;
			this.balance = balance;
			this.status = status;
			this.account = account;
		}


		public Account() {
			super();
			
		}
		
		

		
	}
