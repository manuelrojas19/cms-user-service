package com.ibm.academy.cinema.apirest.userservice.controller;

import com.ibm.academy.cinema.apirest.userservice.dto.AdminDto;
import com.ibm.academy.cinema.apirest.userservice.dto.LoginRequestDto;
import com.ibm.academy.cinema.apirest.userservice.dto.SubscriberDto;
import com.ibm.academy.cinema.apirest.userservice.dto.UserDto;
import com.ibm.academy.cinema.apirest.userservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/subscribers/signup")
    public ResponseEntity<?> subscriberSignup(@Valid @RequestBody SubscriberDto subscriber) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.signup(subscriber));
    }

    @PostMapping("/admin/signup")
    public ResponseEntity<?> adminSignup(@Valid @RequestBody SubscriberDto subscriber) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.signup(subscriber));
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUBSCRIBER')")
    @GetMapping("logout")
    public ResponseEntity<?> logout() {
        authService.logout();
        return ResponseEntity.noContent().build();
    }

}
