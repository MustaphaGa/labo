import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {OperationService} from "../../services/operation/operation.service";
import {OperationDTO} from "../../../gs-api/src/models/operation-dto";

@Component({
  selector: 'app-page-operation',
  templateUrl: './page-operation.component.html',
  styleUrls: ['./page-operation.component.css']
})
export class PageOperationComponent implements OnInit {

  listeOperation : Array<OperationDTO>  = [];
  errorMsgs = '';
  constructor( private router:Router,
               private operationService : OperationService) { }

  ngOnInit(): void {
    this.findListOperation();
  }
  findListOperation(): void{
    this.operationService.findAllOperation().subscribe(res => {
      this.listeOperation = res;

    });
  }
  nouvelOperation():void{
    this.router.navigate(['nouveloperation']);

  }
  exporteoperation():void{
    this.router.navigate(['exporteOperation']);

  }
  handleSuppression(event: any): void{
    if (event === 'success') {
      this.findListOperation();
    } else {
      this.errorMsgs = event;
    }

  }

}
