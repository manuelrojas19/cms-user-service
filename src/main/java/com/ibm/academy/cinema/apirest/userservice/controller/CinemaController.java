package com.ibm.academy.cinema.apirest.userservice.controller;

import com.ibm.academy.cinema.apirest.userservice.dto.CinemaDto;
import com.ibm.academy.cinema.apirest.userservice.service.impl.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/cinemas")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CinemaDto cinemaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cinemaService.create(cinemaDto));
    }
}
