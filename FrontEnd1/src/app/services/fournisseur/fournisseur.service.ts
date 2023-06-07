import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { FournisseurDTO } from 'src/gs-api/src/models/fournisseur-dto';
import { FournisseurService } from '../../../gs-api/src/services/fournisseur.service';

@Injectable({
  providedIn: 'root'
})
export class FournisseurServices {

  constructor(
    private fournisseurService : FournisseurService
    ) { };

   enregistrerfournisseur(fournisseurDt:FournisseurDTO):Observable<FournisseurDTO> {
     return this.fournisseurService.save(fournisseurDt);
   }
   findAllffournisseur(): Observable<FournisseurDTO[]> {
    return this.fournisseurService.findAll();
  }

  findFournisseurById(idFournisseur?: number): Observable<FournisseurDTO> {
    if (idFournisseur) {
      return this.fournisseurService.findById(idFournisseur);
    }
    return of();
  }
  deleteFournisseur(idFournisseur?: number): Observable<any>{
    if (idFournisseur) {
      return this.fournisseurService.delete(idFournisseur);
    }
    return of();
  }
 

}
