package com.stackroute.designerservice.model;


//import org.springframework.data.annotation.Id;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="design-model")
@ToString
@Getter
@Setter



public class designdetail {
    @Id
    private String dId;

    private String d_name;

    private Double d_cost;

    private String d_color;

    private String d_material;

    private Double d_area;

    private String mobile_no;

    private String designer_name;

    private String d_location;

    private String posted_date;

    private designtype DesignType;


}
