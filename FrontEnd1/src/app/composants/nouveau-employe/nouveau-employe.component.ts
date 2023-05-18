import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nouveau-employe',
  templateUrl: './nouveau-employe.component.html',
  styleUrls: ['./nouveau-employe.component.css']
})
export class NouveauEmployeComponent implements OnInit {

  constructor( private router:Router) { }

  ngOnInit(): void {
  }
  cancel(): void {
    this.router.navigate(['employees']);
  }

}
