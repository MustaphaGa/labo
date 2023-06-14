import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BonCommandeServices } from 'src/app/services/BonCommande/bon-commande.service';
import { BonCommandeDTO } from 'src/gs-api/src/models/bon-commande-dto';

@Component({
  selector: 'app-bon-commande-detaill',
  templateUrl: './bon-commande-detaill.component.html',
  styleUrls: ['./bon-commande-detaill.component.css']
})
export class BonCommandeDetaillComponent implements OnInit {

 
 
  bonCommandeDt: BonCommandeDTO = {};
  constructor(private router:Router,
    private boncommandeService:BonCommandeServices,
    private activatedRouter:ActivatedRoute) { }

  ngOnInit(): void {
    const idBonCommande = this.activatedRouter.snapshot.params.idBonCommande;
    if (idBonCommande) {
      this.boncommandeService.findBonById(idBonCommande)
      .subscribe(bonCommande => {
        this.bonCommandeDt = bonCommande;
      });
    }
    console.log(idBonCommande);
    
   
    }

}

