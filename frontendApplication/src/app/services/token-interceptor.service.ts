// import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
// import { Injectable, Injector } from '@angular/core';
// import { Observable, catchError, throwError } from 'rxjs';
// import { Router } from '@angular/router';

// @Injectable({
//   providedIn: 'root'
// })
// export class TokenInterceptorService implements HttpInterceptor {

//   constructor(private inject:Injector, private router: Router) {}
//   intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
//     const token = localStorage.getItem("token");
    
//     const jwtToken = req.clone({
//       setHeaders: {
//         Authorization: 'Bearer '+token
//       }
//     });
//     return next.handle(jwtToken)
//   }
// }

import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from "@angular/common/http";

import { Injectable } from "@angular/core";

import { Router } from "@angular/router";

import { catchError, Observable, throwError } from "rxjs";

import { LoginService } from "../services/login.service";




@Injectable({

    providedIn: 'root'

  })

 

export class AuthInterceptor implements HttpInterceptor{

    constructor(

        private _userService:LoginService,

        private _router: Router

    ){}




    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        const token = this._userService.getToken();

        const auth = 'Bearer '+token;

        let tokenizedReq = req;

        if(token!=null){

            tokenizedReq = req.clone({

                headers: req.headers.set('Authorization',auth)

            })

        }

        return next.handle(tokenizedReq);

    }




}




// export const authInterceptorProviders = [

//     {

//         provide:HTTP_INTERCEPTORS,

//         useClass:AuthInterceptor,

//         multi:true

//     }

// ];


