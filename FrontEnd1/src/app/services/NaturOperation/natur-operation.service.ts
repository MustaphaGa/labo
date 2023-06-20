import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {NatureOperationDTO} from "../../../gs-api/src/models/nature-operation-dto";
import {NatureOperationService} from "../../../gs-api/src/services/nature-operation.service";

@Injectable({
  providedIn: 'root'
})
export class NaturOperationService {

  constructor(
    private naOperationService: NatureOperationService)
  {}

  findAllNatureOperation(): Observable<NatureOperationDTO[]> {
    return this.naOperationService.findAll();
  }

  findNatureOperationById(idNatureOperation?: number): Observable<NatureOperationDTO> {
    if (idNatureOperation) {
      return this.naOperationService.findById(idNatureOperation);
    }
    return of();
  }
  deleteNatureOperation(idNatureOperation?: number): Observable<any>{
    if (idNatureOperation) {
      return this.naOperationService.delecte(idNatureOperation);
    }
    return of();
  }


}
