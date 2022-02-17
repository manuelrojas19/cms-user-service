package com.ibm.academy.cinema.apirest.userservice.service.impl;

import com.ibm.academy.cinema.apirest.userservice.dto.UserDto;
import com.ibm.academy.cinema.apirest.userservice.entity.User;
import com.ibm.academy.cinema.apirest.userservice.mapper.UserMapper;
import com.ibm.academy.cinema.apirest.userservice.repository.UserRepository;
import com.ibm.academy.cinema.apirest.userservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto signup(UserDto userDto) {

        User user = userMapper.toEntity(userDto);

        if (userRepository.existsByEmail(user.getEmail()) || userRepository.existsByUsername(user.getUsername()))
            throw new RuntimeException("Conflict");

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto login(UserDto userDto) {
        return null;
    }

    @Override
    public void logout() {

    }
}
