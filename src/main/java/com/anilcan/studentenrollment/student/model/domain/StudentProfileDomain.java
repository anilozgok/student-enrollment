package com.anilcan.studentenrollment.student.model.domain;

import com.anilcan.studentenrollment.utils.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record StudentProfileDomain(
        @NotBlank @Size(max = 6) Gender gender,
        @NotBlank @Size(max = 50) String nationality,
        @NotBlank @Size(max = 50) String major,
        @NotNull int yearOfAdmission) {
}
