package com.integratec.repositories;

import com.integratec.model.domain.Account;
import com.integratec.model.repositories.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.constraints.Null;
import java.util.Optional;

import static org.aspectj.bridge.MessageUtil.fail;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;

    @Test
    void findByLogin()
    {
        Account account = new Account();
        account.setAccountId(1L);
        account.setLogin("Login");
        account.setPassword("Password");
        account.setSurname("Surname");
        account.setName("Name");

        accountRepository.save(account);

        Optional<Account> byLogin = accountRepository.findAccountByLogin(account.getLogin());

        if (byLogin.isPresent())
        {
            assertThat(byLogin.get().getLogin()).isEqualTo(account.getLogin());
        }
        else
        {
            fail("Account is not present.");
        }
    }


    @Test
    void testSavingAccountWithLoginLengthEqualsMinLength()
    {
        Account account = new Account();
        account.setAccountId(1L);
        account.setLogin("Logi");
        account.setPassword("Password");
        account.setSurname("Surname");
        account.setName("Name");

        accountRepository.save(account);

        assertThat(account.getLogin()).isEqualTo("Logi");
    }

    @Test()
    void testSavingAccountWithLoginLengthBelowAboveMinLength()
    {
        try
        {
            Account account = new Account();
            account.setAccountId(1L);
            account.setLogin("Log");
            account.setPassword("Password");
            account.setSurname("Surname");
            account.setName("Name");

            accountRepository.save(account);

            assertThat(account.getLogin()).isEqualTo("Log");
        } catch (DataIntegrityViolationException e)
        {
            assertThat(e.getMessage()).startsWith("could not execute statement");
        }
    }

    @Test()
    void testSavingAccountWithLoginBeingNull()
    {
        try
        {
            Account account = new Account();
            account.setAccountId(1L);
            account.setPassword("Password");
            account.setSurname("Surname");
            account.setName("Name");

            accountRepository.save(account);

            assertThat(account.getLogin()).isEqualTo(null);
        } catch (DataIntegrityViolationException e)
        {
            assertThat(e.getMessage()).startsWith("could not execute statement");
        }
    }

    @Test()
    void testSavingAccountWithPasswordBeingNull()
    {
        try
        {
            Account account = new Account();
            account.setAccountId(1L);
            account.setLogin("Login");
            account.setSurname("Surname");
            account.setName("Name");

            accountRepository.save(account);

            assertThat(account.getPassword()).isEqualTo(null);
        } catch (DataIntegrityViolationException e)
        {
            assertThat(e.getMessage()).startsWith("could not execute statement");
        }
    }

}
