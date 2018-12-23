/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.exception;

/**
 * @author rolex
 * @since 2018
 */
public class BusinessException extends Exception {

    public BusinessException(Errors errors){
        super(errors.name());
    }

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    protected BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
