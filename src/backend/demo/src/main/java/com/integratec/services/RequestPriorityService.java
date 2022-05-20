package com.integratec.services;

import com.integratec.model.domain.RequestPriority;
import com.integratec.model.repositories.RequestPriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestPriorityService {

    private final RequestPriorityRepository requestPriorityRepository;

    @Autowired
    public RequestPriorityService(RequestPriorityRepository requestPriorityRepository)
    {
        this.requestPriorityRepository = requestPriorityRepository;
    }

    public List<RequestPriority> getPriority(){
        return requestPriorityRepository.findAll();
    }

}
