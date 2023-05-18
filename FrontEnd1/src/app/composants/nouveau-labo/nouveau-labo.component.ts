import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nouveau-labo',
  templateUrl: './nouveau-labo.component.html',
  styleUrls: ['./nouveau-labo.component.css']
})
export class NouveauLaboComponent implements OnInit {
  errorMsg: '';

  constructor() { }

  ngOnInit(): void {
  }

  cancel() {
    
  }
}
