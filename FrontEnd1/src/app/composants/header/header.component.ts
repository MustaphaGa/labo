import {Component, Input, OnInit} from '@angular/core';
import {EmployeDTO} from "../../../gs-api/src/models";
import {Router} from "@angular/router";
import {EmployeService} from "../../services/employe/employe.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Input()
  employeDt: EmployeDTO = {};
  constructor(private router: Router,
              private employeService:EmployeService) { }

  ngOnInit(): void {
  }

}
