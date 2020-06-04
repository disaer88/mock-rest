package com.cancelpwnz.mockback.model.request;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class PageRequest<T extends SortableFiled> {

    @NotNull
    @Min(value = 1)
    private Integer limit;
    @NotNull
    private Integer page;
    @Valid
    private Sort<T> sort;

    public PageRequest() {
    }

    public Integer getLimit() {
        return limit;
    }

    public PageRequest setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getPage() {
        return page;
    }

    public PageRequest setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Sort<T> getSort() {
        return sort;
    }

    public PageRequest<T> setSort(Sort<T> sort) {
        this.sort = sort;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageRequest that = (PageRequest) o;
        return Objects.equals(limit, that.limit) &&
                Objects.equals(page, that.page);
    }

    @Override
    public int hashCode() {
        return Objects.hash(limit, page);
    }

    @Override
    public String toString() {
        return "PageRequest{" +
                "limit=" + limit +
                ", page=" + page +
                '}';
    }

}
