package org.humanitarian.collector.exceptions;

import org.springframework.http.HttpStatus;

public class HandlerNotFoundException extends BaseRestException {
    public HandlerNotFoundException() {
        super(HttpStatus.NOT_FOUND.value(), "Handler not found for the uploaded file.");
    }
}
