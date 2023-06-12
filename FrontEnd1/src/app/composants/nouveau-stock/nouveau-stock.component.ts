import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StockServices } from 'src/app/services/stock/stock.service';
import { StockDTO } from 'src/gs-api/src/models/stock-dto';

@Component({
  selector: 'app-nouveau-stock',
  templateUrl: './nouveau-stock.component.html',
  styleUrls: ['./nouveau-stock.component.css']
})
export class NouveauStockComponent implements OnInit {

  [x: string]: any;
  stockDt: StockDTO={};
  listestock: Array<StockDTO> =[];
  
 
  errorMsg: Array<string> = [];
  patientErrorMsg='';

  constructor( 
    private router:Router,
    private activatedRouter:ActivatedRoute,
    private  stockservices:StockServices,
    ) { }

  ngOnInit(): void {
   

    const idStock = this.activatedRouter.snapshot.params.idStock;
    if (idStock) {
      this.stockservices.findStockById(idStock)
      .subscribe(stock => {
        this.stockDt = stock;

      });
    }
  
  
  }
  

  cancel(): void {
    this.router.navigate(['stock']);
  }
  enregistrerStock(): void {

    this.stockservices.enregistrerStock(this.stockDt)
    .subscribe(res => {
    this.router.navigate(['stock']);
   // console.log(">>>>>>"+this.patientDt);
    }, error => {
      this.errorMsg = error.error.errors;
    });
  }
 
 

}

