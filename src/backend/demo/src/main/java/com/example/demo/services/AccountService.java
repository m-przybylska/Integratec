package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.*;
import com.example.demo.repositories.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts(){
		return accountRepository.findAll();
	}
}
