package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.model.Design;
import com.stackroute.recommendationservice.model.Recommendation;
import com.stackroute.recommendationservice.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface RecommendationsService {
    Recommendation getRecommendationsByCity(User user);

    //Design save(Design design, MultipartFile file) throws IOException;

}
