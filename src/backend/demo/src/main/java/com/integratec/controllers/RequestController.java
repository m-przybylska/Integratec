package com.integratec.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.integratec.model.domain.Request;
import com.integratec.services.RequestService;

import org.hibernate.annotations.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requests")
@CrossOrigin("*")
@Validated

public class RequestController {

    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public ResponseEntity<List<Request>> getRequests() {
        return ResponseEntity.ok(requestService.getRequests());
    }

    @PostMapping("/requests")
    public Request postRequests(@Valid @RequestBody Request request) {
        return requestService.postRequest(request);
    }

    @PutMapping("/{requestId}")
    public Request updateRequest(@PathVariable("requestId") Long requestId, @RequestBody Request request) {
        return requestService.updateRequest(requestId, request);
    }

}
