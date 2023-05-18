import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';
import {LaboDTO} from '../../../gs-api/src/models/labo-dto';

@Injectable({
  providedIn: 'root'
})
export class LaboService {

  constructor(private laboService: LaboService) { }
  /*enregistrerLbao(laboDto: LaboDTO): Observable<LaboDTO> {
    return this.laboService.save(laboDto);

  }
  findAllLabo(): Observable<LaboDTO[]> {
    return this.laboService.findAll();
  }
 /* findLbaoById(idLabo?: number): Observable<LaboDTO> {
    if (idLabo) {
      return this.laboService.findById(idLabo);
    }
    return of();
  }*/

}
