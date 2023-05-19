import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {LaboService} from "../../services/labo/labo.service";

@Component({
  selector: 'app-nouveau-labo',
  templateUrl: './nouveau-labo.component.html',
  styleUrls: ['./nouveau-labo.component.css']
})
export class NouveauLaboComponent implements OnInit {
  errorMsg: '';

  constructor(private  router: Router,
              private  laboService: LaboService) { }

  ngOnInit(): void {
  }

  cancel() {

  }
}
