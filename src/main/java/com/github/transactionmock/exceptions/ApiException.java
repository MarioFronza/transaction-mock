package com.github.transactionmock.exceptions;

import org.springframework.http.HttpStatus;

public class ApiException extends Exception {

    private final String message;
    private final HttpStatus httpStatus;

    public ApiException(String message) {
        this.message = message;
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public ApiException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
