import { Component, OnInit } from '@angular/core';
import { ReviewFields } from './reviewfields';
import { ReviewService } from './../service/review.service';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  fields: {name?:string;email?:string;rating?:string;suggestion?:string;}=new ReviewFields("","","","");
  message:any;

  constructor(private service:ReviewService) { }

  ngOnInit() {
  }
  

  public reviewNow(){
let resp=this.service.doReview(this.fields);
resp.subscribe((data)=>this.message=data);
  }

}
