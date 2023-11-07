import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import{LoginService} from './login.service';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  url="http://localhost:8083"

  constructor(private http: HttpClient,
    private loginService: LoginService) { }

  //calling server to generate

  searchByName(keyword:any){
    return this.http.get(`${this.url}/api/search/name/${keyword}`,{})
  }
  searchByCode(keyword:any){
    return this.http.get(`${this.url}/api/search/code/${keyword}`,{})
  }
  searchByPrice(keyword:any){
    let t= this.loginService.getToken();
    var headerObject = new HttpHeaders().set("Authorization", "Bearer "+t);
    const httpOption = {
      headers: headerObject
    };
    return this.http.get(`${this.url}/api/search/price/${keyword}`,httpOption);
  }

  searchByBrand(keyword:any){
    return this.http.get(`${this.url}/api/search/brand/${keyword}`,{
    })
  }
  searchByAll(keyword:any){
    return this.http.get(`${this.url}/api/search/all/${keyword}`,{})
  }

}
