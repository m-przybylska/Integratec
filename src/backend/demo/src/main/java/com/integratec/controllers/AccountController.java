package com.integratec.controllers;

import java.util.List;

import com.integratec.model.domain.Account;
import com.integratec.model.domain.DTO.AccountGetDto;
import com.integratec.model.domain.DTO.AccountPostDto;
import com.integratec.services.AccountService;
import mapper.MapStructMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/accounts")
@CrossOrigin("*")
public class AccountController {

    private final AccountService accountService;
    MapStructMapperImpl mapstructMapper = new MapStructMapperImpl();

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<AccountGetDto>> getAccount(String key, Object value) {
        return ResponseEntity.ok(mapstructMapper.usersToUsersGetDto(accountService.getAccounts(key, value)));
    }

    @PostMapping
    public Account postAccount(@Valid @RequestBody AccountPostDto newAccount) {
        return accountService.postAccount(mapstructMapper.userPostDtoToUser(newAccount));

    @PutMapping("/{accountId}")
    public Account updateAccount(@PathVariable("accountId") Long accountId, @RequestBody Account account) {
        return accountService.updateAccount(accountId, account);
    }
}

