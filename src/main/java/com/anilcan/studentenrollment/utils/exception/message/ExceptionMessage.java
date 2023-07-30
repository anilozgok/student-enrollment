package com.anilcan.studentenrollment.utils.exception.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {

    STUDENT_ALREADY_REGISTERED_EXCEPTION("Student already registered.", "student.already.registered", HttpStatus.BAD_REQUEST),

    STUDENT_NOT_FOUND_EXCEPTION("Student not found.", "student.not.found", HttpStatus.NOT_FOUND),

    INVALID_PHONE_NUMBER_EXCEPTION("Invalid phone number.", "invalid.phone.number", HttpStatus.BAD_REQUEST),

    COURSE_ALREADY_EXIST_EXCEPTION("Course already exist.","course.already.exist", HttpStatus.BAD_REQUEST),

    COURSE_NOT_FOUND_EXCEPTION("Course not found.", "course.not.found", HttpStatus.NOT_FOUND),

    UNKNOWN_EXCEPTION("Unknown Error Occurred", "unknown.exception", HttpStatus.INTERNAL_SERVER_ERROR);


    private final String message;

    private final String errorName;

    private final HttpStatus errorCode;
}
