import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {


  url="http://localhost:8083"

  constructor(private http: HttpClient) { }

  generateToken(data:any){
    return this.http.post(`${this.url}/token`,data)
  }
  
  SetToken(token:any){
    localStorage.setItem("token", token)
    return true;
  }
  addUser(data:any){
    return this.http.post(`${this.url}/registerNewUsers`, data)
  }


}
