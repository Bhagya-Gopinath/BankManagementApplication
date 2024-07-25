package com.banks.restapi.services;

import java.util.List;

import com.banks.restapi.entity.Account;

public interface AccountService {
	public Account createAccount(Account account); // to create an account
	public Account getAccountDetailsByAccnumber(Long Accountnumber); // to get account details of a accno
	public List<Account> getAllAccountDetails(); // to get all account details
	public Account depositeAmount(Long Accountnumber,Double amount ); // to deposite an amount
	public Account withdrawAmount(Long Accountnumber,Double amount); // to withdraw an amount
	public void closeAccount(Long Accountnumber); //to close an account
	
	

}
