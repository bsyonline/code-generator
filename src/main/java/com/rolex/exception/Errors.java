package com.rolex.exception;

/**
 * @author rolex
 * @since 2018
 */
public enum Errors {

    INVALID_PAREMETER(401001, "INVALID_PAREMETER"),
    UNKNOWN_ERROR(500001, "UNKNOWN_ERROR"),


    ;
    int errorCode;
    String errorMessage;

    Errors(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


}
