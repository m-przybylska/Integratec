package com.example.demo.Controllers;

import java.util.List;

import com.example.demo.domain.Account;
import com.example.demo.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService)
    {
        this.accountService = accountService;
    }

    @GetMapping
	public ResponseEntity<List<Account>> getAccount(){
        System.out.println(accountService.getAccounts());
		return ResponseEntity.ok(accountService.getAccounts());
	}
}
