import {Component, Input, OnInit} from '@angular/core';
import {EmployeDTO} from "../../../gs-api/src/models";
import {Router} from "@angular/router";
import {UserService} from "../../services/user/user.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  connectedUser: EmployeDTO = {};
  constructor(private router: Router,
              private  userService: UserService) { }

  ngOnInit(): void {
    this.connectedUser = this.userService.getConnectedUser();
  }

}
