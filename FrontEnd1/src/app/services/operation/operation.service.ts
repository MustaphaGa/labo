import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {TestCovidv1operationService} from "../../../gs-api/src/services/test-covidv-1operation.service";
import {OperationDTO} from "../../../gs-api/src/models/operation-dto";

@Injectable({
  providedIn: 'root'
})
export class OperationService {

  constructor( private testCovidv1operationService: TestCovidv1operationService ) { }
  enregistrerOperation(operationDto: OperationDTO): Observable<OperationDTO> {
    return this.testCovidv1operationService.save(operationDto);

  }
  findAllOperation(): Observable<OperationDTO[]> {
    return this.testCovidv1operationService.findAll();
  }
  findOperationById(idOperation?: number): Observable<OperationDTO> {
    if (idOperation) {
      return this.testCovidv1operationService.findById(idOperation);
    }
    return of();
  }
  deleteOperation(idOperation?: number): Observable<any>{
    if (idOperation) {
      return this.testCovidv1operationService.delecte(idOperation);
    }
    return of();
  }
}
