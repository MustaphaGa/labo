import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {EmployeService} from '../../../services/employe/employe.service';
import {EmployeDTO} from '../../../../gs-api/src/models/employe-dto';

@Component({
  selector: 'app-page-employees',
  templateUrl: './page-employees.component.html',
  styleUrls: ['./page-employees.component.css']
})
export class PageEmployeesComponent implements OnInit {
  listeemploye : Array<EmployeDTO>  = [];
  errorMsgs = '';

  constructor( private router: Router,
               private employeService: EmployeService) { }

  ngOnInit(): void {
    this.findListemploye();
  }
  nouvelEmployee(): void{
    this.router.navigate(['nouvelEmployee']);
  }
  findListemploye(): void {
    this.employeService.findAllEmploye().subscribe(res => {
      this.listeemploye = res;
    })
  }
}
