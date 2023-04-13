
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../service/customer.service';
import { Customer } from '../customer';

@Component({
  selector: 'app-uprofile',
  templateUrl: './uprofile.component.html',
  styleUrls: ['./uprofile.component.css']
})
export class UprofileComponent implements OnInit {
  [x: string]: any;

  constructor(private router:Router,
    private customerService: CustomerService) { }

  customer:Customer=new Customer();
  customer1:Customer=new Customer();
id = 'customer1@gmail.com';
details:any;

  ngOnInit(): void {
  }

  public redirectCustomer(pageName:String):void{
    //redirect customer to updateCustomerProfile
        console.log(this.customer)
        this.router.navigate([`${pageName}`]);
  }

public getDetails(){
this.customerService.getDetailsById(this.id).subscribe(data=>
  {

    this.customer1=data;
console.log(this.customer1);
console.log(data);

  })



}



  

}
