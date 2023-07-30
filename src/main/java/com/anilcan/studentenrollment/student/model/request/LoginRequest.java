package com.anilcan.studentenrollment.student.model.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record LoginRequest(
        @NotBlank @Length(min=10, max = 50) String email,
        @NotBlank @Length(min=8, max = 50) String password) {
}
