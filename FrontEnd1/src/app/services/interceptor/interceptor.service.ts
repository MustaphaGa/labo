import { Injectable } from '@angular/core';
import {HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from 'rxjs';
import {AuthenticationReponse} from '../../../gs-api/src/models/authentication-reponse';
import {UserService} from "../user/user.service";
import {AuthserviceService} from "../authservice.service";


@Injectable({
  providedIn: 'root'
})
export class InterceptorService implements  HttpInterceptor {

 constructor() {
 }
 intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
   let authenticationResponse: AuthenticationReponse = {};
   if (localStorage.getItem('connectedUser')) {
     authenticationResponse = JSON.parse(
       localStorage.getItem('connectedUser') as string
     );
     }
   const authReq = req.clone({
     headers: new HttpHeaders({
       Authorization: 'Bearer ' + authenticationResponse.accessToken
     })
   });
   return next.handle(authReq);
 }

}

 /*constructor(private authservice: AuthserviceService) {}

 intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
   const token = this.authservice.getToken();

   if (token) {
     request = request.clone({
       setHeaders: {
         Authorization: `Bearer ${token}`
       }
     });
   }

   return next.handle(request);
 }
}*/
