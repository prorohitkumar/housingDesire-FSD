import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Observer } from 'rxjs';
import { User } from '../registration/user';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  baseUrl="http://localhost:9091/registerNewUser"
  constructor(private httpClient: HttpClient) { }


  registerUser(user: User): Observable<Object> {
     console.log(user);
     return (this.httpClient.post(`${this.baseUrl}`,user));
  }

//   registerUser1(user: User): Observable<Object> {
//     console.log(user);
//     return (this.httpClient.post(`${this.baseUrl1}`,user));
//  }
}
