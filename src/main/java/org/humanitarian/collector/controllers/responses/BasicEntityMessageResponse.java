package org.humanitarian.collector.controllers.responses;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.http.HttpStatus;

public class BasicEntityMessageResponse<T> extends BasicMessageResponse {

    private final T entity;

    public BasicEntityMessageResponse(HttpStatus status, T entity) {
        super(status);
        this.entity = entity;
    }

    @JsonGetter("entity")
    public T getEntity() {
        return entity;
    }
}
