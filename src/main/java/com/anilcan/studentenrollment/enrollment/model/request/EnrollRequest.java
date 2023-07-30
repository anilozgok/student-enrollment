package com.anilcan.studentenrollment.enrollment.model.request;

import jakarta.validation.constraints.NotNull;

public record EnrollRequest(@NotNull Long studentId, @NotNull Long courseId) {

}
