import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { StockDTO } from 'src/gs-api/src/models/stock-dto';
import { StockService } from 'src/gs-api/src/services';

@Injectable({
  providedIn: 'root'
})
export class StockServices {


  constructor(
    private stockservice: StockService)
     { }
     
   enregistrerStock(stockDt:StockDTO):Observable<StockDTO> {
    return this.stockservice.save(stockDt);
  }
  findAllStock(): Observable<StockDTO[]> {
   return this.stockservice.findAll();
 }

 findStockById(idStock?: number): Observable<StockDTO> {
   if (idStock) {
     return this.stockservice.findById(idStock);
   }
   return of();
 }

 deleteStock(idStock?: number):Observable<any>{
   if (idStock) {
     return this.stockservice.delete(idStock);
   }
   return of();
 }

}


