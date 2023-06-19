import { Component, OnInit } from '@angular/core';
import {EmployeDTO} from '../../../gs-api/src/models/employe-dto';
import {ActivatedRoute, Router} from '@angular/router';
import {EmployeService} from '../../services/employe/employe.service';
import {MouvementDTO} from '../../../gs-api/src/models/mouvement-dto';
import {MouvementService} from '../../services/mouvement/mouvement.service';


@Component({
  selector: 'app-nouveau-mouvement',
  templateUrl: './nouveau-mouvement.component.html',
  styleUrls: ['./nouveau-mouvement.component.css']
})
export class NouveauMouvementComponent implements OnInit {
  listMouvement: Array<MouvementDTO> = [];
  mouvementDto: MouvementDTO = {};
  employeDTO: EmployeDTO = {};
  listeEmploye: Array<EmployeDTO> = [];
  errorMsg: Array<string> = [];

  constructor(
    private router: Router,
    private activatedRouter: ActivatedRoute,
    private employeService: EmployeService,
    private mouvementService: MouvementService) {
  }

  ngOnInit(): void {
    this.employeService.findAllEmploye().subscribe(analy => {
      this.listeEmploye = analy;
    });
    const idMouvement = this.activatedRouter.snapshot.params.idMouvement;
    if (idMouvement) {
      this.mouvementService.findMouvementById(idMouvement)
        .subscribe(mouvement => {
          this.mouvementDto = mouvement;
          this.employeDTO = this.mouvementDto.employe ? this.mouvementDto.employe : {};
        });
    }
    this.findAllMouvement();
  }

  cancel(): void {
    this.router.navigate(['mouvement']);
  }

  enregistrerMouvement(): void {
    this.mouvementDto.employe = this.employeDTO
    this.mouvementService.enregistrerMouvement(this.mouvementDto).subscribe(res => {
      this.router.navigate(['mouvement']);
    }, error => {
      this.errorMsg = error.error.errors;
    });
  }

  findAllMouvement(): void {
    this.mouvementService.findAllMouvement().subscribe(mouvement => {
      this.listMouvement = mouvement;
    });
  }
}

