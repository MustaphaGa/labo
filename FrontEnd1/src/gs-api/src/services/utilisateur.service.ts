/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { UtilisateurDTO } from '../models/utilisateur-dto';
@Injectable({
  providedIn: 'root',
})
class UtilisateurService extends __BaseService {
  static readonly findAllPath = '/testCovid/v1/utilisateur/all';
  static readonly savePath = '/testCovid/v1/utilisateur/create';
  static readonly deletePath = '/testCovid/v1/utilisateur/delete/{idUtilisateur}';
  static readonly findByIdPath = '/testCovid/v1/utilisateur/filter{idUtilisateur}';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Cette methode permet de rechercher et renvoyer la listes des utilisateur qui existent dans la BDD
   * @return la liste des utilisateur / une liste vide
   */
  findAllResponse(): __Observable<__StrictHttpResponse<Array<UtilisateurDTO>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/testCovid/v1/utilisateur/all`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<UtilisateurDTO>>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher et renvoyer la listes des utilisateur qui existent dans la BDD
   * @return la liste des utilisateur / une liste vide
   */
  findAll(): __Observable<Array<UtilisateurDTO>> {
    return this.findAllResponse().pipe(
      __map(_r => _r.body as Array<UtilisateurDTO>)
    );
  }

  /**
   * Cette methode permet d'enregistrer ou modifier un utilisateur
   * @param body undefined
   * @return l'objet utilisateur cree / modifie
   */
  saveResponse(body?: UtilisateurDTO): __Observable<__StrictHttpResponse<UtilisateurDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/testCovid/v1/utilisateur/create`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<UtilisateurDTO>;
      })
    );
  }
  /**
   * Cette methode permet d'enregistrer ou modifier un utilisateur
   * @param body undefined
   * @return l'objet utilisateur cree / modifie
   */
  save(body?: UtilisateurDTO): __Observable<UtilisateurDTO> {
    return this.saveResponse(body).pipe(
      __map(_r => _r.body as UtilisateurDTO)
    );
  }

  /**
   * Cette methode permet de supprimer un biologiste par ID
   * @param id undefined
   * @return utilisateur a ete supprimer
   */
  deleteResponse(id: number): __Observable<__StrictHttpResponse<UtilisateurDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/testCovid/v1/utilisateur/delete/${idUtilisateur}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<UtilisateurDTO>;
      })
    );
  }
  /**
   * Cette methode permet de supprimer un biologiste par ID
   * @param id undefined
   * @return utilisateur a ete supprimer
   */
  delete(id: number): __Observable<UtilisateurDTO> {
    return this.deleteResponse(id).pipe(
      __map(_r => _r.body as UtilisateurDTO)
    );
  }

  /**
   * Cette methode permet de rechercher  un utilisateur par son ID
   * @param id undefined
   * @return la utilisateur a ete trouver dans la BDD
   */
  findByIdResponse(id: number): __Observable<__StrictHttpResponse<UtilisateurDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/testCovid/v1/utilisateur/filter${idUtilisateur}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<UtilisateurDTO>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher  un utilisateur par son ID
   * @param id undefined
   * @return la utilisateur a ete trouver dans la BDD
   */
  findById(id: number): __Observable<UtilisateurDTO> {
    return this.findByIdResponse(id).pipe(
      __map(_r => _r.body as UtilisateurDTO)
    );
  }
}

module UtilisateurService {
}

export { UtilisateurService }
