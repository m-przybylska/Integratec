package com.integratec.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integratec.services.RequestCategoryService;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = RequestPriorityController.class)
public class RequestPriorityControllerTest {

    @MockBean
    private UserDetailsService userDetailsService;

    @MockBean
    private RequestPriorityController requestPriorityController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGet() throws Exception {
        mockMvc.perform(get("/priorities")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}