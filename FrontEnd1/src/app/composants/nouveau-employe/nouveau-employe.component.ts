import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {EmployeDTO} from '../../../gs-api/src/models/employe-dto';
import {LaboDTO} from '../../../gs-api/src/models/labo-dto';
import {EmployeService} from '../../services/employe/employe.service';
import {LaboService} from '../../services/labo/labo.service';

@Component({
  selector: 'app-nouveau-employe',
  templateUrl: './nouveau-employe.component.html',
  styleUrls: ['./nouveau-employe.component.css']
})
export class NouveauEmployeComponent implements OnInit {
  employeDto: EmployeDTO ={};
  labodto: LaboDTO ={};
  listeLabo : Array<LaboDTO>  = [];
  errorMsg: Array<string> = [];
  constructor( private router: Router,
               private activatedRouter: ActivatedRoute,
               private employeService: EmployeService,
               private laboService : LaboService,) { }

  ngOnInit(): void
  {
    this.laboService.findAllLabo().subscribe(labo => {
      this.listeLabo = labo;

    });
    const idEmploye = this.activatedRouter.snapshot.params.idEmploye;
    if (idEmploye) {
      this.employeService.findEmployetById(idEmploye)
        .subscribe(employe => {
          this.employeDto = employe;
          this.labodto = this.employeDto.labo ? this.employeDto.labo : {};
        });
    }

    }


  cancel(): void
  {
    this.router.navigate(['employees']);
     }
  enregistrerEmploye(): void {
    this.employeDto.labo = this.labodto
    this.employeService.enregistrerEmploye(this.employeDto).subscribe(res => {
      this.router.navigate(['employees']);
    }, error => {
      this.errorMsg = error.error.errors;
    });
  }


}

