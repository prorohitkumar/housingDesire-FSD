package com.stackroute.authenticationservice.controller;



import com.stackroute.authenticationservice.entity.User;
import com.stackroute.authenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import javax.annotation.PostConstruct;

@RestController
//@RequestMapping("/authentication")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user) ;
    }

    @GetMapping({"/forDesigner"})
    @PreAuthorize("hasRole('Designer')")
    public String forAdmin(){
        return "This URL is only accessible to the Designer";
    }

    @GetMapping({"/forCustomer"})
    @PreAuthorize("hasRole('Customer')")
    public String forUser(){
        return "This URL is only accessible to the Customer";
    }
}
