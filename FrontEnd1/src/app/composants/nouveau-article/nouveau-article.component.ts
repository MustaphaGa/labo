import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticleServices } from 'src/app/services/article/article.service';
import { ArticleDTO } from 'src/gs-api/src/models/article-dto';


@Component({
  selector: 'app-nouveau-article',
  templateUrl: './nouveau-article.component.html',
  styleUrls: ['./nouveau-article.component.css']
})
export class NouveauArticleComponent implements OnInit {

  [x: string]: any;
  articleDt: ArticleDTO={};

  listeArticles: Array<ArticleDTO> =[];


  errorMsg: Array<string> = [];
  patientErrorMsg='';

  constructor(
    private router:Router,
    private activatedRouter:ActivatedRoute,
    private  articleServices:ArticleServices,



    ) { }

  ngOnInit(): void {



    const  idArticle= this.activatedRouter.snapshot.params.idArticle;
    if (idArticle) {
      this.articleServices.findArticleById(idArticle)
      .subscribe(article => {
        this.articleDt = article;

      });
    }
  }





  cancel(): void {
    this.router.navigate(['article']);
  }
  enregistrerArticle(): void {

    this.articleServices.enregistrerArticle(this.articleDt)
    .subscribe(res => {
    this.router.navigate(['article']);
   // console.log(">>>>>>"+this.patientDt);
    }, error => {
      this.errorMsg = error.error.errors;
    });
  }



}

