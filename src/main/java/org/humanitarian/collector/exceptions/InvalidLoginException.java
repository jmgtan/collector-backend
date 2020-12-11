package org.humanitarian.collector.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidLoginException extends BaseRestException {
    public InvalidLoginException() {
        super(HttpStatus.UNAUTHORIZED.value(), "Username and password not valid.");
    }
}
