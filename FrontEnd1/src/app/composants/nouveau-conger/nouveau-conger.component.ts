import { Component, OnInit } from '@angular/core';
import {CongeDTO} from '../../../gs-api/src/models/conge-dto';
import {EmployeDTO} from '../../../gs-api/src/models/employe-dto';
import {ActivatedRoute, Router} from '@angular/router';
import {CongerService} from '../../services/conger/conger.service';
import {EmployeService} from '../../services/employe/employe.service';

@Component({
  selector: 'app-nouveau-conger',
  templateUrl: './nouveau-conger.component.html',
  styleUrls: ['./nouveau-conger.component.css']
})
export class NouveauCongerComponent implements OnInit
{
  congeDTo: CongeDTO = {};
  employeDt: EmployeDTO = {};
  listeemploye: Array<EmployeDTO>  = [];
  errorMsg: Array<string> = [];

  constructor(
    private router: Router,
    private activatedRouter: ActivatedRoute,
    private congeService: CongerService,
    private employeService: EmployeService
  ) { }

  ngOnInit(): void
  {
    this.employeService.findAllEmploye().subscribe(employe => {
      this.listeemploye = employe;
    });

    const idconge = this.activatedRouter.snapshot.params.idconge;
    if (idconge)
      {
        this.congeService.findCongerById(idconge)
          .subscribe(conge =>
          {
            this.congeDTo = conge;
            this.employeDt = this.congeDTo.employe ? this.congeDTo.employe : {};

             });
                   }
  }
      cancel(): void {
        this.router.navigate(['conges']);
    }

      enregistrerconge(): void {
        this.congeDTo.employe = this.employeDt
        this.congeService.enregistrerConger(this.congeDTo).subscribe(res => {
          this.router.navigate(['conges']);
        }, error => {
          this.errorMsg = error.error.errors;
        });
    }

}
