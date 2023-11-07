// import { CanActivateFn } from '@angular/router';

// export const authGuard: CanActivateFn = (route, state) => {
//   return true;
// };

import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, CanActivateChild, Router, RouterStateSnapshot } from "@angular/router";
import { LoginService } from "./login.service";
// import { AuthenticationService } from "../services/authentication.service";
// import { MatDialog } from "@angular/material/dialog";
// import * as alertify from 'alertifyjs';

@Injectable()
export class AuthGuardService implements CanActivate {
    
    constructor(private loginService: LoginService, private router: Router){

    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        if(this.loginService.isLoggedIn()) {
            return true;
        }
        else {
          this.router.navigate(['login'])
            return false;
        }
    }
   

}