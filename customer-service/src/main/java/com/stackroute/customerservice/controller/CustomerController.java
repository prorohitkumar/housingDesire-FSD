package com.stackroute.customerservice.controller;


import com.stackroute.customerservice.exceptions.CustomerAlreadyExistException;
import com.stackroute.customerservice.exceptions.CustomerNotFoundException;
import com.stackroute.customerservice.model.Customer;
import com.stackroute.customerservice.repository.CustomerRepository;
import com.stackroute.customerservice.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository repository;



    @PostMapping("/addCustomer")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer cust){
        try { CustomerServiceImpl cs = new CustomerServiceImpl(repository);
            return new ResponseEntity<>(cs.saveCustomer(cust),HttpStatus.OK);
        }catch (CustomerAlreadyExistException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/findAllCustomers")
    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }

    @GetMapping("findCustomer/{emailId}")
    public ResponseEntity<?> getCustomer(@PathVariable String emailId){
        try{
            CustomerServiceImpl cs = new CustomerServiceImpl(repository);
            return new ResponseEntity<>(cs.getCustomer(emailId),HttpStatus.OK);
        }catch(CustomerNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/delete/{emailId}")
    public ResponseEntity<?> deleteById(@PathVariable String emailId){
        try{
            CustomerServiceImpl cs = new CustomerServiceImpl(repository);
            return new ResponseEntity<>(cs.deleteById(emailId),HttpStatus.OK);
        }catch(CustomerNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateCustomer/{emailId}")
    public ResponseEntity<?> updateCustomerById(@RequestBody Customer upcus, @PathVariable String emailId){
        try{
            CustomerServiceImpl cs = new CustomerServiceImpl(repository);
            return new ResponseEntity<>(cs.updateCustomerById(upcus,emailId),HttpStatus.OK);
        }catch(CustomerNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

}
