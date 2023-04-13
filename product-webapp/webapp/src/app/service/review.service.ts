import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(private http:HttpClient) { }


  public doReview(fields:any){
    return this.http.post("http://localhost:9092/review",fields,{responseType:'text' as 'json'});
  }
}
