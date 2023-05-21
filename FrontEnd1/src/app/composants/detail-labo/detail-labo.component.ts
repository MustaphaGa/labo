import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Router} from "@angular/router";
import {LaboService} from "../../services/labo/labo.service";

@Component({
  selector: 'app-detail-labo',
  templateUrl: './detail-labo.component.html',
  styleUrls: ['./detail-labo.component.css']
})
export class DetailLaboComponent implements OnInit {
  constructor(
    private router:Router,
    private  laboService:LaboService,
  ) { }

  ngOnInit(): void {
  }


  confirmerEtSupprimerLabo() {

  }
}
