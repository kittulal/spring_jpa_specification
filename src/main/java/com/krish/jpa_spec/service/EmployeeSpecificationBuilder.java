package com.krish.jpa_spec.service;

import com.krish.jpa_spec.dto.EmployeeFilterRequest;
import com.krish.jpa_spec.entity.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecificationBuilder {

    public static Specification<Employee> build(EmployeeFilterRequest filter) {

        return Specification
                .where(EmployeeSpecifications.hasFirstName(filter.getFirstName()))
                .and(EmployeeSpecifications.hasLastName(filter.getLastName()))
                .and(EmployeeSpecifications.hasEmail(filter.getEmail()))
                .and(EmployeeSpecifications.hasStatus(filter.getStatus()))
                .and(EmployeeSpecifications.hasDepartmentName(filter.getDepartmentName()));
    }
}