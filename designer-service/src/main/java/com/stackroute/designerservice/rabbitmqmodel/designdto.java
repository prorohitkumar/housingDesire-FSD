package com.stackroute.designerservice.rabbitmqmodel;

import com.stackroute.designerservice.model.designtype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class designdto {
    @Id
    private String dId;

    private String d_name;

    private Double d_cost;

    private String d_color;

    private String d_material;

    private Double d_area;

    private String d_location;

    private String mobile_no;

    private String designer_name;

    private String posted_date;

    private designtype DesignType;


}
