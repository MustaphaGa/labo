import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticleServices } from 'src/app/services/article/article.service';
import { ArticleDTO } from 'src/gs-api/src/models/article-dto';

@Component({
  selector: 'app-article-detaill',
  templateUrl: './article-detaill.component.html',
  styleUrls: ['./article-detaill.component.css']
})
export class ArticleDetaillComponent implements OnInit {

 
  articleDt: ArticleDTO = {};
  constructor(private router:Router,
    private articleServices:ArticleServices,
    private activatedRouter:ActivatedRoute) { }

  ngOnInit(): void {
    const idArticle = this.activatedRouter.snapshot.params.idArticle;
    if (idArticle) {
      this.articleServices.findArticleById(idArticle)
      .subscribe(article => {
        this.articleDt = article;
      });
    }
    console.log(idArticle);
    
   
    }

}
