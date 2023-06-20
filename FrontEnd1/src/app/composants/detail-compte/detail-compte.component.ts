import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Router} from "@angular/router";
import {ArticleServices} from "../../services/article/article.service";
import {CompteDTO} from "../../../gs-api/src/models/compte-dto";
import {CompteService} from "../../services/compte/compte.service";

@Component({
  selector: 'app-detail-compte',
  templateUrl: './detail-compte.component.html',
  styleUrls: ['./detail-compte.component.css']
})
export class DetailCompteComponent implements OnInit {

  @Input()
  compteDt: CompteDTO ={};
  @Output()
  suppressionCompte = new EventEmitter();

  constructor(
    private router:Router,
    private   CompteServices : CompteService,
  ) { }

  ngOnInit(): void {
  }
  modifierCompte():void{
    this.router.navigate(['nouveauCompte',this.compteDt.idCompte])
  }
  detailCompte():void{
    this.router.navigate(['detailCompte',this.compteDt.idCompte])
  }
  confirmerEtSupprimerCompte(): void{
    if(this.compteDt.idCompte){
      this.CompteServices.deleteCompte(this.compteDt.idCompte)
        .subscribe(res => {
          this.suppressionCompte.emit('success');
        }, error => {
          this.suppressionCompte.emit(error.error.error);
        });
    }
  }

}
