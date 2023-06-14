import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BonCommandeServices } from 'src/app/services/BonCommande/bon-commande.service';
import { EmployeService } from 'src/app/services/employe/employe.service';
import { FacturesService } from 'src/app/services/facture/factures.service';
import { FournisseurServices } from 'src/app/services/fournisseur/fournisseur.service';
import { BonCommandeDTO } from 'src/gs-api/src/models/bon-commande-dto';
import { EmployeDTO } from 'src/gs-api/src/models/employe-dto';
import { FactureDTO } from 'src/gs-api/src/models/facture-dto';
import { FournisseurDTO } from 'src/gs-api/src/models/fournisseur-dto';

@Component({
  selector: 'app-nouveau-bon-commande',
  templateUrl: './nouveau-bon-commande.component.html',
  styleUrls: ['./nouveau-bon-commande.component.css']
})
export class NouveauBonCommandeComponent implements OnInit {

  [x: string]: any;
  bonCommandeDt: BonCommandeDTO={};
  employeDto:EmployeDTO={};
  fournisseurDto:FournisseurDTO={};
  factureDto:FactureDTO={};
  listeBon: Array<BonCommandeDTO> =[];
  listemploye: Array<EmployeDTO> =[];
  listefournisseur: Array<FournisseurDTO> =[];
  listefacture: Array<FactureDTO> =[];
 
  errorMsg: Array<string> = [];
  patientErrorMsg='';

  constructor( 
    private router:Router,
    private activatedRouter:ActivatedRoute,
    private  bonCommandeServices:BonCommandeServices,
    private employeservice:EmployeService,
    private fournisseurService:FournisseurServices,
    private factureService:FacturesService,

    ) { }

  ngOnInit(): void {
    this.employeservice.findAllEmploye().subscribe(employe => {
      this.listemploye=employe;
    });
      this.fournisseurService.findAllffournisseur().subscribe(fournisseur => {
        this.listefournisseur=fournisseur;
        
      });
        this.factureService.findAllFacture().subscribe(facture => {
          this.listefacture=facture;
      
    });

    const idBonCommande = this.activatedRouter.snapshot.params.idBonCommande;
    if (idBonCommande) {
      this.bonCommandeServices.findBonById(idBonCommande)
      .subscribe(bon => {
        this.bonCommandeDt = bon;
        this.employeDto = this.bonCommandeDt.employe ? this.bonCommandeDt.employe: {};
        this.factureDto = this.bonCommandeDt.facture ? this.bonCommandeDt.facture: {};
        this.fournisseurDto = this.bonCommandeDt.fournisseur ? this.bonCommandeDt.fournisseur: {};

      });
    }
  
  
  }
  

  cancel(): void {
    this.router.navigate(['bonCmd']);
  }
  enregistrerBon(): void {
    this.bonCommandeDt.employe=this.employeDto
    this.bonCommandeDt.facture=this.factureDto
    this.bonCommandeDt.fournisseur=this.fournisseurDto

    this.bonCommandeServices.enregistrerBon(this.bonCommandeDt)
    .subscribe(res => {
    this.router.navigate(['bonCmd']);
   // console.log(">>>>>>"+this.patientDt);
    }, error => {
      this.errorMsg = error.error.errors;
    });
  }
 
 

}

