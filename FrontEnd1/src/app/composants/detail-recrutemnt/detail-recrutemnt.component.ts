import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Router} from '@angular/router';
import {RecrutementService} from '../../services/recrutement/recrutement.service';
import {RecrutementDTO} from '../../../gs-api/src/models/recrutement-dto';

@Component({
  selector: 'app-detail-recrutemnt',
  templateUrl: './detail-recrutemnt.component.html',
  styleUrls: ['./detail-recrutemnt.component.css']
})
export class DetailRecrutemntComponent implements OnInit {

  @Input()
  recrutementDto: RecrutementDTO = {};
  @Output()
  suppressionRecrutement = new EventEmitter();
  constructor(
    private router:Router,
    private  recrutemntService:RecrutementService,
  ) { }

  ngOnInit(): void {
  }
  modifierRecrutement(): void{
    this.router.navigate(['nouveauRecrutement',this.recrutementDto.idRecrutement]);
  }

  confirmerEtSupprimerRecrutemnt() {
    if(this.recrutementDto.idRecrutement){
      this.recrutemntService.deleteRecrutement(this.recrutementDto.idRecrutement)
        .subscribe(res => {
          this.suppressionRecrutement.emit('success');
        }, error => {
          this.suppressionRecrutement.emit(error.error.error);
        });
    }
  }

  detailRecrutement() {

  }
}
