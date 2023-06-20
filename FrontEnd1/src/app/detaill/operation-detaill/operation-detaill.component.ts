import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {OperationDTO} from '../../../gs-api/src/models/operation-dto';
import {OperationService} from '../../services/operation/operation.service';

@Component({
  selector: 'app-operation-detaill',
  templateUrl: './operation-detaill.component.html',
  styleUrls: ['./operation-detaill.component.css']
})
export class OperationDetaillComponent implements OnInit {
  operationDTo: OperationDTO = {};
  constructor(
    private router: Router,
    private activatedRouter: ActivatedRoute,
    private  operationService: OperationService,
  ) { }

  ngOnInit(): void {
    const idOperation = this.activatedRouter.snapshot.params.idOperation;
    if (idOperation) {
      this.operationService.findOperationById(idOperation)
        .subscribe(operation => {
          this.operationDTo = operation;
        });
    }
  }
}
