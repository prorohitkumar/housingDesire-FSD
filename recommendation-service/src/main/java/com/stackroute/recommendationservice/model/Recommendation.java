package com.stackroute.recommendationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;

@Node
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recommendation {
    @Id
    private Long id;
    private List<Design> designs;
    private User user;
}
