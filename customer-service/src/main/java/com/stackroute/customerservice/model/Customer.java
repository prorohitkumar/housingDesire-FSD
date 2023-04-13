package com.stackroute.customerservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Getter
@Setter
@ToString
@Document(collection = "customer")
public class Customer {
   /*
   “First Name”:”String”,
“Last Name”:”String”,
//“emailId”:”String/email”,
//“Mobile No”:”Number”,
“Date of Birth”:”Date”,
//“Address”:”String”,
“City”:”String”,
“State”:”String”,
“Pincode”:”number”,
*/


    private String firstname;
    private String lastname;
    @Id
    private String email;
    private String mobileNo;
    private String  doB;
    private String address;
    private String city;
    private String state;
    private String pincode;



}
