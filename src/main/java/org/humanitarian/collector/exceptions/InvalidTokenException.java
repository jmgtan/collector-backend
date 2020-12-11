package org.humanitarian.collector.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidTokenException extends BaseRestException {
    public InvalidTokenException() {
        super(HttpStatus.UNAUTHORIZED.value(), "Authentication token is invalid.");
    }
}
