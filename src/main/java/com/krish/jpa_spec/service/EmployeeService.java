package com.krish.jpa_spec.service;

import com.krish.jpa_spec.dto.EmployeeCreateRequest;
import com.krish.jpa_spec.dto.EmployeeFilterRequest;
import com.krish.jpa_spec.dto.EmployeeResponseDto;
import com.krish.jpa_spec.entity.Department;
import com.krish.jpa_spec.entity.Employee;
import com.krish.jpa_spec.repository.DepartmentRepository;
import com.krish.jpa_spec.repository.EmployeeRepository;
import com.krish.jpa_spec.utils.EmployeeMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final DepartmentRepository departmentRepo;

    public EmployeeService(EmployeeRepository employeeRepo,
                           DepartmentRepository departmentRepo) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
    }

    public List<EmployeeResponseDto> getEmployeesByFilters(EmployeeFilterRequest filter) {

        Specification<Employee> specification =
                EmployeeSpecificationBuilder.build(filter);

        List<Employee> data = employeeRepo.findAll(specification);
        return data.stream().map(EmployeeMapper::mapToDto).toList();
    }


}
