package com.krish.jpa_spec.controller;


import com.krish.jpa_spec.dto.EmployeeFilterRequest;
import com.krish.jpa_spec.dto.EmployeeResponseDto;
import com.krish.jpa_spec.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }


    @PostMapping("/search")
    public List<EmployeeResponseDto> searchEmployees(
            @RequestBody EmployeeFilterRequest filter) {
        return service.getEmployeesByFilters(filter);
    }
}
