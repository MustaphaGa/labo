import { Component, OnInit } from '@angular/core';
import {AbsenceDTO} from '../../../gs-api/src/models/absence-dto';
import {Router} from '@angular/router';
import {RecrutementDTO} from '../../../gs-api/src/models/recrutement-dto';
import {RecrutementService} from '../../services/recrutement/recrutement.service';

@Component({
  selector: 'app-page-recrutement',
  templateUrl: './page-recrutement.component.html',
  styleUrls: ['./page-recrutement.component.css']
})
export class PageRecrutementComponent implements OnInit {
  listeRecrutement : Array<RecrutementDTO>  = [];
  errorMsgs = '';
  constructor( private router : Router,
               private recrutementService :RecrutementService) { }

  ngOnInit(): void {
    this.findListRecrutement();
  }

  findListRecrutement(): void{
    this.recrutementService.findAllRecrutement().subscribe(res => {
      this.listeRecrutement =res;

    });
  }
  nouveauRecrutement(): void{
    this.router.navigate(['nouveauRecrutement'])
  }
  handleSuppression(event: any): void{
    if (event === 'success') {
      this.findListRecrutement();
    } else {
      this.errorMsgs = event;
    }

  }

}
