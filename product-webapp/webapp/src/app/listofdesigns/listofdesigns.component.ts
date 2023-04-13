import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { DesignDetail } from '../design-details/design-detail';
import { DesignerService } from '../service/designer.service';

@Component({
  selector: 'app-listofdesigns',
  templateUrl: './listofdesigns.component.html',
  styleUrls: ['./listofdesigns.component.css']
})
export class ListofdesignsComponent implements OnInit {

  ngOnInit(): void {
  }

  design1: {
    d_name?: string; d_cost?: number;d_description?: string;name?:String,
    mobile_no?: string;d_color?: string;d_material?: string;d_area?: string;
    d_location?: string;posted_date?: string;DesignType?:String,
  } = new DesignDetail('', '', 0, '', '', '', 0, '', '', '','','');
  design2: {
    d_name?: string; d_cost?: number;d_description?: string;name?:String,
    mobile_no?: string;d_color?: string;d_material?: string;d_area?: string;
    d_location?: string;posted_date?: string;DesignType?:String,
  } = new DesignDetail('', '', 0, '', '', '', 0, '', '', '','','');
  design3: {
    d_name?: string; d_cost?: number;d_description?: string;name?:String,
    mobile_no?: string;d_color?: string;d_material?: string;d_area?: string;
    d_location?: string;posted_date?: string;DesignType?:String,
  } = new DesignDetail('', '', 0, '', '', '', 0, '', '', '','','');
  design4: {
    d_name?: string; d_cost?: number;d_description?: string;name?:String,
    mobile_no?: string;d_color?: string;d_material?: string;d_area?: string;
    d_location?: string;posted_date?: string;DesignType?:String,
  } = new DesignDetail('', '', 0, '', '', '', 0, '', '', '','','');
  design5: {
    d_name?: string; d_cost?: number;d_description?: string;name?:String,
    mobile_no?: string;d_color?: string;d_material?: string;d_area?: string;
    d_location?: string;posted_date?: string;DesignType?:String,
  } = new DesignDetail('', '', 0, '', '', '', 0, '', '', '','','');
  design6: {
    d_name?: string; d_cost?: number;d_description?: string;name?:String,
    mobile_no?: string;d_color?: string;d_material?: string;d_area?: string;
    d_location?: string;posted_date?: string;DesignType?:String,
  } = new DesignDetail('', '', 0, '', '', '', 0, '', '', '','','');
  design7: {
    d_name?: string; d_cost?: number;d_description?: string;name?:String,
    mobile_no?: string;d_color?: string;d_material?: string;d_area?: string;
    d_location?: string;posted_date?: string;DesignType?:String,
  } = new DesignDetail('', '', 0, '', '', '', 0, '', '', '','','');


  id1 = '101';
  id2= '102';
  id3= '103';
  id4= '104';
  id5= '105';
  id6= '106';
  id7= '107';

  designlist1: any;

  constructor(private designerService: DesignerService,private router: Router) {}

  public getDetails() {
    this.designerService.getAlldesigndetails(this.id1).subscribe((data) => {
      this.design1 = data;
      console.log(this.design1);
      console.log(data);
    });

    this.designerService.getAlldesigndetails(this.id2).subscribe((data) => {
      this.design2 = data;
      console.log(this.design2);
      console.log(data);
    });

    this.designerService.getAlldesigndetails(this.id3).subscribe((data) => {
      this.design3 = data;
      console.log(this.design3);
      console.log(data);
    });

    this.designerService.getAlldesigndetails(this.id4).subscribe((data) => {
      this.design4 = data;
      console.log(this.design4);
      console.log(data);
    });

    this.designerService.getAlldesigndetails(this.id5).subscribe((data) => {
      this.design5 = data;
      console.log(this.design5);
      console.log(data);
    });

    this.designerService.getAlldesigndetails(this.id6).subscribe((data) => {
      this.design6 = data;
      console.log(this.design6);
      console.log(data);
    });

    this.designerService.getAlldesigndetails(this.id7).subscribe((data) => {
      this.design7 = data;
      console.log(this.design6);
      console.log(data);
    });

    
  }

  clickMe(){
    this.designerService.sendClickEvent();
  }

main(){
  this.getDetails();
   this.clickMe();

}
public main1() {
  this.getDetails();
  this.router.navigate(['/designdetails']);
}

}
