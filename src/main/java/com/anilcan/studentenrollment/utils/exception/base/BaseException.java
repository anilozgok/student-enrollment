package com.anilcan.studentenrollment.utils.exception.base;

import com.anilcan.studentenrollment.utils.exception.message.ExceptionMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BaseException extends RuntimeException{
    protected final ExceptionMessage exceptionMessage;
}
