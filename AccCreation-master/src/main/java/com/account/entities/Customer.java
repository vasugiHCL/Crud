package com.account.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String address;
	private String city;
	private String Country;
	private String phone;
	private Boolean isEligible;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public Boolean getIsEligible() {
		return isEligible;
	}
	public void setIsEligible(Boolean isEligible) {
		this.isEligible = isEligible;
	}
	public Customer( String name, String email, String address, String city, String country, String phone,
			Boolean isEligible) {
	
		
		this.name = name;
		this.email = email;
		this.address = address;
		this.city = city;
		Country = country;
		this.phone = phone;
		this.isEligible = isEligible;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", city=" + city
				+ ", Country=" + Country + ", phone=" + phone + ", isEligible=" + isEligible + "]";
	}
	
	
	

}
