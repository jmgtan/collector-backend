package org.humanitarian.collector.controllers.responses;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.Page;

public class PaginatedDetails<T> {

    @JsonIgnore
    private Page<T> page;

    public PaginatedDetails(Page<T> page) {
        this.page = page;
    }

    @JsonGetter("total_pages")
    public int getTotalPages() {
        return page.getTotalPages();
    }

    @JsonGetter("first_page")
    public boolean isFirstPage() {
        return page.isFirst();
    }

    @JsonGetter("last_page")
    public boolean isLastPage() {
        return page.isLast();
    }

    @JsonGetter("next")
    public boolean hasNext() {
        return page.hasNext();
    }

    @JsonGetter("previous")
    public boolean hasPrevious() {
        return page.hasPrevious();
    }
}
