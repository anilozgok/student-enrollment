package com.anilcan.studentenrollment.student.model.response;

import com.anilcan.studentenrollment.utils.exception.message.ExceptionMessage;

import java.time.LocalDateTime;

public record ErrorResponse(ExceptionMessage message, LocalDateTime occuredAt) {

}
