package com.integratec.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.integratec.model.domain.Account;
import com.integratec.model.domain.Role;
import com.integratec.security.AccountDetailsService;
import com.integratec.services.AccountService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = AccountController.class)
public class AccountControllerTest {

    @MockBean
    private AccountService accountService;

    @MockBean
    private AccountDetailsService accountDetailsService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;


    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .defaultRequest(get("/"))
                .apply(springSecurity())
                .build();
    }




    @Test
    @WithMockUser(username = "user", password = "password", roles = "HR_employee")
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
    @WithMockUser(username = "user", password = "password", roles = "HR_employee")
    void testPutWithValidInput() throws Exception {
        Account account1 = new Account();
        account1.setLogin("login");
        account1.setPassword("password");
        account1.setAccountId(1L);

        Set<Role> set = new HashSet<Role>();
        Role role1 = new Role(1,"HR_employee" );
        set.add((role1));
        account1.setRoles(set);

        given(accountService.updateAccount(1L,account1)).willReturn(account1);

        mockMvc.perform(put("/accounts/{accountId}", "1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(account1)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "HR_employee")
    void testGet() throws Exception {
        mockMvc.perform(get("/accounts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "HR_employee")
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
    @WithMockUser(username = "user", password = "password", roles = "HR_employee")
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
    @WithMockUser(username = "user", password = "password", roles = "HR_employee")
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
