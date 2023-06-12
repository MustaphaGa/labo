import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { FournisseurServices } from 'src/app/services/fournisseur/fournisseur.service';
import { FournisseurDTO } from 'src/gs-api/src/models/fournisseur-dto';

@Component({
  selector: 'app-detail-fournisseur',
  templateUrl: './detail-fournisseur.component.html',
  styleUrls: ['./detail-fournisseur.component.css']
})
export class DetailFournisseurComponent implements OnInit {
 
  @Input()
  fournisseurDto: FournisseurDTO ={};
  @Output()
  suppressionFournisseur = new EventEmitter();
  constructor( private router:Router,
    private fournisseurServices :FournisseurServices
  
    ) { }

  ngOnInit(): void {
  }
  modifierFournisseur():void{
    this.router.navigate(['nouveauFournisseur',this.fournisseurDto.idFournisseur])
  }
  DetailFournisseur():void{
    this.router.navigate(['detailFournisseur',this.fournisseurDto.idFournisseur])
  }
  confirmerEtSupprimerFournisseur(): void{
    if(this.fournisseurDto.idFournisseur){
      this.fournisseurServices.deleteFournisseur(this.fournisseurDto.idFournisseur)
       .subscribe(res => {
        this.suppressionFournisseur.emit('success');
       }, error => {
         this.suppressionFournisseur.emit(error.error.error);
       });
  }
  
  }

}
