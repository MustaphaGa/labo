import { Component, OnInit } from '@angular/core';
import {TypeAnalyseDTO} from "../../../gs-api/src/models/type-analyse-dto";
import {ActivatedRoute, Router} from "@angular/router";
import {TypAnalyseService} from "../../typeAnalyse/typ-analyse.service";

@Component({
  selector: 'app-nouveau-labo',
  templateUrl: './nouveau-labo.component.html',
  styleUrls: ['./nouveau-labo.component.css']
})
export class NouveauLaboComponent implements OnInit {
  [x: string]: any;
  typeAnalysedTo: TypeAnalyseDTO ={};
  errorMsg: Array<string> = [];
  constructor(private router:Router,
              private activatedRouter:ActivatedRoute,
              private laboService :TypAnalyseService) { }

  ngOnInit(): void {
  }

  cancel(): void {
    this.router.navigate(['labo']);
  }
}
