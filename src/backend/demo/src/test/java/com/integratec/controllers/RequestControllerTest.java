package com.integratec.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integratec.model.domain.DTO.RequestPostDTO;
import com.integratec.model.domain.Request;
import com.integratec.services.AccountService;
import com.integratec.services.RequestService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = RequestController.class)
public class RequestControllerTest {

    @MockBean
    private RequestService requestService;

    @MockBean
    private UserDetailsService userDetailsService;

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
        Request request = new Request();
        request.setRequestId(1L);
        request.setReceiver(1L);
        request.setSenderLong(1L);
        request.setTitle("title");
        request.setText("Text");
        request.setComment("comment");

        mockMvc.perform(post("/requests")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "HR_employee")
    void testPutWithValidInput() throws Exception {
        Request request = new Request();
        request.setRequestId(1L);
        request.setReceiver(1L);
        request.setSenderLong(1L);
        request.setTitle("title");
        request.setText("Text");
        request.setComment("comment");

        mockMvc.perform(put("/requests/{requestId}", "1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "HR_employee")
    void testGet() throws Exception {
        mockMvc.perform(get("/requests")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    @WithMockUser(username = "user", password = "password", roles = "HR_employee")
    void testPostWithReceiverAboveRange() throws Exception {
        RequestPostDTO request = new RequestPostDTO();
        request.setRequestId(1L);
        request.setReceiver(99999L);
        request.setSender(1L);
        request.setTitle("title");
        request.setText("Text");
        request.setComment("comment");

        mockMvc.perform(post("/requests")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "HR_employee")
    void testPostWithSenderAboveRange() throws Exception {
        RequestPostDTO request = new RequestPostDTO();
        request.setRequestId(1L);
        request.setReceiver(1L);
         request.setSender(999999L);
        request.setTitle("title");
        request.setText("Text");
        request.setComment("comment");

        mockMvc.perform(post("/requests")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "HR_employee")
    void testPostWithTitleBelowMinSize() throws Exception {
        Request request = new Request();
        request.setRequestId(1L);
        request.setReceiver(1L);
        request.setSenderLong(1L);
        request.setTitle("t");
        request.setText("Text");
        request.setComment("comment");

        mockMvc.perform(post("/requests")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "HR_employee")
    void testPostWithTitleAboveMaxSize() throws Exception {
        Request request = new Request();
        request.setRequestId(1L);
        request.setReceiver(1L);
        request.setSenderLong(1L);
        request.setTitle("title".repeat(20));
        request.setText("Text");
        request.setComment("comment");

        mockMvc.perform(post("/requests")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "HR_employee")
    void testPostWithTextAboveMaxSize() throws Exception {
        Request request = new Request();
        request.setRequestId(1L);
        request.setReceiver(1L);
        request.setSenderLong(1L);
        request.setTitle("title");
        request.setText("t".repeat(1001));
        request.setComment("comment");

        mockMvc.perform(post("/requests")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "HR_employee")
    void testPostWithCommentAboveMaxSize() throws Exception {
        Request request = new Request();
        request.setRequestId(1L);
        request.setReceiver(1L);
        request.setSenderLong(1L);
        request.setTitle("title");
        request.setText("Text");
        request.setComment("t".repeat(501));

        mockMvc.perform(post("/requests")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}