package com.cancelpwnz.mockback.model.request;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Sort<T extends SortableFiled> {

    @NotNull
    private SortType type;

    @NotNull
    private T field;

    public Sort() {
    }

    public Sort(SortType type, T field) {
        this.type = type;
        this.field = field;
    }

    public SortType getType() {
        return type;
    }

    public Sort<T> setType(SortType type) {
        this.type = type;
        return this;
    }

    public T getField() {
        return field;
    }

    public Sort<T> setField(T field) {
        this.field = field;
        return this;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "type=" + type +
                ", field=" + field +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sort<?> sort = (Sort<?>) o;
        return type == sort.type &&
                Objects.equals(field, sort.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, field);
    }

}
