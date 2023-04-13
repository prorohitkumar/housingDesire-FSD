package com.stackroute.designerservice.service;

import com.stackroute.designerservice.exception.designalreadyexistsexception;
import com.stackroute.designerservice.exception.designnotfoundexception;
import com.stackroute.designerservice.exception.designprovidernotfoundexception;
import com.stackroute.designerservice.model.designdetail;
import com.stackroute.designerservice.model.designerdetail;
import com.stackroute.designerservice.rabbitmqmodel.designdto;
import com.stackroute.designerservice.rabbitmqmodel.designerdto;
import com.stackroute.designerservice.repository.designdetailrepository;
import com.stackroute.designerservice.repository.designerdetailrepository;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class designerserviceimpl implements designservice {

    List<designdetail> list = List.of(new designdetail());

    @Autowired
    private designerdetailrepository Repository;

    @Autowired
    private designdetailrepository repository;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    DirectExchange directExchange;

    designerdto user = new designerdto();
//Authentiation service
    @RabbitListener(queues = "designer")
    public void getDesignerDetail(designerdto dto){
        System.out.println(dto);
        designerdetail user= new designerdetail();
        user.setEmail(dto.getUserName());
        user.setFirstname(dto.getUserFirstName());
        user.setLastname(dto.getUserLastName());
        Repository.save(user);

        System.out.println(user);

    }

//    @Override
//    public designdetail getDesignDetailsById(String dId) throws designnotfoundexception {
//        Optional<designerdetail> ById = Repository.findDesignDetailById(dId);
//        if (ById.isPresent()) {
//            designerdetail designerDetail =ById.get();
//            List<designdetail> collect = designerDetail.getDesignDetail().stream().filter((c) ->c.getDId().equals(dId)).collect(Collectors.toList());
//            designdetail foundDesigndetail = collect.get(0);
//            return foundDesigndetail;
//        }
//            throw new designnotfoundexception();
//
//    }
//
//
//    @Override
//    public designdetail updateDesignDetailById(String dId, designdetail designdetail) throws designnotfoundexception {
//        Optional<designerdetail> ById = Repository.findDesignDetailById(dId);
//        if (ById.isPresent()) {
//            designerdetail designerDetail =ById.get();
//            List<designdetail> collect = designerDetail.getDesignDetail().stream().filter((c) ->c.getDId().equals(dId)).collect(Collectors.toList());
//            designdetail foundDesigndetail1 = collect.get(0);
//            foundDesigndetail1.setDId(designdetail.getDId());
//            foundDesigndetail1.setD_name(designdetail.getD_name());
//            foundDesigndetail1.setDesignType(designdetail.getDesignType());
//            designerdetail save =Repository.save(designerDetail);
//            return save.getDesignDetail().stream().filter((c) ->c.getDId().equals(dId)).collect(Collectors.toList()).get(0);
//        }
//        throw new designnotfoundexception();
//
//    }

    @Override
    public designerdetail createDesignerDetail(designerdetail designerdetail) throws designprovidernotfoundexception {
        designerdetail.setEmail(user.getUserName());
        designerdetail.setFirstname(user.getUserFirstName());
        designerdetail.setLastname(user.getUserLastName());



        return Repository.save(designerdetail);
    }

    @Override
    public designerdetail getDesignerDetailById(String designerid) throws designprovidernotfoundexception {
        Optional<designerdetail> ById = this.Repository.findById(designerid);
        if (ById.isPresent()) {
            return ById.get();
        } else {
            throw new designprovidernotfoundexception();
        }

    }

    @Override
    public String deleteDesignerDetailById(String designerid) throws designprovidernotfoundexception {
        Optional<designerdetail> ById = Repository.findById(designerid);
        if (ById.isPresent()) {
            Repository.deleteById(designerid);
            return "deleted successfully";
        } else {
            throw new designprovidernotfoundexception();
        }
    }

    @Override
    public designerdetail updateDesignerDetailById(String designerId, designerdetail designerdetail) throws designprovidernotfoundexception {
        Optional<designerdetail> ById = Repository.findById(designerId);
        if (ById.isPresent()) {
            designerdetail.setDesignerId(designerdetail.getDesignerId());
            designerdetail.setEmail(designerdetail.getEmail());
            designerdetail.setCity(designerdetail.getCity());
            designerdetail.setMobile_no(designerdetail.getMobile_no());
            designerdetail.setName(designerdetail.getName());
            designerdetail.setPin_code(designerdetail.getPin_code());
            designerdetail.setShopname(designerdetail.getShopname());
            designerdetail.setDesignDetail(designerdetail.getDesignDetail());


            return Repository.save(designerdetail);
        }else{
            throw new designprovidernotfoundexception();
        }
    }

    public List<designdetail> getAllDesigndetails(){
        return repository.findAll();
    }


    @Override
    public designdetail getDesign(String dId) throws designnotfoundexception {
        Optional<designdetail> ById = this.repository.findById(dId);
        if (ById.isPresent()) {
            return ById.get();
        } else {
            throw new designnotfoundexception();

        }
    }
    @Override
    public designdetail createDesignDetail(designdetail designdetail, String designerId) throws designalreadyexistsexception, designprovidernotfoundexception, IOException {
        Optional<designerdetail> designerdetail = Repository.findById(designerId);
        if(designerdetail.isEmpty())
            throw new designprovidernotfoundexception();
        designerdetail designerDetail =designerdetail.get();
        List<designdetail> designDetails = designerDetail.getDesignDetail();
//        designdetail.setVisualsOfCenter(file.getBytes());
        designDetails.add(designdetail);
        designerDetail.setDesignDetail(designDetails);
        Repository.save(designerDetail);

        // System.out.println(file.getBytes());
        designdetail save =repository.save(designdetail);

        //recommendton to design
        designdto recomDesign = new designdto();

        recomDesign.setDId(designdetail.getDId());
        recomDesign.setD_name(designdetail.getD_name());
        recomDesign.setD_cost(designdetail.getD_cost());
        recomDesign.setD_color(designdetail.getD_color());
        recomDesign.setDesignType(designdetail.getDesignType());
        recomDesign.setD_material(designdetail.getD_material());
        recomDesign.setD_location(designdetail.getD_location());
        recomDesign.setD_area(designdetail.getD_area());
        recomDesign.setDesigner_name(designdetail.getDesigner_name());
        recomDesign.setMobile_no(designdetail.getMobile_no());
        recomDesign.setPosted_date(designdetail.getPosted_date());
        //recomDesign.setVisualsOfCenter(designdetail.getVisualsOfCenter());


        rabbitTemplate.convertAndSend(directExchange.getName(), "design_D",recomDesign);




        return save;
    }


    @Override
    public String deleteById(String dId) throws designnotfoundexception {
        Optional<designdetail> byId=repository.findById(dId);
        if(byId.isPresent()){
            repository.deleteById(dId);
            return "deleted";
        }else{
            throw new designnotfoundexception();
        }
    }


    @Override
    public designdetail updateDesign(designdetail designdetail, String dId) throws designnotfoundexception {
        Optional<designdetail> byId = repository.findById(dId);
        if (byId.isPresent()) {

            designdetail.setDId(designdetail.getDId());
            designdetail.setD_name(designdetail.getD_name());
            designdetail.setD_color(designdetail.getD_color());
            designdetail.setD_cost(designdetail.getD_cost());
            designdetail.setD_location(designdetail.getD_location());
            designdetail.setD_material(designdetail.getD_material());
            designdetail.setDesigner_name(designdetail.getDesigner_name());
            designdetail.setMobile_no(designdetail.getMobile_no());
            designdetail.setPosted_date(designdetail.getPosted_date());
            designdetail.setDesignType(designdetail.getDesignType());

            return repository.save(designdetail);

        }else {
            throw new designnotfoundexception();
        }
    }
}