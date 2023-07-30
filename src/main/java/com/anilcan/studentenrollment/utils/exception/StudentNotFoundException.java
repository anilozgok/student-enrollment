package com.anilcan.studentenrollment.utils.exception;

import com.anilcan.studentenrollment.utils.exception.base.BaseException;
import com.anilcan.studentenrollment.utils.exception.message.ExceptionMessage;

public class StudentNotFoundException extends BaseException {
    public StudentNotFoundException(){
        super(ExceptionMessage.STUDENT_NOT_FOUND_EXCEPTION);
    }
}
