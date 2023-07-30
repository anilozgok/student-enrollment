package com.anilcan.studentenrollment.utils.exception;

import com.anilcan.studentenrollment.utils.exception.base.BaseException;
import com.anilcan.studentenrollment.utils.exception.message.ExceptionMessage;

public class InvalidPhoneNumberException extends BaseException {
    public InvalidPhoneNumberException(){
        super(ExceptionMessage.INVALID_PHONE_NUMBER_EXCEPTION);
    }
}
