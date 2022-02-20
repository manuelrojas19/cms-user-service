package com.ibm.academy.cinema.apirest.userservice.exception.handler;

import com.ibm.academy.cinema.apirest.userservice.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validationErrorHandler(MethodArgumentNotValidException e) {
        Map<String, String> errorList = e.getFieldErrors()
                .stream().collect(Collectors
                        .toMap(fieldError -> fieldError.getField(), fieldError -> fieldError.getDefaultMessage()));
        log.info("Sending validationError response to the client");
        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> employeeNotFoundHandler(NotFoundException e) {
        ExceptionResponse response = ExceptionResponse.builder().message(e.getMessage()).build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ExceptionResponse> accessDeniedExceptionHandler(AccessDeniedException e) {
        log.error(e.getMessage());
        ExceptionResponse response = ExceptionResponse.builder().message(e.getMessage()).build();
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

}
