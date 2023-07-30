package com.anilcan.studentenrollment.course.model.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record CourseResponse(@NotNull Long id,
                             @NotBlank @Length(min=3, max=50) String name,
                             @NotBlank @Length(min=3, max=6) String code,
                             @NotNull int credit) {
}
