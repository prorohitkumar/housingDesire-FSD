package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.model.Design;
import com.stackroute.recommendationservice.model.Recommendation;
import com.stackroute.recommendationservice.model.User;
import com.stackroute.recommendationservice.rabbitmqmodel.DesignDto;
import com.stackroute.recommendationservice.repository.DesignsRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationsService{

    @Autowired
    DesignsRepository designsRepository;


    public Recommendation getRecommendationsByCity(User user) {

        List<Design> designs = designsRepository.getDesignsByCity(user.getCity());
        Recommendation recommendation = new Recommendation();
        recommendation.setDesigns(designs);
        recommendation.setUser(user);
        return recommendation;
    }

    @RabbitListener(queues = "designtoRecomnd.Producer")
    public void getOwnerDetail(DesignDto designDto){
        Design design = new Design();
        design.setDId(designDto.getDId());
        design.setName(designDto.getDesigner_name());
        design.setMobile_no(designDto.getMobile_no());
        design.setDesignCost(designDto.getD_cost());
        design.setD_color(designDto.getD_color());
        design.setCity(designDto.getD_location());
        design.setD_name(designDto.getD_name());
       // design.setPicture(designDto.getVisualsOfCenter());
        design.setD_material(designDto.getD_material());
        designsRepository.save(design);
        System.out.println(designDto);

    }

}
