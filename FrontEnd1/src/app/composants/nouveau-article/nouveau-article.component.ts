import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BonCommandeServices } from 'src/app/services/BonCommande/bon-commande.service';
import { ArticleServices } from 'src/app/services/article/article.service';
import { StockServices } from 'src/app/services/stock/stock.service';
import { ArticleDTO } from 'src/gs-api/src/models/article-dto';
import { BonCommandeDTO } from 'src/gs-api/src/models/bon-commande-dto';
import { StockDTO } from 'src/gs-api/src/models/stock-dto';

@Component({
  selector: 'app-nouveau-article',
  templateUrl: './nouveau-article.component.html',
  styleUrls: ['./nouveau-article.component.css']
})
export class NouveauArticleComponent implements OnInit {

  [x: string]: any;
  articleDt: ArticleDTO={};
  stockDt:StockDTO={};
  bonCommandeDt:BonCommandeDTO={};
  listeArticles: Array<ArticleDTO> =[];
  listeStock: Array<StockDTO> =[];
  listeBoncommande: Array<BonCommandeDTO> =[]; 
 
  errorMsg: Array<string> = [];
  patientErrorMsg='';

  constructor( 
    private router:Router,
    private activatedRouter:ActivatedRoute,
    private  articleServices:ArticleServices,
    private  stockservices:StockServices,
    private  boncommandeserv:BonCommandeServices,


    ) { }

  ngOnInit(): void {
    this.stockservices.findAllStock().subscribe(stock => {
      this.listeStock=stock;
    });
     this.boncommandeserv.findAllBon().subscribe(bonCommande => {
      this.listeBoncommande=bonCommande;
    });
     

    const  idArticle= this.activatedRouter.snapshot.params.idArticle;
    if (idArticle) {
      this.articleServices.findArticleById(idArticle)
      .subscribe(article => {
        this.articleDt = article;
        this.stockDt = this.articleDt.stock ? this.articleDt.stock: {};
        this.bonCommandeDt = this.articleDt.bonCommande ? this.articleDt.bonCommande: {};

      }); 
    }
  }
  
  
  
  

  cancel(): void {
    this.router.navigate(['article']);
  }
  enregistrerArticle(): void {
   this.articleDt.bonCommande=this.bonCommandeDt
   this.articleDt.stock=this.stockDt

    this.articleServices.enregistrerArticle(this.articleDt)
    .subscribe(res => {
    this.router.navigate(['article']);
   // console.log(">>>>>>"+this.patientDt);
    }, error => {
      this.errorMsg = error.error.errors;
    });
  }
 
 

}

