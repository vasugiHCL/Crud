package com.account.formbean;

import com.account.entities.AccountType;

public class CreateAccCus {
	
	private String isfc;
	private double balance;
	private boolean status;
	private AccountType account;
	private String name;
	private String address;
	private String contactno;
	private String email;
	private Boolean isEligible;
	public String getIsfc() {
		return isfc;
	}
	public void setIsfc(String isfc) {
		this.isfc = isfc;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public AccountType getAccount() {
		return account;
	}
	public void setAccount(AccountType account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getIsEligible() {
		return isEligible;
	}
	public void setIsEligible(Boolean isEligible) {
		this.isEligible = isEligible;
	}
	
	
	

}
