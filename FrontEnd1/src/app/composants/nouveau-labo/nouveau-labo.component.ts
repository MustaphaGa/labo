import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TypAnalyseService} from "../../typeAnalyse/typ-analyse.service";
import {LaboDTO} from '../../../gs-api/src/models/labo-dto';
import {LaboService} from '../../services/labo/labo.service';

@Component({
  selector: 'app-nouveau-labo',
  templateUrl: './nouveau-labo.component.html',
  styleUrls: ['./nouveau-labo.component.css']
})
export class NouveauLaboComponent implements OnInit {
  [x: string]: any;
  laboDto: LaboDTO ={};
  errorMsg: Array<string> = [];
  constructor(private router:Router,
              private activatedRouter:ActivatedRoute,
              private laboService :LaboService) { }

  ngOnInit(): void {
  }

  cancel(): void {
    this.router.navigate(['labo']);
  }

  enregistrerLabo() {
    this.laboService.enregistrerLbao(this.laboDto).subscribe(res => {
      this.router.navigate(['labo']);
    }, error => {
      this.errorMsg = error.error.errors;
    });
  }
}
