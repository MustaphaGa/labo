/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { ProfilDTO } from '../models/profil-dto';
@Injectable({
  providedIn: 'root',
})
class ProfilService extends __BaseService {
  static readonly findAllPath = '/testCovid/v1/profil/all';
  static readonly savePath = '/testCovid/v1/profil/create';
  static readonly deletePath = '/testCovid/v1/profil/delete/{idProfil}';
  static readonly findByIdPath = '/testCovid/v1/profil/{idProfil}';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Cette methode permet de rechercher et renvoyer la listes des profils qui existent dans la BDD
   * @return la liste des biologiste / une liste vide
   */
  findAllResponse(): __Observable<__StrictHttpResponse<Array<ProfilDTO>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/testCovid/v1/profil/all`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<ProfilDTO>>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher et renvoyer la listes des profils qui existent dans la BDD
   * @return la liste des biologiste / une liste vide
   */
  findAll(): __Observable<Array<ProfilDTO>> {
    return this.findAllResponse().pipe(
      __map(_r => _r.body as Array<ProfilDTO>)
    );
  }

  /**
   * Cette methode permet d'enregistrer ou modifier un profil
   * @param body undefined
   * @return l'objet profil cree / modifie
   */
  saveResponse(body?: ProfilDTO): __Observable<__StrictHttpResponse<ProfilDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/testCovid/v1/profil/create`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ProfilDTO>;
      })
    );
  }
  /**
   * Cette methode permet d'enregistrer ou modifier un profil
   * @param body undefined
   * @return l'objet profil cree / modifie
   */
  save(body?: ProfilDTO): __Observable<ProfilDTO> {
    return this.saveResponse(body).pipe(
      __map(_r => _r.body as ProfilDTO)
    );
  }

  /**
   * Cette methode permet de supprimer un profil par ID
   * @param idProfil undefined
   * @return profil a ete supprimer
   */
  deleteResponse(idProfil: number): __Observable<__StrictHttpResponse<ProfilDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/testCovid/v1/profil/delete/${idProfil}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ProfilDTO>;
      })
    );
  }
  /**
   * Cette methode permet de supprimer un profil par ID
   * @param idProfil undefined
   * @return profil a ete supprimer
   */
  delete(idProfil: number): __Observable<ProfilDTO> {
    return this.deleteResponse(idProfil).pipe(
      __map(_r => _r.body as ProfilDTO)
    );
  }

  /**
   * Cette methode permet de rechercher  un profil par son ID
   * @param idProfil undefined
   * @return la profil a ete trouver dans la BDD
   */
  findByIdResponse(idProfil: number): __Observable<__StrictHttpResponse<ProfilDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/testCovid/v1/profil/${idProfil}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ProfilDTO>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher  un profil par son ID
   * @param idProfil undefined
   * @return la profil a ete trouver dans la BDD
   */
  findById(idProfil: number): __Observable<ProfilDTO> {
    return this.findByIdResponse(idProfil).pipe(
      __map(_r => _r.body as ProfilDTO)
    );
  }
}

module ProfilService {
}

export { ProfilService }
