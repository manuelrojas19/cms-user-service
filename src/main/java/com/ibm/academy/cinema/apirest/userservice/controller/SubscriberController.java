package com.ibm.academy.cinema.apirest.userservice.controller;

import com.ibm.academy.cinema.apirest.userservice.dto.SubscriberDto;
import com.ibm.academy.cinema.apirest.userservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/api/v1/subscribers")
public class SubscriberController {


    @PreAuthorize("hasAuthority('SUBSCRIBER')")
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


}
