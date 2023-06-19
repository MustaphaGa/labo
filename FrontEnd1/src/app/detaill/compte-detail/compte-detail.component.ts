import { Component, OnInit } from '@angular/core';
import {ArticleDTO} from "../../../gs-api/src/models/article-dto";
import {ActivatedRoute, Router} from "@angular/router";
import {ArticleServices} from "../../services/article/article.service";
import {CompteDTO} from "../../../gs-api/src/models/compte-dto";
import {CompteService} from "../../services/compte/compte.service";

@Component({
  selector: 'app-compte-detail',
  templateUrl: './compte-detail.component.html',
  styleUrls: ['./compte-detail.component.css']
})
export class CompteDetailComponent implements OnInit {

  compteDt: CompteDTO = {};
  constructor(private router:Router,
              private compteServices:CompteService,
              private activatedRouter:ActivatedRoute) { }

  ngOnInit(): void {
    const idCompte = this.activatedRouter.snapshot.params.idCompte;
    if (idCompte) {
      this.compteServices.findCompteById(idCompte)
        .subscribe(compte => {
          this.compteDt = compte;
        });
    }

  }

}
