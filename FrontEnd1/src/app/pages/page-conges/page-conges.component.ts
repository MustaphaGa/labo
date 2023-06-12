import { Component, OnInit } from '@angular/core';
import {CongeDTO} from '../../../gs-api/src/models/conge-dto';
import {Router} from '@angular/router';
import {CongerService} from '../../services/conger/conger.service';

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
              private congerService: CongerService) { }

  ngOnInit(): void
  {
    this.findListconger();
  }
  nouveauconger(): void
  {
    this.router.navigate(['nouveauconger']);
  }

  findListconger(): void
  {
    this.congerService.findAllconger().subscribe(res =>
    {
      this.listeconger = res;
    })
  }

  handleSuppression(event: any): void
  {
    if (event === 'success')
    {
      this.findListconger();
    } else
    {
      this.errorMsgs = event;
    }

  }
}
