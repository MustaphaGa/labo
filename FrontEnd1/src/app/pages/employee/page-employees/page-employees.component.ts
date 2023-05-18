import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-page-employees',
  templateUrl: './page-employees.component.html',
  styleUrls: ['./page-employees.component.css']
})
export class PageEmployeesComponent implements OnInit {


  constructor( private router: Router) { }

  ngOnInit(): void {
  }
  nouvelEmployee(): void{
    this.router.navigate(['nouvelEmployee']);
  }

}
