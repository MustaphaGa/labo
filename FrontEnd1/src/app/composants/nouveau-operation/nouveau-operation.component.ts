import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {OperationDTO} from '../../../gs-api/src/models/operation-dto';
import {OperationService} from '../../services/operation/operation.service';
import {CompteDTO} from '../../../gs-api/src/models/compte-dto';
import {CompteService} from '../../services/compte/compte.service';
import {NatureOperationDTO} from '../../../gs-api/src/models/nature-operation-dto';
import {NaturOperationService} from '../../services/NaturOperation/natur-operation.service';

@Component({
  selector: 'app-nouveau-operation',
  templateUrl: './nouveau-operation.component.html',
  styleUrls: ['./nouveau-operation.component.css'],

})
export class NouveauOperationComponent implements OnInit {

  listeCompte: Array<CompteDTO>  = [];
  compteDto: CompteDTO = {};
  listeNatureOperation: Array<NatureOperationDTO>  = [];
  natueOperationDto: NatureOperationDTO = {};
  listeOperation: Array<OperationDTO>
  operationDto: OperationDTO = {};
  errorMsg: Array<string> = [];
  constructor( private router: Router,
               private activatedRouter: ActivatedRoute,
               private compteService: CompteService,
               private naOperationService: NaturOperationService,
               private operationService: OperationService ,
              ) { }

  ngOnInit(): void {
    this.naOperationService.findAllNatureOperation().subscribe(naOperation => {
     this.listeNatureOperation = naOperation;
    });
    this.compteService.findAllCompte().subscribe(compte => {
      this.listeCompte = compte;
    });
    const idOperation = this.activatedRouter.snapshot.params.idOperation;
    if (idOperation) {
      this.operationService.findOperationById(idOperation)
        .subscribe(operation => {
          this.operationDto = operation;
          this.compteDto = this.operationDto.compte ? this.operationDto.compte : {};
          this.natueOperationDto = this.operationDto.natureOperation ? this.operationDto.natureOperation : {};
        });
    }
    this.findAllOperation();

  }

  cancel(): void {
    this.router.navigate(['operation']);
  }

  enregistrerOperation(): void {
    this.operationDto.natureOperation = this.natueOperationDto
    this.operationDto.compte = this.compteDto
    this.operationService.enregistrerOperation(this.operationDto).subscribe(res => {
      this.router.navigate(['operation']);
    }, error => {
      this.errorMsg = error.error.errors;
    });
  }
  findAllOperation(): void {
    this.operationService.findAllOperation().subscribe(operation => {
      this.listeOperation = operation;
    });
  }
}
