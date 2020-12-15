package org.humanitarian.collector.controllers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.util.Collection;
import java.util.List;

public class BasicListMessageResponse<T> extends BasicMessageResponse {

    @JsonProperty("items")
    private Collection<T> items;

    public BasicListMessageResponse(HttpStatus status, Collection<T> items) {
        super(status);
        this.items = items;
    }

    public Collection<T> getItems() {
        return items;
    }
}
