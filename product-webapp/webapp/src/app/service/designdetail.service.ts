import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DesigndetailService {

  baseurl1='http://localhost:8086/api/getDesign/';

  constructor(private httpClient:HttpClient) { }
  
  public getAlldesigndetails(id){
    return this.httpClient.get(`${this.baseurl1+ id}`).pipe(
      catchError(this.handleError)
    );;
}
private handleError(error: any): Promise<any> {
  console.log(error); // for demo purposes only
  return Promise.reject(error.message || error);
}
}
