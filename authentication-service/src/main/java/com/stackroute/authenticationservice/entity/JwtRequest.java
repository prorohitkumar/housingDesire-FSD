package com.stackroute.authenticationservice.entity;

import lombok.*;

@Getter
@Setter
@ToString
public class JwtRequest {

    private String userName;
    private String userPassword;
}

