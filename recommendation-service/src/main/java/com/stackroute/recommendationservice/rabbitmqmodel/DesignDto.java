package com.stackroute.recommendationservice.rabbitmqmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DesignDto {

    private String designer_name;
    @Id
    @org.springframework.data.annotation.Id
    private String dId;

    private String d_name;
    private String mobile_no;

    private Double d_cost;

    private String d_color;

    private String d_material;

    private Double d_area;

   // private byte[] visualsOfCenter;

    private String d_location;


}
