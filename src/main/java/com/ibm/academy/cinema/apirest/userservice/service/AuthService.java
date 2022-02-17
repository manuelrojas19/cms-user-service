package com.ibm.academy.cinema.apirest.userservice.service;

import com.ibm.academy.cinema.apirest.userservice.dto.UserDto;
import com.ibm.academy.cinema.apirest.userservice.entity.User;

public interface AuthService {

    UserDto signup(UserDto user);

    UserDto login(UserDto userDto);

    void logout();
}
