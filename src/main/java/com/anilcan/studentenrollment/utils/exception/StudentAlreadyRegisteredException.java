package com.anilcan.studentenrollment.utils.exception;

import com.anilcan.studentenrollment.utils.exception.message.ExceptionMessage;
import com.anilcan.studentenrollment.utils.exception.base.BaseException;

public class StudentAlreadyRegisteredException extends BaseException {
    public StudentAlreadyRegisteredException(){
        super(ExceptionMessage.STUDENT_ALREADY_REGISTERED_EXCEPTION);
    }
}
