package org.humanitarian.collector.controllers.responses;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.util.List;

public class PaginatedListMessageResponse<T> extends BasicMessageResponse {

    @JsonIgnore
    private Page<T> paginatedResult;

    public PaginatedListMessageResponse(HttpStatus status, Page<T> paginatedResult) {
        super(status);
        this.paginatedResult = paginatedResult;
    }

    @JsonGetter("entities")
    public List<T> getEntities() {
        return paginatedResult.getContent();
    }

    @JsonGetter("page_details")
    public PaginatedDetails<T> getPaginatedDetails() {
        return new PaginatedDetails<T>(paginatedResult);
    }
}
