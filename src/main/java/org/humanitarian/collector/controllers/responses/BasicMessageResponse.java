package org.humanitarian.collector.controllers.responses;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.http.HttpStatus;

public class BasicMessageResponse {
    private HttpStatus status;

    public BasicMessageResponse(HttpStatus status) {
        this.status = status;
    }

    public int getStatusCode() {
        return status.value();
    }

    public String getMessage() {
        return status.getReasonPhrase();
    }
}
