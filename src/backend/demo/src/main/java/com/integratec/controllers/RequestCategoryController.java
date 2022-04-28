package com.integratec.controllers;

import java.util.List;

import com.integratec.model.domain.RequestCategory;
import com.integratec.services.RequestCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
public class RequestCategoryController {

    private final RequestCategoryService requestCategoryService;

    @Autowired
    public RequestCategoryController(RequestCategoryService requestCategoryService) {
        this.requestCategoryService = requestCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<RequestCategory>> getCategory() {
        return ResponseEntity.ok(requestCategoryService.getCategory());
    }

}

