import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {TestCovidv1compteService} from "../../../gs-api/src/services/test-covidv-1compte.service";
import {CompteDTO} from "../../../gs-api/src/models/compte-dto";

@Injectable({
  providedIn: 'root'
})
export class CompteService {
  constructor(
    private testCovidv1compteService: TestCovidv1compteService)
  { }

  enregistrerCompte(compteDto: CompteDTO): Observable<CompteDTO> {
    return this.testCovidv1compteService.save(compteDto);
  }
  findAllCompte(): Observable<CompteDTO[]> {
    return this.testCovidv1compteService.findAll();
  }

  findCompteById(idCompte?: number): Observable<CompteDTO> {
    if (idCompte) {
      return this.testCovidv1compteService.findById(idCompte);
    }
    return of();
  }

  deleteCompte(idCompte?: number): Observable<any>{
    if (idCompte) {
      return this.testCovidv1compteService.delete(idCompte);
    }
    return of();

  }
}
