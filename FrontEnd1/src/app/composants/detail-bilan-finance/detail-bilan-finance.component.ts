import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { BilanFinanceService } from 'src/app/services/bilanFinance/bilan-finance.service';
import { BilanFinancierDTO } from 'src/gs-api/src/models';

@Component({
  selector: 'app-detail-bilan-finance',
  templateUrl: './detail-bilan-finance.component.html',
  styleUrls: ['./detail-bilan-finance.component.css']
})
export class DetailBilanFinanceComponent implements OnInit {

  @Input()
  bilanFinanceDto: BilanFinancierDTO = {};
  @Output()
  suppressionBilanFinance = new EventEmitter();
  constructor(
    private router: Router,
    private  bilanFinanceService: BilanFinanceService,
  ) { }

  ngOnInit(): void {
  }
  modifierBilanFinance(): void{
    this.router.navigate(['nouveauBilanFinance', this.bilanFinanceDto.idBilan]);
  }
  detailBilanFinance():void{
    this.router.navigate(['detailBilanFinance',this.bilanFinanceDto.idBilan]);
  }


  // tslint:disable-next-line:typedef
  confirmerEtSupprimerBilanFinance() {
    if (this.bilanFinanceDto.idBilan){
      this.bilanFinanceService.deleteBilanFinance(this.bilanFinanceDto.idBilan)
        .subscribe(res => {
          this.suppressionBilanFinance.emit('success');
        }, error => {
          this.suppressionBilanFinance.emit(error.error.error);
        });
    }
  }
}
