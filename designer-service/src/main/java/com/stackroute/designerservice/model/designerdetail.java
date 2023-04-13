package com.stackroute.designerservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.GeneratedValue;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="design-provider")
@ToString
@Getter
@Setter

public class designerdetail {

    @Id
    private String designerId;

    private String name;

    private String pin_code;

    private String city;

    private String mobile_no;

    private String shopname;

    private String email;

    private List<designdetail> DesignDetail;



    private String firstname;

    private String lastname;
}
