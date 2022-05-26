package com.integratec.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.integratec.model.domain.Account;
import com.integratec.services.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = AccountController.class)
public class AccountControllerTest {

    @MockBean
    private AccountService accountService;

    @MockBean
    private UserDetailsService userDetailsService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testPostWithValidInput() throws Exception {

        Account account1 = new Account(
                "test1",
                "test1");
        account1.setAccountId(1L);

        mockMvc.perform(post("/accounts")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(account1)))
                .andExpect(status().isOk());
    }

    @Test
    void testPutWithValidInput() throws Exception {
        Account account1 = new Account();
        account1.setLogin("login");
        account1.setPassword("password");
        account1.setAccountId(1L);
        String id = "1";
        accountService.postAccount(account1);
        mockMvc.perform(put("/accounts/{accountId}", id)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(account1)))
                .andExpect(status().isOk());
    }

    @Test
    void testGet() throws Exception {
        mockMvc.perform(get("/accounts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testPostWithNullLogin() throws Exception {
        Account account1 = new Account();
        account1.setPassword("password");
        account1.setAccountId(1L);
        mockMvc.perform(post("/accounts")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(account1)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testPostWithNullPassword() throws Exception {
        Account account1 = new Account(
                "test1",
                "test1");
        account1.setAccountId(1L);
        account1.setPassword(null);
        mockMvc.perform(post("/accounts")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(account1)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testPostWithLoginBelowMinSize() throws Exception {
        Account account1 = new Account(
                "t",
                "test1");
        account1.setAccountId(1L);
        account1.setPassword(null);
        mockMvc.perform(post("/accounts")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(account1)))
                .andExpect(status().isBadRequest());
    }
}
