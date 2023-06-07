import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FournisseurServices } from 'src/app/services/fournisseur/fournisseur.service';
import { FournisseurDTO } from 'src/gs-api/src/models/fournisseur-dto';

@Component({
  selector: 'app-nouveau-fournissseur',
  templateUrl: './nouveau-fournissseur.component.html',
  styleUrls: ['./nouveau-fournissseur.component.css']
})
export class NouveauFournisseurComponent implements OnInit {

  [x: string]: any;
  fournisseurDt: FournisseurDTO={};
  listFournisseurs: Array<FournisseurDTO> =[];
  
  errorMsg: Array<string> = [];


  constructor( 
    private router:Router,
    private activatedRouter:ActivatedRoute,
    private  fournisseurServices:FournisseurServices
    ) { }

  ngOnInit(): void {

    const idFournisseur = this.activatedRouter.snapshot.params.idFournisseur;
    if (idFournisseur) {
      this.fournisseurServices.findFournisseurById(idFournisseur)
      .subscribe(fournisseur => {
        this.fournisseurDt = fournisseur;
      });
    }
    this.findAllPatient();
  
  }
  

  cancel(): void {
    this.router.navigate(['fournisseur']);
  }
  enregistrerFournisseur(): void {
    this.fournisseurServices.enregistrerfournisseur(this.idFournisseur).subscribe(res => {
    this.router.navigate(['patients']);
   // console.log(">>>>>>"+this.patientDt);
    }, error => {
      this.errorMsg = error.error.errors;
    });
  }
  findAllFournisseur(): void{
    this.fournisseurServices.findAllffournisseur().subscribe(fournisseur=>{
      this.listFournisseurs=fournisseur;
    });

  }
 
    



}
