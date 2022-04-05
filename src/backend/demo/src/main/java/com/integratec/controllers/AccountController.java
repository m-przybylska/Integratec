package com.integratec.controllers;

import java.util.List;

import com.integratec.model.domain.Account;
import com.integratec.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@CrossOrigin("*")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService)
    {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAccount(){
        System.out.println(accountService.getAccounts());
		return ResponseEntity.ok(accountService.getAccounts());
	}

    @PostMapping("/accounts")
    public Account postAccount(@RequestBody Account newAccount){
        return accountService.postAccount(newAccount);
    }
}
