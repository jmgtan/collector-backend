package org.humanitarian.collector.controllers.responses;

public enum HttpStatusResponse {
    OK_200(200, "OK");

    private final int statusCode;

    private final String message;

    HttpStatusResponse(int i, String message) {
        this.statusCode = i;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
