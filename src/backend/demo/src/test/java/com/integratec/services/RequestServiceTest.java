package com.integratec.services;

import com.integratec.model.domain.Request;
import com.integratec.model.repositories.RequestRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class RequestServiceTest {

    @Mock
    private RequestRepository requestRepository;
    private AutoCloseable autoCloseable;
    private RequestService requestServiceTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        requestServiceTest = new RequestService(requestRepository);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void getRequests() {
        //when
        requestServiceTest.getRequests();
        //then
        verify(requestRepository).findAll();
    }

    @Test
    void postRequest() {
        //given
        Request request = new Request(
                1L,
                2L,
                3L,
                "test",
                "test",
                "test");
        //when
        requestServiceTest.postRequest(request);
        //then
        ArgumentCaptor<Request> requestArgumentCaptor = ArgumentCaptor.forClass(Request.class);
        verify(requestRepository).save(requestArgumentCaptor.capture());
        Request capturedRequest = requestArgumentCaptor.getValue();
        assertThat(capturedRequest).isEqualTo(request);
    }
}