import { CustomerService } from '../service/customer.service';
import { Customer } from '../customer';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ucprofile',
  templateUrl: './ucprofile.component.html',
  styleUrls: ['./ucprofile.component.css']
})
export class UCProfileComponent implements OnInit {

  customer:Customer=new Customer();

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    
  }
 

  public updateCustomer(){

    console.log(this.customer)
    this.customerService.updateTheCustomer(this.customer).subscribe(data=>{
      alert(this.customer+"Updated Successfully")
    },error=>alert("cannot update"));
  }
}
