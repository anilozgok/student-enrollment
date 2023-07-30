package com.anilcan.studentenrollment.student.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record RegisterRequest(@NotBlank @Length(min=2, max = 50) String firstName,
                              @NotBlank @Length(min=2, max = 50) String lastName,
                              @NotBlank @Length(min=10, max = 50) String email,
                              @NotBlank String password,
                              @NotNull LocalDate dateOfBirth,
                              @NotBlank @Length(min=14, max = 14) String phoneNumber) {
}
