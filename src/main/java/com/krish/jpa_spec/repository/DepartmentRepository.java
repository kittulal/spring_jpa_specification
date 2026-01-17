package com.krish.jpa_spec.repository;

import com.krish.jpa_spec.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository
        extends JpaRepository<Department, Long> {

    Optional<Department> findByCode(String code);
}
