package com.banks.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {
	@Column(name="account_no")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Accountnumber;
	@Column(name="holder_name")
	private String account_holder;
	@Column(name="balance")
	private Double balance;
	
	//default constructor
	public Account() {
		super();

	}

// constructor using fields
	public Account(String account_holder, Double balance) {
		super();
		this.account_holder = account_holder;
		this.balance = balance;
	}

	public Long getAccountnumber() {
		return Accountnumber;
	}

	public void setAccountnumber(Long accountnumber) {
		Accountnumber = accountnumber;
	}

	public String getAccount_holder() {
		return account_holder;
	}

	public void setAccount_holder(String account_holder) {
		this.account_holder = account_holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [Accountnumber=" + Accountnumber + ", account_holder=" + account_holder + ", balance=" + balance
				+ "]";
	}
	
	
	

}
