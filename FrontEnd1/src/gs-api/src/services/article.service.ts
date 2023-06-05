/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { ArticleDTO } from '../models/article-dto';
@Injectable({
  providedIn: 'root',
})
class ArticleService extends __BaseService {
  static readonly findAllPath = '/testCovid/v1/article/all';
  static readonly savePath = '/testCovid/v1/article/create';
  static readonly delectePath = '/testCovid/v1/article/delete/{idArticle}';
  static readonly findByIdPath = '/testCovid/v1/article/{idArticle}';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Cette methode permet de rechercher et renvoyer la listes des articles qui existent dans la BDD
   * @return la liste des articles / une liste vide
   */
  findAllResponse(): __Observable<__StrictHttpResponse<Array<ArticleDTO>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/testCovid/v1/article/all`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<ArticleDTO>>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher et renvoyer la listes des articles qui existent dans la BDD
   * @return la liste des articles / une liste vide
   */
  findAll(): __Observable<Array<ArticleDTO>> {
    return this.findAllResponse().pipe(
      __map(_r => _r.body as Array<ArticleDTO>)
    );
  }

  /**
   * Cette methode permet d'enregistrer ou modifier un article
   * @param body undefined
   * @return l'objet article cree / modifie
   */
  saveResponse(body?: ArticleDTO): __Observable<__StrictHttpResponse<ArticleDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/testCovid/v1/article/create`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ArticleDTO>;
      })
    );
  }
  /**
   * Cette methode permet d'enregistrer ou modifier un article
   * @param body undefined
   * @return l'objet article cree / modifie
   */
  save(body?: ArticleDTO): __Observable<ArticleDTO> {
    return this.saveResponse(body).pipe(
      __map(_r => _r.body as ArticleDTO)
    );
  }

  /**
   * Cette methode permet de supprimer un article par ID
   * @param idArticle undefined
   * @return article a ete supprimer
   */
  delecteResponse(idArticle: number): __Observable<__StrictHttpResponse<ArticleDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/testCovid/v1/article/delete/${idArticle}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ArticleDTO>;
      })
    );
  }
  /**
   * Cette methode permet de supprimer un article par ID
   * @param idArticle undefined
   * @return article a ete supprimer
   */
  delecte(idArticle: number): __Observable<ArticleDTO> {
    return this.delecteResponse(idArticle).pipe(
      __map(_r => _r.body as ArticleDTO)
    );
  }

  /**
   * Cette methode permet de rechercher  un article par son ID
   * @param idArticle undefined
   * @return article a ete trouver dans la BDD
   */
  findByIdResponse(idArticle: number): __Observable<__StrictHttpResponse<ArticleDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/testCovid/v1/article/${idArticle}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ArticleDTO>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher  un article par son ID
   * @param idArticle undefined
   * @return article a ete trouver dans la BDD
   */
  findById(idArticle: number): __Observable<ArticleDTO> {
    return this.findByIdResponse(idArticle).pipe(
      __map(_r => _r.body as ArticleDTO)
    );
  }
}

module ArticleService {
}

export { ArticleService }
