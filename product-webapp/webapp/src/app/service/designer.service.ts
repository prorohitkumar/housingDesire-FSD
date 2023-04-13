import { Designer } from '../designer';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DesignerService {

  constructor(private httpClient:HttpClient) { }


    baseurl='http://localhost:8089/api/updateDesignerDetail/103';

    myId = '103';
    baseurl1='http://localhost:8089/api/getDesignerDetail/';
  
    public updateTheDesigner(designer:Designer): Observable<any>{
      console.log(designer);
      
      return this.httpClient.put(`${this.baseurl}`,designer).pipe(
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
  baseurl2='http://localhost:8089/api/getDesign/';

  public getAlldesigndetails(id){
    return this.httpClient.get(`${this.baseurl2+ id}`).pipe(
      catchError(this.handleError)
    );;
 } 
 
 private subject = new Subject<any>();

  sendClickEvent(){
    this.subject.next();

  }

  getClickEvent():Observable<any>{
     return this.subject.asObservable();
  }
 
}
