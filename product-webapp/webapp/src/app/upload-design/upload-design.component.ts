import { User1 } from './design';
import { Component, OnInit } from '@angular/core';
import { UploadDesignService } from '../service/upload-design.service';

@Component({
  selector: 'app-upload-design',
  templateUrl: './upload-design.component.html',
  styleUrls: ['./upload-design.component.css']
})
export class UploadDesignComponent implements OnInit {

  user:User1 =new User1();
  errorMessage: String = "";

  constructor(private uploaddesignService: UploadDesignService) {}
  


  ngOnInit() :void{
  }

  


  Submitclick(){
    if(this.user.dId==null || this.user.d_name==null || this.user.d_color==null || this.user.d_material==null || 
    this.user.DesignType==null || this.user.d_description==null ||this.user.d_cost==null || this.user.d_area==null || 
    this.user.d_location==null){
      
      this.errorMessage = "FEILDS CAN'T BE EMPTY !!";
      
    }
    else{
      this.uploaddesignService.d_upload(this.user).subscribe(data=>{
        alert("Design is successfully uploaded!!")},error=>{
          alert("cannot update")}
        );
    }
  }
    
  
}

