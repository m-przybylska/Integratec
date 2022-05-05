package com.integratec.services;

import com.integratec.model.domain.RequestStatus;
import com.integratec.model.repositories.RequestStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestStatusService {

    private final RequestStatusRepository requestStatusRepository;

    @Autowired
    public RequestStatusService(RequestStatusRepository requestStatusRepository)
    {
        this.requestStatusRepository = requestStatusRepository;
    }

    public List<RequestStatus> getStatus(){
        return requestStatusRepository.findAll();
    }

}
