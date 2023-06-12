import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { StockServices } from 'src/app/services/stock/stock.service';
import { StockDTO } from 'src/gs-api/src/models/stock-dto';

@Component({
  selector: 'app-detail-stock',
  templateUrl: './detail-stock.component.html',
  styleUrls: ['./detail-stock.component.css']
})
export class DetailStockComponent implements OnInit {



  @Input()
  stockDto: StockDTO = {};
  @Output()
  suppressionStock = new EventEmitter();
  constructor(
    private router:Router,
    private stockservices:StockServices
  ) { };

  ngOnInit(): void {
   
  
  
    }
    modifierStock():void{
      this.router.navigate(['nouveauStock',this.stockDto.idStock])
    }
    
    detaillStock(): void{
      this.router.navigate(['detailStock',this.stockDto.idStock]);
      
    }
   
    confirmerEtSupprimerStock(): void{
      if(this.stockDto.idStock){
       this.stockservices.deleteStock(this.stockDto.idStock)
        .subscribe(res => {
         this.suppressionStock.emit('success');
        }, error => {
          this.suppressionStock.emit(error.error.error);
        });
   }
   }
  
  }

