import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ChartOptions, ChartType} from 'chart.js';
import {Color, Label, SingleDataSet} from 'ng2-charts';
import {AnalyseMedicalDTO} from "../../../gs-api/src/models/analyse-medical-dto";
import {Router} from "@angular/router";
import {AnnalyseMedicalService} from "../../services/analyse-medical/annalyse-medical.service";
import {PatientDTO} from "../../../gs-api/src/models/patient-dto";
import {PatientService} from "../../services/patient/patient.service";
import {EmployeService} from "../../services/employe/employe.service";

@Component({
  selector: 'app-page-statistiques',
  templateUrl: './page-statistiques.component.html',
  styleUrls: ['./page-statistiques.component.css']
})
export class PageStatistiquesComponent implements OnInit {

  @Input()
  analyseMedicalDtto: AnalyseMedicalDTO = {};
  public doughnutChartOptions: ChartOptions = {
    responsive: true,
    legend: {
      display: false,
    },
    cutoutPercentage: 100,
  };
  // @ts-ignore
  public doughnutChartLabels: Label[] = [ 'analyses' , 'patients', 'employes' ];
  public doughnutChartData: SingleDataSet = [30, 20, 10];
  public doughnutChartType: ChartType = 'bar';
  public doughnutChartColor: Color[] = [
    {backgroundColor: ['#4e3dc8', '#ffbf3a', , '#f68059']},
  ];

  constructor(private router: Router,
              private annalyseMedicalService: AnnalyseMedicalService,
              private  patientService: PatientService,
              private  employeService: EmployeService) {
  }

  ngOnInit(): void {
    this.annalyseMedicalService.findCountAnalysMedical().subscribe(res1 => {
      const index = this.doughnutChartData.indexOf(30);
      this.doughnutChartData[index] = res1;

    });
    this.patientService.findCountPatients().subscribe(res3 => {
      const index = this.doughnutChartData.indexOf(20);
      this.doughnutChartData[index] = res3;

    });
    this.employeService.findCountEmployees().subscribe(res2 => {
      const index = this.doughnutChartData.indexOf(10);
      this.doughnutChartData[index] = res2;

    });
  }
}





