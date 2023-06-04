import { Component, OnInit } from '@angular/core';
import {FactureDTO} from '../../../gs-api/src/models/facture-dto';
import {AnalyseMedicalDTO} from '../../../gs-api/src/models/analyse-medical-dto';
import {ActivatedRoute, Router} from '@angular/router';
import {AnnalyseMedicalService} from '../../services/analyse-medical/annalyse-medical.service';
import {FacturesService} from '../../services/facture/factures.service';
import {RecrutementDTO} from '../../../gs-api/src/models/recrutement-dto';
import {EmployeDTO} from '../../../gs-api/src/models/employe-dto';
import {EmployeService} from '../../services/employe/employe.service';
import {RecrutementService} from '../../services/recrutement/recrutement.service';

@Component({
  selector: 'app-nouveau-recrutement',
  templateUrl: './nouveau-recrutement.component.html',
  styleUrls: ['./nouveau-recrutement.component.css']
})
export class NouveauRecrutementComponent implements OnInit {

  recrutemenDt: RecrutementDTO = {};
  employeDTO: EmployeDTO = {};
  listeEmploye: Array<EmployeDTO> = [];
  errorMsg: Array<string> = [];

  constructor(
    private router: Router,
    private activatedRouter: ActivatedRoute,
    private employeService: EmployeService,
    private recrutemntService: RecrutementService) {
  }

  ngOnInit(): void {
    this.employeService.findAllEmploye().subscribe(analy => {
      this.listeEmploye = analy;
    });
    const idRecrutement = this.activatedRouter.snapshot.params.idRecrutement;
    if (idRecrutement) {
      this.recrutemntService.findRecrutemntById(idRecrutement)
        .subscribe(recrutement => {
          this.recrutemenDt = recrutement;
          this.employeDTO = this.recrutemenDt.employe ? this.recrutemenDt.employe : {};
        });
    }
  }

  cancel(): void {
    this.router.navigate(['recrutement']);
  }

  enregistrerRecrutemnt(): void {
    this.recrutemenDt.employe = this.employeDTO
    this.recrutemntService.enregistrerRecrutemnt(this.recrutemenDt).subscribe(res => {
      this.router.navigate(['recrutement']);
    }, error => {
      this.errorMsg = error.error.errors;
    });
  }
}
