package com.anilcan.studentenrollment.student.model.response;

import com.anilcan.studentenrollment.student.model.domain.StudentDomain;
import com.anilcan.studentenrollment.student.model.domain.StudentProfileDomain;

public record StudentResponse(Long id, StudentDomain student, StudentProfileDomain studentProfile) {
}
