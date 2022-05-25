package com.integratec.repositories;

import com.integratec.model.domain.Account;
import com.integratec.model.repositories.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.constraints.Null;
import java.util.Optional;

import static org.aspectj.bridge.MessageUtil.fail;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertFalse;

@DataJpaTest
public class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;


    @Test
    public void testFindByLoginNonExistentEntity() {
        Optional<Account> account = accountRepository.findAccountByLogin("doesNotExist");
        assertFalse(account.isPresent());
    }

    @Test
    public void testFindByIdNonExistentEntity() {
        Optional<Account> account = accountRepository.findById(1L);
        assertFalse(account.isPresent());
    }

    @Test
    void findById() {
        Account account = new Account();
        account.setAccountId(1L);
        account.setLogin("Login");
        account.setPassword("Password");
        account.setSurname("Surname");
        account.setName("Name");

        account = accountRepository.save(account);

        assertThat(accountRepository.findById(account.getAccountId())).hasValue(account);

    }
    @Test
    void findByLogin() {
        Account account = new Account();
        account.setAccountId(1L);
        account.setLogin("Login");
        account.setPassword("Password");
        account.setSurname("Surname");
        account.setName("Name");

        account = accountRepository.save(account);

        assertThat(accountRepository.findAccountByLogin(account.getLogin())).hasValue(account);

    }



}
