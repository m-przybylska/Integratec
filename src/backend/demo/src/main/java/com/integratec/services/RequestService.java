package com.integratec.services;

import java.util.List;


import com.integratec.model.domain.Request;
import com.integratec.model.repositories.RequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository)
    {
        this.requestRepository= requestRepository;
    }
    
    public List<Request> getRequests(String keyword){
        if (keyword != null) {
            return requestRepository.findAll(keyword);
        }
        return requestRepository.findAll();
	}

    public Request postRequest( Request newRequest){
        return requestRepository.save(newRequest);
    }

    public Request updateRequest(Long requestId, Request request) {
        request.setRequestId(requestId);
        return requestRepository.save(request);
    }
}
