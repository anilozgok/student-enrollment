package com.anilcan.studentenrollment.student.model.request;

import com.anilcan.studentenrollment.utils.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record StudentProfileRequest(@NotBlank @Length(min=4, max = 6) Gender gender,
                                    @NotBlank @Length(min=5, max = 50) String nationality,
                                    @NotBlank @Length(min=2, max = 50) String major,
                                    @NotNull int yearOfAdmission) {
}
