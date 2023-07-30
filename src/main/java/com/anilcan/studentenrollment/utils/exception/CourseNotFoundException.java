package com.anilcan.studentenrollment.utils.exception;

import com.anilcan.studentenrollment.utils.exception.base.BaseException;
import com.anilcan.studentenrollment.utils.exception.message.ExceptionMessage;

public class CourseNotFoundException extends BaseException {
    public CourseNotFoundException()
    {
        super(ExceptionMessage.COURSE_NOT_FOUND_EXCEPTION);
    }}
