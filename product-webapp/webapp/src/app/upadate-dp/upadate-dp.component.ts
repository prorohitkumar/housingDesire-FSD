import { DesignerService } from '../service/designer.service';
import { Designer } from '../designer';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-upadate-dp',
  templateUrl: './upadate-dp.component.html',
  styleUrls: ['./upadate-dp.component.css']
})
export class UpadateDpComponent implements OnInit {
  
 designer:{
    designerId?:string;
    name?:string;
    pin_code?:string;
    city?:string;
   mobile_no?:string;
   shopname?:string;
   email?:string;
   DesignDetail?:any;
   firstname?:string;
   lastname?:string;
  } = new Designer("","","","","","","","","","");

  constructor(private designerService: DesignerService) { }

  ngOnInit(): void {
  }

  public updateDesigner(){

    console.log(this.designer)
    this.designerService.updateTheDesigner(this.designer).subscribe(data=>{
      alert(this.designer+"Updated Successfully")
    },error=>alert("cannot update"));
  }


}
