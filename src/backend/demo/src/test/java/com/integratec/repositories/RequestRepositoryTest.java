package com.integratec.repositories;


import com.integratec.model.domain.Account;
import com.integratec.model.domain.Request;
import com.integratec.model.repositories.RequestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

@DataJpaTest
public class RequestRepositoryTest {
    @Autowired
    RequestRepository requestRepository;

    @Test
    public void testFindByIdNonExistentEntity() {
        Optional<Request> request = requestRepository.findById(1L);
        assertFalse(request.isPresent());
    }

    @Test
    void testFindRequestById()
    {

            Request request = new Request();
            request.setRequestId(1L);
            request.setReceiver(1L);
            request.setSenderLong(1L);
            request.setTitle("title");
            request.setText("Text");
            request.setComment("comment");

            request = requestRepository.save(request);
        assertThat(requestRepository.findById(request.getRequestId())).hasValue(request);

    }
}
