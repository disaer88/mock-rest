package com.cancelpwnz.mockback.dao;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import java.time.Instant;

public abstract class BaseSpecification<T, U> {

    private static final String wildcard = "%";
    public abstract Specification<T> getFilter(U filter);

    public Specification<T> attributeIsNull(String field){
        return (root, query, cb) -> {
            try {
                return cb.isNull(root.get(field));
            } catch (Exception e){
                return null;
            }
        };
    }

    public Specification<T> dateGreatThanOrEqualTo(String field, Instant value){
        return (root, query, cb) -> {
            try {
                if (value == null) {
                    return null;
                }
                return cb.greaterThanOrEqualTo(root.get(field), value);
            } catch (Exception e){
                return null;
            }
        };
    }

    public Specification<T> attributeEquals(String field, Object value){
        return (root, query, cb) -> {

            if(value == null) {
                return null;
            }

            return cb.equal(root.get(field), value);
        };
    }

    public Specification<T> attributeEquals(String[] fields, Object value){
        return (root, query, cb) -> {

            if(value == null) {
                return null;
            }

            Path p = null;

            for (int i = 0; i < fields.length; i++) {
                if (i == 0){
                    p = root.get(fields[i]);
                } else {
                    p = p.get(fields[i]);
                }
            }

            return cb.equal(p, value);
        };
    }

    public Specification<T> attributeLike(String field, String value) {
        return (root, query, cb) -> {

            if(value == null) {
                return null;
            }

            return cb.like(root.get(field), addWildcard(value));
        };
    }

    public Specification<T> conjunction(){
        return ((root, q, cb) -> cb.conjunction());
    }

    public String addWildcard(String value){
        return wildcard+value+wildcard;
    }

}
