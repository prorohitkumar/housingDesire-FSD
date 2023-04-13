package com.stackroute.reviewservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.reviewservice.model.Review;

public interface ReviewRepository extends JpaRepository<Review,Integer> {

}

