import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { HttpHeaders, HttpClient } from "@angular/common/http";
import { CookieService } from 'ngx-cookie-service';
import { NewUserDTO } from "../Domains/app-interfaces";

@Injectable()
export class AppService {
  constructor(
    private _router: Router, private _http: HttpClient, private cookie: CookieService){}
  
  obtainAccessToken(username:string, password:string){
    let headers = new HttpHeaders({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8', 'Authorization': 'Basic '+btoa("gigy:secret")});
    let success=false;
    let params = new URLSearchParams();
    params.append('username',username);
    params.append('password',password);    
    params.append('grant_type','password');
    params.append('client_id','gigy');
     
   return this._http.post('http://localhost:8080/oauth/token', params.toString(), {headers:headers});
  }
 
  saveToken(token){
    var expireDate = 1/24;
    this.cookie.set("access_token", token.access_token, expireDate);
    this._router.navigate(['/list']);
  }
 
  getHeader() : HttpHeaders{
    var headers = new HttpHeaders({'Accept': 'application/json', 'Authorization': 'Bearer '+this.cookie.get('access_token')});
    console.log(headers);
    return headers;
  }
 
  isLogged():boolean{
    if (!this.cookie.check('access_token')){
       // this._router.navigate(['/login']);
        return false;
    }else {
        return true;
    }
  } 
 
  logout() {
    this.cookie.delete('access_token');
    this._router.navigate(['/login']);
  } 

  register(newUser: NewUserDTO){
      return this._http.post("http://localhost:8080/register", newUser);
  }
}