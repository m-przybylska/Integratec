package com.integratec.services;

import com.integratec.model.domain.Request;
import com.integratec.model.repositories.RequestRepository;
import com.integratec.model.repositories.specification.RequestSpecification;
import com.integratec.model.repositories.specification.SearchCriteria;
import com.integratec.model.repositories.specification.SearchOperation;
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
    public List<Request> getRequests(String key, Object value) {
        if (key != null && value != null) {
            RequestSpecification specification = new RequestSpecification();
            specification.add(new SearchCriteria(key, value, SearchOperation.EQUAL));
            List<Request> requestList = requestRepository.findAll(specification);
            return requestList;
        } else {
            return requestRepository.findAll();
        }
    }

    public Request postRequest(Request newRequest) {
        switch(newRequest.getRequestCategory().intValue()) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                newRequest.setReceiver(1L);
                break;
            case 6:
            case 7:
            case 8:
            case 14:
            case 15:
                newRequest.setReceiver(2L);
                break;
        }
        return requestRepository.save(newRequest);
    }

    public Request updateRequest(Long requestId, Request request) {
        request.setRequestId(requestId);
        return requestRepository.save(request);
    }
}
