package com.krish.jpa_spec.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EmployeeCreateRequest(

        @NotBlank
        String empCode,

        @NotBlank
        String firstName,

        @NotBlank
        String lastName,

        @Email
        @NotBlank
        String email,

        @NotNull
        Double salary,

        @NotBlank
        String designation,

        @NotNull
        LocalDate joiningDate,

        @NotBlank
        String status,

        @NotNull
        Long departmentId
) {}
