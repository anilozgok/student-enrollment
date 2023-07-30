package com.anilcan.studentenrollment.utils.exception.handler;

import com.anilcan.studentenrollment.utils.exception.base.BaseException;
import com.anilcan.studentenrollment.utils.exception.message.ExceptionMessage;
import com.anilcan.studentenrollment.student.model.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    private ResponseEntity<ErrorResponse> handle(BaseException exception) {

        log.error("Error occurred. Error: ", exception);

        return new ResponseEntity<>(new ErrorResponse(exception.getExceptionMessage(), LocalDateTime.now()),
                exception.getExceptionMessage().getErrorCode());
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ErrorResponse> handle(Exception exception) {

        log.error("Error occurred. Error: ", exception);

        return new ResponseEntity<>(new ErrorResponse(ExceptionMessage.UNKNOWN_EXCEPTION, LocalDateTime.now()),
                ExceptionMessage.UNKNOWN_EXCEPTION.getErrorCode());
    }

}
