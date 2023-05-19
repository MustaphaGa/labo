/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { ServiceFinanceDTO } from '../models/service-finance-dto';
import { RhDTO } from '../models/rh-dto';
@Injectable({
  providedIn: 'root',
})
class TestCovidv1servicefinanceService extends __BaseService {
  static readonly findAllPath = '/testCovid/v1/servicefinance/all';
  static readonly savePath = '/testCovid/v1/servicefinance/create';
  static readonly delectePath = '/testCovid/v1/servicefinance/delete/{idFinance}';
  static readonly findByIdPath = '/testCovid/v1/servicefinance/{idFinance}';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Cette methode permet de rechercher et renvoyer la listes des servicefinance qui existent dans la BDD
   * @return successful operation
   */
  findAllResponse(): __Observable<__StrictHttpResponse<Array<ServiceFinanceDTO>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/testCovid/v1/servicefinance/all`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<ServiceFinanceDTO>>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher et renvoyer la listes des servicefinance qui existent dans la BDD
   * @return successful operation
   */
  findAll(): __Observable<Array<ServiceFinanceDTO>> {
    return this.findAllResponse().pipe(
      __map(_r => _r.body as Array<ServiceFinanceDTO>)
    );
  }

  /**
   * Cette methode permet d'enregistrer ou modifier un servicefinance
   * @param body undefined
   * @return l'objet servicefinance cree / modifie
   */
  saveResponse(body?: ServiceFinanceDTO): __Observable<__StrictHttpResponse<ServiceFinanceDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/testCovid/v1/servicefinance/create`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ServiceFinanceDTO>;
      })
    );
  }
  /**
   * Cette methode permet d'enregistrer ou modifier un servicefinance
   * @param body undefined
   * @return l'objet servicefinance cree / modifie
   */
  save(body?: ServiceFinanceDTO): __Observable<ServiceFinanceDTO> {
    return this.saveResponse(body).pipe(
      __map(_r => _r.body as ServiceFinanceDTO)
    );
  }

  /**
   * Cette methode permet de supprimer un servicefinance par ID
   * @param idFinance undefined
   * @return rh a ete supprimer
   */
  delecteResponse(idFinance: number): __Observable<__StrictHttpResponse<RhDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/testCovid/v1/servicefinance/delete/${idFinance}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<RhDTO>;
      })
    );
  }
  /**
   * Cette methode permet de supprimer un servicefinance par ID
   * @param idFinance undefined
   * @return rh a ete supprimer
   */
  delecte(idFinance: number): __Observable<RhDTO> {
    return this.delecteResponse(idFinance).pipe(
      __map(_r => _r.body as RhDTO)
    );
  }

  /**
   * Cette methode permet de rechercher  un servicefinance par son ID
   * @param idFinance undefined
   * @return  servicefinance a ete trouver dans la BDD
   */
  findByIdResponse(idFinance: number): __Observable<__StrictHttpResponse<ServiceFinanceDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/testCovid/v1/servicefinance/${idFinance}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ServiceFinanceDTO>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher  un servicefinance par son ID
   * @param idFinance undefined
   * @return  servicefinance a ete trouver dans la BDD
   */
  findById(idFinance: number): __Observable<ServiceFinanceDTO> {
    return this.findByIdResponse(idFinance).pipe(
      __map(_r => _r.body as ServiceFinanceDTO)
    );
  }
}

module TestCovidv1servicefinanceService {
}

export { TestCovidv1servicefinanceService }
