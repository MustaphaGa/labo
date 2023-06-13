import { Component, OnInit } from '@angular/core';
import {ReservationDTO} from '../../../gs-api/src/models/reservation-dto';
import {AnalyseMedicalDTO} from '../../../gs-api/src/models/analyse-medical-dto';
import {TypeAnalyseDTO} from '../../../gs-api/src/models/type-analyse-dto';
import {ActivatedRoute, Router} from '@angular/router';
import {AnnalyseMedicalService} from '../../services/analyse-medical/annalyse-medical.service';
import {ReservationnService} from '../../services/reservation/reservationn.service';
import {TypAnalyseService} from '../../typeAnalyse/typ-analyse.service';
import {EmployeDTO} from '../../../gs-api/src/models/employe-dto';
import {OperationDTO} from '../../../gs-api/src/models/operation-dto';
import {BilanFinancierDTO} from '../../../gs-api/src/models/bilan-financier-dto';
import {OperationService} from '../../services/operation/operation.service';
import {EmployeService} from '../../services/employe/employe.service';
import {BilanFinanceService} from '../../services/bilanFinance/bilan-finance.service';

@Component({
  selector: 'app-nouveau-operation',
  templateUrl: './nouveau-operation.component.html',
  styleUrls: ['./nouveau-operation.component.css']
})
export class NouveauOperationComponent implements OnInit {

  listeBilanFinancier: Array<BilanFinancierDTO>  = [];
  bilanFinancierDto: BilanFinancierDTO = {};
  operationDto: OperationDTO = {};
  errorMsg: Array<string> = [];
  constructor( private router: Router,
               private activatedRouter: ActivatedRoute,
               private operationservice: OperationService,
               private bilanFinancierService: BilanFinanceService) { }

  ngOnInit(): void {
    this.bilanFinancierService.findAllBilanFinance().subscribe(bilanFinancier => {
      this.listeBilanFinancier = bilanFinancier;
    });
    const idOperation = this.activatedRouter.snapshot.params.idOperation;
    if (idOperation) {
      this.operationservice.findOperationById(idOperation)
        .subscribe(operation => {
          this.operationDto = operation;
          this.bilanFinancierDto = this.operationDto.bilanFinancier ? this.operationDto.bilanFinancier : {};
        });
    }

  }
  cancel(): void {
    this.router.navigate(['operation']);
  }
  enregistrerOperation(): void {
    this.operationDto.bilanFinancier = this.bilanFinancierDto;
    this.operationservice.enregistrerOperation(this.operationDto).subscribe(res => {
      this.router.navigate(['operation']);
    }, error => {
      this.errorMsg = error.error.errors;
    });
  }
}
