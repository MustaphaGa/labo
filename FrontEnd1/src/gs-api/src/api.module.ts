/* tslint:disable */
import { NgModule, ModuleWithProviders } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ApiConfiguration, ApiConfigurationInterface } from './api-configuration';

import { TestCovidv1absenceService } from './services/test-covidv-1absence.service';
import { AnalyseMedicalService } from './services/analyse-medical.service';
import { TestCovidv1patientService } from './services/test-covidv-1patient.service';
import { ArticleService } from './services/article.service';
import { AuthenticationService } from './services/authentication.service';
import { TestCovidv1bilanfinanceService } from './services/test-covidv-1bilanfinance.service';
import { BiologisteService } from './services/biologiste.service';
import { BoncommandeService } from './services/boncommande.service';
import { TestCovidv1compteService } from './services/test-covidv-1compte.service';
import { TestCovidv1congeService } from './services/test-covidv-1conge.service';
import { DepartementService } from './services/departement.service';
import { DetailResultatService } from './services/detail-resultat.service';
import { TestCovidv1employeService } from './services/test-covidv-1employe.service';
import { FactureService } from './services/facture.service';
import { FournisseurService } from './services/fournisseur.service';
import { TestCovidv1laboService } from './services/test-covidv-1labo.service';
import { TestCovidv1mouvementService } from './services/test-covidv-1mouvement.service';
import { NatureOperationService } from './services/nature-operation.service';
import { TestCovidv1operationService } from './services/test-covidv-1operation.service';
import { PreleveurService } from './services/preleveur.service';
import { TestCovidv1recrutementService } from './services/test-covidv-1recrutement.service';
import { ReservationService } from './services/reservation.service';
import { TestCovidv1rolesService } from './services/test-covidv-1roles.service';
import { StockService } from './services/stock.service';
import { TypeAnalyseService } from './services/type-analyse.service';

/**
 * Provider for all Api services, plus ApiConfiguration
 */
@NgModule({
  imports: [
    HttpClientModule
  ],
  exports: [
    HttpClientModule
  ],
  declarations: [],
  providers: [
    ApiConfiguration,
    TestCovidv1absenceService,
    AnalyseMedicalService,
    TestCovidv1patientService,
    ArticleService,
    AuthenticationService,
    TestCovidv1bilanfinanceService,
    BiologisteService,
    BoncommandeService,
    TestCovidv1compteService,
    TestCovidv1congeService,
    DepartementService,
    DetailResultatService,
    TestCovidv1employeService,
    FactureService,
    FournisseurService,
    TestCovidv1laboService,
    TestCovidv1mouvementService,
    NatureOperationService,
    TestCovidv1operationService,
    PreleveurService,
    TestCovidv1recrutementService,
    ReservationService,
    TestCovidv1rolesService,
    StockService,
    TypeAnalyseService
  ],
})
export class ApiModule {
  static forRoot(customParams: ApiConfigurationInterface): ModuleWithProviders {
    return {
      ngModule: ApiModule,
      providers: [
        {
          provide: ApiConfiguration,
          useValue: {rootUrl: customParams.rootUrl}
        }
      ]
    }
  }
}
