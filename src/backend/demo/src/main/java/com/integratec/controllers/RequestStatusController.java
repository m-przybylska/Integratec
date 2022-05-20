package com.integratec.controllers;

import java.util.List;

import com.integratec.model.domain.RequestStatus;
import com.integratec.services.RequestStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/statuses")
@CrossOrigin("*")
public class RequestStatusController {

    private final RequestStatusService requestStatusService;

    @Autowired
    public RequestStatusController(RequestStatusService requestStatusService) {
        this.requestStatusService = requestStatusService;
    }

    @GetMapping
    public ResponseEntity<List<RequestStatus>> getStatus() {
        return ResponseEntity.ok(requestStatusService.getStatus());
    }

}

