package com.safetynet.alerts.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Actor Not Found")
public class NoFoundException extends RuntimeException {

    public NoFoundException(String message) {

        super(message);
    }
}