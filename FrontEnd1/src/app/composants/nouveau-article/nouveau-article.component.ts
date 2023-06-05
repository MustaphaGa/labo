import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticleServices } from 'src/app/services/article/article.service';
import { ArticleDTO } from 'src/gs-api/src/models/article-dto';
import { BonCommandeDTO } from 'src/gs-api/src/models/bon-commande-dto';
import { StockDTO } from 'src/gs-api/src/models/stock-dto';

@Component({
  selector: 'app-nouveau-article',
  templateUrl: './nouveau-article.component.html',
  styleUrls: ['./nouveau-article.component.css']
})
export class NouveauArticleComponent implements OnInit {

  [x: string]: any;
  articleDt: ArticleDTO={};
  stockDt:StockDTO={};
 /*  bonCommandeDt:BonCommandeDTO={};
  listeArticles: Array<ArticleDTO> =[];
  listeStock: Array<StockDTO> =[];
  listeBoncommande: Array<BonCommandeDTO> =[]; */
 
  errorMsg: Array<string> = [];
  patientErrorMsg='';

  constructor( 
    private router:Router,
    private activatedRouter:ActivatedRoute,
    private  articleServices:ArticleServices,

    ) { }

  ngOnInit(): void {
   /*  this.employeService.findAllEmploye().subscribe(employe => {
      this.listemploye=employe;
    });

    const idAbsence = this.activatedRouter.snapshot.params.idAbsence;
    if (idAbsence) {
      this.absenceService.findAbsenceById(idAbsence)
      .subscribe(absence => {
        this.absenceDt = absence;
        this.employeDto = this.absenceDt.employe ? this.absenceDt.employe: {};

      }); */
    }
  
  
  
  

  cancel(): void {
    this.router.navigate(['article']);
  }
  enregistrerArticle(): void {
   // this.absenceDt.employe=this.employeDto

    this.articleServices.enregistrerArticle(this.articleDt)
    .subscribe(res => {
    this.router.navigate(['article']);
   // console.log(">>>>>>"+this.patientDt);
    }, error => {
      this.errorMsg = error.error.errors;
    });
  }
 
 

}

