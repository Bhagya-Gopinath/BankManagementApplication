package com.banks.restapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banks.restapi.entity.Account;
import com.banks.restapi.repository.AccountRepo;
@Service
public class AccountServiceImplementation  implements AccountService{
	@Autowired
	AccountRepo repo;

	@Override
	public Account createAccount(Account account) {
		Account account_saved=repo.save(account);
		return account_saved;
	}

	@Override
	public Account getAccountDetailsByAccnumber(Long Accountnumber) {
		Account account=repo.findById(Accountnumber).get();
		return account;
	}

	@Override
	public List<Account> getAllAccountDetails() {
		 List<Account> allacounts= repo.findAll();
		return allacounts;
	}

	@Override
	public Account depositeAmount(Long Accountnumber, Double amount) {
		//find the current account number
		Optional<Account>account= repo.findById(Accountnumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Account accountPresent=account.get();
		Double totalBalance=accountPresent.getBalance()+amount;
		accountPresent.setBalance(totalBalance);
		repo.save(accountPresent);
				return accountPresent;
	}

	@Override
	public Account withdrawAmount(Long Accountnumber, Double amount) {
	Optional<Account>account = repo.findById(Accountnumber);
	if(account.isEmpty()) {
		throw new RuntimeException("Account is not present");
	}
	Account account_withdraw = account.get();
	Double balance = account_withdraw.getBalance()-amount;
    account_withdraw.setBalance(balance);
    repo.save(account_withdraw);
	
	return account_withdraw;
	}

	@Override
	public void closeAccount(Long Accountnumber) {
		getAccountDetailsByAccnumber(Accountnumber);
		repo.deleteById(Accountnumber);
		
	}

}
