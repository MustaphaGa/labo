import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Router} from "@angular/router";
import {LaboService} from "../../services/labo/labo.service";
import {LaboDTO} from '../../../gs-api/src/models/labo-dto';

@Component({
  selector: 'app-detail-labo',
  templateUrl: './detail-labo.component.html',
  styleUrls: ['./detail-labo.component.css']
})
export class DetailLaboComponent implements OnInit {
  @Input()
  laboDt: LaboDTO = {};
  @Output()
  suppressionLabo = new EventEmitter();
  constructor(
    private router:Router,
    private  laboService:LaboService,
  ) { }

  ngOnInit(): void {
  }
  modifierLabo(): void{
    this.router.navigate(['nouveauLabo',this.laboDt.idLabo]);
  }


  confirmerEtSupprimerLabo() {
    if(this.laboDt.idLabo){
      this.laboService.deletelabo(this.laboDt.idLabo)
        .subscribe(res => {
          this.suppressionLabo.emit('success');
        }, error => {
          this.suppressionLabo.emit(error.error.error);
        });
    }
  }
}
