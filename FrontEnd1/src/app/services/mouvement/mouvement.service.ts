import { Injectable } from '@angular/core';
import {TestCovidv1recrutementService} from '../../../gs-api/src/services/test-covidv-1recrutement.service';
import {RecrutementDTO} from '../../../gs-api/src/models/recrutement-dto';
import {Observable, of} from 'rxjs';
import {AbsenceDTO} from '../../../gs-api/src/models/absence-dto';
import {TestCovidv1mouvementService} from '../../../gs-api/src/services/test-covidv-1mouvement.service';
import {MouvementDTO} from '../../../gs-api/src/models/mouvement-dto';

@Injectable({
  providedIn: 'root'
})
export class MouvementService {
  constructor( private  testCovidv1Mouvement : TestCovidv1mouvementService) { };

  enregistrerMouvement(mouvementDto: MouvementDTO): Observable<MouvementDTO> {
    return this.testCovidv1Mouvement.save(mouvementDto);

  }
  findAllMouvement(): Observable<MouvementDTO[]> {
    return this.testCovidv1Mouvement.findAll();
  }
  findMouvementById(idMouvement?: number): Observable<MouvementDTO> {
    if (idMouvement) {
      return this.testCovidv1Mouvement.findById(idMouvement);
    }
    return of();
  }
  deleteMouvement(idMouvement?: number): Observable<any>{
    if (idMouvement) {
      return this.testCovidv1Mouvement.delecte(idMouvement);
    }
    return of();
  }
}
