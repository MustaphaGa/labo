import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AbsenceService } from 'src/app/services/absence/absence.service';
import { AbsenceDTO } from 'src/gs-api/src/models/absence-dto';

@Component({
  selector: 'app-absence-detaill',
  templateUrl: './absence-detaill.component.html',
  styleUrls: ['./absence-detaill.component.css']
})
export class AbsenceDetaillComponent implements OnInit {

 
  absenceDt: AbsenceDTO = {};
  constructor(private router:Router,
    private absenceService:AbsenceService,
    private activatedRouter:ActivatedRoute) { }

  ngOnInit(): void {
    const idAbsence = this.activatedRouter.snapshot.params.idAbsence;
    if (idAbsence) {
      this.absenceService.findAbsenceById(idAbsence)
      .subscribe(absence => {
        this.absenceDt = absence;
      });
    }
    console.log(idAbsence);
    
   
    }

}

