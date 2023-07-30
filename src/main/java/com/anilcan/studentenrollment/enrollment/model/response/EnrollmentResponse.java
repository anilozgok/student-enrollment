package com.anilcan.studentenrollment.enrollment.model.response;

import com.anilcan.studentenrollment.course.model.domain.CourseDomain;
import com.anilcan.studentenrollment.student.model.domain.StudentDomain;
import jakarta.validation.constraints.NotNull;

public record EnrollmentResponse(@NotNull Long id, @NotNull StudentDomain student, @NotNull CourseDomain course) {
}
