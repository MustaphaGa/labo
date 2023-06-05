import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ArticleDTO } from 'src/gs-api/src/models/article-dto';
import { ArticleService } from 'src/gs-api/src/services';

@Injectable({
  providedIn: 'root'
})
export class ArticleServices {

  constructor(
    private articleService: ArticleService)
     { }
     
   enregistrerArticle(articleDt:ArticleDTO):Observable<ArticleDTO> {
    return this.articleService.save(articleDt);
  }
  findAllArticle(): Observable<ArticleDTO[]> {
   return this.articleService.findAll();
 }

 findArticleById(idArticle?: number): Observable<ArticleDTO> {
   if (idArticle) {
     return this.articleService.findById(idArticle);
   }
   return of();
 }

 deleteArticle(idArticle?: number):Observable<any>{
   if (idArticle) {
     return this.articleService.delecte(idArticle);
   }
   return of();

}
}
