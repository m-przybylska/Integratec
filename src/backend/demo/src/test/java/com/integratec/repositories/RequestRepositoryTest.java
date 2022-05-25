package com.integratec.repositories;


import com.integratec.model.domain.Account;
import com.integratec.model.domain.Request;
import com.integratec.model.repositories.RequestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

@DataJpaTest
public class RequestRepositoryTest {
    @Autowired
    RequestRepository requestRepository;

    @Test
    void testSavingRequestWithReceiverAboveMaxRange()
    {

        try
        {
            Request request = new Request();
            request.setRequestId(1L);
            request.setReceiver(1000L);
            request.setSenderLong(1L);
            request.setTitle("title");
            request.setText("Text");
            request.setComment("Comment");

            requestRepository.save(request);

        } catch (DataIntegrityViolationException e)
        {
            assertThat(e.getMessage()).startsWith("could not execute statement");
        }
    }

    @Test
    void testSavingRequestWithSenderLongBeingNull()
    {

        try
        {
            Request request = new Request();
            request.setRequestId(1L);
            request.setReceiver(1L);
            request.setTitle("title");
            request.setText("Text");
            request.setComment("Comment");

            requestRepository.save(request);

        } catch (DataIntegrityViolationException e)
        {
            assertThat(e.getMessage()).startsWith("could not execute statement");
        }
    }

    @Test
    void testSavingRequestWithSenderLongAboveMaxRange()
    {

        try
        {
            Request request = new Request();
            request.setRequestId(1L);
            request.setReceiver(1L);
            request.setSenderLong(1000L);
            request.setTitle("title");
            request.setText("Text");
            request.setComment("Comment");

            requestRepository.save(request);

        } catch (DataIntegrityViolationException e)
        {
            assertThat(e.getMessage()).startsWith("could not execute statement");
        }
    }

    @Test
    void testSavingRequestWithTitleBelowMinLenght()
    {

        try
        {
            Request request = new Request();
            request.setRequestId(1L);
            request.setReceiver(1L);
            request.setSenderLong(1L);
            request.setTitle("t");
            request.setText("Text");
            request.setComment("Comment");

            requestRepository.save(request);

        } catch (DataIntegrityViolationException e)
        {
            assertThat(e.getMessage()).startsWith("could not execute statement");
        }
    }

    @Test
    void testSavingRequestWithTitleAboveMaxLenght()
    {

        try
        {
            Request request = new Request();
            request.setRequestId(1L);
            request.setReceiver(1L);
            request.setSenderLong(1L);
            request.setTitle("A".repeat(71));
            request.setText("Text");
            request.setComment("Comment");

            requestRepository.save(request);

        } catch (DataIntegrityViolationException e)
        {
            assertThat(e.getMessage()).startsWith("could not execute statement");
        }
    }

    @Test
    void testSavingRequestWithTextAboveMaxLenght()
    {

        try
        {
            Request request = new Request();
            request.setRequestId(1L);
            request.setReceiver(1L);
            request.setSenderLong(1L);
            request.setTitle("title");
            request.setText("A".repeat(1001));
            request.setComment("Comment");

            requestRepository.save(request);

        } catch (DataIntegrityViolationException e)
        {
            assertThat(e.getMessage()).startsWith("could not execute statement");
        }
    }

    @Test
    void testSavingRequestWithCommentAboveMaxLenght()
    {

        try
        {
            Request request = new Request();
            request.setRequestId(1L);
            request.setReceiver(1L);
            request.setSenderLong(1L);
            request.setTitle("title");
            request.setText("Text");
            request.setComment("A".repeat(501));

            requestRepository.save(request);
            assertThat(request.getComment()).isEqualTo("A".repeat(501));
            fail();
        } catch (DataIntegrityViolationException e)
        {
            assertThat(e.getMessage()).startsWith("could not execute statement");
        }
    }
}
