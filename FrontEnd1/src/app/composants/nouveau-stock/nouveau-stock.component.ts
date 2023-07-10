import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticleServices } from 'src/app/services/article/article.service';
import { StockServices } from 'src/app/services/stock/stock.service';
import { ArticleDTO } from 'src/gs-api/src/models';
import { StockDTO } from 'src/gs-api/src/models/stock-dto';

@Component({
  selector: 'app-nouveau-stock',
  templateUrl: './nouveau-stock.component.html',
  styleUrls: ['./nouveau-stock.component.css']
})
export class NouveauStockComponent implements OnInit {

  [x: string]: any;
  stockDt: StockDTO={};
  articleDto :ArticleDTO={};
  listestock: Array<StockDTO> =[];
  listearticles: Array<ArticleDTO> =[];

  
 
  errorMsg: Array<string> = [];
  patientErrorMsg='';

  constructor( 
    private router:Router,
    private activatedRouter:ActivatedRoute,
    private  stockservices:StockServices,
    private articleServices:ArticleServices,
    ) { }

  ngOnInit(): void { 
    this.articleServices.findAllArticle().subscribe(article => {
    this.listearticles=article;
    
  });
   

    const idStock = this.activatedRouter.snapshot.params.idStock;
    if (idStock) {
      this.stockservices.findStockById(idStock)
      .subscribe(stock => {
        this.stockDt = stock;
        this.articleDto = this.stockDt.article ? this.stockDt.article: {};


      });
    }
  
  
  }
  

  cancel(): void {
    this.router.navigate(['stock']);
  }
  enregistrerStock(): void {
    this.stockDt.article=this.articleDto

    this.stockservices.enregistrerStock(this.stockDt)
    .subscribe(res => {
    this.router.navigate(['stock']);
   // console.log(">>>>>>"+this.patientDt);
    }, error => {
      this.errorMsg = error.error.errors;
    });
  }
 
 

}

