package com.stackroute.designerservice.controller;


import com.stackroute.designerservice.exception.designalreadyexistsexception;
import com.stackroute.designerservice.exception.designnotfoundexception;
import com.stackroute.designerservice.exception.designprovidernotfoundexception;
import com.stackroute.designerservice.model.designdetail;
import com.stackroute.designerservice.model.designerdetail;
import com.stackroute.designerservice.service.designservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class designservicecontroller {

    @Autowired
    private designservice designservice;
    private ResponseEntity<?> responseEntity;

    @Autowired
    public designservicecontroller(designservice designservice){
        this.designservice=designservice;
    }


    @PostMapping("/addDesignDetail/{designerId}")
    public ResponseEntity<?> addDesignDetail(@RequestBody designdetail designdetail,  @PathVariable("designerId") String designerId ) throws designalreadyexistsexception ,designprovidernotfoundexception , IOException {
//        Gson gson = new Gson();
//        designdetail designdetailObj = gson.fromJson(designdetail, designdetail.class);

        //paymentstatusdto paymentdto;
        //paymentstatusdto paymentstatusdto=new paymentstatusdto(paymentdto ,"PROCESS","payment done for "+designerId)
        try{
            return new ResponseEntity<>(designservice.createDesignDetail( designdetail,designerId), HttpStatus.CREATED);

       }catch (designalreadyexistsexception | designprovidernotfoundexception e){

           return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);

       }catch (Exception x){

           return new ResponseEntity<>(x.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }

    }

//    @GetMapping("/getDesignDetail/{dId}")
//    public ResponseEntity<?>getDesignDetail(@PathVariable("dId") String dId) throws designnotfoundexception {
//        try{
//
//            return new ResponseEntity<>(designservice.getDesign(dId),HttpStatus.OK);
//
//        }catch(designnotfoundexception e){
//
//            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
//        }
//        catch(Exception x){
//
//            return new ResponseEntity<>(x.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//
//        }
//
//    }
//@PostMapping("/addDesign/{designerId}")
//public ResponseEntity<?> addDesign(@PathVariable("designerId") String designerId, @RequestBody designdetail designdetail) throws designalreadyexistsexception {
//    try {
//
//        return new ResponseEntity<>(designservice.createDesignDetail(designerId, designdetail), HttpStatus.CREATED);
//
//    } catch (designalreadyexistsexception e) {
//
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
//
//    } catch (Exception x) {
//
//        return new ResponseEntity<>(x.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//}
    @GetMapping("/listofAllDesign")
    public ResponseEntity<List<designdetail>> getAlldesigndetails() {
        return ResponseEntity.ok(designservice.getAllDesigndetails());
    }

//getdesignbyid

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getDesign/{dId}")
    public ResponseEntity<?> getDesign(@PathVariable("dId") String dId) {
        try {
            //Optional<designdetail> designdetail=this.service.getDesign(id);
            return new ResponseEntity<>(designservice.getDesign(dId), HttpStatus.OK);
        } catch (designnotfoundexception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception x) {
            return new ResponseEntity<>(x.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }
    @DeleteMapping("/deleteDesign/{dId}")
    public ResponseEntity<?> deleteById(@PathVariable("dId") String dId){
        try{
            return new ResponseEntity<>(designservice.deleteById(dId),HttpStatus.OK);

        } catch (designnotfoundexception e){

            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);

        } catch (Exception x){

            return new ResponseEntity<>(x.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("updateDesignDetail/{dId}")
    public ResponseEntity<?> updateDesign(@RequestBody designdetail designdetail, @PathVariable String dId) throws designnotfoundexception{
        try {
            return new ResponseEntity<>(designservice.updateDesign(designdetail,dId ), HttpStatus.CREATED);

        } catch (designnotfoundexception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);

        } catch(Exception x){

            return new ResponseEntity<>(x.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PostMapping("/addDesignerDetail")
    public ResponseEntity<?> addDesignerDetail(@RequestBody designerdetail designerdetail) throws designprovidernotfoundexception {
        try {
            return new ResponseEntity<>(designservice.createDesignerDetail(designerdetail), HttpStatus.CREATED);

        }catch (designprovidernotfoundexception e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);

        }catch (Exception x){

            return new ResponseEntity<>(x.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getDesignerDetail/{designerid}")
    public ResponseEntity<?>getDesignerDetail(@PathVariable("designerid") String designerid) throws designprovidernotfoundexception {
        try{

            return new ResponseEntity<>(designservice.getDesignerDetailById(designerid),HttpStatus.OK);

        }catch(designprovidernotfoundexception e){

            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
        catch(Exception x){

            return new ResponseEntity<>(x.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @DeleteMapping("/deleteDesignerDetail/{designerid}")
    public ResponseEntity<?> deleteDesignerDetailById(@PathVariable("designerid") String designerid){
        try{
            return new ResponseEntity<>(designservice.deleteDesignerDetailById(designerid),HttpStatus.OK);

        } catch (designprovidernotfoundexception e){

            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);

        } catch (Exception x){

            return new ResponseEntity<>(x.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("updateDesignerDetail/{designerId}")
    public ResponseEntity<?> updateDesignerDetailById(@RequestBody designerdetail designerdetail, @PathVariable String designerId) throws designprovidernotfoundexception{
        try {
            return new ResponseEntity<>(designservice.updateDesignerDetailById(designerId,designerdetail ), HttpStatus.CREATED);

        } catch (designprovidernotfoundexception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);

        } catch(Exception x){

            return new ResponseEntity<>(x.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }




}
