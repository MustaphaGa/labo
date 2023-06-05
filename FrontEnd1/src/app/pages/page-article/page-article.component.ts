import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ArticleDTO } from 'src/gs-api/src/models/article-dto';
import { ArticleServices } from 'src/app/services/article/article.service';



@Component({
  selector: 'app-page-article',
  templateUrl: './page-article.component.html',
  styleUrls: ['./page-article.component.css']
})
export class PageArticleComponent implements OnInit {

  listeArticles :Array<ArticleDTO>  = [];
  errorMsgs = '';
    constructor( 
      private router:Router,
      private articleServices:ArticleServices
    
      ) { }
  
    ngOnInit(): void {
    this.findlisteArticle();
     }
      
      findlisteArticle(): void {
        this.articleServices.findAllArticle().subscribe(res => {
          this.listeArticles=res;
      })
    }
    
    nouveauArticle(): void{
      this.router.navigate(['nouveauArticle']);
    }
    exporteArticle():void{
      this.router.navigate(['exporteArticle']);
    }
    
    handleSuppression(event: any): void{
      if (event === 'success') {
        this.findlisteArticle;
      } else {
        this.errorMsgs = event;
      }
    
    }
  
  }
  
