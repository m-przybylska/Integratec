package com.integratec.services;

import com.integratec.model.domain.RequestCategory;
import com.integratec.model.repositories.RequestCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestCategoryService {

    private final RequestCategoryRepository requestCategoryRepository;

    @Autowired
    public RequestCategoryService(RequestCategoryRepository requestCategoryRepository)
    {
        this.requestCategoryRepository = requestCategoryRepository;
    }

    public List<RequestCategory> getCategory(){
        return requestCategoryRepository.findAll();
    }

}
