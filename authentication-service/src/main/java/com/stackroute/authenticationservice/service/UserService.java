package com.stackroute.authenticationservice.service;


import com.stackroute.authenticationservice.dao.RoleDao;
import com.stackroute.authenticationservice.dao.UserDao;
import com.stackroute.authenticationservice.entity.Role;
import com.stackroute.authenticationservice.entity.User;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.awt.print.PrinterJob;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DirectExchange directExchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void initRoleAndUser() {

        Role designerRole = new Role();
        designerRole.setRoleName("Designer");
        designerRole.setRoleDescription("Designer role");
        roleDao.save(designerRole);

        Role customerRole = new Role();
        customerRole.setRoleName("Customer");
        customerRole.setRoleDescription("Customer role");
        roleDao.save(customerRole);
    }



    public User registerNewUser(User user){
        Optional<User> o=userDao.findById(user.getUserName());
        if (o.isPresent()) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists!");

        }
        else{

            Role role = roleDao.findById(user.getUserRole()).get();
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(role);
            user.setRole(userRoles);
            user.setUserPassword(getEncodedPassword(user.getUserPassword()));

            if(user.getUserRole().toString().equals("Designer"))
                rabbitTemplate.convertAndSend(directExchange.getName(),"routing_A",user);

            else if(user.getUserRole().toString().equals("Customer"))
                rabbitTemplate.convertAndSend(directExchange.getName(),"routing_B",user);

            else{}


        }
        rabbitTemplate.convertAndSend(directExchange.getName(),"routing_C",user);
        return (userDao.save(user));
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }


}

