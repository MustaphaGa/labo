import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FournisseurDTO } from 'src/gs-api/src/models/fournisseur-dto';
import {FournisseurServices} from '../../services/fournisseur/fournisseur.service';

@Component({
  selector: 'app-fournisseur-detaill',
  templateUrl: './fournisseur-detaill.component.html',
  styleUrls: ['./fournisseur-detaill.component.css']
})
export class FournisseurDetaillComponent implements OnInit {
  
  fournisseurDt: FournisseurDTO ={};
  constructor(private router:Router,
    private fournisseurServices :FournisseurServices,
    private activatedRouter:ActivatedRoute) { }

  ngOnInit(): void {
    const idFournisseur = this.activatedRouter.snapshot.params.idFournisseur
    if (idFournisseur) {
      this.fournisseurServices.findFournisseurById(idFournisseur)
      .subscribe(fourniss => {
        this.fournisseurDt = fourniss;
      });
    }
   
    
  }

}