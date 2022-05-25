package com.integratec.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integratec.model.domain.Request;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
@AutoConfigureMockMvc(addFilters = false)
public class RequestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testPostWithValidInput() throws Exception {
        Request request = new Request();
        request.setRequestId(1L);
        request.setReceiver(1L);
        request.setSenderLong(1L);
        request.setTitle("title");
        request.setText("Text");
        request.setComment("comment");

        mockMvc.perform(post("/request")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void testPutWithValidInput() throws Exception {
        Request request = new Request();
        request.setRequestId(1L);
        request.setReceiver(1L);
        request.setSenderLong(1L);
        request.setTitle("title");
        request.setText("Text");
        request.setComment("comment");

        mockMvc.perform(put("/request/{requestId}")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void testGet() throws Exception {
        mockMvc.perform(get("/request")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testPostWithNullReceiver() throws Exception {
        Request request = new Request();
        request.setRequestId(1L);
        request.setSenderLong(1L);
        request.setTitle("title");
        request.setText("Text");
        request.setComment("comment");

        mockMvc.perform(put("/request")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testPostWithReceiverAboveRange() throws Exception {
        Request request = new Request();
        request.setRequestId(1L);
        request.setReceiver(1000L);
        request.setSenderLong(1L);
        request.setTitle("title");
        request.setText("Text");
        request.setComment("comment");

        mockMvc.perform(put("/request")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testPostWithNullSenderLong() throws Exception {
        Request request = new Request();
        request.setRequestId(1L);
        request.setReceiver(1L);
        request.setTitle("title");
        request.setText("Text");
        request.setComment("comment");

        mockMvc.perform(put("/request")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testPostWithSenderLongAboveRange() throws Exception {
        Request request = new Request();
        request.setRequestId(1L);
        request.setReceiver(1L);
        request.setSenderLong(1000L);
        request.setTitle("title");
        request.setText("Text");
        request.setComment("comment");

        mockMvc.perform(put("/request")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testPostWithTitleBelowMinSize() throws Exception {
        Request request = new Request();
        request.setRequestId(1L);
        request.setReceiver(1L);
        request.setSenderLong(1L);
        request.setTitle("t");
        request.setText("Text");
        request.setComment("comment");

        mockMvc.perform(put("/request")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testPostWithTitleAboveMaxSize() throws Exception {
        Request request = new Request();
        request.setRequestId(1L);
        request.setReceiver(1L);
        request.setSenderLong(1L);
        request.setTitle("title".repeat(20));
        request.setText("Text");
        request.setComment("comment");

        mockMvc.perform(put("/request")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testPostWithTextAboveMaxSize() throws Exception {
        Request request = new Request();
        request.setRequestId(1L);
        request.setReceiver(1L);
        request.setSenderLong(1L);
        request.setTitle("title");
        request.setText("t".repeat(1001));
        request.setComment("comment");

        mockMvc.perform(put("/request")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testPostWithCommentAboveMaxSize() throws Exception {
        Request request = new Request();
        request.setRequestId(1L);
        request.setReceiver(1L);
        request.setSenderLong(1L);
        request.setTitle("title");
        request.setText("Text");
        request.setComment("t".repeat(501));

        mockMvc.perform(put("/request")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}
