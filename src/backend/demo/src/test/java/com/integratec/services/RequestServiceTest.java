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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class RequestServiceTest {

    @Mock
    private RequestRepository requestRepository;
    @Mock
    private AutoCloseable autoCloseable;
    @Mock
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
    void testGettingRequests() {
        requestServiceTest.getRequests(null, null);
        verify(requestRepository).findAll();
    }

    @Test
    void testPostingRequest() {
        Request request = new Request();
        request.setRequestId(1L);
        request.setReceiver(2L);
        request.setSenderLong(3L);
        request.setText("text");
        request.setTitle("titel");
        request.setComment("comment");

        requestServiceTest.postRequest(request);

        ArgumentCaptor<Request> requestArgumentCaptor = ArgumentCaptor.forClass(Request.class);
        verify(requestRepository).save(requestArgumentCaptor.capture());
        Request capturedRequest = requestArgumentCaptor.getValue();
        assertThat(capturedRequest).isEqualTo(request);
    }

    @Test
    void testUpdatingRequest() {
        Request request = new Request();
        request.setRequestId(1L);
        request.setReceiver(2L);
        request.setSenderLong(3L);
        request.setText("text");
        request.setTitle("titel");
        request.setComment("comment");

        Request requestUpdate = new Request();
        requestUpdate.setRequestId(1L);
        requestUpdate.setReceiver(2L);
        requestUpdate.setText("text");
        requestUpdate.setSenderLong(3L);
        requestUpdate.setTitle("titel");
        requestUpdate.setComment("comment");

        requestServiceTest.postRequest(request);
        requestServiceTest.updateRequest(1L,requestUpdate);
        ArgumentCaptor<Request> requestArgumentCaptor = ArgumentCaptor.forClass(Request.class);
        verify(requestRepository, times(2)).save(requestArgumentCaptor.capture());
        Request capturedRequest = requestArgumentCaptor.getValue();
        assertThat(capturedRequest).isEqualTo(requestUpdate);
    }
}