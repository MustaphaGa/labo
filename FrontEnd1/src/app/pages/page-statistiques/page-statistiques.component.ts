import { Component, OnInit } from '@angular/core';
import {ChartOptions, ChartType} from 'chart.js';
import {Color, Label, SingleDataSet} from 'ng2-charts';

@Component({
  selector: 'app-page-statistiques',
  templateUrl: './page-statistiques.component.html',
  styleUrls: ['./page-statistiques.component.css']
})
export class PageStatistiquesComponent implements OnInit {


  public doughnutChartOptions: ChartOptions = {
    responsive: true,
    legend: {
      display: false,
    },
    cutoutPercentage: 100,
  };
  public doughnutChartLabels: Label[] = ['patients', 'employes', 'analyes'];
  public doughnutChartData: SingleDataSet = [50, 30, 25];
  public doughnutChartType: ChartType = 'bar';
  public doughnutChartColor: Color[] = [
    { backgroundColor: ['#f68059', '#ffbf3a', '#4e3dc8'] },
  ];
  constructor() { }

  ngOnInit(): void {
  }
}




