import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StockDTO } from 'src/gs-api/src/models/stock-dto';
import { StockServices } from 'src/app/services/stock/stock.service';


@Component({
  selector: 'app-page-stock',
  templateUrl: './page-stock.component.html',
  styleUrls: ['./page-stock.component.css']
})
export class PageStockComponent implements OnInit {

  listestock :Array<StockDTO>  = [];
  errorMsgs = '';
    constructor( 
      private router:Router,
      private stockservices:StockServices
    
      ) { }
  
    ngOnInit(): void {
    this.findlisteStock();
     }
      
      findlisteStock(): void {
        this.stockservices.findAllStock().subscribe(res => {
          this.listestock=res;
      })
    }
    
    nouveauStock(): void{
      this.router.navigate(['nouveauStock']);
    }
    exporterStock():void{
      this.router.navigate(['exporteStock']);
    }
    
    handleSuppression(event: any): void{
      if (event === 'success') {
        this.findlisteStock;
      } else {
        this.errorMsgs = event;
      }
    
    }
  
  }
  