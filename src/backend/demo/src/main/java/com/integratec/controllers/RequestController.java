package com.integratec.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.integratec.model.domain.Request;
import com.integratec.services.RequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@CrossOrigin("*")
@Validated
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
    ResponseEntity<String> postRequest(@Valid @RequestBody Request request) {
        requestService.postRequest(request);
        return ResponseEntity.ok("User is valid");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
