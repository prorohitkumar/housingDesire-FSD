package com.stackroute.designerservice.rabbitmqmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class designerdto {

    private String userName;

    private String userFirstName;

    private String userLastName;
}
