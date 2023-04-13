import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User1 } from '../upload-design/design';

@Injectable({
  providedIn: 'root'
})
export class UploadDesignService {

  baseUrl="http://localhost:8086/api/addDesignDetail/101";
  constructor(private httpClient: HttpClient) { }


  d_upload(user: User1): Observable<Object> {
     console.log(user);
     return this.httpClient.post(`${this.baseUrl}`,user);
  }
}
