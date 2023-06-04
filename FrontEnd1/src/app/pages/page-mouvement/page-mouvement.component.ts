import { Component, OnInit } from '@angular/core';
import {RecrutementDTO} from '../../../gs-api/src/models/recrutement-dto';
import {Router} from '@angular/router';
import {RecrutementService} from '../../services/recrutement/recrutement.service';
import {MouvementService} from '../../services/mouvement/mouvement.service';
import {MouvementDTO} from '../../../gs-api/src/models/mouvement-dto';

@Component({
  selector: 'app-page-mouvement',
  templateUrl: './page-mouvement.component.html',
  styleUrls: ['./page-mouvement.component.css']
})
export class PageMouvementComponent implements OnInit {

  listeMouvement : Array<MouvementDTO>  = [];
  errorMsgs = '';
  constructor( private router : Router,
               private mouvementService : MouvementService) { }

  ngOnInit(): void {
    this.findListMouvement();
  }

  findListMouvement(): void{
    this.mouvementService.findAllMouvement().subscribe(res => {
      this.listeMouvement = res;

    });
  }
  nouveauMouvement(): void{
    this.router.navigate(['nouveauMouvement'])
  }
  handleSuppression(event: any): void{
    if (event === 'success') {
      this.findListMouvement();
    } else {
      this.errorMsgs = event;
    }

  }

}

