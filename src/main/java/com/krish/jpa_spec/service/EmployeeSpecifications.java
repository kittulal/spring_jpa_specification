package com.krish.jpa_spec.service;

import com.krish.jpa_spec.entity.Department;
import com.krish.jpa_spec.entity.Employee;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;

public class EmployeeSpecifications {

    public static Specification<Employee> hasFirstName(String firstName) {
        return (root, query, cb) ->
                firstName == null || firstName.isBlank()
                        ? null
                        : cb.equal(
                        cb.lower(root.get("firstName")),
                        firstName.toLowerCase()
                );
    }

    public static Specification<Employee> hasLastName(String lastName) {
        return (root, query, cb) ->
                lastName == null || lastName.isBlank()
                        ? null
                        : cb.like(
                        cb.lower(root.get("lastName")),
                        "%" + lastName.toLowerCase() + "%"
                );
    }

    public static Specification<Employee> hasEmail(String email) {
        return (root, query, cb) ->
                email == null || email.isBlank()
                        ? null
                        : cb.equal(
                        cb.lower(root.get("email")),
                        email.toLowerCase()
                );
    }

    public static Specification<Employee> hasStatus(String status) {
        return (root, query, cb) ->
                status == null || status.isBlank()
                        ? null
                        : cb.equal(root.get("status"), status);
    }

    public static Specification<Employee> hasDepartmentName(String departmentName) {
        return (root, query, cb) -> {
            if (departmentName == null || departmentName.isBlank()) {
                return null;
            }

            Join<Employee, Department> department =
                    root.join("department", JoinType.INNER);

            return cb.like(
                    cb.lower(department.get("name")),
                    "%" + departmentName.toLowerCase() + "%"
            );
        };
    }
}
