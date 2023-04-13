import { CustomerService } from './../_services/customer.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  message:any;
  constructor(private userService: CustomerService) { }

  ngOnInit(): void {
    this.forUser();
  }

  forUser() {
    this.userService.forUser().subscribe(
      (response) => {
        console.log(response);
        this.message = response;
      }, 
      (error)=>{
        console.log(error);
      }
    );
  }

  // forAdmin() {
  //   this.userService.forUser().subscribe(
  //     (response) => {
  //       console.log(response);
  //       this.message = response;
  //     }, 
  //     (error)=>{
  //       console.log(error);
  //     }
  //   );
  // }
}
