import { Component, OnInit } from '@angular/core';
import {ArticleDTO} from "../../../gs-api/src/models/article-dto";
import {ActivatedRoute, Router} from "@angular/router";
import {ArticleServices} from "../../services/article/article.service";
import {CompteDTO} from "../../../gs-api/src/models/compte-dto";
import {CompteService} from "../../services/compte/compte.service";

@Component({
  selector: 'app-nouveau-compte',
  templateUrl: './nouveau-compte.component.html',
  styleUrls: ['./nouveau-compte.component.css']
})
export class NouveauCompteComponent implements OnInit {


  [x: string]: any;
  compteDt: CompteDTO={};

  listeCompte: Array<CompteDTO> =[];


  errorMsg: Array<string> = [];
  compteErrorMsg='';

  constructor(
    private router:Router,
    private activatedRouter:ActivatedRoute,
    private  compteService:CompteService,



  ) { }

  ngOnInit(): void {



    const  idCompte= this.activatedRouter.snapshot.params.idCompte;
    if (idCompte) {
      this.compteService.findCompteById(idCompte)
        .subscribe(compte => {
          this.compteDt = compte;

        });
    }
  }





  cancel(): void {
    this.router.navigate(['compte']);
  }
  enregistrerCompte(): void {

    this.compteService.enregistrerCompte(this.compteDt)
      .subscribe(res => {
        this.router.navigate(['compte']);
        // console.log(">>>>>>"+this.patientDt);
      }, error => {
        this.errorMsg = error.error.errors;
      });
  }



}
