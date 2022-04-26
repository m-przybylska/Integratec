package com.integratec.services;

import com.integratec.model.domain.Request;
import com.integratec.model.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RequestService {

    @Autowired
    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public List<Request> getRequests() {
        return requestRepository.findAll();
    }

    public Request postRequest(Request newRequest) {
        return requestRepository.save(newRequest);
    }

    public Request updateRequest(Long requestId, Request request) {
        request.setRequestId(requestId);
        return requestRepository.save(request);
    }
}
