import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BonCommandeServices } from 'src/app/services/BonCommande/bon-commande.service';
import { ArticleServices } from 'src/app/services/article/article.service';
import { FournisseurServices } from 'src/app/services/fournisseur/fournisseur.service';
import { ArticleDTO } from 'src/gs-api/src/models';
import { BonCommandeDTO } from 'src/gs-api/src/models/bon-commande-dto';
import { FournisseurDTO } from 'src/gs-api/src/models/fournisseur-dto';

@Component({
  selector: 'app-nouveau-bon-commande',
  templateUrl: './nouveau-bon-commande.component.html',
  styleUrls: ['./nouveau-bon-commande.component.css']
})
export class NouveauBonCommandeComponent implements OnInit {

  [x: string]: any;
  bonCommandeDt: BonCommandeDTO={};
  articleDto :ArticleDTO={};
  fournisseurDto:FournisseurDTO={};
  listeBon: Array<BonCommandeDTO> =[];
  listefournisseur: Array<FournisseurDTO> =[];
  listearticle: Array<ArticleDTO> =[];
 
  errorMsg: Array<string> = [];
  patientErrorMsg='';

  constructor( 
    private router:Router,
    private activatedRouter:ActivatedRoute,
    private  bonCommandeServices:BonCommandeServices,
    private fournisseurService:FournisseurServices,
    private articleServices:ArticleServices,

    ) { }

  ngOnInit(): void {
    
      this.fournisseurService.findAllffournisseur().subscribe(fournisseur => {
        this.listefournisseur=fournisseur;
        
      });
      this.articleServices.findAllArticle().subscribe(article => {
        this.listearticle=article;
        
      });
     

    const idBonCommande = this.activatedRouter.snapshot.params.idBonCommande;
    if (idBonCommande) {
      this.bonCommandeServices.findBonById(idBonCommande)
      .subscribe(bon => {
        this.bonCommandeDt = bon;
        this.fournisseurDto = this.bonCommandeDt.fournisseur ? this.bonCommandeDt.fournisseur: {};
        this.articleDto = this.bonCommandeDt.article ? this.bonCommandeDt.article: {};

      });
    }
  
  
  }
  

  cancel(): void {
    this.router.navigate(['bonCmd']);
  }
  enregistrerBon(): void {
    this.bonCommandeDt.fournisseur=this.fournisseurDto
    this.bonCommandeDt.article=this.articleDto

    this.bonCommandeServices.enregistrerBon(this.bonCommandeDt)
    .subscribe(res => {
    this.router.navigate(['bonCmd']);
   // console.log(">>>>>>"+this.patientDt);
    }, error => {
      this.errorMsg = error.error.errors;
    });
  }
 
 

}

