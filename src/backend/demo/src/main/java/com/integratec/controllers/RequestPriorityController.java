package com.integratec.controllers;

import java.util.List;

import com.integratec.model.domain.RequestPriority;
import com.integratec.services.RequestPriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/priorities")
@CrossOrigin("*")
public class RequestPriorityController {

    private final RequestPriorityService requestPriorityService;

    @Autowired
    public RequestPriorityController(RequestPriorityService requestPriorityService) {
        this.requestPriorityService = requestPriorityService;
    }

    @GetMapping
    public ResponseEntity<List<RequestPriority>> getPriority() {
        return ResponseEntity.ok(requestPriorityService.getPriority());
    }

}

