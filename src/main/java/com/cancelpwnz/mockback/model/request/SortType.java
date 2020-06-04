package com.cancelpwnz.mockback.model.request;

public enum SortType {

    ASC("ASC"),
    DESC("DESC");

    private String value;

    SortType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
