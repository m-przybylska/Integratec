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
        switch(newRequest.getRequestCategory().getRequestCategory()) {
            case "kitchen":
            case "stationery":
            case "benefits":
            case "documents":
            case "trainings":
            case "time tracking & absences":
            case "internal tools":
            case "software":
            case "hardware":
            case "internal events & meetings":
            case "financial matters":
                newRequest.setReceiver(1L);
                break;
            case "recruiting":
            case "marketing":
            case "business travels":
            case "breakdowns & technical matters":
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
