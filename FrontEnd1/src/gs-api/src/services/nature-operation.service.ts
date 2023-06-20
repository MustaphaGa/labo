/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { NatureOperationDTO } from '../models/nature-operation-dto';
@Injectable({
  providedIn: 'root',
})
class NatureOperationService extends __BaseService {
  static readonly findAllPath = '/testCovid/v1/natureOperation/all';
  static readonly savePath = '/testCovid/v1/natureOperation/create';
  static readonly delectePath = '/testCovid/v1/natureOperation/delete/{idNatureOperation}';
  static readonly findByIdPath = '/testCovid/v1/natureOperation/{idNatureOperation}';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Cette methode permet de rechercher et renvoyer la listes des natures d'operation qui existent dans la BDD
   * @return la liste des natures d'operation / une liste vide
   */
  findAllResponse(): __Observable<__StrictHttpResponse<Array<NatureOperationDTO>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/testCovid/v1/natureOperation/all`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<NatureOperationDTO>>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher et renvoyer la listes des natures d'operation qui existent dans la BDD
   * @return la liste des natures d'operation / une liste vide
   */
  findAll(): __Observable<Array<NatureOperationDTO>> {
    return this.findAllResponse().pipe(
      __map(_r => _r.body as Array<NatureOperationDTO>)
    );
  }

  /**
   * Cette methode permet d'enregistrer ou modifier un nature d'operation
   * @param body undefined
   * @return l'objet natureOperation cree/modifie
   */
  saveResponse(body?: NatureOperationDTO): __Observable<__StrictHttpResponse<NatureOperationDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/testCovid/v1/natureOperation/create`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<NatureOperationDTO>;
      })
    );
  }
  /**
   * Cette methode permet d'enregistrer ou modifier un nature d'operation
   * @param body undefined
   * @return l'objet natureOperation cree/modifie
   */
  save(body?: NatureOperationDTO): __Observable<NatureOperationDTO> {
    return this.saveResponse(body).pipe(
      __map(_r => _r.body as NatureOperationDTO)
    );
  }

  /**
   * Cette methode permet de supprimer un nature d'operation par ID
   * @param idNatureOperation undefined
   * @return Nature d'operation a été supprimer
   */
  delecteResponse(idNatureOperation: number): __Observable<__StrictHttpResponse<NatureOperationDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/testCovid/v1/natureOperation/delete/${idNatureOperation}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<NatureOperationDTO>;
      })
    );
  }
  /**
   * Cette methode permet de supprimer un nature d'operation par ID
   * @param idNatureOperation undefined
   * @return Nature d'operation a été supprimer
   */
  delecte(idNatureOperation: number): __Observable<NatureOperationDTO> {
    return this.delecteResponse(idNatureOperation).pipe(
      __map(_r => _r.body as NatureOperationDTO)
    );
  }

  /**
   * Cette methode permet de rechercher  un nature d'operation par son ID
   * @param idNatureOperation undefined
   * @return la nature d'operation a ete trouver dans la BDD
   */
  findByIdResponse(idNatureOperation: number): __Observable<__StrictHttpResponse<NatureOperationDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/testCovid/v1/natureOperation/${idNatureOperation}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<NatureOperationDTO>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher  un nature d'operation par son ID
   * @param idNatureOperation undefined
   * @return la nature d'operation a ete trouver dans la BDD
   */
  findById(idNatureOperation: number): __Observable<NatureOperationDTO> {
    return this.findByIdResponse(idNatureOperation).pipe(
      __map(_r => _r.body as NatureOperationDTO)
    );
  }
}

module NatureOperationService {
}

export { NatureOperationService }
