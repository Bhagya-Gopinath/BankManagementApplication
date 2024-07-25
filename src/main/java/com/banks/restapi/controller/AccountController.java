package com.banks.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banks.restapi.entity.Account;
import com.banks.restapi.services.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService service;
	
	// create an account
	@PostMapping("/create")
	public Account createAccount(@RequestBody Account account) {
		Account createaccount=service.createAccount(account);
		return createaccount;
	}

	@GetMapping("/{Accountnumber}")
	public  Account getAccountDetailsByAccountNumber(@PathVariable Long Accountnumber) {
		Account account=service.getAccountDetailsByAccnumber(Accountnumber);
		return account;
	}
	@GetMapping("/getallaccounts")
	public List<Account> getAllAccountDetails(){
		List<Account> accounts=service.getAllAccountDetails();
		return accounts;
	}
	@PutMapping("/deposit/{Accountnumber}/{amount}")
	public Account depositeAmount(@PathVariable Long Accountnumber,@PathVariable Double amount) {
		Account account=service.depositeAmount(Accountnumber, amount);
		return account;
	}
	@PutMapping("/withdraw/{Accountnumber}/{amount}")
	public Account withdrawAmount(@PathVariable Long Accountnumber,@PathVariable Double amount) {
		Account account= service.withdrawAmount(Accountnumber, amount);
		return account;
	}
	@DeleteMapping("/delete/{Accountnumber}")
	public void deleteAccount(@PathVariable Long Accountnumber) {
		service.closeAccount(Accountnumber);
	}
	
}
