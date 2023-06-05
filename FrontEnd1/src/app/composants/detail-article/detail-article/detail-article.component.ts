import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { ArticleServices } from 'src/app/services/article/article.service';
import { ArticleDTO } from 'src/gs-api/src/models/article-dto';

@Component({
  selector: 'app-detail-article',
  templateUrl: './detail-article.component.html',
  styleUrls: ['./detail-article.component.css']
})
export class DetailArticleComponent implements OnInit {

  @Input()
  articleDt: ArticleDTO ={};
  @Output()
 suppressionReservation = new EventEmitter();
  
  constructor(
    private router:Router,
    private   articleServices :ArticleServices,
  ) { }

  ngOnInit(): void {
  }
  modifierArticle():void{
    this.router.navigate(['nouveauArticle',this.articleDt.idArticle])
  }
  detailArticle():void{
    this.router.navigate(['detailArticle',this.articleDt.idArticle])
  }
  confirmerEtSupprimerArticle(): void{
    if(this.articleDt.idArticle){
     this.articleServices.deleteArticle(this.articleDt.idArticle)
      .subscribe(res => {
       this.suppressionReservation.emit('success');
      }, error => {
        this.suppressionReservation.emit(error.error.error);
      });
 }
 }

}

