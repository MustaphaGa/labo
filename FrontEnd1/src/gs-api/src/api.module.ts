/* tslint:disable */
import { NgModule, ModuleWithProviders } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ApiConfiguration, ApiConfigurationInterface } from './api-configuration';

import { AnalyseMedicalService } from './services/analyse-medical.service';
import { BiologisteService } from './services/biologiste.service';
import { DepartementService } from './services/departement.service';
import { DetailResultatService } from './services/detail-resultat.service';
import { FactureService } from './services/facture.service';
import { TestCovidv1patientService } from './services/test-covidv-1patient.service';
import { PreleveurService } from './services/preleveur.service';
import { ProfilService } from './services/profil.service';
import { ReservationService } from './services/reservation.service';
import { TypeAnalyseService } from './services/type-analyse.service';
import { UtilisateurService } from './services/utilisateur.service';

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
    AnalyseMedicalService,
    BiologisteService,
    DepartementService,
    DetailResultatService,
    FactureService,
    TestCovidv1patientService,
    PreleveurService,
    ProfilService,
    ReservationService,
    TypeAnalyseService,
    UtilisateurService
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
