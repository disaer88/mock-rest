package com.cancelpwnz.mockback.model.request;

public class BatchDelete<T> {

    private T ids;

    public BatchDelete() {
    }

    public T getIds() {
        return ids;
    }

    public BatchDelete<T> setIds(T ids) {
        this.ids = ids;
        return this;
    }

    @Override
    public String toString() {
        return "BatchDelete{" +
                "ids=" + ids +
                '}';
    }

}
