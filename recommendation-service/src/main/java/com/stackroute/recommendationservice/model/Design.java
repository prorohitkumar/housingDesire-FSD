package com.stackroute.recommendationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Design {
    @Id
    private String dId;
    private String name;
    private String mobile_no;
    //private String email;
    private String city;
    private Double designCost;
    //private byte[] picture;
    private String d_name;
    private String d_color;
    private String d_material;

}
