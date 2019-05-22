package com.luv2code.springdemo.exception;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.CustomerException;
import com.sun.javaws.exceptions.BadVersionResponseException;
import javassist.tools.web.BadHttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by admin on 19.12.2018.
 */
@ControllerAdvice
public class CustomerExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CustomerException> handleException(BadHttpRequest ex){
        CustomerException customerException = new CustomerException();

        customerException.setCode(HttpStatus.BAD_REQUEST.value());
        customerException.setMessage(ex.getMessage());
        customerException.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<CustomerException>(customerException,HttpStatus.BAD_REQUEST);
    }
}
