import { Component, OnInit } from '@angular/core';
import {ArticleDTO} from "../../../gs-api/src/models/article-dto";
import {Router} from "@angular/router";
import {ArticleServices} from "../../services/article/article.service";
import {CompteDTO} from "../../../gs-api/src/models/compte-dto";
import {CompteService} from "../../services/compte/compte.service";

@Component({
  selector: 'app-page-compte',
  templateUrl: './page-compte.component.html',
  styleUrls: ['./page-compte.component.css']
})
export class PageCompteComponent implements OnInit {

  listeComptes :Array<CompteDTO>  = [];
  errorMsgs = '';
  constructor(
    private router:Router,
    private compteService:CompteService

  ) { }

  ngOnInit(): void {
    this.findlisteCompte();
  }

  findlisteCompte(): void {
    this.compteService.findAllCompte().subscribe(res => {
      this.listeComptes=res;
    })
  }

  nouveauCompte(): void{
    this.router.navigate(['nouveauCompte']);
  }
  exporteCompte():void{
    this.router.navigate(['exporteCompte']);
  }

  handleSuppression(event: any): void{
    if (event === 'success') {
      this.findlisteCompte();
    } else {
      this.errorMsgs = event;
    }

  }

}

