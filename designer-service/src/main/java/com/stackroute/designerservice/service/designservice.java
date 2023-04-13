package com.stackroute.designerservice.service;


import com.stackroute.designerservice.exception.designalreadyexistsexception;
import com.stackroute.designerservice.exception.designnotfoundexception;
import com.stackroute.designerservice.exception.designprovideralreadyexistsexception;
import com.stackroute.designerservice.exception.designprovidernotfoundexception;
import com.stackroute.designerservice.model.designdetail;
import com.stackroute.designerservice.model.designerdetail;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface designservice {

     designdetail createDesignDetail( designdetail designdetail, String designerId) throws designalreadyexistsexception, designprovidernotfoundexception, IOException;

//     designdetail getDesignDetailsById(String dId) throws designnotfoundexception;
//
//     String deleteDesignDetailById(String dId) throws designnotfoundexception;
//
//     designdetail updateDesignDetailById(String dId, designdetail designdetail) throws designnotfoundexception;

     designerdetail createDesignerDetail(designerdetail designerdetail) throws designprovidernotfoundexception;

     designerdetail getDesignerDetailById(String designerId) throws designprovidernotfoundexception;

     String deleteDesignerDetailById(String designerId) throws designprovidernotfoundexception;

     designerdetail updateDesignerDetailById(String designerId,designerdetail designerdetail) throws designprovidernotfoundexception;


     List<designdetail> getAllDesigndetails();
     designdetail getDesign(String  dId) throws designnotfoundexception;

     String deleteById(String  dId) throws designnotfoundexception;
     //Optional<designdetail> deleteDesign(String  id);

     //List<designdetail> getDesignName(String name);
     designdetail updateDesign(designdetail designdetail , String  dId) throws designnotfoundexception;


     //designdetail addDesignDetail(designdetail designdetail, MultipartFile file,String designerId) throws designalreadyexistsexception, IOException;
}
