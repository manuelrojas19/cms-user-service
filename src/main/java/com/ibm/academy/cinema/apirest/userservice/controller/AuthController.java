package com.ibm.academy.cinema.apirest.userservice.controller;

import com.ibm.academy.cinema.apirest.userservice.dto.SubscriberDto;
import com.ibm.academy.cinema.apirest.userservice.entity.Subscriber;
import com.ibm.academy.cinema.apirest.userservice.entity.User;
import com.ibm.academy.cinema.apirest.userservice.mapper.UserMapper;
import com.ibm.academy.cinema.apirest.userservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public ResponseEntity<?> login() {
        return ResponseEntity.ok("login");
    }

    @GetMapping("logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok("logout");
    }

    @PostMapping("/subscribers/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SubscriberDto subscriber) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.signup(subscriber));
    }
}
