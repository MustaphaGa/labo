import { Component, OnInit } from '@angular/core';
import {BilanFinancierDTO} from "../../../gs-api/src/models/bilan-financier-dto";
import {Router} from "@angular/router";
import {BilanFinanceService} from "../../services/bilanFinance/bilan-finance.service";

@Component({
  selector: 'app-page-bilan-financier',
  templateUrl: './page-bilan-financier.component.html',
  styleUrls: ['./page-bilan-financier.component.css']
})
export class PageBilanFinancierComponent implements OnInit {
  listeBilan : Array<BilanFinancierDTO>  = [];
  errorMsgs = '';
  constructor(
    private router: Router,
    private bilanFinanceService: BilanFinanceService,
  ) { }

  ngOnInit(): void {
    this.findListbilanFinance();
  }

  nouveauBilanFinance(): void{
    this.router.navigate(['nouveauBilanFinance']);
  }
  findListbilanFinance(): void {
    this.bilanFinanceService.findAllBilanFinance().subscribe(res => {
      this.listeBilan = res;
    })
  }
  handleSuppression(event: any): void{
    if (event === 'success') {
      this.findListbilanFinance();
    } else {
      this.errorMsgs = event;
    }

  }


}
