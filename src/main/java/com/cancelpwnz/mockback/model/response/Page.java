package com.cancelpwnz.mockback.model.response;

import java.util.List;
import java.util.Objects;

public class Page<T> {

    private long totalElements;
    private long totalPages;
    private long number;
    private long size;
    private long numberOfElements;
    private List<T> content;

    public Page() {
    }

    public Page(long totalElements, long totalPages, long number, long size, long numberOfElements, List<T> content) {
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.number = number;
        this.size = size;
        this.numberOfElements = numberOfElements;
        this.content = content;
    }

    public List<T> getContent() {
        return content;
    }

    public Page<T> setContent(List<T> content) {
        this.content = content;
        return this;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(long numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page pageDTO = (Page) o;
        return totalElements == pageDTO.totalElements &&
                totalPages == pageDTO.totalPages &&
                number == pageDTO.number &&
                size == pageDTO.size &&
                numberOfElements == pageDTO.numberOfElements;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalElements, totalPages, number, size, numberOfElements);
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                ", number=" + number +
                ", size=" + size +
                ", numberOfElements=" + numberOfElements +
                '}';
    }

}
