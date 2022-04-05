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
    
    public List<Request> getRequests(){
		return requestRepository.findAll();
	}

    public Request postRequest( Request newRequest){
        return requestRepository.save(newRequest);
    }
}
