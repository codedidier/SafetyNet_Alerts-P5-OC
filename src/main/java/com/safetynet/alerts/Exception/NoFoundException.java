package com.safetynet.alerts.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("serial")
@Slf4j
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Actor Not Found")
public class NoFoundException extends RuntimeException {

    public NoFoundException(String message) {

        super(message);
    }
}