import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StockServices } from 'src/app/services/stock/stock.service';
import { StockDTO } from 'src/gs-api/src/models/stock-dto';

@Component({
  selector: 'app-stock-detaill',
  templateUrl: './stock-detaill.component.html',
  styleUrls: ['./stock-detaill.component.css']
})
export class StockDetaillComponent implements OnInit {

  stockDt: StockDTO = {};
  constructor(private router:Router,
    private stockservices:StockServices,
    private activatedRouter:ActivatedRoute) { }

  ngOnInit(): void {
    const idStock = this.activatedRouter.snapshot.params.idStock;
    if (idStock) {
      this.stockservices.findStockById(idStock)
      .subscribe(stock => {
        this.stockDt = stock;
      });
    }
    console.log(idStock);
    
   
    }

}

