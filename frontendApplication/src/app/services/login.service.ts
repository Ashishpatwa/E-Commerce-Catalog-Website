import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url="http://localhost:8083"

  constructor(private http: HttpClient) { }

  //calling server to generate

  doLogin(data:any){
    return this.http.post(`${this.url}/token`,data)
  }

  getFirstnameAndLastName(gmail: any){
    return this.http.get(`${this.url}/getUserName/${gmail}`,{})
  }


// login user
loginUser(token:any){
  localStorage.setItem("token", token)
  return true;
}

isLoggedIn(){
  let token = localStorage.getItem("token");
  if(token === undefined || token === '' || token === null){
    return false;
  }
  return true;
}

logout(){
  localStorage.removeItem("token");
  localStorage.removeItem("user");
  return true;
}

getToken(){
  return localStorage.getItem("token");
}

}
