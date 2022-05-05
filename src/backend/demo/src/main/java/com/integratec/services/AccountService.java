package com.integratec.services;

import java.util.List;

import com.integratec.model.domain.Account;
import com.integratec.model.repositories.AccountRepository;

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

    public Account postAccount(Account newAccount){
        return accountRepository.save(newAccount);
    }
}