import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { BonCommandeDTO } from 'src/gs-api/src/models/bon-commande-dto';
import {  BoncommandeService } from 'src/gs-api/src/services';

@Injectable({
  providedIn: 'root'
})
export class BonCommandeServices {


  constructor(
    private boncommandeService: BoncommandeService)
     { }
     
   enregistrerBon(BcommandeDt:BonCommandeDTO):Observable<BonCommandeDTO> {
    return this.boncommandeService.save(BcommandeDt);
  }
  findAllBon(): Observable<BonCommandeDTO[]> {
   return this.boncommandeService.findAll();
 }

 findBonById(idBonCommande?: number): Observable<BonCommandeDTO> {
   if (idBonCommande) {
     return this.boncommandeService.findById(idBonCommande);
   }
   return of();
 }

 deleteBon(idBonCommande?: number):Observable<any>{
   if (idBonCommande) {
     return this.boncommandeService.delecte(idBonCommande);
   }
   return of();
 }

}

