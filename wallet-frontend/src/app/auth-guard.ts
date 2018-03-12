import { CanActivate } from "@angular/router";

import { ActivatedRouteSnapshot, RouterStateSnapshot, Router } from "@angular/router";
import { Injectable } from "@angular/core";
import { AppService } from "./Services/auth-service";

@Injectable()
export class AuthGuard implements CanActivate {
  
    constructor(private authService: AppService, private route:Router){}
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Promise<boolean> {
        if(!this.authService.isLogged()){
            return true;
        }else {
            this.route.navigateByUrl('/list');
            return false;
        }
    }
  

}