package com.luv2code.springdemo.exception;

/**
 * Created by admin on 19.12.2018.
 */
public class CustomerNotFindException extends RuntimeException {
    public CustomerNotFindException() {
    }

    public CustomerNotFindException(String message) {
        super(message);
    }

    public CustomerNotFindException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerNotFindException(Throwable cause) {
        super(cause);
    }
}
