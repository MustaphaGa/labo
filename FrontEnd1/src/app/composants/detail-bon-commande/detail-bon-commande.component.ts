import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BonCommandeServices } from 'src/app/services/BonCommande/bon-commande.service';
import { BonCommandeDTO } from 'src/gs-api/src/models/bon-commande-dto';

@Component({
  selector: 'app-detail-bon-commande',
  templateUrl: './detail-bon-commande.component.html',
  styleUrls: ['./detail-bon-commande.component.css']
})
export class DetailBonCommandeComponent implements OnInit {

  
 
  @Input()
  boncommandeDt: BonCommandeDTO = {};
    @Output()
  suppressionBon = new EventEmitter();
  constructor(
    private router:Router,
    private bonCommandeServices:BonCommandeServices
  ) { };

  ngOnInit(): void {
    }
    modifierBon():void{
      this.router.navigate(['nouveauBonCommande',this.boncommandeDt.idBonCommande])
    }

    detaillresultat(): void{
      this.router.navigate(['detailBonCommande',this.boncommandeDt.idBonCommande]);

    }

    confirmerEtSupprimerBon(): void{
      if(this.boncommandeDt.idBonCommande){
       this.bonCommandeServices.deleteBon(this.boncommandeDt.idBonCommande)
        .subscribe(res => {
         this.suppressionBon.emit('success');
        }, error => {
          this.suppressionBon.emit(error.error.error);
        });
   }
   }

  }



