package com.luv2code.springdemo.entity;

/**
 * Created by admin on 19.12.2018.
 */
public class CustomerException {
    int code;
    String message;
    long timeStamp;

    public CustomerException() {
    }

    public CustomerException(int code, String message, long timeStamp) {
        this.code = code;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
