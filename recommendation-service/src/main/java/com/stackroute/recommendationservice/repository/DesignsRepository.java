package com.stackroute.recommendationservice.repository;

import com.stackroute.recommendationservice.model.Design;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignsRepository extends Neo4jRepository<Design , String> {

    @Query("MATCH (D:Design) WHERE D.city=$city RETURN D")
    List<Design> getDesignsByCity(String city);


}
