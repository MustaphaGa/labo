import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {TestCovidv1bilanfinanceService} from "../../../gs-api/src/services/test-covidv-1bilanfinance.service";
import {BilanFinancierDTO} from "../../../gs-api/src/models/bilan-financier-dto";

@Injectable({
  providedIn: 'root'
})
export class BilanFinanceService {

  constructor(private testCovidv1bilanfinanceService: TestCovidv1bilanfinanceService) { }
  enregistrerBilanFinance(bialnFinancierDto: BilanFinancierDTO): Observable<BilanFinancierDTO> {
    return this.testCovidv1bilanfinanceService.save(bialnFinancierDto);

  }
  findAllBilanFinance(): Observable<BilanFinancierDTO[]> {
    return this.testCovidv1bilanfinanceService.findAll();
  }
  findBilanFinanceById(idBilan?: number): Observable<BilanFinancierDTO> {
    if (idBilan) {
      return this.testCovidv1bilanfinanceService.findById(idBilan);
    }
    return of();
  }
  deleteBilanFinance(idBilan?: number): Observable<any>{
    if (idBilan) {
      return this.testCovidv1bilanfinanceService.delecte(idBilan);
    }
    return of();
  }

}
