package org.humanitarian.collector.controllers.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.humanitarian.collector.exceptions.BaseRestException;

public class ExceptionResponse {
    private int statusCode;

    private String message;

    public ExceptionResponse(BaseRestException baseRestException) {
        this.statusCode = baseRestException.getStatusCode();
        this.message = baseRestException.getMessage();
    }

    public ExceptionResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
