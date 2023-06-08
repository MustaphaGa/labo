import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CongeDTO} from '../../../gs-api/src/models/conge-dto';
import {Router} from '@angular/router';
import {CongerService} from '../../services/conger/conger.service';

@Component
({
  selector: 'app-detail-conger',
  templateUrl: './detail-conger.component.html',
  styleUrls: ['./detail-conger.component.css']
})
export class DetailCongerComponent implements OnInit
{
  @Input()
  congerDT: CongeDTO = {};
  @Output()
  suppressionConger = new EventEmitter();

  constructor(private router: Router,
              private   congerService: CongerService,
              ) { }

  ngOnInit(): void
  {
  }

  modifierConger(): void{
    this.router.navigate(['nouveauconger', this.congerDT.idConge])
  }
  detailReservation(): void{
    this.router.navigate(['detailconger', this.congerDT.idConge])
  }
  confirmerEtSupprimerReservation(): void{
    if (this.congerDT.idConge){
      this.congerService.deleteConger(this.congerDT.idConge)
        .subscribe(res => {
          this.suppressionConger.emit('success');
        }, error => {
          this.suppressionConger.emit(error.error.error);
        });
    }
  }
}
