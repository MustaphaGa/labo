import { Component, OnInit } from '@angular/core';
import {LaboDTO} from '../../../gs-api/src/models/labo-dto';
import {ActivatedRoute, Router} from '@angular/router';
import {LaboService} from '../../services/labo/labo.service';
import {BilanFinancierDTO} from '../../../gs-api/src/models/bilan-financier-dto';
import {BilanFinanceService} from '../../services/bilanFinance/bilan-finance.service';
import {AnalyseMedicalDTO} from '../../../gs-api/src/models/analyse-medical-dto';
import {CompteDTO} from '../../../gs-api/src/models/compte-dto';
import {CompteService} from '../../services/compte/compte.service';

@Component({
  selector: 'app-nouveau-bilan-finance',
  templateUrl: './nouveau-bilan-finance.component.html',
  styleUrls: ['./nouveau-bilan-finance.component.css']
})
export class NouveauBilanFinanceComponent implements OnInit {
  [x: string]: any;
  bilanFinanDto: BilanFinancierDTO = {};
  compteDTo: CompteDTO = {};
  listeCompte: Array<CompteDTO>  = [];
  errorMsg: Array<string> = [];
  constructor(private router: Router,
              private activatedRouter: ActivatedRoute,
              private bilanFinanceService: BilanFinanceService,
              private  compteService: CompteService, ) { }

  ngOnInit(): void {
    this.compteService.findAllCompte().subscribe(compte => {
      this.listeCompte=compte;
    });
    const idBilan = this.activatedRouter.snapshot.params.idBilan;
    if (idBilan) {
      this.bilanFinanceService.findBilanFinanceById(idBilan)
        .subscribe(bilan => {
          this.bilanFinanDtoDT = bilan;
          this.compteDTo = this.bilanFinanDto.compte ? this.bilanFinanDto.compte : {};
        });
    }
  }

  cancel(): void {
    this.router.navigate(['bilanFinance']);
  }

  enregistrerBilanFinance() {
    this.bilanFinanDto.compte =this.compteDTo
    this.bilanFinanceService.enregistrerBilanFinance(this.bilanFinanDto).subscribe(res => {
      this.router.navigate(['bilanFinance']);
    }, error => {
      this.errorMsg = error.error.errors;
    });
  }
}
