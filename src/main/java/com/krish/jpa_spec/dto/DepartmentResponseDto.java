package com.krish.jpa_spec.dto;

public record DepartmentResponseDto(
        Long id,
        String code,
        String name,
        String location,
        boolean active
) {}
