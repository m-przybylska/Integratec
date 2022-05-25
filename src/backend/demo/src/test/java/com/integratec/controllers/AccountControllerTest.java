package com.integratec.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.integratec.model.domain.Account;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class AccountControllerTest {
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
        Account account1 = new Account(
                "test1",
                "test1");
        account1.setAccountId(1L);

        mockMvc.perform(put("/accounts/{accountId}")
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
        Account account1 = new Account(
                "test1",
                "test1");
        account1.setAccountId(1L);
        account1.setLogin(null);
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
