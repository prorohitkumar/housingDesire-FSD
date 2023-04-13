import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Designer } from '../designer';
import { DesignerService } from '../service/designer.service';

@Component({
  selector: 'app-viewdesignerprofile',
  templateUrl: './viewdesignerprofile.component.html',
  styleUrls: ['./viewdesignerprofile.component.css']
})
export class ViewdesignerprofileComponent implements OnInit {

  constructor(private router:Router,
    private designerService: DesignerService ) { }

    designer1:{
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

  ngOnInit(): void {
  }
  id = '103';
  details:any;
  public redirectCustomer(pageName:String):void{
    //redirect customer to updateCustomerProfile
        console.log(this.designer1)
        this.router.navigate([`${pageName}`]);
  }

public getDetails(){
this.designerService.getDetailsById(this.id).subscribe(data=>
  {

    this.designer1=data;
console.log(this.designer1);
console.log(data);

  })

}



}
