package org.humanitarian.collector.exceptions;

public abstract class BaseRestException extends Exception {
    private int statusCode;

    public BaseRestException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}


