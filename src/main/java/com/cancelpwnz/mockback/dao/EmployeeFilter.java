package com.cancelpwnz.mockback.dao;

import java.time.Instant;

public class EmployeeFilter {

    private String name;
    private Integer age;
    private Boolean married;
    private Instant startWorkGreatThan;
    private Long chiefId;

    public EmployeeFilter() {
    }

    public String getName() {
        return name;
    }

    public EmployeeFilter setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public EmployeeFilter setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Boolean getMarried() {
        return married;
    }

    public EmployeeFilter setMarried(Boolean married) {
        this.married = married;
        return this;
    }

    public Instant getStartWorkGreatThan() {
        return startWorkGreatThan;
    }

    public EmployeeFilter setStartWorkGreatThan(Instant startWorkGreatThan) {
        this.startWorkGreatThan = startWorkGreatThan;
        return this;
    }

    public Long getChiefId() {
        return chiefId;
    }

    public EmployeeFilter setChiefId(Long chiefId) {
        this.chiefId = chiefId;
        return this;
    }

    @Override
    public String toString() {
        return "EmployeeFilter{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", married=" + married +
                ", startWorkGreatThan=" + startWorkGreatThan +
                ", chiefId=" + chiefId +
                '}';
    }
}
