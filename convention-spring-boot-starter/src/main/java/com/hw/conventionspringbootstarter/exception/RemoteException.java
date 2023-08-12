package com.hw.conventionspringbootstarter.exception;

import com.hw.conventionspringbootstarter.error.IErrorCode;
import lombok.ToString;

@ToString
public class RemoteException extends AbstractException {
    public RemoteException(String errorMessage, IErrorCode iErrorCode, Throwable throwable) {
        super(errorMessage, iErrorCode, throwable);
    }

    public RemoteException(String message, IErrorCode iErrorCode) {
        this(message, iErrorCode, null);
    }
}
