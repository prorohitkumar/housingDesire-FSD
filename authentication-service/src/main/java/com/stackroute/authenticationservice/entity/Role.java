package com.stackroute.authenticationservice.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity
public class Role {

    @Id
    private String roleName;
    private String roleDescription;
}

