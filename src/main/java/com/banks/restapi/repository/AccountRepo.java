package com.banks.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banks.restapi.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

}
