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
import static org.mockito.Mockito.verify;

class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;
    private AutoCloseable autoCloseable;
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
    void getAccounts() {
        //when
        accountServiceTest.getAccounts();
        //then
        verify(accountRepository).findAll();
    }

    @Test
    void postAccount() {
        //given
        Account account1 = new Account(
                "test1",
                "test1");
        //when
        accountServiceTest.postAccount(account1);
        //then
        ArgumentCaptor<Account> accountArgumentCaptor = ArgumentCaptor.forClass(Account.class);
        verify(accountRepository).save(accountArgumentCaptor.capture());
        Account capturedAccount = accountArgumentCaptor.getValue();
        assertThat(capturedAccount).isEqualTo(account1);
    }
}