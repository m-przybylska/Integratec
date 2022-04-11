package com.integratec.services;

import com.integratec.model.domain.Request;
import com.integratec.model.repositories.RequestRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
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

    public ResponseEntity isValid(@Valid Request request, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.ok(request);
        }
    }

    public Request postRequest(@Valid Request newRequest) {
        //isValid();
        return requestRepository.save(newRequest);
    }
}
