import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Router} from "@angular/router";
import {OperationDTO} from "../../../gs-api/src/models/operation-dto";
import {OperationService} from "../../services/operation/operation.service";

@Component({
  selector: 'app-detail-operation',
  templateUrl: './detail-operation.component.html',
  styleUrls: ['./detail-operation.component.css']
})
export class DetailOperationComponent implements OnInit {

  @Input()
  operationDto: OperationDTO = {};
  @Output()
  suppressionOperation = new EventEmitter();
  constructor(
    private router:Router,
    private operationService: OperationService,
  ) { }

  ngOnInit(): void {
  }
  modifierOperation():void{
    this.router.navigate(['nouveloperation', this.operationDto.idOperation])
  }
  detailOperation():void{
    this.router.navigate(['detailOperation', this.operationDto.idOperation])
  }
  confirmerEtSupprimerOperation(): void{
    if (this.operationDto.idOperation){
      this.operationService.deleteOperation(this.operationDto.idOperation)
        .subscribe(res => {
          this.suppressionOperation.emit('success');
        }, error => {
          this.suppressionOperation.emit(error.error.error);
        });
    }

  }

}
