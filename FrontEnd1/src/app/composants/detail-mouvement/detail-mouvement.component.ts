import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {RecrutementDTO} from '../../../gs-api/src/models/recrutement-dto';
import {Router} from '@angular/router';
import {RecrutementService} from '../../services/recrutement/recrutement.service';
import {MouvementDTO} from '../../../gs-api/src/models/mouvement-dto';
import {MouvementService} from '../../services/mouvement/mouvement.service';

@Component({
  selector: 'app-detail-mouvement',
  templateUrl: './detail-mouvement.component.html',
  styleUrls: ['./detail-mouvement.component.css']
})
export class DetailMouvementComponent implements OnInit {

  @Input()
  mouvementDto: MouvementDTO = {};
  @Output()
  suppressionMouvement = new EventEmitter();
  constructor(
    private router:Router,
    private  mouvementService: MouvementService,
  ) { }

  ngOnInit(): void {
  }
  modifierMouvement(): void{
    this.router.navigate(['nouveauMouvement',this.mouvementDto.idMouvement]);
  }

  confirmerEtSupprimerMouvement() {
    if(this.mouvementDto.idMouvement){
      this.mouvementService.deleteMouvement(this.mouvementDto.idMouvement)
        .subscribe(res => {
          this.suppressionMouvement.emit('success');
        }, error => {
          this.suppressionMouvement.emit(error.error.error);
        });
    }
  }

  detailRecrutement() {

  }
}

