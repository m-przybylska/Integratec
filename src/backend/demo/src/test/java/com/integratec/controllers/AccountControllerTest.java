package com.integratec.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.integratec.model.domain.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    // @MockBean
//    // private RegisterUseCase registerUseCase;

    @Test
    void whenValidInput_thenReturns200() throws Exception {
//        Account account1 = new Account(
//                "test1",
//                "test1");
//        account1.setAccountId(1L);
//
//        mockMvc.perform(post("/accounts", 42L)
//                        .contentType("application/json")
//                        .content(objectMapper.writeValueAsString(account1)))
//                .andExpect(status().isOk());
    }
}
