import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';
import {LaboDTO} from '../../../gs-api/src/models/labo-dto';
import {TestCovidv1laboService} from '../../../gs-api/src/services/test-covidv-1labo.service';

@Injectable({
  providedIn: 'root'
})
export class LaboService {

  constructor(private testCovidv1laboService: TestCovidv1laboService) { }
  enregistrerLbao(laboDto: LaboDTO): Observable<LaboDTO> {
    return this.testCovidv1laboService.save(laboDto);

  }
  findAllLabo(): Observable<LaboDTO[]> {
    return this.testCovidv1laboService.findAll();
  }
  findLbaoById(idLabo?: number): Observable<LaboDTO> {
    if (idLabo) {
      return this.testCovidv1laboService.findById(idLabo);
    }
    return of();
  }
  deletelabo(idlabo?: number): Observable<LaboDTO>{
    if (idlabo) {
      return this.testCovidv1laboService.delete(idlabo);
    }
    return of();
  }

}
