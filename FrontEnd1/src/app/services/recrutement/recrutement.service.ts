import { Injectable } from '@angular/core';
import {TestCovidv1absenceService} from '../../../gs-api/src/services/test-covidv-1absence.service';
import {AbsenceDTO} from '../../../gs-api/src/models/absence-dto';
import {Observable, of} from 'rxjs';
import {TestCovidv1recrutementService} from '../../../gs-api/src/services/test-covidv-1recrutement.service';
import {RecrutementDTO} from '../../../gs-api/src/models/recrutement-dto';

@Injectable({
  providedIn: 'root'
})
export class RecrutementService {

  constructor( private  testCovidv1recrutement : TestCovidv1recrutementService) { };

  enregistrerRecrutemnt(recrutementDto: RecrutementDTO): Observable<AbsenceDTO> {
    return this.testCovidv1recrutement.save(recrutementDto);

  }
  findAllRecrutement(): Observable<AbsenceDTO[]> {
    return this.testCovidv1recrutement.findAll();
  }
  findRecrutemntById(idRecrutement?: number): Observable<RecrutementDTO> {
    if (idRecrutement) {
      return this.testCovidv1recrutement.findByIdRecrutement(idRecrutement);
    }
    return of();
  }
  deleteRecrutement(idRecrutement?: number): Observable<any>{
    if (idRecrutement) {
      return this.testCovidv1recrutement.delecte(idRecrutement);
    }
    return of();
  }
}
