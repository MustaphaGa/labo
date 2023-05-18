/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { RhDTO } from '../models/rh-dto';
@Injectable({
  providedIn: 'root',
})
class TestCovidv1rhService extends __BaseService {
  static readonly findAllPath = '/testCovid/v1/rh/all';
  static readonly savePath = '/testCovid/v1/rh/create';
  static readonly delectePath = '/testCovid/v1/rh/delete/{idRh}';
  static readonly findByIdPath = '/testCovid/v1/rh/{idRh}';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Cette methode permet de rechercher et renvoyer la listes des rh qui existent dans la BDD
   * @return successful operation
   */
  findAllResponse(): __Observable<__StrictHttpResponse<Array<RhDTO>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/testCovid/v1/rh/all`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<RhDTO>>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher et renvoyer la listes des rh qui existent dans la BDD
   * @return successful operation
   */
  findAll(): __Observable<Array<RhDTO>> {
    return this.findAllResponse().pipe(
      __map(_r => _r.body as Array<RhDTO>)
    );
  }

  /**
   * Cette methode permet d'enregistrer ou modifier un rh
   * @param body undefined
   * @return l'objet patient cree / modifie
   */
  saveResponse(body?: RhDTO): __Observable<__StrictHttpResponse<RhDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/testCovid/v1/rh/create`,
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
   * Cette methode permet d'enregistrer ou modifier un rh
   * @param body undefined
   * @return l'objet patient cree / modifie
   */
  save(body?: RhDTO): __Observable<RhDTO> {
    return this.saveResponse(body).pipe(
      __map(_r => _r.body as RhDTO)
    );
  }

  /**
   * Cette methode permet de supprimer un rh par ID
   * @param idRh undefined
   * @return rh a ete supprimer
   */
  delecteResponse(idRh: number): __Observable<__StrictHttpResponse<RhDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/testCovid/v1/rh/delete/${idRh}`,
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
   * Cette methode permet de supprimer un rh par ID
   * @param idRh undefined
   * @return rh a ete supprimer
   */
  delecte(idRh: number): __Observable<RhDTO> {
    return this.delecteResponse(idRh).pipe(
      __map(_r => _r.body as RhDTO)
    );
  }

  /**
   * Cette methode permet de rechercher  un rh par son ID
   * @param idRh undefined
   * @return  rh a ete trouver dans la BDD
   */
  findByIdResponse(idRh: number): __Observable<__StrictHttpResponse<RhDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/testCovid/v1/rh/${idRh}`,
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
   * Cette methode permet de rechercher  un rh par son ID
   * @param idRh undefined
   * @return  rh a ete trouver dans la BDD
   */
  findById(idRh: number): __Observable<RhDTO> {
    return this.findByIdResponse(idRh).pipe(
      __map(_r => _r.body as RhDTO)
    );
  }
}

module TestCovidv1rhService {
}

export { TestCovidv1rhService }
