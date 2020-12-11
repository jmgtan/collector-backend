package org.humanitarian.collector.exceptions;

import org.springframework.http.HttpStatus;

public class DuplicateUserException extends BaseRestException {
    public DuplicateUserException() {
        super(HttpStatus.CONFLICT.value(), "User already exists.");
    }
}
