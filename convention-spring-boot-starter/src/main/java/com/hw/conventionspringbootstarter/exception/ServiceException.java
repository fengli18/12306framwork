package com.hw.conventionspringbootstarter.exception;

import com.hw.conventionspringbootstarter.error.BaseErrorCode;
import com.hw.conventionspringbootstarter.error.IErrorCode;
import lombok.ToString;

/**
 * 服务端异常
 */
@ToString
public class ServiceException extends AbstractException {
    public ServiceException(String errorMessage, IErrorCode iErrorCode, Throwable throwable) {
        super(errorMessage, iErrorCode, throwable);
    }

    public ServiceException(String message) {
        this(message, BaseErrorCode.SERVICE_ERROR, null);
    }

    public ServiceException(String message, IErrorCode iErrorCode) {
        this(message, iErrorCode, null);
    }

    public ServiceException(IErrorCode iErrorCode) {
        this(null, iErrorCode, null);
    }
}
