package com.stackroute.designerservice.repository;

import com.stackroute.designerservice.model.designerdetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface designerdetailrepository extends MongoRepository<designerdetail,String> {

    @Query("{'designerId': ?0 }")
    Optional<designerdetail> findById(String s);

    @Query("{'designdetail.d_Id': ?0 }")
    Optional<designerdetail> findDesignDetailById(String d_Id);
}
