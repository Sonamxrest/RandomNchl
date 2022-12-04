package com.xrest.nchl.specification;

import com.xrest.nchl.model.Customer;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
public class UserSpec implements Specification<Customer> {
    private final String FIRST_NAME = "firstName";
    private final String BALANCE = "balance";
    private final String property;
    private final String value;

    public UserSpec(String property, String value) {
        this.property = property;
        this.value = value;
    }

    @Override
    public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        switch (property) {
            case FIRST_NAME -> {
                return criteriaBuilder
                        .like(criteriaBuilder.lower(root.get(property)), value.toLowerCase() + "%");

            }
            case BALANCE -> {
                return criteriaBuilder.greaterThan(root.get(property), value);

            }
            default -> {
                return  null;
            }
        }
    }
}
