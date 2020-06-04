package com.cancelpwnz.mockback.model.request;

public enum EmployeeSortFiled implements SortableFiled{

    NAME("name"),
    AGE("age"),
    MARRIED("married"),
    STARTWORK("startWorkSt");

    private String value;

    EmployeeSortFiled(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


    @Override
    public String getFieldPath() {
        return value;
    }
}
