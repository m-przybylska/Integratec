package com.integratec.controllers;

import java.util.List;

import com.integratec.model.domain.Request;
import com.integratec.services.RequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@CrossOrigin("*")
public class RequestController {

    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService)
    {
        this.requestService = requestService;
    }

    @GetMapping("/requests")
	public ResponseEntity<List<Request>> getRequests(){
        System.out.println(requestService.getRequests());
		return ResponseEntity.ok(requestService.getRequests());
	}

    @PostMapping("/requests")
    public Request postRequest(@RequestBody Request newRequest){
        return requestService.postRequest(newRequest);
    }

    @PutMapping("/requests/{requestId}")
    public Request updateReqeust(@PathVariable("requestId") Long requestId, @RequestBody Request request) {
       return requestService.updateRequest(requestId,request);
    }
}
