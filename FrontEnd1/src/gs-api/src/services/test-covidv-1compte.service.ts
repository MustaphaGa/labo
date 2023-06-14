/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { CompteDTO } from '../models/compte-dto';
@Injectable({
  providedIn: 'root',
})
class TestCovidv1compteService extends __BaseService {
  static readonly findAllPath = '/testCovid/v1/compte/all';
  static readonly savePath = '/testCovid/v1/compte/create';
  static readonly deletePath = '/testCovid/v1/compte/delete/{idCompte}';
  static readonly findByIdPath = '/testCovid/v1/compte/{idCompte}';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Cette methode permet de rechercher et renvoyer la listes des compte qui existent dans la BDD
   * @return la liste des compte / une liste vide
   */
  findAllResponse(): __Observable<__StrictHttpResponse<Array<CompteDTO>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/testCovid/v1/compte/all`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<CompteDTO>>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher et renvoyer la listes des compte qui existent dans la BDD
   * @return la liste des compte / une liste vide
   */
  findAll(): __Observable<Array<CompteDTO>> {
    return this.findAllResponse().pipe(
      __map(_r => _r.body as Array<CompteDTO>)
    );
  }

  /**
   * Cette methode permet d'enregistrer ou modifier un compte
   * @param body undefined
   * @return l'objet compte crée / modifie
   */
  saveResponse(body?: CompteDTO): __Observable<__StrictHttpResponse<CompteDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/testCovid/v1/compte/create`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CompteDTO>;
      })
    );
  }
  /**
   * Cette methode permet d'enregistrer ou modifier un compte
   * @param body undefined
   * @return l'objet compte crée / modifie
   */
  save(body?: CompteDTO): __Observable<CompteDTO> {
    return this.saveResponse(body).pipe(
      __map(_r => _r.body as CompteDTO)
    );
  }

  /**
   * Cette methode permet de supprimer un compte par ID
   * @param idCompte undefined
   * @return compte a été supprimer
   */
  deleteResponse(idCompte: number): __Observable<__StrictHttpResponse<CompteDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/testCovid/v1/compte/delete/${idCompte}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CompteDTO>;
      })
    );
  }
  /**
   * Cette methode permet de supprimer un compte par ID
   * @param idCompte undefined
   * @return compte a été supprimer
   */
  delete(idCompte: number): __Observable<CompteDTO> {
    return this.deleteResponse(idCompte).pipe(
      __map(_r => _r.body as CompteDTO)
    );
  }

  /**
   * Cette methode permet de rechercher  un compte par son ID
   * @param idCompte undefined
   * @return compte a ete trouver dans la BDD
   */
  findByIdResponse(idCompte: number): __Observable<__StrictHttpResponse<CompteDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/testCovid/v1/compte/${idCompte}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CompteDTO>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher  un compte par son ID
   * @param idCompte undefined
   * @return compte a ete trouver dans la BDD
   */
  findById(idCompte: number): __Observable<CompteDTO> {
    return this.findByIdResponse(idCompte).pipe(
      __map(_r => _r.body as CompteDTO)
    );
  }
}

module TestCovidv1compteService {
}

export { TestCovidv1compteService }
