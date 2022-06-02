package com.integratec.controllers;

import com.integratec.mapper.MapStructMapperImpl;
import com.integratec.model.domain.DTO.RequestGetDTO;
import com.integratec.model.domain.DTO.RequestPostDTO;
import com.integratec.model.domain.Request;
import com.integratec.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    MapStructMapperImpl mapstructMapper = new MapStructMapperImpl();

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public ResponseEntity<List<RequestGetDTO>> getRequest(String key, Object value) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("other_employee"))) {
            //reutrn z filtrami
        }
        return ResponseEntity.ok(mapstructMapper.requestsToRequestsGetDto(requestService.getRequests(key, value)));
    }

    @PostMapping
    public Request postRequest(@Valid @RequestBody RequestPostDTO newRequest) {
        return requestService.postRequest(mapstructMapper.requestPostDTO(newRequest));
    }

    @PutMapping("/{requestId}")
    public Request updateRequest(@PathVariable("requestId") Long requestId, @RequestBody RequestPostDTO request) {
        return requestService.updateRequest(requestId, mapstructMapper.requestPostDTO(request));
    }

}
