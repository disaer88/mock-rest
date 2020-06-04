package com.cancelpwnz.mockback.dao;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeSpecification extends BaseSpecification<Employee,EmployeeFilter> {

    @Override
    public Specification<Employee> getFilter(EmployeeFilter filter) {
        return (root, query, cb) -> {

            Specification<Employee> byName = Optional.ofNullable(filter.getName()).map(e ->
                    Specification.where(attributeLike("name", e))).orElse(null);

            Specification<Employee> dateGreater = Optional.ofNullable(filter.getStartWorkGreatThan()).map(e ->
                    Specification.where(dateGreatThanOrEqualTo("startWorkSt", e))).orElse(null);

            Specification<Employee> byAge = Optional.ofNullable(filter.getAge()).map(e ->
                    Specification.where(attributeEquals("age", e))).orElse(null);

            Specification<Employee> byMarried = Optional.ofNullable(filter.getMarried()).map(e ->
                    Specification.where(attributeEquals("married", e))).orElse(null);

            Specification<Employee> byChief = Optional.ofNullable(filter.getChiefId()).map(e ->
                    Specification.where(attributeEquals(new String[]{"chief","id"}, e))).orElse(null);

            return Specification.where(byName)
                    .and(dateGreater)
                    .and(byAge)
                    .and(byMarried)
                    .and(byChief)
                    .toPredicate(root, query, cb);
        };
    }


}
