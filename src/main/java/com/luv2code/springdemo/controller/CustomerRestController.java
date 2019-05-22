package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.CustomerException;
import com.luv2code.springdemo.exception.CustomerNotFindException;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 19.12.2018.
 */
@RestController
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }
    @GetMapping("/customers/{customerId}")
    public Customer getCustomers(@PathVariable int customerId){
        Customer theCustomer = customerService.getCustomer(customerId);
        if(theCustomer==null)
            throw new CustomerNotFindException("Wrong id: "+customerId);
        return theCustomer;
    }
    @PostMapping("customers")
    public Customer addCustomer(@RequestBody Customer c){
        c.setId(0);
        customerService.saveCustomer(c);
        return c;
    }

    @PutMapping("customers")
    public Customer updateCustomer(@RequestBody Customer c){
        customerService.saveCustomer(c);
        return c;
    }

    @DeleteMapping("customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);

        if(customer==null)
            throw new CustomerNotFindException("Customer not found");

        customerService.deleteCustomer(customerId);
        return "Customer Deleted id - "+customerId;
    }

    @ExceptionHandler
    public ResponseEntity<CustomerException> handleException(CustomerNotFindException ex){
        CustomerException customerException = new CustomerException();

        customerException.setCode(HttpStatus.NOT_FOUND.value());
        customerException.setMessage(ex.getMessage());
        customerException.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<CustomerException>(customerException,HttpStatus.NOT_FOUND);
    }


}
