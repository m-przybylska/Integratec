package com.integratec.controllers;

import com.integratec.model.domain.Request;
import com.integratec.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<List<Request>> getRequests(String key, Object value) {
        return ResponseEntity.ok(requestService.getRequests(key, value));
    }

    @PostMapping
    public Request postRequests(@Valid @RequestBody Request request) {
        return requestService.postRequest(request);
    }

    @PutMapping("/{requestId}")
    public Request updateRequest(@PathVariable("requestId") Long requestId, @RequestBody Request request) {
        return requestService.updateRequest(requestId, request);
    }

}
