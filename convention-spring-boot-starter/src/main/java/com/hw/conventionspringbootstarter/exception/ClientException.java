package com.hw.conventionspringbootstarter.exception;

import com.hw.conventionspringbootstarter.error.BaseErrorCode;
import com.hw.conventionspringbootstarter.error.IErrorCode;
import lombok.ToString;

/**
 * 客户端异常
 */
@ToString
public class ClientException extends AbstractException {
    public ClientException(IErrorCode iErrorCode) {
        this(null, iErrorCode, null);
    }

    public ClientException(String message) {
        this(message, BaseErrorCode.CLIENT_ERROR, null);
    }

    public ClientException(String message, IErrorCode iErrorCode) {
        this(message,iErrorCode,null);
    }

    public ClientException(String errorMessage, IErrorCode iErrorCode, Throwable throwable) {
        super(errorMessage, iErrorCode, throwable);
    }

}
