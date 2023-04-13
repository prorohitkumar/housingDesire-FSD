package com.stackroute.recommendationservice.controller;


import com.google.gson.Gson;
import com.stackroute.recommendationservice.model.Design;
import com.stackroute.recommendationservice.model.Recommendation;
import com.stackroute.recommendationservice.model.User;
import com.stackroute.recommendationservice.service.RecommendationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/recommendations")
public class RecommendationsController {
    private RecommendationsService recommendationService;

    @Autowired
    public RecommendationsController(final RecommendationsService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping("/get/user")
    public Recommendation getRecommendations(@RequestBody User user) {
        return recommendationService.getRecommendationsByCity(user);
    }


    @GetMapping("/get/{city}")
    public Recommendation getRecommendationscity(@PathVariable String city) {
        User user = new User();
        user.setCity(city);
        return recommendationService.getRecommendationsByCity(user);
    }


    /*
    @PostMapping("/design")
    public String addall(@RequestParam String design,@RequestParam MultipartFile file) throws IOException {
        Gson gson=new Gson();
        Design designs=gson.fromJson(design,Design.class);
        recommendationService.save(designs,file);
        return "nodes added";
    }
*/
}
