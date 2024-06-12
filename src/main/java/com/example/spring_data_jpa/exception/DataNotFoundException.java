package com.example.spring_data_jpa.exception;
import com.example.spring_data_jpa.helper.ErrorCode;

public class DataNotFoundException extends RuntimeException {

    public static final ErrorCode errorCode = ErrorCode.DATA_NOT_FOUND;

    public DataNotFoundException(String message) {
        super(message);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }


}
