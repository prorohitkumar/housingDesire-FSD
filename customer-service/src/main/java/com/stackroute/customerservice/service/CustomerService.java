package com.stackroute.customerservice.service;

import com.stackroute.customerservice.exceptions.CustomerAlreadyExistException;
import com.stackroute.customerservice.exceptions.CustomerNotFoundException;
import com.stackroute.customerservice.model.Customer;


import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public String saveCustomer(Customer cust) throws CustomerAlreadyExistException;
    public Optional<Customer> getCustomer(String emailId) throws CustomerNotFoundException;
    public String deleteById(String emailId) throws CustomerNotFoundException;
    public Customer updateCustomerById(Customer upcus,String emailId) throws CustomerNotFoundException;

}
