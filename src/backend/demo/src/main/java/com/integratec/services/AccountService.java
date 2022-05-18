package com.integratec.services;

import com.integratec.model.domain.Account;
import com.integratec.model.repositories.AccountRepository;
import com.integratec.model.repositories.specification.AccountSpecification;
import com.integratec.model.repositories.specification.SearchCriteria;
import com.integratec.model.repositories.specification.SearchOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //TODO more complex filters e.g. something like this, ('and' can be repleced
    // by 'or' etc.)
    // List<Account> accounts = accountRepository
    // .findAll(Specification.where(specification1).and(specification2));

    public List<Account> getAccounts(String key, Object value) {
        if (key != null && value != null) {
            AccountSpecification specification = new AccountSpecification();
            specification.add(new SearchCriteria(key, value, SearchOperation.EQUAL));
            List<Account> accountList = accountRepository.findAll(specification);
            return accountList;
        } else {
            return accountRepository.findAll();
        }
    }

    public Account postAccount(Account newAccount) {
        return accountRepository.save(newAccount);
    }

    public Account updateAccount(Long accountId, Account account) {
        account.setAccountId(accountId);
        return accountRepository.save(account);
    }
}
