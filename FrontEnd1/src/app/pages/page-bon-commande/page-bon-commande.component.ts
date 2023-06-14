import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BonCommandeDTO } from 'src/gs-api/src/models/bon-commande-dto';
import { BonCommandeServices } from 'src/app/services/BonCommande/bon-commande.service';

@Component({
  selector: 'app-page-bon-commande',
  templateUrl: './page-bon-commande.component.html',
  styleUrls: ['./page-bon-commande.component.css']
})
export class PageBonCommandeComponent implements OnInit {

  listeBon :Array<BonCommandeDTO>  = [];
  errorMsgs = '';
    constructor( 
      private router:Router,
      private boncommandeServices:BonCommandeServices
    
      ) { }
  
    ngOnInit(): void {
    this.findlisteBon();
     }
      
      findlisteBon(): void {
        this.boncommandeServices.findAllBon().subscribe(res => {
          this.listeBon=res;
      })
    }
    
    nouveauBonCommande(): void{
      this.router.navigate(['nouveauBonCommande']);
    }
    exporteBonCommande():void{
      this.router.navigate(['exporteBonCommande']);
    }
    
    handleSuppression(event: any): void{
      if (event === 'success') {
        this.findlisteBon;
      } else {
        this.errorMsgs = event;
      }
    
    }
  
  }
  

  
