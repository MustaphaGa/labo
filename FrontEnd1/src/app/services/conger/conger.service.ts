import { Injectable } from '@angular/core';
import {TestCovidv1congeService} from '../../../gs-api/src/services/test-covidv-1conge.service';
import {CongeDTO} from '../../../gs-api/src/models/conge-dto';
import {Observable, of} from 'rxjs';

@Injectable
({
  providedIn: 'root'
})
export class CongerService
{

  constructor(private congeServicees: TestCovidv1congeService) { }
  enregistrerConger(congeDT: CongeDTO): Observable<CongeDTO>
  {
    return this.congeServicees.save(congeDT);
  }

  findAllconger(): Observable<CongeDTO[]>
  {
    return this.congeServicees.findAll();
  }

  findCongerById(idConge?: number): Observable<CongeDTO>
  {
    if (idConge)
    {
      return this.congeServicees.findById(idConge);
    }
    return of();
  }

  deleteConger(idConge?: number): Observable<any>
  {
    if (idConge)
    {
      return this.congeServicees.delecte(idConge);
    }
    return of();
  }

}
