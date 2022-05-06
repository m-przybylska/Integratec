package com.integratec.controllers;

import com.integratec.model.domain.Account;
import com.integratec.model.domain.DTO.AccountGetDto;
import com.integratec.model.domain.DTO.AccountPostDto;
import com.integratec.services.AccountService;
import mapper.MapStructMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    }

    @PutMapping("/{accountId}")
    public Account updateAccount(@PathVariable("accountId") Long accountId, @RequestBody Account account) {
        return accountService.updateAccount(accountId, account);
    }
}

