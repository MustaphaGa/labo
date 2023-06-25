import { Injectable } from '@angular/core';
import {PatientDTO} from '../../../gs-api/src/models/patient-dto';
import {Observable, of} from 'rxjs';
import {TestCovidv1employeService} from '../../../gs-api/src/services/test-covidv-1employe.service';
import {EmployeDTO} from '../../../gs-api/src/models/employe-dto';

@Injectable({
  providedIn: 'root'
})
export class EmployeService {

  constructor(private  testCovidv1employeService: TestCovidv1employeService) { }

  enregistrerEmploye(employeDt: EmployeDTO): Observable<PatientDTO> {
    return this.testCovidv1employeService.save(employeDt);
  }
  findAllEmploye(): Observable<EmployeDTO[]> {
    return this.testCovidv1employeService.findAll();
  }

  findEmployetById(idEmploye?: number): Observable<EmployeDTO> {
    if (idEmploye) {
      return this.testCovidv1employeService.findById(idEmploye);
    }
    return of();
  }
  findCountEmployees(): Observable<number>{
    return this.testCovidv1employeService.findCountEmploye();
  }
  deleteemploye(idEmploye?: number): Observable<any>{
    if (idEmploye) {
      return this.testCovidv1employeService.delete(idEmploye);
    }
    return of();
  }
}
