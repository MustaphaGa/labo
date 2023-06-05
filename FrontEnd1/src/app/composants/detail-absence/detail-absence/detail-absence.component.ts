import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { AbsenceService } from 'src/app/services/absence/absence.service';
import { AbsenceDTO } from 'src/gs-api/src/models/absence-dto';

@Component({
  selector: 'app-detail-absence',
  templateUrl: './detail-absence.component.html',
  styleUrls: ['./detail-absence.component.css']
})
export class DetailAbsenceComponent implements OnInit {

  @Input()
  absencedto: AbsenceDTO = {};
  @Output()
  suppressionAbsence = new EventEmitter();
  constructor(
    private router:Router,
    private absenceService:AbsenceService
  ) { };

  ngOnInit(): void {
   
  
  
    }
    modifierAbsence():void{
      this.router.navigate(['nouveauAbsence',this.absencedto.idAbsence])
    }
    
    detaillresultat(): void{
      this.router.navigate(['detailAbsence',this.absencedto.idAbsence]);
      
    }
   
    confirmerEtSupprimerAbsence(): void{
      if(this.absencedto.idAbsence){
       this.absenceService.deleteAbsence(this.absencedto.idAbsence)
        .subscribe(res => {
         this.suppressionAbsence.emit('success');
        }, error => {
          this.suppressionAbsence.emit(error.error.error);
        });
   }
   }
  
  }
