import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FournisseurDTO } from 'src/gs-api/src/models/fournisseur-dto';
import {FournisseurServices} from '../../services/fournisseur/fournisseur.service';

@Component({
  selector: 'app-page-fournisseur',
  templateUrl: './page-fournisseur.component.html',
  styleUrls: ['./page-fournisseur.component.css']
})
export class PageFournisseurComponent implements OnInit {

  listeFournisseurs : Array<FournisseurDTO>  = [];
 errorMsgs = '';
  constructor(
    private router: Router,
    private fournisseurServices: FournisseurServices,
  ) { }

  ngOnInit(): void {
   this.findListFournisseur();
  }

  nouveauFournisseur() : void{
    this.router.navigate(['nouveauFournisseur']);
  }
  findListFournisseur(): void {
    this.fournisseurServices.findAllffournisseur().subscribe(res => {
      this.listeFournisseurs = res;
    })
  }


}
