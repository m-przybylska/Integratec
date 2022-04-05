package com.integratec.services;

import java.util.List;
import java.util.Set;


import com.integratec.model.domain.Request;
import com.integratec.model.repositories.RequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.validation.*;

@Service
public class RequestService {

    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public List<Request> getRequests() {
        return requestRepository.findAll();
    }

    private void isValid(Request request){
        Validator validator = createValidator();
        Set<ConstraintViolation<Request>> violations = validator.validate(request);
        if (violations.size() == 0) {
            return;
        } else {

        }
    }
    public static Validator createValidator() {
        Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        Validator validator = factory.getValidator();
        factory.close();
        return validator;
    }

    public Request postRequest(@Valid Request newRequest) {
        isValid(newRequest);
        return requestRepository.save(newRequest);
    }
}
