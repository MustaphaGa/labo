import { Component, OnInit } from '@angular/core';
import {LaboDTO} from "../../../gs-api/src/models/labo-dto";
import {ActivatedRoute, Router} from "@angular/router";
import {LaboService} from "../../services/labo/labo.service";
import {BilanFinancierDTO} from "../../../gs-api/src/models/bilan-financier-dto";
import {BilanFinanceService} from "../../services/bilanFinance/bilan-finance.service";

@Component({
  selector: 'app-nouveau-bilan-finance',
  templateUrl: './nouveau-bilan-finance.component.html',
  styleUrls: ['./nouveau-bilan-finance.component.css']
})
export class NouveauBilanFinanceComponent implements OnInit {
  [x: string]: any;
  bilanFinanDto: BilanFinancierDTO ={};
  errorMsg: Array<string> = [];
  constructor(private router:Router,
              private activatedRouter:ActivatedRoute,
              private bilanFinanceService : BilanFinanceService) { }

  ngOnInit(): void {
  }

  cancel(): void {
    this.router.navigate(['bilanFinance']);
  }

  enregistrerBilanFinance() {
    this.bilanFinanceService.enregistrerBilanFinance(this.bilanFinanDto).subscribe(res => {
      this.router.navigate(['bilanFinance']);
    }, error => {
      this.errorMsg = error.error.errors;
    });
  }
}
