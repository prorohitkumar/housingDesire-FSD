import { Customer } from '../customer';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient:HttpClient) { }

  baseurl='http://localhost:8085/customer/updateCustomer/';
  emailId = 'customer1@gmail.com';
  baseurl1='http://localhost:8085/customer/findCustomer/';

  public updateTheCustomer(customer:Customer): Observable<any>{
    console.log(customer);
    
    return this.httpClient.put(`${this.baseurl + this.emailId}`,customer).pipe(
      catchError(this.handleError)
    );;
  
  }
  private handleError(error: any): Promise<any> {
    console.log(error); // for demo purposes only
    return Promise.reject(error.message || error);
 }

public getDetailsById(id){
  return this.httpClient.get(`${this.baseurl1 +id}`).pipe(
    catchError(this.handleError)
  );; 
}
 


}
