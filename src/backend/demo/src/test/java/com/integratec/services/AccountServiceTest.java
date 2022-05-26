package com.integratec.services;

import com.integratec.model.domain.Account;
import com.integratec.model.repositories.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private AutoCloseable autoCloseable;
    @Mock
    private AccountService accountServiceTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        accountServiceTest = new AccountService(accountRepository);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void testGettingAllAccounts() {
        accountServiceTest.getAccounts(null, null);
        verify(accountRepository).findAll();
    }


    @Test
    void testUpdatingAccount() {
        Account account1 = new Account(
                "test1",
                "test1");
        account1.setAccountId(1L);
        Account account2 = new Account(
                "test2",
                "test2");
        account2.setAccountId(1L);
        accountServiceTest.postAccount(account1);
        accountServiceTest.updateAccount(1L,account2);

        ArgumentCaptor<Account> accountArgumentCaptor = ArgumentCaptor.forClass(Account.class);
        verify(accountRepository, times(2)).save(accountArgumentCaptor.capture());
        Account capturedAccount = accountArgumentCaptor.getValue();
        assertThat(capturedAccount).isEqualTo(account2);
    }

    @Test
    void testPostingAccount() {
        Account account1 = new Account(
                "test1",
                "test1");

        accountServiceTest.postAccount(account1);

        ArgumentCaptor<Account> accountArgumentCaptor = ArgumentCaptor.forClass(Account.class);
        verify(accountRepository).save(accountArgumentCaptor.capture());
        Account capturedAccount = accountArgumentCaptor.getValue();
        assertThat(capturedAccount).isEqualTo(account1);
    }
}