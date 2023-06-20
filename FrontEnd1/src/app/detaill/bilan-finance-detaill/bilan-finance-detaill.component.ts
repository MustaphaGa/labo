import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {BilanFinancierDTO} from '../../../gs-api/src/models/bilan-financier-dto';
import {BilanFinanceService} from '../../services/bilanFinance/bilan-finance.service';

@Component({
  selector: 'app-bilan-finance-detaill',
  templateUrl: './bilan-finance-detaill.component.html',
  styleUrls: ['./bilan-finance-detaill.component.css']
})
export class BilanFinanceDetaillComponent implements OnInit {
  bilanFinanceDto: BilanFinancierDTO ={};
  constructor(
    private router: Router,
    private activatedRouter: ActivatedRoute,
    private  bilanFinanceService: BilanFinanceService,
  ) { }

  ngOnInit(): void {
    const idBilan = this.activatedRouter.snapshot.params.idBilan;
    if (idBilan) {
      this.bilanFinanceService.findBilanFinanceById(idBilan)
        .subscribe(bilan => {
          this.bilanFinanceDto = bilan;
        });
    }
  }
}

