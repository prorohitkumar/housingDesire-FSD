package com.stackroute.customerservice.service;

import com.stackroute.customerservice.exceptions.CustomerAlreadyExistException;
import com.stackroute.customerservice.exceptions.CustomerNotFoundException;
import com.stackroute.customerservice.model.Customer;
import com.stackroute.customerservice.model.customerdto;
import com.stackroute.customerservice.repository.CustomerRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository repository;
    private CustomerRepository repo;

    customerdto user =new customerdto();


    //Authentiation service
  /* @RabbitListener(queues = "detailstocustmer.consumer")
    public Customer getCustomer(Customer Customer){
        System.out.println(Customer);
        Customer user= new Customer();
        user.setEmailId(Customer.getEmailId());
        user.setFirstName(Customer.getFirstName());
        user.setLastName(Customer.getLastName());

        System.out.println(user);
        return user;

    }*/
//    @RabbitListener(queues = "detailstocustmer.consumer")
//    public void getCustomer(customerdto customerdto){
//        System.out.println(customerdto);
//        //Customer user= new Customer();
////        user.setEmailId(Customer.getEmailId());
////        user.setFirstname(Customer.getFirstName());
////        user.setLastname(Customer.getLastName());
//        user=customerdto;
//
//        System.out.println(user);
//
//
//    }

    @RabbitListener(queues = "customer")
    public void getCustomer(customerdto customerdto){
        System.out.println(customerdto);
        Customer user= new Customer();
        user.setEmail(customerdto.getUserName());
        user.setFirstname(customerdto.getUserFirstName());
        user.setLastname(customerdto.getUserLastName());

        repo.save(user);
        System.out.println(user);
    }

    @Autowired
    public CustomerServiceImpl(CustomerRepository repo){
        this.repo=repo;
    }

    @Override
    public String saveCustomer(Customer cust) throws CustomerAlreadyExistException {
        Optional<Customer> o = repo.findById(cust.getEmail());
        Customer newcust = null;
        if(o.isPresent()){
            throw new CustomerAlreadyExistException();
        }else{
            cust.setEmail(user.getUserName());
            cust.setFirstname(user.getUserFirstName());
            cust.setLastname(user.getUserLastName());
            newcust = repo.save(cust);
            return "Successfully Registered";
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @Override
    public Optional<Customer> getCustomer(String emailId) throws CustomerNotFoundException {
        Optional<Customer> o = repo.findById(emailId);
        Customer newcust = null;
        if (o.isPresent()) {
            return o;
        } else {
            throw new CustomerNotFoundException();
        }
    }

    @Override
    public String deleteById(String emailId) throws CustomerNotFoundException {
        Optional<Customer> o = repo.findById(emailId);
        Customer newcust = null;
        if (o.isPresent()) {
            repo.deleteById(emailId);
            return "Your Account has Been Deleted Successfully";
        }else {
            throw new CustomerNotFoundException();
        }
    }


    @CrossOrigin(origins = "http://localhost:4200")
    public Customer updateCustomerById(Customer upcus,String emailId) throws CustomerNotFoundException{
        Optional<Customer> o = repo.findById(emailId);

        if (o.isPresent()) {
            Customer cus = repo.findById(emailId).get();
            cus.setAddress(upcus.getAddress());
            cus.setCity(upcus.getCity());
            cus.setFirstname(upcus.getFirstname());
            cus.setDoB(upcus.getDoB());
            cus.setPincode(upcus.getPincode());
            cus.setState(upcus.getState());
            cus.setLastname(upcus.getLastname());
            cus.setMobileNo(upcus.getMobileNo());

            repo.save(cus);
            return cus;
        }else {
            throw new CustomerNotFoundException();
        }
    }




}



