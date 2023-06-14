import { Injectable } from '@angular/core';
import {AuthenticationService, TestCovidv1employeService} from '../../../gs-api/src/services';
import { Router } from '@angular/router';
import {AuthenticationRequest} from '../../../gs-api/src/models/authentication-request';
import {AuthenticationReponse} from '../../../gs-api/src/models/authentication-reponse';
import {Observable, of} from "rxjs";
import {EmployeDTO} from "../../../gs-api/src/models/employe-dto";




@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(
    private authenticationService: AuthenticationService,
    private  testCovidv1employeService: TestCovidv1employeService,
    private  router:Router) {
  }

  // tslint:disable-next-line:typedef
  login(authenticationRequest: AuthenticationRequest): Observable<AuthenticationReponse> {

    return  this.authenticationService.authenticate(authenticationRequest);
  }
  getUserByEmail(email?: string): Observable<EmployeDTO> {
    if (email !== undefined) {
      return this.testCovidv1employeService.findByEmail(email);
    }
    return of();
  }
 /* setConnectedUser(authenticatorResponse: AuthenticationReponse): void{
    localStorage.setItem('connectedUser' ,JSON.stringify(authenticatorResponse));
  }*/
  setAccessToken(authenticationResponse: AuthenticationReponse): void {
    localStorage.setItem('accessToken', JSON.stringify(authenticationResponse));
  }


  setConnectedUser(employe: EmployeDTO): void {
    localStorage.setItem('connectedUser', JSON.stringify(employe));
  }
  getConnectedUser(): EmployeDTO {
    if (localStorage.getItem('connectedUser')) {
      return JSON.parse(localStorage.getItem('connectedUser') as string);
    }
    return {};
  }
  //TODO
  isUserLoggedAndAcessTokenValid(){
    if(localStorage.getItem('accessToken')) {
      //IL FAUT verfier si le access token est valid
      return true;
    }
    this.router.navigate(['pagAccPrincp']);
    return  false;

  }


}
