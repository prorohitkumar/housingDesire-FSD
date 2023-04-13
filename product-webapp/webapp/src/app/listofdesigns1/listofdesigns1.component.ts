import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { DesignDetail } from '../design-details/design-detail';
import { DesignerService } from '../service/designer.service';

@Component({
  selector: 'app-listofdesigns1',
  templateUrl: './listofdesigns1.component.html',
  styleUrls: ['./listofdesigns1.component.css']
})
export class Listofdesigns1Component implements OnInit {

  ngOnInit(): void {
  }


  design8: {
    d_name?: string; d_cost?: number;d_description?: string;name?:String,
    mobile_no?: string;d_color?: string;d_material?: string;d_area?: string;
    d_location?: string;posted_date?: string;DesignType?:String,
  } = new DesignDetail('', '', 0, '', '', '', 0, '', '', '','','');
  design9: {
    d_name?: string; d_cost?: number;d_description?: string;name?:String,
    mobile_no?: string;d_color?: string;d_material?: string;d_area?: string;
    d_location?: string;posted_date?: string;DesignType?:String,
  } = new DesignDetail('', '', 0, '', '', '', 0, '', '', '','','');
  design10: {
    d_name?: string; d_cost?: number;d_description?: string;name?:String,
    mobile_no?: string;d_color?: string;d_material?: string;d_area?: string;
    d_location?: string;posted_date?: string;DesignType?:String,
  } = new DesignDetail('', '', 0, '', '', '', 0, '', '', '','','');
  design11: {
    d_name?: string; d_cost?: number;d_description?: string;name?:String,
    mobile_no?: string;d_color?: string;d_material?: string;d_area?: string;
    d_location?: string;posted_date?: string;DesignType?:String,
  } = new DesignDetail('', '', 0, '', '', '', 0, '', '', '','','');
  design12: {
    d_name?: string; d_cost?: number;d_description?: string;name?:String,
    mobile_no?: string;d_color?: string;d_material?: string;d_area?: string;
    d_location?: string;posted_date?: string;DesignType?:String,
  } = new DesignDetail('', '', 0, '', '', '', 0, '', '', '','','');
  design13: {
    d_name?: string; d_cost?: number;d_description?: string;name?:String,
    mobile_no?: string;d_color?: string;d_material?: string;d_area?: string;
    d_location?: string;posted_date?: string;DesignType?:String,
  } = new DesignDetail('', '', 0, '', '', '', 0, '', '', '','','');
  design14: {
    d_name?: string; d_cost?: number;d_description?: string;name?:String,
    mobile_no?: string;d_color?: string;d_material?: string;d_area?: string;
    d_location?: string;posted_date?: string;DesignType?:String,
  } = new DesignDetail('', '', 0, '', '', '', 0, '', '', '','','');

  
  id8 = '108';
  id9= '109';
  id10= '110';
  id11= '111';
  id12= '112';
  id13= '113';
  id14= '114';

  clickEventSubscription:Subscription;
  
  constructor(private designerService: DesignerService) {
    this.clickEventSubscription= this.designerService.getClickEvent().subscribe(()=>{
      this.getDetails1();
    })
   }


  public getDetails1() {
    this.designerService.getAlldesigndetails(this.id8).subscribe((data) => {
      this.design8 = data;
      console.log(this.design8);
      console.log(data);
    });

    this.designerService.getAlldesigndetails(this.id9).subscribe((data) => {
      this.design9 = data;
      console.log(this.design9);
      console.log(data);
    });

    this.designerService.getAlldesigndetails(this.id10).subscribe((data) => {
      this.design10 = data;
      console.log(this.design10);
      console.log(data);
    });

    this.designerService.getAlldesigndetails(this.id11).subscribe((data) => {
      this.design11 = data;
      console.log(this.design11);
      console.log(data);
    });

    this.designerService.getAlldesigndetails(this.id12).subscribe((data) => {
      this.design12 = data;
      console.log(this.design12);
      console.log(data);
    });

    this.designerService.getAlldesigndetails(this.id13).subscribe((data) => {
      this.design13 = data;
      console.log(this.design13);
      console.log(data);
    });

    this.designerService.getAlldesigndetails(this.id14).subscribe((data) => {
      this.design14 = data;
      console.log(this.design14);
      console.log(data);
    });

    
  }
}
