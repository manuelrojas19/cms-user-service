package com.ibm.academy.cinema.apirest.userservice.service.impl;

import com.ibm.academy.cinema.apirest.userservice.dto.CinemaDto;
import com.ibm.academy.cinema.apirest.userservice.dto.UserDto;

public interface CinemaService {
    CinemaDto create(UserDto cinemaDto);
}
