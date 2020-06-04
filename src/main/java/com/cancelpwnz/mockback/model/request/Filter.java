package com.cancelpwnz.mockback.model.request;

import java.time.Instant;
import java.util.Objects;

public class Filter {

    private String name;
    private Integer age;
    private Boolean married;
    private Instant startWorkGreatThan;
    private Long chiefId;

    public Filter() {
    }

    public Filter(String name, Integer age, Boolean married, Instant startWorkGreatThan, Long chiefId) {
        this.name = name;
        this.age = age;
        this.married = married;
        this.startWorkGreatThan = startWorkGreatThan;
        this.chiefId = chiefId;
    }

    public String getName() {
        return name;
    }

    public Filter setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Filter setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Boolean getMarried() {
        return married;
    }

    public Filter setMarried(Boolean married) {
        this.married = married;
        return this;
    }

    public Instant getStartWorkGreatThan() {
        return startWorkGreatThan;
    }

    public Filter setStartWorkGreatThan(Instant startWorkGreatThan) {
        this.startWorkGreatThan = startWorkGreatThan;
        return this;
    }

    public Long getChiefId() {
        return chiefId;
    }

    public Filter setChiefId(Long chiefId) {
        this.chiefId = chiefId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filter filter = (Filter) o;
        return Objects.equals(name, filter.name) &&
                Objects.equals(age, filter.age) &&
                Objects.equals(married, filter.married) &&
                Objects.equals(startWorkGreatThan, filter.startWorkGreatThan) &&
                Objects.equals(chiefId, filter.chiefId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, married, startWorkGreatThan, chiefId);
    }

    @Override
    public String toString() {
        return "Filter{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", married=" + married +
                ", startWorkGreatThan=" + startWorkGreatThan +
                ", chiefId=" + chiefId +
                '}';
    }
}
