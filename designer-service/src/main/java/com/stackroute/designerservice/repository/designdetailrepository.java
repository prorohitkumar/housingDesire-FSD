package com.stackroute.designerservice.repository;

import com.stackroute.designerservice.model.designdetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface designdetailrepository extends MongoRepository <designdetail,String> {


}
