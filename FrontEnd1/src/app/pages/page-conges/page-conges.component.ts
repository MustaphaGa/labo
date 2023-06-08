import { Component, OnInit } from '@angular/core';
import {CongeDTO} from '../../../gs-api/src/models/conge-dto';
import {Router} from '@angular/router';
import {TestCovidv1congeService} from '../../../gs-api/src/services/test-covidv-1conge.service';

@Component
({
  selector: 'app-page-conges',
  templateUrl: './page-conges.component.html',
  styleUrls: ['./page-conges.component.css']
})
export class PageCongesComponent implements OnInit
{
  listeconger: Array<CongeDTO>  = [];
  errorMsgs = '';

  constructor(private router: Router,
              private congerService: TestCovidv1congeService) { }

  ngOnInit(): void
  {
    this.findListconger();
  }
  nouveauconger(): void{
    this.router.navigate(['nouveauconger']);
  }

  findListconger(): void
  {
    this.congerService.findAll().subscribe(res =>
    {
      this.listeconger = res;
    })
  }
}
