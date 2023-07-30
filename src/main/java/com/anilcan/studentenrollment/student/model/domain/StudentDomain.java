package com.anilcan.studentenrollment.student.model.domain;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record StudentDomain(
        @NotBlank @Size(max=50) String firstName,
        @NotBlank @Size(max=50) String lastName,
        @NotBlank @Size(max=50) String email,
        @NotNull LocalDate dateOfBirth,
        @NotBlank @Size(max=10) String phoneNumber) { }
