package com.stackroute.reviewservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import com.stackroute.reviewservice.repository.ReviewRepository;
import com.stackroute.reviewservice.model.Review;




@SpringBootApplication
@RestController
@RequestMapping("/api/r")
@CrossOrigin(origins = "*")
@EnableEurekaClient
public class ReviewServiceApplication {

	@Autowired
	private ReviewRepository repository;

	@PostMapping("/review")
	public String review(@RequestBody Review review) {
		repository.save(review);
		return "Hi " + review.getName() + " your feedback submitted successfully";
	}
	public static void main(String[] args) {
		SpringApplication.run(ReviewServiceApplication.class, args);
	}

}
