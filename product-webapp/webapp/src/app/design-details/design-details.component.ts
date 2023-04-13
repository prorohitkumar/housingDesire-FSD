import { Component, OnInit } from '@angular/core';
import { DesigndetailService } from '../service/designdetail.service';
import { DesignDetail } from './design-detail';
import { Router } from '@angular/router';

@Component({
  selector: 'app-design-details',
  templateUrl: './design-details.component.html',
  styleUrls: ['./design-details.component.css']
})
export class DesignDetailsComponent {
  designdetail1: {
    d_name?: string;
    d_cost?: number;
    d_description?: string;
    name?:String,
    mobile_no?: string;
    d_color?: string;
    d_material?: string;
    d_area?: string;
    d_location?: string;
    posted_date?: string;
    DesignType?:String,
  } = new DesignDetail('', '', 0, '', '', '', 0, '', '', '','','');

  id = '105';
  designlist1: any;

  constructor(private designdetailService: DesigndetailService,private router: Router,) {}

  public getDetails() {
    this.designdetailService.getAlldesigndetails(this.id).subscribe((data) => {
      this.designdetail1 = data;
      console.log(this.designdetail1);
      console.log(data);
    });
  }


  ngOnInit(): void {}

  paypage(data: any): void {
    alert('pay page working..' + data);
    console.log(data);
  }
  chatpage(data: any): void {
    alert('chat page working..' + data);
    console.log(data);
  }
  public logout() {
    this.getDetails();
    this.router.navigate(['/home']);
  }
  public payNow(){
    window.open("http://localhost:8084/"+this.designdetail1.d_cost+"/"+this.designdetail1.d_name);
  }
}