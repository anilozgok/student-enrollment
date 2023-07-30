package com.anilcan.studentenrollment.utils.exception;

import com.anilcan.studentenrollment.utils.exception.base.BaseException;
import com.anilcan.studentenrollment.utils.exception.message.ExceptionMessage;

public class CourseAlreadyExistException extends BaseException {
    public CourseAlreadyExistException(){
        super(ExceptionMessage.COURSE_ALREADY_EXIST_EXCEPTION);
    }
}
