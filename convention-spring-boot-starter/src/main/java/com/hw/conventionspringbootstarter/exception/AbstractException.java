package com.hw.conventionspringbootstarter.exception;

import com.hw.conventionspringbootstarter.error.IErrorCode;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

import java.util.Optional;

/**
 * 抽象项目中三类异常体系，客户端异常、服务端异常以及远程服务调用异常
 * @author chen.ma
 * @see ClientException
 * @see ServiceException
 * @see RemoteException
 */
@Getter
public class AbstractException extends RuntimeException {
    public final String errorCode;

    public final String errorMessage;

    public AbstractException(String errorMessage, IErrorCode iErrorCode, Throwable throwable) {
        super(errorMessage, throwable);
        this.errorCode = iErrorCode.code();
        this.errorMessage = Optional.ofNullable(Strings.trimToNull(errorMessage)).orElse(iErrorCode.message());
    }
}
