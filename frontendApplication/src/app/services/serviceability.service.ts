import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ServiceabilityService {

  url="http://localhost:8083"

  constructor(private http: HttpClient) { }


  checkServiceability(productId:any, pincode:any){
    return  this.http.get(`${this.url}/serviceabilty/${productId}/${pincode}`);
   
  }



}
