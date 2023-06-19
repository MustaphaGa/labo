import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {PatientDTO} from '../../../gs-api/src/models/patient-dto';
import {EmployeDTO} from '../../../gs-api/src/models/employe-dto';
import {Router} from '@angular/router';
import {PatientService} from '../../services/patient/patient.service';
import {EmployeService} from '../../services/employe/employe.service';

@Component({
  selector: 'app-detail-employe',
  templateUrl: './detail-employe.component.html',
  styleUrls: ['./detail-employe.component.css']
})
export class DetailEmployeComponent implements OnInit {
  @Input()
  employeDt: EmployeDTO = {};
  @Output()
  suppressionEmploye = new EventEmitter();
  constructor(
    private router: Router,
    private employeService:EmployeService
  ) { }

  ngOnInit(): void {
  }
  modifierEmploye(): void{
    this.router.navigate(['nouvelEmployee', this.employeDt.id_employe]);
  }
  detailEmploye(): void{
    this.router.navigate(['detailemploye', this.employeDt.id_employe]);
  }
  confirmerEtSupprimerEmploye() {
    if(this.employeDt.id_employe){
      this.employeService.deleteemploye(this.employeDt.id_employe)
        .subscribe(res => {
          this.suppressionEmploye.emit('success');
        }, error => {
          this.suppressionEmploye.emit(error.error.error);
        });
    }
  }
}
