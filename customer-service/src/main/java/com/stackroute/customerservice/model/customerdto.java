package com.stackroute.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class customerdto {

    private String userName;
    private String userFirstName;
    private String userLastName;

}
