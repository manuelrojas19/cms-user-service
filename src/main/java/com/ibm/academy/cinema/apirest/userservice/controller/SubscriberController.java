package com.ibm.academy.cinema.apirest.userservice.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/subscribers")
public class SubscriberController {


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/noHello")
    public String noHello() {
        return "hello";
    }


}
