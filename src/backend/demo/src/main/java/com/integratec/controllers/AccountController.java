package com.integratec.controllers;

import java.util.List;

import com.integratec.model.domain.Account;
import com.integratec.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@CrossOrigin("*")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAccount() {
        return ResponseEntity.ok(accountService.getAccounts());
    }

    @PostMapping
    public Account postAccount(@RequestBody Account newAccount) {
        return accountService.postAccount(newAccount);
    }

    @PutMapping("/{accountId}")
    public Account updateAccount(@PathVariable("accountId") Long accountId, @RequestBody Account account) {
        return accountService.updateAccount(accountId, account);
    }
}
